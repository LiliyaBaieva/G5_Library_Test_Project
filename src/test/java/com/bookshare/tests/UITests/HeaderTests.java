package com.bookshare.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase{

  @Test
  public void headerLoggedInUser(){
    if(app.getHeader().isLoginLinkPresent()){
      app.getUser().loginUser("anna@mail.com", "$Anna.2023$");
    }
    Assert.assertTrue(app.getHeader().isElementsInHeaderLoggedInUserPresent());
    Assert.assertTrue(app.getHeader().verifyLinksInHeaderForLoggedInUser());
  }

  @Test
  public void headerNotLoggedInUser(){
    if(app.getHeader().isLogOutButtonPresent()){
      app.getUser().logOutUser();
    }
    Assert.assertTrue(app.getHeader().isAElementsInHeaderNotLoggedInUserPresent());
    Assert.assertTrue(app.getHeader().verifyLinksInHeaderForNotLoggedInUser());
  }

}
