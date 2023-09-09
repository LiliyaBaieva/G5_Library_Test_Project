package com.bookshare.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookHelper extends BaseHelper{

  public BookHelper(WebDriver driver) {
    super(driver);
  }

  public void clickOnAddNewBookLink() {
    click(By.cssSelector(" a.library-item-left__bottom.button.button-library"));
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
    return isElementPresent(By.cssSelector(" a.library-item-left__bottom.button.button-library"));
  }

  public void clickOnAddBookButton() {
    click(By.xpath("//button[.='Add']"));
  }

  public boolean isBookInMyPagePresent(String title) {
    return false;
  }

  public void clickMoreInfoOfBookLink(int numOfBook) {
    click(By.xpath("//div[" + numOfBook + "]/div[1]/div[1]/button[1]"));
  }

  public void clickOnGetBookButton() {
    click(By.xpath("//button[.='Get book']"));
  }

  public String getTitleOfBook() {
    return getText(By.cssSelector("p.book__title:nth-child(1)"));
  }


  public boolean isBookWithTitleInWaitingBookPresent(String title) {
    click(By.xpath("//button[.='My waiting books']"));
    return isElementPresent(By.xpath("//*[.='" + title + "']"));
  }
}
