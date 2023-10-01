package com.bookshare.tests.UITests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteBookFromWantToReadTests extends TestBase{

  private String title;
  @BeforeMethod
  public void ensurePrecondition(){
    if(app.getHeader().isLogOutButtonPresent()) {
      app.getUser().logOutUser();
    }
      app.getHeader().clickOnLoginLink();
      app.getUser().loginUser("anna@mail.com", "$Anna.2023$");
      title = app.getBook().getTitleOfBook(8);
      app.getBook().clickOnGetBookButton();

  }

  @Test
  public void deleteBookFromWantToReadTest(){

    app.getHeader().clickOnMyLibraryLink();
    app.getBook().deleteBookFromWantToRead(title);
    Assert.assertTrue(!app.getBook().isBookWithTitleInWaitingBookPresent(title));

  }


}












