package com.bookshare.tests;

import static io.restassured.RestAssured.given;

import com.bookshare.model.AuthRequestDto;
import com.bookshare.model.AuthResponseDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class RALoginTests extends TestBase{

  @Test
  public void loginSuccessTest() {

    AuthRequestDto auth = AuthRequestDto.builder()
        .username("anna@mail.com")
        .password("$Anna.2023$")
        .build();

    AuthResponseDto responseDto = given()
        .contentType(ContentType.JSON)
        .body(auth)
        .when()
        .post("api/login")
        .then()
        .assertThat().statusCode(200)
        .extract().response().as(AuthResponseDto.class);

    System.out.println(responseDto.getToken());
  }

}
