package com.bookshare.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyProfileTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition(){
    if(!app.getHeader().isLogOutButtonPresent()){
      app.getHeader().clickOnLoginLink();
      app.getUser().fillInLoginForm("anna@mail.com", "$Anna.2023$");
      app.getUser().clickOnLogInButton();
    }
  }

  @Test
  public void updateUserInfo(){
    app.getHeader().clickOnMyProfileLink();
    app.getUser().fillInUpdateForm("Anna", "Lou", "10115");
    app.getUser().clickOnSaveButton();

    Assert.assertEquals(app.getUser().firstnameGetText(), "Anna");
    Assert.assertEquals(app.getUser().lastnameGetText(), "Lou");
    Assert.assertEquals(app.getUser().postalCodeGetText(), "10115");
  }

}
