package com.bookshare.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterHelper extends BaseHelper{

  public FooterHelper(WebDriver driver) {
    super(driver);
  }


  public boolean isTermAndConditionLinkPresent() {
    return isElementPresent(By.cssSelector(".terms"));
  }

  public boolean isFacebookLinkPresent() {
    return isElementPresent(By.cssSelector(".face"));
  }

  public boolean isInstagramLinkPresent() {
    return isElementPresent(By.cssSelector(".insta"));
  }

  public boolean isTwitterLinkPresent() {
    return isElementPresent(By.cssSelector(".twit"));
  }

  public boolean isLinkedInLinkPresent() {
    return isElementPresent(By.cssSelector(".linkd"));
  }

  public boolean isContactPresent() {
    if(emailPresent() && phonePresent() && addressPresent()){
      return true;
    }
    return false;
  }

  private boolean addressPresent() {
    return isElementPresent(By.xpath("//*[contains(text(),'Berlin, Deutschland')]"));
  }

  private boolean phonePresent() {
    return isElementPresent(By.xpath("//*[contains(text(),'+49-162-45-78')]"));
  }

  private boolean emailPresent() {
    return isElementPresent(By.xpath("//*[contains(text(),'bookshare@gmail.com')]"));
  }
}
