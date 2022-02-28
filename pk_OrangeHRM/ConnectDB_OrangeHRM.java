package pk_OrangeHRM;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ConnectDB_OrangeHRM {
	ChromeDriver driver;
    @BeforeMethod
    public void LaunchApp() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		//driver.manage().window().maximize();
	}
	
	@Test
	public void  ConnectMySQLDB() throws  ClassNotFoundException, SQLException, InterruptedException {													
		//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
        String dbUrl = "jdbc:mysql://localhost:3306/orangehrm";					

		//Database Username		
		String username = "root";	
        
		//Database Password		
		String password = "root";				

		//Query to Execute		
		String query = "select * from login1;";	
        
 	    //Load mysql jdbc driver		
   	    Class.forName("com.mysql.cj.jdbc.Driver");			
   
   		//Create Connection to DB		
    	Connection con = DriverManager.getConnection(dbUrl,username,password);
  
  		//Create Statement Object		
	   Statement stmt = con.createStatement();					

			// Execute the SQL Query. Store results in ResultSet		
 		ResultSet rs= stmt.executeQuery(query);							
 
 		// While Loop to iterate through all data and print results		
		while (rs.next()){
	        		String Username = rs.getString(1);								        
                    String Password = rs.getString(2);					                               
                    System. out.println(Username+"  "+Password);
                    //Pass Data to Login OrnageHRM
                    
                    driver.findElement(By.id("txtUsername")).clear();
                	driver.findElement(By.id("txtUsername")).sendKeys(Username);
                	driver.findElement(By.id("txtPassword")).clear();
                	driver.findElement(By.id("txtPassword")).sendKeys(Password);
                	driver.findElement(By.id("btnLogin")).click();
                	/*Thread.sleep(3000);
                	driver.findElementById("welcome").click();
                	Thread.sleep(3000);
                	driver.findElementByLinkText("Logout").click();
                	Thread.sleep(3000);*/
                    
            }		
			 // closing DB Connection		
			con.close();			
}
    @AfterTest
    public void CloseAPP() throws Exception {

    	driver.quit();
	}
}
