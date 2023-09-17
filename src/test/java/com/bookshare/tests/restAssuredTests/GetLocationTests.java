package com.bookshare.tests.restAssuredTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class GetLocationTests extends TestBaseApi{

  @Test
  public void getlocationResponse200Test(){
    given().when().get("/api/location/" + randomPostalCode()).then()
        .assertThat().statusCode(200);
  }

  @Test
  public void getlocationCityTest(){
    given().when().get("/api/location/13599").then()
        .assertThat().statusCode(200)
        .body("city", equalTo("Berlin"));
  }

  @Test
  public void getlocationResponse404NegativeTest(){
    given().when().get("/api/location/18754").then()
        .assertThat().statusCode(404);
  }

}
