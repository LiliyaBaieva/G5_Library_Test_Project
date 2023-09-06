package com.bookshare.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition(){
    if(!app.getHeader().isLoginLinkPresent()){
      app.getHeader().clickOnLogOutButton();
    }
    app.getHeader().clickOnLoginButton();
  }

  @Test
  public void loginRegisteredUser(){
    app.getHeader().clickOnLoginButton();
    app.getUser().fillInLoginForm("anna@mail.com", "$Anna.2023$");
    app.getUser().clickOnLogInButton();
  }

  @Test
  public void loginNotRegisteredUser(){
    app.getHeader().clickOnLoginButton();
    app.getUser().fillInLoginForm("boris@mail.com", "$Boris.2023$");
    app.getUser().clickOnLogInButton();
  }

  @Test
  public void loginWithEmptyEmail(){
    app.getHeader().clickOnLoginButton();
    app.getUser().fillInLoginForm(null, "$Anna.2023$");
    app.getUser().clickOnLogInButton();
  }

  @Test
  public void loginWithEmptyPassword(){
    app.getHeader().clickOnLoginButton();
    app.getUser().fillInLoginForm("anna@mail.com", null);
    app.getUser().clickOnLogInButton();
  }

}

// loginRegisteredUser(), loginNotRegisteredUser(), loginWithEmptyEmail(), loginWithEmptyPassword()