package com.bookshare.tests.restAssuredTests;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveBookFromUserBooksListTests extends TestBaseApi{

  private Cookie cookieAnna;

  @BeforeMethod
  public void precondition() {
    cookieAnna = loginWithUser("anna@mail.com", "$Anna.2023$");
  }

  @Test
  public void removeBookFromUserBooksListPositiveTest(){
    addBookToUsersListOfBooks(cookieAnna, 2, 10);

    given()
        .contentType(ContentType.JSON)
        .cookie(cookieAnna)
        .body("{\"bookId\": 2, \"userId\": 10}")
        .when()
        .delete("/api/books/remove")
        .then()
        .assertThat().statusCode(200);
  }

  @Test
  public void removeBookFromNotAuthorizedUserBooksListNegativeTest(){

    given()
        .contentType(ContentType.JSON)
        .body("{\"bookId\": 2, \"userId\": 10}")
        .when()
        .delete("/api/books/remove")
        .then()
        .assertThat().statusCode(401);
  }

  @Test
  public void removeNotExistBookFromUserBooksListNegativeTest(){

    given()
        .contentType(ContentType.JSON)
        .cookie(cookieAnna)
        .body("{\"bookId\": 2, \"userId\": 10}")
        .when()
        .delete("/api/books/remove")
        .then()
        .assertThat().statusCode(404);
  }




}







