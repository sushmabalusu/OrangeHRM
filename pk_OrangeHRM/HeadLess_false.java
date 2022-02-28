package pk_OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class HeadLess_false {
	WebDriver driver;
  
	@Test
   public void Chrome_Headless() {

			driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
			driver.findElement(By.name("txtUsername")).sendKeys("Admin");
			driver.findElement(By.name("txtPassword")).sendKeys("admin123");
			driver.findElement(By.id("btnLogin")).click();
  }
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
		// WebDriverManager.firefoxdriver().setup();
		// WebDriverManager.edgedriver().setup();

		// EdgeOptions options = new EdgeOptions();
		// FirefoxOptions options = new FirefoxOptions();
		ChromeOptions options = new ChromeOptions();
	  driver = new ChromeDriver(options);
	  options.setHeadless(false);
	  driver.manage().window().maximize();

		
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
	  
  }

}
