package com.bookshare.fw;

import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseHelper {

  WebDriver driver;

  public BaseHelper(WebDriver driver) {
    this.driver = driver;
  }

  public boolean isElementPresent(By locator){
    try{
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException ex){
      return false;
    }
  }

  public void click(By locator){
    driver.findElement(locator).click();
  }

  public boolean isAlertPresent(){
    Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
        .until(ExpectedConditions.alertIsPresent());

    if (alert == null) {
      return false;
    } else {
      driver.switchTo().alert();
      alert.accept();
      return true;
    }

  }

  public void type(By locator, String text){
    if (text != null) {
      driver.findElement(locator).click();
      driver.findElement(locator).clear();
      driver.findElement(locator).sendKeys(text);
    }
  }

  public void pause (int millis){
    try{
      Thread.sleep(millis);
    } catch (InterruptedException e){
      throw  new RuntimeException(e);
    }
  }

  public String takeScreenshot(){
    File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    File screenshot = new File("screenshot/screen" + System.currentTimeMillis() + ".png");
    try{
      Files.copy(tmp, screenshot);
    } catch (IOException e){
      throw new RuntimeException(e);
    }

    return screenshot.getAbsolutePath();

  }

  public void verifyLinks(String linkURL){
    try{
      URL url = new URL(linkURL);

      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setConnectTimeout(5000);
      connection.connect();

      if(connection.getResponseCode() >= 400){
        System.out.println(linkURL + " - " + connection.getResponseMessage());
      } else {
        System.out.println(linkURL + " - " + connection.getResponseMessage());
      }
    } catch (Exception e){
      System.out.println(linkURL + " - " + e.getMessage() + " is broken link");
    }
  }

  public boolean shouldHaveText(WebElement locator, String text, int time){
    return new WebDriverWait(driver, Duration.ofSeconds(time))
        .until(ExpectedConditions.textToBePresentInElement(locator, text));
  }

  public void clickOnAddNewBookLink() {
    click(By.xpath("//a[.=' Add new books']"));
  }

  public void fillInNewBookForm(String picPath, String title, String author, String genre,
      String numberOfPages, String language, String year, String description) {
    type(By.cssSelector("[name='cover']"), picPath);
    type(By.cssSelector("[name='title']"), title);
    type(By.cssSelector("[name='author']"), author);
    selectGenre(genre);
    type(By.cssSelector("[name='pages']"), numberOfPages);
    selectLanguage(language);
    type(By.cssSelector("[name='publisherDate']"), year);
    type(By.cssSelector("textarea"), description);
  }

  private void selectLanguage(String language) {
    click(By.cssSelector("[name='languageId']"));
    click(By.xpath("//option[.='"+ language + "']"));
  }

  private void selectGenre(String genre) {
    click(By.cssSelector("[name='categoryId']"));
    click(By.xpath("//option[.='"+ genre + "']"));
  }

  public void clickOnCancelButton() {
    click(By.xpath("//button[.='Cancel']"));
  }

  public boolean isAddBookLinkPresent() {
    return isElementPresent(By.xpath("//a[.=' Add new books']"));
  }

  public void clickOnAddBookButton() {
    click(By.xpath("//button[.='Add']"));
  }
}













