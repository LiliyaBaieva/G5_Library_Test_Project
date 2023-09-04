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

  public void setUser(UserHelper user) {
    this.user = user;
  }

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init () {

    if(browser.equalsIgnoreCase("chrome")){
      driver = new ChromeDriver();
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
