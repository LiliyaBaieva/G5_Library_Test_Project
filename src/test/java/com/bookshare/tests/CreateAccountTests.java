package com.bookshare.tests;

import com.bookshare.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition(){
    if(!app.getHeader().isLoginLinkPresent()){
      app.getHeader().clickOnLogOutButton();
    }
    app.getHeader().clickOnLoginButton();
  }


//  @Test // проверка работает ли вообще
//  public void isLoginLinkPresent(){
//    app.getHeader().isLoginLinkPresent();
////    app.getHeader().clickOnSignUpButton();
//
//  }

  @Test(dataProviderClass = DataProvider.class, dataProvider = "addUserFromCsvFile")
  public void RegistrationUserFromCsvPositive(User user){
    app.getHeader().clickOnSignUpButton();
    app.getUser().fillInRegistrationFormFromCsv(user);
    app.getUser().clickOnSignUpButton();
    Assert.assertTrue(app.getHeader().isMyLibraryLinkPresent());
  }

  @Test(dataProviderClass = DataProvider.class, dataProvider = "addUserFromCsvFileNegative")
  public void RegistrationUserFromCsvNegative(User user) {
    app.getHeader().clickOnSignUpButton();
    app.getUser().fillInRegistrationFormFromCsv(user);
    app.getUser().clickOnSignUpButton();
//    Assert.assertEquals("", "");  //TODO get error message
  }

  @Test
  public void RegistrationUserWithoutCheckBoxNegative(){
    app.getHeader().clickOnSignUpButton();
    app.getUser().fillInRegistrationFormWithoutCheckBox("test@mail.com", "Test%555", "Test%555");
    app.getUser().clickOnSignUpButton();
//    Assert.assertTrue(app.getHeader().isAlertPresent()); //TODO get error message
  }

  @Test
  public void RegistrationUserWithoutEmailNegative(){
    app.getHeader().clickOnSignUpButton();
    app.getUser().fillInRegistrationForm(null, "Test%555", "Test%555");
    app.getUser().clickOnSignUpButton();
//    Assert.assertTrue(app.getHeader().isAlertPresent()); //TODO get error message
  }

  @Test
  public void RegistrationUserWithoutPasswordNegative(){
    app.getHeader().clickOnSignUpButton();
    app.getUser().fillInRegistrationForm( "test@mail.com", null, "Test%555");
    app.getUser().clickOnSignUpButton();
//    Assert.assertTrue(app.getHeader().isAlertPresent()); //TODO get error message
  }

  @Test
  public void RegistrationUserWithoutConfirmPasswordNegative(){
    app.getHeader().clickOnSignUpButton();
    app.getUser().fillInRegistrationForm( "test@mail.com",  "Test%555", null);
    app.getUser().clickOnSignUpButton();
//    Assert.assertTrue(app.getHeader().isAlertPresent()); //TODO get error message
  }




}
