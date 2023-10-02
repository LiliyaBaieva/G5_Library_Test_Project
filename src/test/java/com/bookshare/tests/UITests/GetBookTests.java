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
    String titleOfBook = app.getBook().getTitleOfBook(8);
    app.getBook().clickOnGetBookButton();

    app.getHeader().clickOnLogo();
    app.getBook().clickMoreInfoOfBookLinkByTitle(titleOfBook);
    app.getBook().clickOnGetBookButton();

    Assert.assertTrue(app.getBook().isErrorWindowDisplayed());

    app.getHeader().clickOnMyLibraryLink();
    app.getBook().deleteBookFromWantToRead(titleOfBook);

  }

  @Test
  public void getBookNotLoggedInUserNegativeTest(){
    app.getBook().clickMoreInfoOfBookLink(1);
    app.getBook().clickOnGetBookButton();
    Assert.assertTrue(app.getUser().isLoginButtonPresent());
  }

}
