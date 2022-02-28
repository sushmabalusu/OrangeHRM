package pk_SmartBear;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SmartBear_DataProvider extends WebOrder_TestData{
	WebDriver driver;
	
	  @Test(dataProvider="WebOrder_Login")
	  public void Login(String Uname, String Upass) {
		  driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(Uname);
			driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(Upass);
			driver.findElement(By.id("ctl00_MainContent_login_button")).click();
			driver.findElement(By.linkText("View all orders")).isDisplayed();
		    driver.findElement(By.linkText("Logout")).click();
		    String Actual=driver.findElement(By.id("ctl00_MainContent_login_button")).getText();
		    String expect="Login";
		    Assert.assertEquals(expect, Actual);
}  
	  
	  @BeforeTest
	  public void beforeTest() {
		  
		  WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx");
			driver.manage().window().maximize();
	  }

	  @AfterTest
	  public void afterTest() {
		  driver.quit();
	  }

}
