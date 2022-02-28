package pk_SmartBear;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SmartBear_Weborder_Add_Update {
	WebDriver driver;
	
	  @Test(priority=1)
	  public void Login() {
		  driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		  driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		  driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		  driver.findElement(By.linkText("View all orders")).isDisplayed();
	  }
		  @Test(priority=2)
		  
		  public void Details() throws InterruptedException {
		  driver.findElement(By.linkText("Order")).click();
		//To select the value from Dropdown
			Select selectproduct = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
			selectproduct.selectByVisibleText("FamilyAlbum");
			Thread.sleep(5000);
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("10");
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice")).sendKeys("5");
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtDiscount")).sendKeys("6");
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal")).sendKeys("5");
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys("sushma");
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("dsnr");
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("hyd");
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("Telangana");
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("500060");
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("5000608765");
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("22/06");
		  driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();

			String ActOutput = driver.findElement(By.tagName("strong")).getText();
			String ExpOutput = "New order has been successfully added.";
			Assert.assertEquals(ActOutput, ExpOutput);
		  
		  }
		  @Test(priority=3)
		  public void Verify() throws InterruptedException
		  {
			  driver.findElement(By.linkText("View all orders")).click();
			  String ExpUserName = "sushma";
				driver.navigate().refresh();
				Thread.sleep(2000);
				WebElement cellIneed = driver.findElement(By.xpath("//td[normalize-space()='"+ ExpUserName +"']"));
				String ActualUserName = cellIneed.getText();
			    System.out.println("Cell value is : " + ActualUserName); 
			    Assert.assertEquals(ExpUserName, ActualUserName);
			  
			  
		  }
		  
		  @Test(priority=4)
		  public void Update() throws InterruptedException
		  {
			  driver.findElement(By.xpath("//tbody/tr[2]/td[13]/input[1]")).click();
			  driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).clear();
			  driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("chennai");
			  driver.findElement(By.linkText("Update")).click();
				Thread.sleep(3000);
				// Verify that City name updated
				String ActOutputCity = driver
						.findElement(By.xpath("//td[text()='sushma']/following-sibling::td[text()='chennai']")).getText();
				String ExpOutputCity = "chennai";
				Assert.assertEquals(ActOutputCity, ExpOutputCity);
		  }
		  
	  
	  @Test(priority=5)
	 public void Logout() {
		 driver.findElement(By.linkText("Logout")).click();
		 driver.findElement(By.id("ctl00_MainContent_login_button")).isDisplayed();
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
