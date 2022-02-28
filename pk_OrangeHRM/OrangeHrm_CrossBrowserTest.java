package pk_OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class OrangeHrm_CrossBrowserTest extends OrangeHRM_TestData {
 
  WebDriver driver;
  @Test

	@BeforeTest
	@Parameters("browser")
	public void LaunchBrowser(String browser) throws Exception {

		if(browser.equalsIgnoreCase("firefox")){
		    WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")){
		    WebDriverManager.chromedriver().setup();
		    
		    driver = new ChromeDriver();
		}
		/*else if(browser.equalsIgnoreCase("edge")){
		    WebDriverManager.edgedriver().setup();
		    driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("ie")){
		    WebDriverManager.iedriver().setup();
		    driver = new InternetExplorerDriver();
		}*/
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
	
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
	
	//@Test(dataProvider="Login")
	//public void Login_Validation(String uname, String upass) throws InterruptedException {
	@Test(dataProvider="Login")
	public void Login_Validation(String Uname,String Upass) throws InterruptedException {
		// Enter the URL
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		// Enter the valid Username and valid Password
		//driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		//driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("txtUsername")).sendKeys(Uname);
		driver.findElement(By.name("txtPassword")).sendKeys(Upass);
		// click on the Login Button
		driver.findElement(By.id("btnLogin")).click();
		// verify Dashboard page is displayed
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
		System.out.print("Test Success");
		
		// ----------------To Verify Logout Function without using
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.id("logInPanelHeading")).isDisplayed();
	}
}
