package com.bookshare.fw;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {

  String browser;

  WebDriver driver;

  UserHelper user;
  HeaderHelper header;

  public HeaderHelper getHeader() {
    return header;
  }

  public void setUser(UserHelper user) {
    this.user = user;
  }

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init () {

    if(browser.equalsIgnoreCase("chrome")){
      System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
//      driver = new ChromeDriver();
      // Создаем объект ChromeOptions и настраиваем опции
      ChromeOptions options = new ChromeOptions();
//      options.addArguments("--disable-extensions");
//      options.addArguments("--disable-gpu");
//      options.addArguments("--headless"); // Опционально: запуск в безголовом режиме
//      options.addArguments("--no-sandbox"); // Опционально: для безопасного запуска в контейнере
//      options.addArguments("--disable-dev-shm-usage"); // Опционально: для безопасного запуска в контейнере
      options.addArguments("--proxy-server=http://localhost:3000"); // Указываем адрес localhost:3000
      driver = new ChromeDriver(options);

    } else if (browser.equalsIgnoreCase("firefox")) {
      driver = new FirefoxDriver();
    } else if (browser.equalsIgnoreCase("edge")) {
      EdgeOptions options = new EdgeOptions();
      options.addArguments("remote-allow-origins=*");
      driver = new EdgeDriver(options);
    }

    driver.get("http://localhost:3000");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

  }

  public void stop(){
    driver.quit();
  }

  public UserHelper getUser() {
    return user;
  }
}
