package com.bookshare.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddBookTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition(){
    if(app.getHeader().isLoginLinkPresent()){
      app.getHeader().clickOnLoginLink();
      app.getUser().loginUser("anna@mail.com", "$Anna.2023$");
//      app.getUser().loginUser("n2@gmail.com", "Qwerty007!");
    }
  }

  @Test
  public void AddNewBookPositiveTest(){
    app.getHeader().clickOnMyLibraryLink();
    app.getBook().clickOnAddNewBookLink();
    app.getBook().fillInNewBookForm(
        "http://surl.li/kxoqm",
        "The Da Vinci Code",
        "Dan Brown",
        "Detective",
        "592",
        "English",
        "2009",
        "While on a business trip to Paris, Harvard professor Robert Langdon "
            + "answers an urgent late-night phone call. "
            + "The senior curator of the Louvre was brutally murdered inside the walls of the museum."
            + " Next to the victim's body, the police found unknown mysterious ciphers."
    );
    app.getBook().clickOnAddBookButton();
        // TODO    Assert
  }

  @Test
  public void AddNewBookNegativeTest(){
    app.getHeader().clickOnMyLibraryLink();
    app.getBook().clickOnAddNewBookLink();
    app.getBook().clickOnCancelButton();
    Assert.assertTrue(app.getBook().isAddBookLinkPresent());
  }

}
