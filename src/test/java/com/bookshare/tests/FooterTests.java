package com.bookshare.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FooterTests extends TestBase{

  // TODO Precondition пролистнуть вниз

  @Test
  public void contactIsPresentTest(){
    Assert.assertTrue(app.getFooter().isContactPresent());
  }

  @Test
  public void termAndConditionIsPresentTest(){
    Assert.assertTrue(app.getFooter().isTermAndConditionLinkPresent());
  }

  @Test
  public void facebookIsPresentTest(){
    Assert.assertTrue(app.getFooter().isFacebookLinkPresent());
  }

  @Test
  public void instagramIsPresentTest(){
    Assert.assertTrue(app.getFooter().isInstagramLinkPresent());
  }

  @Test
  public void twitterIsPresentTest(){
    Assert.assertTrue(app.getFooter().isTwitterLinkPresent());
  }

  @Test
  public void linkedInIsPresentTest(){
    Assert.assertTrue(app.getFooter().isLinkedInLinkPresent());
  }

}
