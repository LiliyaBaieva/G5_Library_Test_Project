package com.bookshare.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition(){
    if(!app.getHeader().isLoginLinkPresent()){
      app.getHeader().clickOnLogOutButton();
    }
  }

  @Test
  public void loginRegisteredUser(){
    app.getUser().loginUser("anna@mail.com", "$Anna.2023$");
    Assert.assertTrue(app.getHeader().isMyLibraryLinkPresent());
  }
  @Test
  public void loginRegisteredUser2(){
    app.getUser().loginUser("n2@gmail.com", "Qwerty007!");
    Assert.assertTrue(app.getHeader().isMyLibraryLinkPresent());
  }

  @Test
  public void loginNotRegisteredUser(){
    app.getUser().loginUser("boris@mail.com", "$Boris.2023$");
    Assert.assertTrue(app.getUser().isLoginButtonPresent());
//    Assert.assertTrue(app.getUser().isAlertPresent());//TODO add error message
  }

  @Test
  public void loginWithEmptyEmail(){
    app.getUser().loginUser(null, "$Anna.2023$");
    Assert.assertTrue(app.getUser().isLoginButtonPresent());
//    Assert.assertTrue(app.getUser().isAlertPresent());//TODO add error message
  }

  @Test
  public void loginWithEmptyPassword(){
    app.getUser().loginUser("anna@mail.com", null);
    Assert.assertTrue(app.getUser().isLoginButtonPresent());
//    Assert.assertTrue(app.getUser().isAlertPresent());//TODO add error message
  }

}