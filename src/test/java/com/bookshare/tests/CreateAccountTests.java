package com.bookshare.tests;

import com.bookshare.model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

//  @BeforeMethod
//  public void ensurePrecondition(){
//    if(!app.getHeader().isLoginLinkPresent()){
//      app.getHeader().clickOnLogOutButton();
//    }
//    app.getHeader().clickOnLoginButton();
//  }


  @Test
  public void isLoginLinkPresent(){
    app.getHeader().isLoginLinkPresent();
  }

  @Test(dataProviderClass = DataProvider.class, dataProvider = "addUserFromCsvFile")
  public void RegistrationUserFormFromCsvPositive(User user){
    app.getHeader().clickOnSignUpButton();
    app.getUser().fillInRegistrationForm(user);
    app.getUser().clickOnSignUpButton();
  }

}
