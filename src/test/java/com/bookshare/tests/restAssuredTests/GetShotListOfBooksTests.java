package com.bookshare.tests.restAssuredTests;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetShotListOfBooksTests extends TestBaseApi{

  private Cookie cookieAnna;

  @BeforeMethod
  public void precondition() {
    cookieAnna = loginWithUser("anna@mail.com", "$Anna.2023$");
  }

  @Test
  public void getShotListOfBooksPositiveTest(){
    given()
        .contentType(ContentType.JSON)
        .cookie(cookieAnna)
        .when()
        .get("/api/books")
        .then()
        .assertThat().statusCode(200);

  }

    @Test
  public void getShotListOfBooksWithoutAuthorizationTest(){
    given()
        .contentType(ContentType.JSON)
//        .cookie(cookieAnna)
        .when()
        .get("/api/books")
        .then()
        .assertThat().statusCode(403);

  }


}











