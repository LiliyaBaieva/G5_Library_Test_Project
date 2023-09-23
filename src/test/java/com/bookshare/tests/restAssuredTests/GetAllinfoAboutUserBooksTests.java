package com.bookshare.tests.restAssuredTests;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetAllinfoAboutUserBooksTests extends TestBaseApi{

  private Cookie cookieAnna;

  @BeforeMethod
  public void precondition() {
    cookieAnna = loginWithUser("anna@mail.com", "$Anna.2023$");
  }

  @Test
  public void GetAllinfoAboutUserBooksPositiveTest(){
    given()
        .contentType(ContentType.JSON)
        .cookie(cookieAnna)
        .when()
        .get("/api/books/all/10")
        .then()
        .assertThat().statusCode(200);
  }

  @Test
  public void GetAllinfoAboutUserBooksWithoutAuthorizationNegativeTest(){
    given()
        .contentType(ContentType.JSON)
//        .cookie(cookieAnna)
        .when()
        .get("/api/books/all/10")
        .then()
        .assertThat().statusCode(401);
  }

  @Test
  public void GetAllinfoAboutAnotherUserBooksNegativeTest(){
    given()
        .contentType(ContentType.JSON)
        .cookie(cookieAnna)
        .when()
        .get("/api/books/all/100")
        .then()
        .assertThat().statusCode(404);
  }



}
