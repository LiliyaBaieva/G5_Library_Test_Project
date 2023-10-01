package com.bookshare.tests.UITests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetBookTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition(){
    if(app.getHeader().isLogOutButtonPresent()){
      app.getUser().logOutUser();
    }
  }

  @Test
  public void getBookLoggedInUserPositiveTest(){
    app.getUser().loginUser("anna@mail.com", "$Anna.2023$");
    String title = app.getBook().getTitleOfBook(8);
    app.getBook().clickOnGetBookButton();
    Assert.assertTrue(app.getBook().isBookWithTitleInWaitingBookPresent(title));

    app.getBook().deleteBookFromWantToRead(title);
  }

  @Test
  public void alreadyHaveThisBookNegativeTest(){
    app.getUser().loginUser("anna@mail.com", "$Anna.2023$");
    app.getHeader().clickOnMyLibraryLink();
    app.getBook().clickOnWantToReadButton();
    String titleOfBook = app.getBook().getTitleOfBook(1);
    app.getHeader().clickOnLogo();
    app.getBook().clickMoreInfoOfBookLinkByTitle(titleOfBook);
    app.getBook().clickOnGetBookButton();
    Assert.assertTrue(app.getBook().isErrorWindowDisplayed());
    app.getBook().clickOnCloseErrorWindowButton();
  }

  @Test
  public void getBookNotLoggedInUserNegativeTest(){
    app.getBook().clickMoreInfoOfBookLink(1);
    app.getBook().clickOnGetBookButton();
    Assert.assertTrue(app.getUser().isLoginButtonPresent());
  }

}
