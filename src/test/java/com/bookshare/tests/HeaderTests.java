package com.bookshare.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase{

  @Test
  public void headerLoggedInUser(){
    Assert.assertTrue(app.getHeader()
        .isAElementsInHeaderLoggedInUserPresent("anna@mail.com", "$Anna.2023$"));
  }

  @Test
  public void headerNotLoggedInUser(){
    Assert.assertTrue(app.getHeader().isAElementsInHeaderNotLoggedInUserPresent());
  }

}
