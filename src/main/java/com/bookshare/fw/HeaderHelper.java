package com.bookshare.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper extends BaseHelper {

//  UserHelper user;

  public HeaderHelper(WebDriver driver) {
    super(driver);
//    user = new UserHelper(driver);
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

  public void clickOnSignUpLink() {
    click(By.xpath("//a[.='Sign Up']"));
  }

  public boolean isLogOutButtonPresent() {
    pause(1000);
    return isElementPresent(By.xpath("//a[.='Log out']"));
  }

  public boolean isLogInAndSignUpLinkPresent() {
    if (isLoginLinkPresent() && isSignUpLinkPresent()) {
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

  public void clickOnMyProfileLink() {
    click(By.xpath("//a[.='My profile']"));
  }

  public boolean isAElementsInHeaderNotLoggedInUserPresent() {
    if (isLogoPresent() && isLoginLinkPresent() && isSignUpLinkPresent()) {
      return true;
    }
    return false;
  }

  public boolean isLogoPresent() {
    return isElementPresent(By.cssSelector("[alt='logo']"));
  }

  public boolean isElementsInHeaderLoggedInUserPresent() {
    if (isLogoPresent() && isMyLibraryLinkPresent()
        && isMyProfileLinkPresent() && isLogOutButtonPresent()) {
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

  public boolean verifyLinksInHeaderForLoggedInUser() {
    if (verifyMyLibrarylink() && verifyMyProfileLink()) {
      return true;
    }

    return false;
  }

  private boolean verifyMyProfileLink() {
    return verifyLinks("http://localhost:3000/profile");
  }

  private boolean verifyMyLibrarylink() {
    return verifyLinks("http://localhost:3000/library");
  }

  public boolean verifyLinksInHeaderForNotLoggedInUser() {
    if (verifyLogInLink() && verifySigUpLink()) {
      return true;
    }
    return false;
  }

  private boolean verifySigUpLink() {
    return verifyLinks("http://localhost:3000/registration");
  }

  private boolean verifyLogInLink() {
    return verifyLinks("http://localhost:3000/login");
  }

  public void clickOnLogo() {
    pause(1000);
    click(By.cssSelector("[alt='logo']"));
  }
}

