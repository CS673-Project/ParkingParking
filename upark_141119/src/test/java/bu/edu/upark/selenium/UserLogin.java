package bu.edu.upark.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UserLogin {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void testUserLoginCorrect() throws Exception {
    driver.get(baseUrl + "/upark/#/");
    driver.findElement(By.cssSelector("span.ng-binding")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("fshi@bu.edu");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("//li[3]/a/span[2]")).click();
  }
  
  @Test
  public void testUserLoginIllegalUserName1() throws Exception {
	  driver.get(baseUrl + "/upark/#/");
	  driver.findElement(By.cssSelector("span.ng-binding")).click();
	  driver.findElement(By.name("username")).clear();
	  driver.findElement(By.name("username")).sendKeys("fshi");
	  // get return value from javascript
	  
  }

  @Test
  public void testUserLoginIllegalUserName2() throws Exception {
	  driver.get(baseUrl + "/upark/#/");
	  driver.findElement(By.cssSelector("span.ng-binding")).click();
	  driver.findElement(By.name("username")).clear();
	  driver.findElement(By.name("username")).sendKeys("fshi@bu");
	  

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
