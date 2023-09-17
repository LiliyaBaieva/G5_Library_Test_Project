package com.bookshare.tests.restAssuredTests;

import static io.restassured.RestAssured.given;

import com.bookshare.dto.AuthResponseDto;
import com.bookshare.dto.RegistrationUserDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class RARegistrationUserTests extends TestBaseApi{

  @Test
  public void registerUserPositiveTest(){

    RegistrationUserDto user = RegistrationUserDto.builder()
        .email("jon" + randomInt() + "@mail.com")
        .password("Qwerty$333")
        .confirmPassword("Qwerty$333")
        .build();

    AuthResponseDto response = given()
        .contentType(ContentType.JSON)
        .body(user)
        .when()
        .post("/api/registration")
        .then()
        .assertThat().statusCode(201)
        .extract().response().as(AuthResponseDto.class);

    System.out.println(response);

  }

}
