package pk_OrangeHRM;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HDFC_JavaScriptAlerEx {
	
	WebDriver driver;
	
  @Test(priority=1)
  public void Click_JsAlert() {
	  driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
	  String actual1=driver.switchTo().alert().getText();
	  String expect1="I am a JS Alert";
	  Assert.assertEquals(actual1, expect1);
	  driver.switchTo().alert().accept();
	  String actual=driver.findElement(By.id("result")).getText();
	  String expect="You successfully clicked an alert";
	  Assert.assertEquals(actual, expect);
	  
 }
  @Test(priority=2)
  public void Click_JSConfirm() {
	  driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
	  String actual1=driver.switchTo().alert().getText();
	  String expect1="I am a JS Confirm";
	  Assert.assertEquals(actual1, expect1);
	  driver.switchTo().alert().accept();
	  String actual=driver.findElement(By.id("result")).getText();
	  String expect="You clicked: Ok";
	  Assert.assertEquals(actual, expect);
	  
 }
  @Test(priority=3)
  
  public void Click_Jsprompt() {
	  driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
	  driver.switchTo().alert().sendKeys("text");
	  driver.switchTo().alert().accept();
	  String actual=driver.findElement(By.id("result")).getText();
	  String expect="You entered: text";
	  Assert.assertEquals(actual, expect);
	  
 }
  @Test(priority=4)
  public void Click_JSConfirm_Cancel() {
	  driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
	  String actual1=driver.switchTo().alert().getText();
	  String expect1="I am a JS Confirm";
	  Assert.assertEquals(actual1, expect1);
	  driver.switchTo().alert().dismiss();
	  String actual=driver.findElement(By.id("result")).getText();
	  String expect="You clicked: Cancel";
	  Assert.assertEquals(actual, expect);
	  
 }
 @Test(priority=5)
  
  public void Click_Jsprompt_cancel() {
	  driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
	  driver.switchTo().alert().dismiss();
	  String actual=driver.findElement(By.id("result")).getText();
	  String expect="You entered: null";
	  Assert.assertEquals(actual, expect);
	  
 }
  
  
  @BeforeTest
  public void beforeTest() {
	  
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
