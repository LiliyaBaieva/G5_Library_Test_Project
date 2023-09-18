package com.bookshare.tests.restAssuredTests;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetCategoriesTests extends TestBaseApi{

  @Test
  public void getCategoriesTest(){
    given()
        .contentType(ContentType.JSON)
        .when()
        .get("/api/categories")
        .then()
        .assertThat().statusCode(200);
  }

}
