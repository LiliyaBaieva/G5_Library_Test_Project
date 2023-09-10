package com.bookshare.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchBookTests extends TestBase{

  @Test
  public void searchBookByTitleTest(){
    String searchedTitle = app.getBook().getTitleOfBook(3);
    app.getBook().searchBookByTitle(searchedTitle);
    String resultTitle = app.getBook().getTitleOfBook(1);
    Assert.assertEquals(searchedTitle, resultTitle);
  }

  @Test
  public void searchBookByAuthorTest(){
    String searchedAuthor = app.getBook().getAuthorOfBook(3);
    app.getBook().searchBookByAuthor(searchedAuthor);
    String resultAuthor = app.getBook().getAuthorOfBook(1);
    Assert.assertEquals(searchedAuthor, resultAuthor);
  }

}
