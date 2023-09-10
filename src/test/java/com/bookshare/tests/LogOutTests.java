package com.bookshare.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutTests extends TestBase{
  @BeforeMethod
  public void ensurePrecondition(){
    if(!app.getHeader().isLogOutButtonPresent()){
      app.getUser().loginUser("anna@mail.com", "$Anna.2023$");
    }
  }

  @Test
  public void logOutUser(){
    app.getUser().logOutUser();
    Assert.assertTrue(app.getHeader().isLogInAndSignUpLinkPresent());
  }

}
