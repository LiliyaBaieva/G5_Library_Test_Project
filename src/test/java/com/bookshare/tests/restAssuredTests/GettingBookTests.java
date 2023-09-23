package com.bookshare.tests.restAssuredTests;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GettingBookTests extends TestBaseApi{

  private Cookie cookieAnna;
  private Cookie cookieN2;

  @BeforeMethod
  public void precondition() {
    cookieAnna = loginWithUser("anna@mail.com", "$Anna.2023$");
    cookieN2 = loginWithUser("n2@gmail.com", "Qwerty007!");
  }

  @Test
  public void gettingBookRegisteredUserPositiveTest(){

    given()
        .cookie(cookieAnna)
        .contentType(ContentType.JSON)
        .body("{\"bookId\": 2, \"userId\": 10}")
        .when()
        .post("/api/books/getting")
        .then()
        .assertThat().statusCode(200);

    removeBookFromUserBooksList(cookieAnna, 2, 10);
  }

  @Test
  public void gettingBookUserAlreadyHaveNegativeTest(){

    given()
        .cookie(cookieN2)
        .contentType(ContentType.JSON)
        .body("{\"bookId\": 3, \"userId\": 7}")
        .when()
        .post("/api/books/getting")
        .then()
        .assertThat().statusCode(403);
  }

  @Test
  public void gettingBookNotRegisteredUserNegativeTest(){

    given()
        .contentType(ContentType.JSON)
        .body("{\"bookId\": 2, \"userId\": 10}")
        .when()
        .post("/api/books/getting")
        .then()
        .assertThat().statusCode(401);
  }

  @Test
  public void gettingNotExistBookNegativeTest(){

    given()
        .cookie(cookieAnna)
        .contentType(ContentType.JSON)
        .body("{\"bookId\": 200, \"userId\": 10}")
        .when()
        .post("/api/books/getting")
        .then()
        .assertThat().statusCode(404);
  }

//  @AfterMethod

}
