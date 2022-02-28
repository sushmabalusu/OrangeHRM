package pk_OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_AllTestCasesExe extends OrangeHRM_TestData {
  
  WebDriver driver;

	@Test(dataProvider="LoginScenario")
	public void Login_Validation(String uname, String upass, String ExpectedResult) throws InterruptedException {

		// Enter the URL
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		// Enter the valid Username and valid Password
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(upass);
		// click on the Login Button
		driver.findElement(By.cssSelector("input[id='btnLogin']")).click();
		// verify Dashboard page is displayed
		try 
		 {
		  
		  Boolean boolDisplayed = driver.findElement(By.linkText("Dashboard")).isDisplayed();
		  
		  if (boolDisplayed) 
		  {
		   System.out.println("Successfull Login");
		   String strCurrDashboardLabel = driver.findElement(By.linkText("Dashboard")).getText();   
		   Assert.assertEquals(ExpectedResult, strCurrDashboardLabel);
		 //Logout from the application
		   driver.findElement(By.partialLinkText("Welcome")).click();
		   Thread.sleep(3000);
		   driver.findElement(By.linkText("Logout")).isDisplayed();
		   driver.findElement(By.linkText("Logout")).click();
		   driver.findElement(By.name("Submit")).isDisplayed();  
		  }
		  else {
		   System.out.println("Unsuccessfull Login");
		   String strInvalidLoginMessage = driver.findElement(By.id("spanMessage")).getText();
		   Assert.assertEquals(ExpectedResult, strInvalidLoginMessage);
		  }

		 }
		 catch(Exception e)
		 {
		   e.printStackTrace();
		 } 

	}

	@BeforeTest
	public void LaunchBrowser() {
		// Launch the Browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
