package com.bookshare.tests.restAssuredTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import com.bookshare.dto.AddBookDto;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddBookTests extends TestBaseApi {

  public Integer bookId;
  private Cookie cookieValidUser;
  private Cookie cookieUserWithoutData;

  @BeforeMethod
  public void precondition() {
     cookieValidUser = loginWithUser("anna@mail.com", "$Anna.2023$");
     cookieUserWithoutData = loginWithUser("mark@mail.com", "Qwerty$111");
  }

  @Test
  public void addBookPositiveTests(){
    AddBookDto newBook = AddBookDto.builder()
        .title("Test Book")
        .author("Test Author")
        .description("Some description")
        .categoryId(1)
        .languageId(1)
        .pages(200)
        .publisherDate("2000")
        .cover("https://upload.wikimedia.org/wikipedia/commons/thumb/1/11/Test-Logo.svg/783px-Test-Logo.svg.png")
        .owner(10)
        .build();

    given()
        .cookie(cookieValidUser)
        .contentType(ContentType.JSON)
        .body(newBook)
        .when()
        .post("/api/books")
        .then()
        .assertThat().statusCode(201)
        .assertThat().body("title", equalTo("Test Book"))
        .assertThat().body("author", equalTo("Test Author"))
        .assertThat().body("publisherDate", equalTo("2000"));
  }

 @Test
  public void addBookNotAuthorizedUserNegativeTests(){
    AddBookDto newBook = AddBookDto.builder()
        .title("Test Book negative")
        .author("Test Author negative")
        .description("Some description of negative test ")
        .categoryId(1)
        .languageId(1)
        .pages(200)
        .publisherDate("2000")
        .cover("https://upload.wikimedia.org/wikipedia/commons/thumb/1/11/Test-Logo.svg/783px-Test-Logo.svg.png")
        .owner(10)
        .build();

    given()
       .contentType(ContentType.JSON)
       .body(newBook)
       .when()
       .post("/api/books")
       .then()
       .assertThat().statusCode(401)
       .assertThat().body("message", containsString("User unauthorized"));
 }

  @Test
  public void addBookForUserWithoutDataNegativeTests(){
    AddBookDto newBook = AddBookDto.builder()
        .title("Test Book")
        .author("Test Author")
        .description("Some description")
        .categoryId(1)
        .languageId(1)
        .pages(200)
        .publisherDate("2000")
        .cover("https://upload.wikimedia.org/wikipedia/commons/thumb/1/11/Test-Logo.svg/783px-Test-Logo.svg.png")
        .owner(10)
        .build();

    given()
        .cookie(cookieUserWithoutData)
        .contentType(ContentType.JSON)
        .body(newBook)
        .when()
        .post("/api/books")
        .then()
        .assertThat().statusCode(403);
  }


}










