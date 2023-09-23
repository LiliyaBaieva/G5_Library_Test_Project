package com.bookshare.tests.restAssuredTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.bookshare.dto.BookDto;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetBookTests extends TestBaseApi{

  @Test
  public void getBookPositiveTest(){

    given()
        .contentType(ContentType.JSON)
        .when()
        .get("/api/books/2/detail")
        .then()
        .assertThat().statusCode(200)
        .assertThat().body("title", equalTo("The Chronicles of Narnia"))
        .assertThat().body("author", equalTo("Murphy Raymond"))
        .assertThat().body("pages", equalTo("556"))
        .assertThat().body("publisherDate", equalTo("2019"));
  }

  @Test
  public void getNotExistBookNegativeTest(){

    given()
        .contentType(ContentType.JSON)
        .when()
        .get("/api/books/200/detail")
        .then()
        .assertThat().statusCode(404);
  }

}
