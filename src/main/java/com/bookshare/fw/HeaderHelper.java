package com.bookshare.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper extends BaseHelper {

  UserHelper user;

  public HeaderHelper(WebDriver driver) {
    super(driver);
  }

  public boolean isLoginLinkPresent() {
    return isElementPresent(By.xpath("//a[.='Login']"));
  }

  public void clickOnLogOutButton() {
    click(By.xpath("//a[.='Log out']"));
  }

  public void clickOnLoginLink() {
    click(By.xpath("//a[.='Login']"));
  }

  public void clickOnSignUpButton() {
    click(By.xpath("//a[.='Sign Up']"));
  }

  public boolean isLogOutButtonPresent() {
    return isElementPresent(By.xpath("//a[.='Log out']"));
  }

  public boolean isLogInAndSignUpLinkPresent() {
    if(isLoginLinkPresent() && isSignUpLinkPresent()){
      return true;
    }
    return false;
  }

  private boolean isSignUpLinkPresent() {
    return isElementPresent(By.xpath("//a[.='Sign Up']"));
  }

  public boolean isMyLibraryLinkPresent() {
    return isElementPresent(By.xpath("//a[.='My library']"));
  }

  public void clickOnMyProfileButton() {
    click(By.xpath("//a[.='My profile']"));
  }

  public boolean isAElementsInHeaderNotLoggedInUserPresent() {
    if(isLogoPresent() && isLoginLinkPresent() && isSignUpLinkPresent()){
      return true;
    }
    return false;
  }

  public boolean isLogoPresent() {
    return isElementPresent(By.cssSelector("[alt='logo']"));
  }

  public boolean isAElementsInHeaderLoggedInUserPresent(String email, String password) {
    user.loginUser(email, password);
    if(isLogoPresent() && isMyLibraryLinkPresent()
        && isMyProfileLinkPresent() && isLogOutButtonPresent()){
      return true;
    }
    return false;
  }

  public boolean isMyProfileLinkPresent() {
    return isElementPresent(By.xpath("//a[.='My profile']"));

  }

  public void clickOnMyLibraryLink() {
    click(By.xpath("//a[.='My library']"));
  }
}
