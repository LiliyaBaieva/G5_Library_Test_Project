package com.bookshare.tests.restAssuredTests;

import static io.restassured.RestAssured.given;
import com.bookshare.dto.AuthResponseDto;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertNotNull;

public class RALoginTest extends TestBaseApi{

  @Test
  public void loginSuccessTest1(){
    AuthResponseDto response = given()
        .contentType(ContentType.fromContentType("application/x-www-form-urlencoded"))
        .body("username=test2@gmail.com&password=Qwerty007!")
        .when()
        .post("/api/login")
        .then()
        .assertThat().statusCode(200)
        .extract().response().as(AuthResponseDto.class);
    System.out.println(response.getToken());
  }

  @Test
  public void loginSuccessTest2(){
    given()
        .contentType(ContentType.fromContentType("application/x-www-form-urlencoded"))
        .body("username=anna@mail.com&password=$Anna.2023$")
        .when()
        .post("/api/login")
        .then()
        .assertThat().statusCode(200)
        .extract().response().as(AuthResponseDto.class);
//        .extract().path("message");
  }

  @Test
  public void loginNotRegisteredUserNegativeTest1(){
    given()
        .contentType(ContentType.fromContentType("application/x-www-form-urlencoded"))
        .body("username=annna@mail.com&password=$Annna.2023$")
        .when()
        .post("/api/login")
        .then()
        .assertThat().statusCode(401);
  }

  @Test
  public void loginWithWrongPasswordNegativeTest1(){
    given()
        .contentType(ContentType.fromContentType("application/x-www-form-urlencoded"))
        .body("username=anna@mail.com&password=$Annna.2023$")
        .when()
        .post("/api/login")
        .then()
        .assertThat().statusCode(401);

  }

  @Test
  public void loginUserWithCookieTest(){
    Cookie cookie =  loginWithUser("anna@mail.com", "$Anna.2023$");
    System.out.println(cookie);
    assertNotNull(cookie);
  }

}












