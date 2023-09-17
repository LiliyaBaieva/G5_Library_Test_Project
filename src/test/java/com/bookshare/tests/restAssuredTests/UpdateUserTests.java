package com.bookshare.tests.restAssuredTests;

import static io.restassured.RestAssured.given;

import com.bookshare.dto.UserProfileDto;
import com.bookshare.dto.UserUpdetedDto;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import java.util.Random;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UpdateUserTests extends TestBaseApi{

  Integer id;
  Cookie sessionCookie;

  @BeforeMethod
  //login user
  public void precondition() {
    sessionCookie = loginWithUser("anna@mail.com", "$Anna.2023$");
    UserProfileDto userData = getUserData(sessionCookie);
    id = (int) (long) (userData.getId());
  }

  @Test
  public void updateUserTest(){
    UserUpdetedDto userData = UserUpdetedDto.builder()
        .firstName("Anna")
        .lastName("Lou")
        .postalCode(randomPostalCode())
        .build();

    given()
        .cookie(sessionCookie)
        .contentType(ContentType.JSON)
        .body(userData)
        .when()
        .put("/api/users/" + id)
        .then()
        .assertThat().statusCode(200);
  }



}
