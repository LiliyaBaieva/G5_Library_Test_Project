package com.bookshare.fw;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {

  String browser;

  WebDriver driver;

  UserHelper user;
  HeaderHelper header;

  FooterHelper footer;

  public FooterHelper getFooter() {
    return footer;
  }

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
      driver = new ChromeDriver();

//      System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");


      // СПОСОБ 1

//      ChromeOptions options = new ChromeOptions();

      // Создаем объект ChromeOptions и настраиваем опции
//      options.addArguments("--disable-extensions");
//      options.addArguments("--disable-gpu");
//      options.addArguments("--headless"); // Опционально: запуск в безголовом режиме
//      options.addArguments("--no-sandbox"); // Опционально: для безопасного запуска в контейнере
//      options.addArguments("--disable-dev-shm-usage"); // Опционально: для безопасного запуска в контейнере
//      options.addArguments("--proxy-server=http://localhost:3000"); // Указываем адрес localhost:3000
//      driver = new ChromeDriver(options);

      // СПОСОБ 2

//      ChromeOptions options = new ChromeOptions();
//      options.addArguments("remote-allow-origins=*");
//      driver = new ChromeDriver(options);

      // СПОСОБ 3

//      ChromeOptions options = new ChromeOptions();
//      options.addArguments("--proxy-server=*");
//      driver = new ChromeDriver(options);


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
