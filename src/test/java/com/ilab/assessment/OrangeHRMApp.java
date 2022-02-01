package com.ilab.assessment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.System.Logger;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.input.Input;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
//import org.apache.logging.log4j.*;
import org.xml.sax.Locator;

import io.github.bonigarcia.wdm.WebDriverManager;



public class OrangeHRMApp {
	
	WebDriver driver = null;
	Locators loc  = new Locators();
	
	Inputs inp = new Inputs();
	//static Logger log = (Logger) LogManager.getLogger(OrangeHRMApp.class);
	
	@Test(priority=1)
	public void loadBrowser() throws IOException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();//method chaining
		
		FileInputStream fis = new FileInputStream("./config.properties");
		Properties config = new Properties();
		config.load(fis);

		driver.get(config.getProperty("url"));
		
		
		Thread.sleep(5000); 

		String actualTitle = driver.getTitle();

		//System.out.println("Page title is" + actualTitle);

		if(actualTitle.equalsIgnoreCase("OrangeHRM")) {
		
			System.out.println("Test passed");
			}

			else {
			System.out.println("Test failed");
			}
		
		WebElement usernames =driver.findElement(By.name("txtUsername"));
		usernames.sendKeys(inp.user);
		
		
		driver.findElement(By.name(loc.getPassword())).sendKeys(inp.password);
		
	   WebElement logins = driver.findElement(By.name(loc.getLoginBtn()));
	   logins.click();
		
	   
	  // =================================================================
	  WebElement admintab = driver.findElement(By.id("menu_admin_viewAdminModule")) ;	
	  admintab.click();
	  
	  WebElement addButon = driver.findElement(By.id("btnAdd"));
	  addButon.click();
	  
	  //===================================================================
	  
	  //adduser
	  Select drpRole = new Select(driver.findElement(By.name("systemUser[userType]")));
		drpRole.selectByVisibleText("ESS");
		
	 WebElement EmpName = driver.findElement(By.name("systemUser[employeeName][empName]"));
	EmpName.sendKeys("Jasmine Morgan");
	 
	 
	 
	 WebElement usernameEmp = driver.findElement(By.name("systemUser[userName]"));
	 usernameEmp.sendKeys("Selenium50106");
	 
	 //Select drpStatus = new Select(driver.findElement(By.name(" systemUser[status]")));
	 //drpStatus.selectByVisibleText("Enabled");
	
	 
	 WebElement passwordsEmp =driver.findElement(By.name("systemUser[password]"));
	 passwordsEmp.sendKeys("Selenium50106");
	 
	 WebElement ConfirmPass =driver.findElement(By.name("systemUser[confirmPassword]"));
	 ConfirmPass.sendKeys("Selenium50106");
	 
	// WebElement btnSave = driver.findElement(By.name("btnSave"));
	 
	  
	  WebElement btnSave = driver.findElement(By.xpath("//*[@id=\"btnSave\"]"));
	  System.out.println("1111111111111");
	  Thread.sleep(200);
	  btnSave.click();
	Thread.sleep(400);
	 btnSave.click();
	 
	 //==========================================================================end add user

	 WebElement search = driver.findElement(By.xpath("//*[@id=\"searchSystemUser_userName\"]"));
	 search.sendKeys("Selenium5006");
	 Thread.sleep(400);
	 
	 WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"ohrmList_chkSelectRecord_54\"]"));
	 checkbox.click();
	 
	 WebElement delete = driver.findElement(By.xpath("//*[@id=\"btnDelete\"]"));
	 delete.click();
	 
	 WebElement search2 = driver.findElement(By.xpath("//*[@id=\"searchSystemUser_userName\"]"));
	 search2.sendKeys("Selenium5006");
	 Thread.sleep(400);
	 
	//Selenium5006
	/*@Test(priority=2)
	public void Login()
	{
		
		WebElement usernames =driver.findElement(By.name("txtUsername"));
		usernames.sendKeys(inp.user);
		
		
		driver.findElement(By.name(loc.getPassword())).sendKeys(inp.password);
		
	   WebElement logins = driver.findElement(By.name(loc.getLoginBtn()));
	   logins.click();
	}
	
	public void AddUser()
	{
		Select drpRole = new Select(driver.findElement(By.name("systemUser[userType]")));
		drpRole.selectByVisibleText("2"); 
	}**/
	}
}
