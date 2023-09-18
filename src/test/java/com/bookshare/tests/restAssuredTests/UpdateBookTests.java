package com.bookshare.tests.restAssuredTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.bookshare.dto.AddBookDto;
import com.bookshare.dto.UpdatedBookDto;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UpdateBookTests extends TestBaseApi {

  private Cookie cookie;

  @BeforeMethod
  public void precondition() {
    cookie = loginWithUser("anna@mail.com", "$Anna.2023$");
  }

  @Test
  public void updateBookPositiveTests() {

    int nuOfPages = randomInt() * 10;
    AddBookDto updatedBook = AddBookDto.builder()
        .title("Test Book update")
        .author("Test Author")
        .description("Some description")
        .categoryId(1)
        .languageId(1)
        .pages(nuOfPages)
        .publisherDate("2000")
        .cover(
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/11/Test-Logo.svg/783px-Test-Logo.svg.png")
        .owner(10)
        .build();

    UpdatedBookDto updatedBookData = given()
        .cookie(cookie)
        .contentType(ContentType.JSON)
        .body(updatedBook)
        .when()
        .put("/api/books/31")
        .then()
        .assertThat().statusCode(200)
        .assertThat().body("title", equalTo("Test Book update"))
        .assertThat().body("pages", equalTo(nuOfPages + ""))
        .extract().body().as(UpdatedBookDto.class);
    String title = updatedBookData.getTitle();
    Integer pages = updatedBookData.getPages();
    System.out.println("title: " + title);
    System.out.println("pages: " + pages);
  }


}