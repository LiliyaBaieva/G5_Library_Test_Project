package com.bookshare.tests.UITests;

import com.bookshare.fw.DataProviders;
import com.bookshare.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterAccountTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition(){
    if(app.getHeader().isLogOutButtonPresent()){
      app.getHeader().clickOnLogOutButton();
    }
    app.getHeader().clickOnSignUpLink();
  }

  @Test
  public void RegistrationUserPositiveTest(){
    app.getUser().fillInRegistrationForm(
        "test" + app.getUser().randomInt() + "@mail.com",
        "Test%555",
        "Test%555");
    app.getUser().clickOnSignUpButton();
    Assert.assertTrue(app.getUser().isLoginButtonPresent());
  }

  @Test(dataProviderClass = DataProviders.class, dataProvider = "addUserFromCsvFileNegative")
  public void RegistrationUserFromCsvNegative(User user) {
    app.getUser().fillInRegistrationFormFromCsv(user);
    app.getUser().clickOnSignUpButton();
    Assert.assertTrue(app.getUser().isModalWindowPresent());
//    Assert.assertTrue(app.getUser().isSignUpButtonPresent());
  }

  @Test
  public void RegistrationUserWithoutCheckBoxNegative(){
    app.getUser().fillInRegistrationFormWithoutCheckBox("test@mail.com", "Test%555", "Test%555");
    app.getUser().clickOnSignUpButton();
    Assert.assertTrue(app.getHeader().isAlertPresent());
  }

  @Test
  public void RegistrationUserWithoutEmailNegative(){
    app.getUser().fillInRegistrationForm(null, "Test%555", "Test%555");
    app.getUser().clickOnSignUpButton();
    Assert.assertTrue(app.getHeader().isAlertPresent());
  }

  @Test
  public void RegistrationUserWithoutPasswordNegative(){
    app.getUser().fillInRegistrationForm( "test@mail.com", null, "Test%555");
    app.getUser().clickOnSignUpButton();
    Assert.assertTrue(app.getHeader().isAlertPresent());
  }

  @Test
  public void RegistrationUserWithoutConfirmPasswordNegative(){
    app.getUser().fillInRegistrationForm( "test@mail.com",  "Test%555", null);
    app.getUser().clickOnSignUpButton();
    Assert.assertTrue(app.getHeader().isAlertPresent());
  }


  @Test
  public void registrationUserWithWrongEmailNegative1(){
    app.getUser().fillInRegistrationForm("testLu.mail.com", "testLu@mail.com", "testLu@mail.com");
    app.getUser().clickOnSignUpButton();
//    Assert.assertTrue(validationMessageElement.isDisplayed());  //TODO get error message
//    Assert.assertTrue(app.getUser().isPopUpWinIsPresent());
    Assert.assertTrue(app.getUser().isSignUpButtonPresent());
  }

  @Test
  public void registrationUserWithWrongEmailNegative2(){
    app.getUser().fillInRegistrationForm("testm@mailcom", "Qwerty$123", "Qwerty$123");
    app.getUser().clickOnSignUpButton();
//    Assert.assertTrue(validationMessageElement.isDisplayed());  //TODO get error message
//    Assert.assertTrue(app.getUser().isPopUpWinIsPresent());
    Assert.assertTrue(app.getUser().isSignUpButtonPresent());
  }

  @Test
  public void registerExistedUserNegativeTest(){
    app.getUser().fillInRegistrationForm("anna@mail.com", "$Anna.2023$", "$Anna.2023$");
    app.getUser().clickOnSignUpButton();
    Assert.assertTrue(app.getUser().isModalWindowPresent());
  }

  @Test
  public void registrationUserNegative(){
    app.getUser().fillInRegistrationForm("testLu.mail.com", "testLu@mail.com", "testLu@mail.com");
    app.getUser().clickOnSignUpButton();
//    Assert.assertTrue(validationMessageElement.isDisplayed());  //TODO get error message
    Assert.assertTrue(app.getUser().isSignUpButtonPresent());
  }

}
