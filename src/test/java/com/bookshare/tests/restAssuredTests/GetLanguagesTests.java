package com.bookshare.tests.restAssuredTests;

import static io.restassured.RestAssured.given;

import com.bookshare.tests.restAssuredTests.TestBaseApi;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetLanguagesTests extends TestBaseApi {

  Cookie sessionCookie;

  @BeforeMethod
  public void precondition(){
    sessionCookie = loginWithUser("anna@mail.com", "$Anna.2023$");
  }

  @Test
  public void getLanguagesTest(){
    given()
        .contentType(ContentType.JSON)
        .cookie(sessionCookie)
        .when()
        .get("/api/languages")
        .then()
        .assertThat().statusCode(200);
  }

  @Test
  public void getLanguagesWithoutAuthorizationNegativeTest(){
    given()
        .contentType(ContentType.JSON)
        .when()
        .get("/api/languages")
        .then()
        .assertThat().statusCode(401);
  }

}
