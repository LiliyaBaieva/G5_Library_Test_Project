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
    app.getHeader().clickOnLoginButton();
  }

  @Test
  public void loginRegisteredUser(){
    app.getUser().loginUser("anna@mail.com", "$Anna.2023$");
    Assert.assertTrue(app.getHeader().isMyLibraryLinkPresent());
  }

  @Test
  public void loginNotRegisteredUser(){
    app.getUser().loginUser("boris@mail.com", "$Boris.2023$");
    //TODO add error message
  }

  @Test
  public void loginWithEmptyEmail(){
    app.getUser().loginUser(null, "$Anna.2023$");
    //TODO add error message
  }

  @Test
  public void loginWithEmptyPassword(){
    app.getUser().loginUser("anna@mail.com", null);
    //TODO add error message
  }

}