package com.bookshare.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyProfileTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition(){
    if(!app.getHeader().isLogOutButtonPresent()){
      app.getHeader().clickOnLoginButton();
      app.getUser().fillInLoginForm("anna@mail.com", "$Anna.2023$");
      app.getUser().clickOnLogInButton();
    }
  }

  @Test
  public void updateUserInfo(){
    app.getHeader().clickOnMyProfileButton();
    app.getUser().fillInUpdateForm("Anna", "Lou", "10115");
    app.getUser().clickOnSaveButton();
    Assert.assertTrue(app.getUser()
        .isContactHasUpdatedData("Anna", "Lou", "10115"));
  }

}
