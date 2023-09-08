package com.bookshare.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutTests extends TestBase{
  @BeforeMethod
  public void ensurePrecondition(){
    if(!app.getHeader().isLogOutButtonPresent()){
      app.getHeader().clickOnLoginLink();
      app.getUser().fillInLoginForm("anna@mail.com", "$Anna.2023$");
      app.getUser().clickOnLogInButton();
    }
  }

  @Test
  public void logOutUser(){
    app.getHeader().clickOnLogOutButton();
    app.getUser().clickOnYesButtonToConfirmLogOut();
    Assert.assertTrue(app.getHeader().isLogInAndSignUpLinkPresent());
  }

}
