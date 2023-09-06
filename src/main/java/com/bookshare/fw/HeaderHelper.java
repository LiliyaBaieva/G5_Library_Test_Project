package com.bookshare.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper extends BaseHelper {

  public HeaderHelper(WebDriver driver) {
    super(driver);
  }

  public boolean isLoginLinkPresent() {
    return isElementPresent(By.xpath("//a[.='Sign Up']"));
  }

  public void clickOnLogOutButton() {
    click(By.xpath("//a[.='Log out']"));
  }

  public void clickOnLoginButton() {
    click(By.xpath("//a[.='Sign Up']"));
  }

  public void clickOnSignUpButton() {
    click(By.xpath("//a[.='Sign Up']"));
  }
}
