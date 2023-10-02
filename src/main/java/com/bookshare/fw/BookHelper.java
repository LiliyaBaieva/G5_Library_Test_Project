package com.bookshare.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BookHelper extends BaseHelper{

  public BookHelper(WebDriver driver) {
    super(driver);
  }

  public void clickOnAddNewBookLink() {
    click(By.cssSelector("button.library-item-left__bottom.button.button-library"));
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
    type(By.cssSelector("textarea.form__input"), description);
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
    return isElementPresent(By.cssSelector("button.library-item-left__bottom.button.button-library"));
  }

  public void clickOnAddBookButton() {
    click(By.xpath("//button[.='Add']"));
  }

  public boolean isBookInMyPagePresent(String title) {
    clickOnMyBookButton();
    return isElementPresent(By.xpath("//*[.='" + title + "']"));
  }

  public void clickOnMyBookButton() {
    click(By.xpath("//button[.='My books ']"));
  }

  public void clickMoreInfoOfBookLink(int numOfBook) {
    click(By.xpath("//div[2]/div[" + numOfBook + "]/div[1]/div[1]/button[1]"));
  }

  public void clickOnGetBookButton() {
    click(By.xpath("//button[.='Get book']"));
  }

  public String getTitleOfBook(int numOfBook) {
    pause(1000);
    clickMoreInfoOfBookLink(numOfBook);
    pause(1000);
    return getText(By.cssSelector("p.book__title:nth-child(1)"));
  }


  public boolean isBookWithTitleInWaitingBookPresent(String title) {
    clickOnWantToReadButton();
    return isElementPresent(By.xpath("//*[.='" + title + "']"));
  }

  public void clickOnWantToReadButton() {
    click(By.xpath("//button[.='Want to read']"));
  }

  public boolean myBookButtonIsPresent() {
    return isElementPresent(By.xpath("//button[.='My books ']"));
  }

  public boolean wantToReadIsPresent() {
    return isElementPresent(By.xpath("//button[.='Want to read']"));
  }

  public boolean booksToSendButtonIsPresent() {
    return isElementPresent(By.xpath("//button[.='Books To Send']"));
  }

  public boolean myHistoryButtonIsPresent() {
    return isElementPresent(By.xpath("//button[.='My history']"));
  }

  public void clickMoreInfoOfBookLinkByTitle(String title) {
    click(By.xpath("(//p[.='" + title + "'])[1]/..//button"));
  }

  public void clickOnUpdateButton() {
    click(By.xpath("//button[.='Update Book']"));
  }

  public void changeDataOfBook(String picPath, String title, String author, String genre,
      String numberOfPages, String language, String year, String description) {
    fillInNewBookForm(picPath, title, author, genre, numberOfPages, language, year, description);
  }

  public String getLanguageOfBook(String title) {
    clickOnMyBookButton();
    clickMoreInfoOfBookLinkByTitle(title);
    pause(1000);
    return driver.findElement(By.cssSelector(" p.book__genre:nth-child(4)")).getText();
  }

  public void searchBookByType(String searchedTitle) {
    //type on search
    type(By.cssSelector("[placeholder='Search by title, author']"), searchedTitle);
    driver.findElement(By.cssSelector("[placeholder='Search by title, author']")).sendKeys(Keys.ENTER);
  }


  public String getAuthorOfBook(int numOfBook) {
    pause(1000);
    clickMoreInfoOfBookLink(numOfBook);
    pause(1000);
    return getText(By.cssSelector("p.book__title:nth-child(2)"));
  }


  public void clickOnUpdateBookButton() {
    click(By.xpath("//button[.='Update Book']"));
  }

  public void searchBookByLanguage(String language) {
    click(By.xpath("//button[1]/*[1]"));
    click(By.xpath("//label[.='" + language + "']/input"));
  }

  public String getLanguageOfFirstBook(int numOfBook) {
    pause(1000);
    clickMoreInfoOfBookLink(numOfBook);
    pause(1000);
    return getText(By.cssSelector("p.book__genre:nth-child(4)"));
  }

  public void searchBookByLocation(String city) {
    click(By.xpath("//button[1]/*[1]"));
    click(By.xpath("//label[.='" + city + "']/input"));
  }

  public String getCityOfBook(int numOfBook) {
    pause(1000);
    clickMoreInfoOfBookLink(numOfBook);
    pause(1000);
    return getText(By.xpath("//div[2]/p[8]"));
  }

  public void deleteBookFromWantToRead(String title) {
    clickOnWantToReadButton();
    // isElementPresent(By.xpath("//*[.='" + title + "']"));
    clickMoreInfoOfBookLinkByTitle(title);
    click(By.xpath("//button[.='Delete']"));
  }

  public boolean isErrorWindowDisplayed() {
    pause(1000);
    boolean result = isElementPresent(By.cssSelector("p.error-message"));
    clickOnCloseErrorWindowButton();
    return result;
  }


}
