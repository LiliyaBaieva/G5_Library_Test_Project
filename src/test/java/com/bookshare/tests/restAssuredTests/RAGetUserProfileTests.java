package com.bookshare.tests.restAssuredTests;

import static io.restassured.RestAssured.given;

import com.bookshare.dto.UserProfileDto;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RAGetUserProfileTests extends TestBaseApi{

  Cookie sessionCookie;

  @BeforeMethod
  //login user
  public void precondition() {
    sessionCookie = loginWithUser("anna@mail.com", "$Anna.2023$");
  }

  @Test
  public void getUserProfileTest(){
    given()
        .cookie(sessionCookie)
        .when().get("/api/users/me").then()
        .assertThat().statusCode(200)
        .extract().response().as(UserProfileDto.class);
  }

  @Test
  public void getNotAutorisedUserProfileNegativeTest(){
    given()
        .when().get("/api/users/me").then()
        .assertThat().statusCode(401);
  }

}
