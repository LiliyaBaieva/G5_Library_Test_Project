package com.bookshare.tests;

import com.bookshare.fw.DataProviders;
import com.bookshare.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition(){
//    if(!app.getHeader().isLoginLinkPresent()){
    if(app.getHeader().isLogOutButtonPresent()){
      app.getHeader().clickOnLogOutButton();
    }
    app.getHeader().clickOnSignUpButton();
  }

  @Test
  public void registrationUserNegative(){
    app.getUser().fillInRegistrationForm("testLu.mail.com", "testLu@mail.com", "testLu@mail.com");
    app.getUser().clickOnSignUpButton();
//    Assert.assertTrue(validationMessageElement.isDisplayed());  //TODO get error message
    Assert.assertTrue(app.getUser().isSignUpButtonPresent());
  }

  @Test(dataProviderClass = DataProviders.class, dataProvider = "addUserFromCsvFile")
  public void RegistrationUserFromCsvPositive(User user){
    app.getUser().fillInRegistrationFormFromCsv(user);
    app.getUser().clickOnSignUpButton();
    Assert.assertTrue(app.getHeader().isLoginLinkPresent());
  }

  @Test(dataProviderClass = DataProviders.class, dataProvider = "addUserFromCsvFileNegative")
  public void RegistrationUserFromCsvNegative(User user) {
    app.getUser().fillInRegistrationFormFromCsv(user);
    app.getUser().clickOnSignUpButton();
//    Assert.assertTrue(app.getHeader().isAlertPresent());  //TODO get error message
    Assert.assertTrue(app.getUser().isSignUpButtonPresent());
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
    Assert.assertTrue(app.getHeader().isAlertPresent()); //TODO get error message
  }




}
