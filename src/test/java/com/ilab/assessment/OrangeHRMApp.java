package com.ilab.assessment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.System.Logger;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.input.Input;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
//import org.apache.logging.log4j.*;
import org.xml.sax.Locator;

import io.github.bonigarcia.wdm.WebDriverManager;



public class OrangeHRMApp {
	
	WebDriver driver = null;
	Locators loc  = new Locators();
	
	Inputs inp = new Inputs();
	//static Logger log = (Logger) LogManager.getLogger(OrangeHRMApp.class);
	
	@BeforeSuite
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

		//validating title
		String actualTitle = driver.getTitle();


		if(actualTitle.equalsIgnoreCase("OrangeHRM")) {
		
			System.out.println("Test passed");
			}

			else {
			System.out.println("Test failed");
			
			}
		
	
				 
	 

	}

	@Test(priority = 1)
	public void Login()
	{
		
		//getting the elements,username,password and clicking login
		
		WebElement usernames =driver.findElement(By.name("txtUsername"));
		usernames.sendKeys(inp.user);
		
		
		WebElement password =driver.findElement(By.name(loc.getPassword()));
		password.sendKeys(inp.password);
		
	    WebElement logins = driver.findElement(By.name(loc.getLoginBtn()));
	    logins.click();
	    
	    String text = driver.getCurrentUrl();

	  //checking if the url contain dashbord

	  		if(text.contains("dashboard")) {

	  			System.out.println("dashboard keyword is obtained");
	  		}
	  		else
	  			System.out.println("keyword dashbord is not obtained");
	  		try{
	  			WebElement admintab = driver.findElement(By.id(loc.getTapAdmin())) ;

	  			//Since, no exception, so element is present
	  			System.out.println("Tab Admin is present");
	  		}
	  		catch(NoSuchElementException e){

	  			//Element is not present
	  			System.out.println("Tab Admin is not present");
	  		}
	  		
	  		WebElement welcome = driver.findElement(By.id("welcome"));

			if (welcome.equals("welcome Admin")) {
				System.out.println("welcome admin is displayed");

			}

			else
				System.out.println("welcome admin is not displayed");
	}
	
	@Test (priority=2)
	public void addTap()
	{
		//getting the element to click tap
		WebElement admintab = driver.findElement(By.id(loc.getTapAdmin())) ;	
		  admintab.click();
		  
		  WebElement addButon = driver.findElement(By.id(loc.getAddBtn()));
		  WebElement deleteButon = driver.findElement(By.id(loc.getDeleteBtn())); 
			
		  WebElement search = driver.findElement(By.id(loc.getSearchBtn())); 

		  WebElement resetBtn = driver.findElement(By.id(loc.getResetBtn())); 

				
			if(addButon.isDisplayed()) {

				
				System.out.print("Add button is displayed");
				
			}
			else if(deleteButon.isDisplayed())
			{
				System.out.println("Delete button is displayed");
			}
			else if(search.isDisplayed())
			{
				System.out.print("search button is displayed");
			}
			else if(resetBtn.isDisplayed())
			{
				System.out.print("rest button is displayed");
			}

			else
			{
				System.out.print("Add button,delete and search must be Displayed is not displayed");
			}
				
			
	}
	
	@Test (priority=3)
	public void addButton() 
	{
		WebElement addButon = driver.findElement(By.id(loc.getAddBtn()));
		addButon.click();
		
		String url = driver.getCurrentUrl();
		
		String actualHeader = "Add User";
	
		WebElement H1 = driver.findElement(By.id(loc.getHeader()));
		
		//validate the url
		if(url.contains("saveSystemUser"))
		{
			System.out.println("Url contain saveSystemUser");
			
		}
		else
		{
			System.out.println("Url should contain save");
		}
	
		//validate the H1
		if(H1.isDisplayed())
		{
			System.out.println("H1 is displayed");
		}
		else
		{
			System.out.println("H1 should be displayed");
		}
	}
	
	@Test (priority=4)
	public void AddingUser() throws InterruptedException
	{
		
		Boolean dropdownPresent = driver.findElement(By.name(loc.getDropdownRole())).isDisplayed();
		
		//validate a drop down status is enable
		if (dropdownPresent ==true)
		{
			 Select drpRole = new Select(driver.findElement(By.name(loc.getDropdownRole())));
			 drpRole.selectByVisibleText("ESS");
			 System.out.println("Drop down is enabled");
			 
		}
		else
		{
			 System.out.println("Error!! the Drop down should be enabled");
		}
		   
			
		//creating user
			
		 WebElement EmpName = driver.findElement(By.name(loc.getEmploName()));
		EmpName.sendKeys(inp.EmployerName);
		 
	
		 WebElement usernameEmp = driver.findElement(By.name(loc.getEmploUsername()));
		 usernameEmp.sendKeys(inp.EmployerUsername);
		 
		 //Select drpStatus = new Select(driver.findElement(By.name(" systemUser[status]")));
		 //drpStatus.selectByVisibleText("Enabled");
		
		 
		 WebElement passwordsEmp =driver.findElement(By.name(loc.getEmploPassword()));
		 passwordsEmp.sendKeys(inp.EmployerPassword);
		 
		 WebElement ConfirmPass =driver.findElement(By.name(loc.getEmploConfPassword()));
		 ConfirmPass.sendKeys(inp.EmployerConfirmPassword);
		 
		  WebElement btnSave = driver.findElement(By.xpath(loc.getEmploBtnsave()));
		  System.out.println("About to save ");
		  Thread.sleep(200);
		  btnSave.click();
		  Thread.sleep(400);
		  btnSave.click();
		 
	}
	
	@Test (priority=4)
	public void SearchUser() throws InterruptedException
	{
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
	}
	
	
	
}
