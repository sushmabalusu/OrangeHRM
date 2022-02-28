package pk_OrangeHRM;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Admin_AddUser {

  WebDriver driver;

	@Test(priority = 1)
	public void Login_Validation() throws InterruptedException {

		// Enter the URL
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		// Enter the valid Username and valid Password
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");
		// click on the Login Button
		driver.findElement(By.cssSelector("input[id='btnLogin']")).click();
		// verify Dashboard page is displayed
		driver.findElement(By.linkText("Dashboard")).isDisplayed();

	}
	@Test(priority = 2)
	public void Adduser() throws InterruptedException {
		// Click on Admin->Add user and Add user details in User page

		driver.findElement(By.linkText("Admin")).click();
		//Click on Add Button
		driver.findElement(By.id("btnAdd")).click();
		Select SelectPass = new Select(driver.findElement(By.id("systemUser_userType")));
		//SelectPass.selectByValue("1");
		//SelectPass.selectByIndex(0);
		SelectPass.selectByVisibleText("Admin");
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Fiona Grace");

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		driver.findElement(By.id("systemUser_userName")).sendKeys("abhi" + randomInt);
		//String ExpUserName=driver.findElementById("systemUser_userName").getText();
		driver.findElement(By.id("systemUser_password")).sendKeys("admin123");
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("admin123");
		Thread.sleep(2000);
		driver.findElement(By.id("btnSave")).click();

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
