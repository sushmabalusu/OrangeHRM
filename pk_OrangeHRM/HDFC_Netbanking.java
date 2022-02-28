package pk_OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class HDFC_Netbanking {
	
	WebDriver driver;
	
  @Test 
  public void Login() {
	  driver.switchTo().frame("login_page");
	  driver.findElement(By.cssSelector("input[name='fldLoginUserId']")).sendKeys("1000");
	  driver.findElement(By.xpath("//a[normalize-space()='CONTINUE']")).click();
		
	  
  }
  @BeforeTest
  public void beforeTest() {
	  
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
