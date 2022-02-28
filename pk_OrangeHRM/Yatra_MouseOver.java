package pk_OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Yatra_MouseOver {
	ChromeDriver driver;

	@BeforeTest
	public void LaunchBrowser() {
		// Launch the Browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.yatra.com/");
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

	public void MouseHover() throws InterruptedException

	{
		
		//First Mouse Hover on Admin Tab
		WebElement admin = driver.findElement(By.id("menu_admin_viewAdminModule"));
		
		Actions action = new Actions(driver);
		action.moveToElement(admin).build().perform();
		
		//Second Mouse Hover on Job Sub Tab
		WebElement Job = driver.findElement(By.id("menu_admin_Job"));
		action.moveToElement(Job).build().perform();
	
		//Finally Click on Job Titles under the Job Sub Tab
		driver.findElement(By.linkText("Job Titles")).click();
		driver.findElement(By.xpath("//h1[normalize-space()='Job Titles']")).isDisplayed();
		Thread.sleep(3000);
	}
}


