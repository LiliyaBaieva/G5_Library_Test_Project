package com.bookshare.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BookPageTests extends TestBase{

  @Test
  public void getBookLoggedInUserPositiveTest(){
    app.getHeader().clickOnLoginLink();
    app.getUser().loginUser("anna@mail.com", "$Anna.2023$");
    app.getBook().clickMoreInfoOfBookLink(1);
    String title = app.getBook().getTitleOfBook();
    app.getBook().clickOnGetBookButton();
    System.out.println(title);
    Assert.assertTrue(app.getBook().isBookWithTitleInWaitingBookPresent(title));
  }

  @Test
  public void getBookNotLoggedInUserNegativeTest(){
    app.getBook().clickMoreInfoOfBookLink(1);
    app.getBook().clickOnGetBookButton();
    Assert.assertTrue(app.getUser().isLoginButtonPresent());
  }

}
