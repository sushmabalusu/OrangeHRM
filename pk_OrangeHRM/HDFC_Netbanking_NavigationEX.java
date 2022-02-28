package pk_OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class HDFC_Netbanking_NavigationEX {
	
	WebDriver driver;
	
  @Test 
  public void Navigation_command() throws InterruptedException {
	  driver.switchTo().frame("login_page");
	  driver.findElement(By.cssSelector("input[name='fldLoginUserId']")).sendKeys("1000");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[normalize-space()='CONTINUE']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//div[normalize-space()='Login to NetBanking']")).isDisplayed();
	  driver.navigate().back();
	  Thread.sleep(5000);
	  //driver.findElement(By.xpath("//a[normalize-space()='CONTINUE']")).isDisplayed();
	  driver.navigate().forward();
	  Thread.sleep(5000);
	  //driver.findElement(By.cl("//a[normalize-space()='LOGIN']"));
	  driver.navigate().to("https://www.google.com/");
	  

	  
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
