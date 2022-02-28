package pk_OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class OrangeHRM_TestNGEX_priority {
	
	WebDriver driver;
	
  @Test (priority=1)
  public void Login_Valid_credentials() {
	  driver.findElement(By.cssSelector("input[name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		//verify login
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
  }
  @Test (priority=2)
	public void Logout() throws InterruptedException {
	  driver.findElement(By.partialLinkText("Welcome")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.linkText("Logout")).click();
	  driver.findElement(By.linkText("Forgot your password?")).isDisplayed();
		
	}
  
  @BeforeTest
  public void beforeTest() {
	  
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
