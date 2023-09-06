package com.bookshare.fw;

import com.bookshare.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

  public UserHelper(WebDriver driver) {
    super(driver);
  }

  public void fillInRegistrationForm(User user) {
    type(By.cssSelector("[name='email']"), user.getEmail());
    type(By.cssSelector("[name='password']"), user.getPassword());
    type(By.cssSelector("[placeholder='Repeat password']"), user.getConfirmPassword());
    click(By.id("checkbox-id"));
  }

  public void clickOnSignUpButton() {
    click(By.xpath("//button[.='Sign Up']"));
  }
}
