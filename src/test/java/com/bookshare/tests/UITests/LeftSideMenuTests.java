package com.bookshare.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LeftSideMenuTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition(){
    if(app.getHeader().isLoginLinkPresent()){
      app.getHeader().clickOnLoginLink();
      app.getUser().loginUser("anna@mail.com", "$Anna.2023$");
    }
    app.getHeader().clickOnMyLibraryLink();
  }

  @Test
  public void allButtonInLeftSideMenuIsPresent(){
    Assert.assertTrue(app.getBook().myBookButtonIsPresent());
    Assert.assertTrue(app.getBook().wantToReadIsPresent());
    Assert.assertTrue(app.getBook().booksToSendButtonIsPresent());
    Assert.assertTrue(app.getBook().myHistoryButtonIsPresent());
  }

}











