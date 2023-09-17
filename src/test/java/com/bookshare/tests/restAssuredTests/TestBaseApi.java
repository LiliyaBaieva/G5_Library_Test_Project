package com.bookshare.tests.restAssuredTests;

import static io.restassured.RestAssured.given;

import com.bookshare.dto.UserProfileDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBaseApi {

  public static final String TOKEN = "";
  final static Logger logger = LoggerFactory.getLogger(TestBaseApi.class);

  @BeforeMethod
  public void precondition(Method method, Object[] parametrs){
    RestAssured.baseURI ="http://localhost:8080";
//    RestAssured.basePath = "/v3/api-docs";
    logger.info("Start test " + method.getName() + " with parametrs: " + Arrays.asList(parametrs));
  }

  @AfterMethod
  public void quit(){
    logger.info("Stop test");
    logger.info("========================");
  }

  public static Cookie loginWithUser(String email, String password) {
    Response loginResponse = given()
        .contentType(ContentType.fromContentType("application/x-www-form-urlencoded"))
        .body("username=" + email + "&password=" + password + "")
        .when()
        .post("/api/login");

    return loginResponse.getDetailedCookie("JSESSIONID");
  }

  public UserProfileDto getUserData(Cookie sessionCookie) {
    return given()
        .cookie(sessionCookie)
        .when().get("/api/users/me").then()
        .extract().response().as(UserProfileDto.class);
  }

  public static String randomPostalCode() {
    String postalCode;
    Random random = new Random();
    int randomInt = random.nextInt(6);
    switch (randomInt) {
      case 1 -> postalCode = "13599";
      case 2 -> postalCode = "01109";
      case 3 -> postalCode = "01067";
      case 4 -> postalCode = "55743";
      case 5 -> postalCode = "60308";
      case 6 -> postalCode = "10111";
      default -> postalCode = "10115";
    }
    return postalCode;
  }

  public Integer randomInt(){
    Random random = new Random();
    return random.nextInt(100);
  }

}
