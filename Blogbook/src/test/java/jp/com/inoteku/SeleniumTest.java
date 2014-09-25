package jp.com.inoteku;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSelenium() throws Exception {
    driver.get(baseUrl + "/Blogbook/rest");
    driver.findElement(By.id("title")).clear();
    driver.findElement(By.id("title")).sendKeys("sampletitle");
    driver.findElement(By.id("message")).clear();
    driver.findElement(By.id("message")).sendKeys("samplemessage1");
    driver.findElement(By.id("add")).click();
    
    WebElement webElement = driver.findElement(By.cssSelector("div.viewtitle > label"));
    assertThat("sampletitle", is(webElement.getText()));
    webElement = driver.findElement(By.cssSelector("div.viewmessage > label"));
    assertThat("samplemessage1", is(webElement.getText()));
    
    driver.findElement(By.cssSelector("div.viewmessage > label")).click();
    
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("button.delete")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
