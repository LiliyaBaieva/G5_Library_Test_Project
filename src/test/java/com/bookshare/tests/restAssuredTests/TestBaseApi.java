package com.bookshare.tests.restAssuredTests;

import io.restassured.RestAssured;
import java.lang.reflect.Method;
import java.util.Arrays;
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
    RestAssured.basePath = "/v3/api-docs";
    logger.info("Start test " + method.getName() + " with parametrs: " + Arrays.asList(parametrs));
  }

  @AfterMethod
  public void quit(){
    logger.info("Stop test");
    logger.info("========================");
  }


}
