package com.bookshare.tests.restAssuredTests;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetListOfBookToReadTests extends TestBaseApi{


  private Cookie cookieAnna;

  @BeforeMethod
  public void precondition() {
    cookieAnna = loginWithUser("anna@mail.com", "$Anna.2023$");
  }

  @Test
  public void getListOfBookToReadPositiveTest(){
    given()
        .contentType(ContentType.JSON)
        .cookie(cookieAnna)
        .when()
        .get("/api/books/history/10")
        .then()
        .assertThat().statusCode(200);
  }

  // Want to get a list of Book another user 403
  @Test
  public void getListOfBookToReadAnotherUserNegativeTest(){
    given()
        .contentType(ContentType.JSON)
        .cookie(cookieAnna)
        .when()
        .get("/api/books/history/7")
        .then()
        .assertThat().statusCode(403);
  }

  // Want to get a list of Book another user also 403
  @Test
  public void getListOfBookToReadUserWithoutAuthorizationNegativeTest(){
    given()
        .contentType(ContentType.JSON)
//        .cookie(cookieAnna)
        .when()
        .get("/api/books/history/7")
        .then()
        .assertThat().statusCode(403);
  }

  @Test
  public void getListOfBookToReadUserNotExistNegativeTest(){
    given()
        .contentType(ContentType.JSON)
//        .cookie(cookieAnna)
        .when()
        .get("/api/books/history/100")
        .then()
        .assertThat().statusCode(404);
  }

}
