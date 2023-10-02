package com.bookshare.tests.UITests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchBookTests extends TestBase{

  @BeforeMethod
  public void precondition(){
    app.getHeader().clickOnLogo();
  }

  @Test
  public void searchBookByTitleTest(){
    String searchedTitle = app.getBook().getTitleOfBook(2);
    app.getHeader().clickOnLogo();
    app.getBook().searchBookByType(searchedTitle);
    String resultTitle = app.getBook().getTitleOfBook(1);
    Assert.assertEquals(searchedTitle, resultTitle);
  }

  @Test
  public void searchBookByAuthorTest(){
    String searchedAuthor = app.getBook().getAuthorOfBook(3);
    System.out.println(searchedAuthor);
    app.getHeader().clickOnLogo();
    app.getBook().searchBookByType(searchedAuthor);
    String resultAuthor = app.getBook().getAuthorOfBook(1);
    Assert.assertEquals(searchedAuthor, resultAuthor);
  }

  @Test
  public void searchBookByLanguageTest(){
    app.getBook().searchBookByLanguage("English");
    String result = app.getBook().getLanguageOfFirstBook(1);
    app.getBook().pause(1000);
    Assert.assertEquals(result, "English");
  }

  @Test
  public void searchBookByLocationTest(){
    app.getBook().searchBookByLocation("Berlin");
    String result = app.getBook().getCityOfBook(1);
    app.getBook().pause(1000);
    Assert.assertTrue(result.contains("Berlin"));
  }

}
