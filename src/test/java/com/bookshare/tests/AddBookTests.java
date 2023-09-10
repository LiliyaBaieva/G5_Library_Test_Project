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
    }
  }

  @Test
  public void addNewBookPositiveTest(){
    app.getHeader().clickOnMyLibraryLink();
    app.getBook().clickOnAddNewBookLink();
    app.getBook().fillInNewBookForm(
        "https://www.britishbook.ua/upload/resize_cache/iblock/8ea/01la3lu7sh8f34h4tbpt1o291gdkb5ts/296_500_174b5ed2089e1946312e2a80dcd26f146/kniga_the_da_vinci_code.jpg",
        "The Da Vinci Code",
        "Dan Brown",
        "Detective",
        "592",
        "English",
        "2009",
        "While on a business trip to Paris, Harvard professor Robert Langdon "
            + "answers an urgent late-night phone call... "
    );
//    app.getBook().clickOnAddBookButton();
//
//    Assert.assertTrue(app.getBook().isBookInMyPagePresent("The Da Vinci Code"));

  }

  @Test
  public void cancelAddNewBookTest(){
    app.getHeader().clickOnMyLibraryLink();
    app.getBook().clickOnAddNewBookLink();
    app.getBook().clickOnCancelButton();
    Assert.assertTrue(app.getBook().isAddBookLinkPresent());
  }

}
