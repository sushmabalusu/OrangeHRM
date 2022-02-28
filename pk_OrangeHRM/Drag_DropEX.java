package pk_OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Drag_DropEX {
	WebDriver driver;
	
  @Test
  public void DragDrop() throws InterruptedException {
	  Actions act=new Actions(driver);
		 WebElement drag=driver.findElement(By.id("draggable"));

			// find element which we need to drop
			//WebElement drop=driver.findElementById("droppable");
			WebElement drop=driver.findElement(By.id("droppable"));
			// this will drag element to destination
	   
		act.dragAndDrop(drag, drop).build().perform();
		 Thread.sleep(5000);
  }
		 
		
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
	  //ChromeDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		driver.manage().window().maximize();
		
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
