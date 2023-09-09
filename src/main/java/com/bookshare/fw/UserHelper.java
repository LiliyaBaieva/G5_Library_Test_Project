package com.bookshare.fw;

import com.bookshare.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

  HeaderHelper header;


  public UserHelper(WebDriver driver) {
    super(driver);
    header = new HeaderHelper(driver);
  }

  public void fillInRegistrationFormFromCsv(User user) {
    type(By.cssSelector("[name='email']"), user.getEmail());
    type(By.cssSelector("[name='password']"), user.getPassword());
    type(By.cssSelector("[placeholder='Repeat password']"), user.getConfirmPassword());
    click(By.cssSelector(":nth-child(4) > label:nth-child(2)"));
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
    click(By.cssSelector(":nth-child(4) > label:nth-child(2)"));
  }

  public void fillInLoginForm(String email, String password) {
    type(By.cssSelector("[name='email']"), email);
    type(By.cssSelector("[name='password']"), password);
  }

  public void clickOnLogInButton() {
    click(By.xpath("//button[.='Log In']"));
  }

  public void loginUser(String email, String password) {
    header.clickOnLoginLink();
    fillInLoginForm(email, password);
    clickOnLogInButton();
  }


  public void clickOnYesButtonToConfirmLogOut() {
    click(By.xpath("//button[.='Yes']"));
  }

  public void fillInUpdateForm(String firstName, String lastName, String postalCode) {
    type(By.cssSelector("[name='firstName']"), firstName);
    type(By.cssSelector("[name='lastName']"), lastName);
    type(By.cssSelector("[name='postalCode']"), postalCode);
  }

  public void clickOnSaveButton() {
    click(By.xpath("//button[.='Save']"));
  }

//  @FindBy(css ="[name='firstName']")
//  WebElement firstNameElement;
//  @FindBy(css = "[name='lastName']")
//  WebElement lastNameElement;
//  @FindBy( css = "[name='postalCode']")
//  WebElement postalCodeElement;

//  public boolean isContactHasUpdatedData(String firstName, String lastName, String postalCode) {
//    header.clickOnMyProfileLink();
//    if(shouldHaveText(firstNameElement, firstName, 10)
//        && shouldHaveText(lastNameElement, lastName, 10)
//        && shouldHaveText(postalCodeElement, postalCode, 10)
//    ){
//      return true;
//    }
//    return false;
//  }

  public boolean isSignUpButtonPresent() {
    return isElementPresent(By.xpath("//button[.='Sign Up']"));
  }

  public boolean isLoginButtonPresent() {
    return isElementPresent(By.xpath("//button[.='Log In']"));
  }

  public String firstnameGetText() {
    return getText(By.cssSelector("[name='firstName']"));
  }

  public String lastnameGetText() {
    return getText(By.cssSelector("[name='lastName']"));
  }

  public String postalCodeGetText() {
    return getText(By.cssSelector("[name='postalCode']"));
  }

}











