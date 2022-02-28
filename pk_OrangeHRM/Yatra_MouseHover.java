package pk_OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Yatra_MouseHover {
	
	@Test
	
	public void Mouse() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.yatra.com/");
			
			//First Mouse Hover on Admin Tab
			WebElement admin = driver.findElement(By.xpath("//a[contains(text(),'My Account')]"));
			
			Actions action = new Actions(driver);
			action.moveToElement(admin).build().perform();
			
			//Second Mouse Hover on Job Sub Tab
			WebElement Job = driver.findElement(By.cssSelector("li[class='list-dropdown customer-support-ddn'] a[class='dropdown-toggle']"));
			action.moveToElement(Job).build().perform();
		
			//Finally Click on Job Titles under the Job Sub Tab
			driver.findElement(By.xpath("//a[@class='simple-tab eventTrackable adobeTracking'][normalize-space()='Contact Us']")).click();
			Thread.sleep(3000);
			driver.quit();
		}
}
