package pk_SmartBear;

import java.sql.SQLException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pk_OrangeHRM.BaseClass;

public class ReadDatafrom_Db_BaseClass extends BaseClass {
	ChromeDriver driver;

	@BeforeTest
	public void LaunchApp() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		driver.manage().window().maximize();
	}

	@Test
	public void ConnectSQLDB_With_LoginApp() throws ClassNotFoundException, SQLException, InterruptedException,
			InstantiationException, IllegalAccessException {

		ArrayList<String> sqlData = ConnectMySQLDatabase("jdbc:mysql://localhost:3306/weborder", "root", "root");
		System.out.println("SQL Data from DB Example Class : " + sqlData + "\n Array List Size : " + sqlData.size());

		for (String sqlValues : sqlData) {
			System.out.println(sqlValues + " split : 0\t" + sqlValues.split("~")[0]);
			System.out.println(sqlValues + " split : 1\t" + sqlValues.split("~")[1]);
			String uname=sqlValues.split("~")[0];
			String upass=sqlValues.split("~")[1];
			//String expresult=sqlValues.split("~")[1];

			 driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(uname);
     		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(upass);
     		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
     		driver.findElement(By.linkText("View all orders")).isDisplayed();
     		driver.findElement(By.linkText("Logout")).click();
     		Thread.sleep(3000);
     		driver.findElement(By.id("ctl00_MainContent_login_button")).isDisplayed();
			Thread.sleep(3000);
		}

	}

	@AfterTest
	public void CloseApp() throws Exception {

		driver.quit();
	}
}
