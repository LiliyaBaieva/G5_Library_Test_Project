package com.bookshare.tests.UITests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UpdateBookTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition(){
    // login
    if(app.getHeader().isLoginLinkPresent()){
      app.getHeader().clickOnLoginLink();
      app.getUser().loginUser("anna@mail.com", "$Anna.2023$");
    }

    // add book
    app.getHeader().clickOnMyLibraryLink();
    app.getBook().clickOnAddNewBookLink();
    app.getBook().fillInNewBookForm(
        "https://www.britishbook.ua/upload/resize_cache/iblock/e2f/"
            + "i5c2c1rn9ic5m4mzpewo3b16rg0m1b87/348_557_174b5ed2089e1946312e2a80dcd26f146"
            + "/kniga_pinocchio.jpg",
        "Pinocchio",
        "Carlo Collodi",
        "Fairy tales",
        "192",
        "English",
        "1998",
        "Carved by old Geppetto, Pinocchio has a huge nose that grows every time he tells"
            + " a lie. Pinocchio is such a mischievous person that easily gets into various troubles."
    );
    app.getBook().clickOnAddBookButton();

  }

  @Test
  public void updateBookTest(){
    app.getBook().clickOnMyBookButton();
    app.getBook().clickMoreInfoOfBookLinkByTitle("Pinocchio");
    app.getBook().clickOnUpdateButton();
    app.getBook().changeDataOfBook(
        "https://www.britishbook.ua/upload/resize_cache/iblock/e2f/"
            + "i5c2c1rn9ic5m4mzpewo3b16rg0m1b87/348_557_174b5ed2089e1946312e2a80dcd26f146"
            + "/kniga_pinocchio.jpg",
        "Pinocchio",
        "Carlo Collodi",
        "Fairy tales",
        "192",
        "German",
        "1998",
        "Carved by old Geppetto, Pinocchio has a huge nose that grows every time he tells"
            + " a lie. Pinocchio is such a mischievous person that easily gets into various troubles.");
    app.getBook().clickOnUpdateBookButton();

//    System.out.println("*********************" + app.getBook().getLanguageOfBook("Pinocchio"));
    Assert.assertEquals(app.getBook().getLanguageOfBook("Pinocchio"), "German");
  }

}
