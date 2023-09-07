package com.bookshare.fw;

import com.bookshare.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

  public UserHelper(WebDriver driver) {
    super(driver);
  }

  public void fillInRegistrationFormFromCsv(User user) {
    type(By.cssSelector("[name='email']"), user.getEmail());
    type(By.cssSelector("[name='password']"), user.getPassword());
    type(By.cssSelector("[placeholder='Repeat password']"), user.getConfirmPassword());
    click(By.id("checkbox-id"));
  }

  public void clickOnSignUpButton() {
    click(By.xpath("//button[.='Sign Up']"));
  }

  public void fillInRegistrationFormWithoutCheckBox(String email, String password, String confPass) {
    type(By.cssSelector("[name='email']"), email);
    type(By.cssSelector("[name='password']"), password);
    type(By.cssSelector("[placeholder='Repeat password']"), confPass);
  }

  public void fillInRegistrationForm(String email, String password, String confPass) {
    type(By.cssSelector("[name='email']"), email);
    type(By.cssSelector("[name='password']"), password);
    type(By.cssSelector("[placeholder='Repeat password']"), confPass);
    click(By.id("checkbox-id"));
  }

  public void fillInLoginForm(String email, String password) {
    type(By.cssSelector("[name='email']"), email);
    type(By.cssSelector("[name='password']"), password);
  }

  public void clickOnLogInButton() {
    click(By.xpath("//button[.='Continue']")); //TODO "Continue" -> "Log In"
  }

  public static void loginUser(String email, String Password) {

  }


  public void clickOnYesButtonToConfirmLogOut() {
    click(By.xpath("//button[.='Yes']"));
  }

  public void fillInUpdateForm(String firstName, String lastName, String postalCode) {
    type(By.xpath(""), firstName); // TODO add locator
    type(By.xpath(""), lastName); // TODO add locator
    type(By.xpath(""), postalCode); // TODO add locator
  }

  public void clickOnSaveButton() {
    click(By.xpath("")); // TODO add locator
  }
}











