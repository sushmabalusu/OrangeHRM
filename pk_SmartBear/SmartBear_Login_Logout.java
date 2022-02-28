package pk_SmartBear;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class SmartBear_Login_Logout {
	WebDriver driver;
	
	  @Test(priority=1)
	  public void Login() {
		  driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
			driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
			driver.findElement(By.id("ctl00_MainContent_login_button")).click();
			driver.findElement(By.linkText("View all orders")).isDisplayed();
		  
	  }
	  
	  @Test(priority=2)
	  public void Logout() {
		  driver.findElement(By.linkText("Logout")).click();
		  driver.findElement(By.id("ctl00_MainContent_login_button")).isDisplayed();
		  
	  }
	  @BeforeTest
	  public void beforeTest() {
		  
		  WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx");
	  }

	  @AfterTest
	  public void afterTest() {
		  driver.quit();
	  }

}
