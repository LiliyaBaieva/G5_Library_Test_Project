package com.bookshare.tests.restAssuredTests;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetListOfWaitingBooksTests extends TestBaseApi{

  private Cookie cookieAnna;

  @BeforeMethod
  public void precondition() {
    cookieAnna = loginWithUser("anna@mail.com", "$Anna.2023$");
  }

  @Test
  public void getListOfWaitingBooksPositiveTest(){
    given()
        .contentType(ContentType.JSON)
        .cookie(cookieAnna)
        .when()
        .get("/api/books/waiting/10")
        .then()
        .assertThat().statusCode(200);

  }

  @Test
  public void getListOfWaitingBooksWithoutAuthorizationNegativeTest(){
    given()
        .contentType(ContentType.JSON)
//        .cookie(cookieAnna)
        .when()
        .get("/api/books/waiting/10")
        .then()
        .assertThat().statusCode(401);
  }

  @Test
  public void getListOfWaitingBooksAnotherUserNegativeTest(){
    given()
        .contentType(ContentType.JSON)
        .cookie(cookieAnna)
        .when()
        .get("/api/books/waiting/2")
        .then()
        .assertThat().statusCode(403);
  }


}
