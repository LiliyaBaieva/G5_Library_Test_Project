package com.bookshare.tests.restAssuredTests;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class GetListForFiltersTests extends TestBaseApi{

  @Test
  public void getListForFiltersPositiveTest(){
    given()
        .contentType(ContentType.JSON)
        .when()
        .get("/api/books/filter")
        .then()
        .assertThat().statusCode(200);

  }

}
