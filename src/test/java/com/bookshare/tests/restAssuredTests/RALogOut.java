package com.bookshare.tests.restAssuredTests;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RALogOut extends TestBaseApi{
  Cookie sessionCookie;

  @BeforeMethod
  //login user
  public void precondition() {
    sessionCookie = loginWithUser("anna@mail.com", "$Anna.2023$");
  }

  @Test
  public void logOutUserTest(){
    given()
        .cookie(sessionCookie)
        .contentType(ContentType.JSON)
        .when().post("/api/logout").then()
        .assertThat().statusCode(200);
  }

}
