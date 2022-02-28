package pk_OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Login_Parameter_EX {
  WebDriver driver;

	@Test 
	@Parameters({"uname","upass"})
	
	public void ValidateLogin(String Uname, String Upass) throws InterruptedException {
		
		driver.findElement(By.id("txtUsername")).sendKeys(Uname);
		driver.findElement(By.id("txtPassword")).sendKeys(Upass);
		driver.findElement(By.id("btnLogin")).click();
		// verify Dashboard page is displayed
				//driver.findElement(By.linkText("Dashboard")).isDisplayed();

				// Logout from OrangeHRM and Verify that user has logged out

				//driver.findElement(By.partialLinkText("Welcome")).click();
				//Thread.sleep(2000);
				//driver.findElement(By.linkText("Logout")).click();
				
		
	}
@BeforeTest
	
	public void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	}
	
	@AfterTest
	
	public void CloseBrowser(){
		driver.quit();
		
	}

}
