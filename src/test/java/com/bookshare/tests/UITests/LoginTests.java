package com.bookshare.tests.UITests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition(){
    if(app.getHeader().isLogOutButtonPresent()){
      app.getUser().logOutUser();
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
  public void loginNotRegisteredUserNegativeTest(){
    app.getUser().loginUser("boris@mail.com", "$Boris.2023$");
    Assert.assertTrue(app.getBook().isErrorWindowDisplayed());
    app.getHeader().clickOnLogo();
  }

  @Test
  public void loginWithEmptyEmailNegativeTest(){
    app.getUser().loginUser("", "$Anna.2023$");
    Assert.assertTrue(app.getBook().isErrorWindowDisplayed());
    app.getHeader().clickOnLogo();
  }

  @Test
  public void loginWithEmptyPasswordNegativeTest(){
    app.getUser().loginUser("anna@mail.com", "");
    Assert.assertTrue(app.getBook().isErrorWindowDisplayed());
    app.getHeader().clickOnLogo();
  }

}