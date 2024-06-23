/**
 * GUIDED PROJECT: Create Automation Script Using Selenium and Java
 * 
 * Create Test cases using TestNG 
 * 
 * Developer: Keith Kretz
 * Date Created: 6/23/2024
 * Last Updated: 6/23/2024
 */
package guru99Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Guru99ApplicationTest {
	
	private ChromeDriver driver;
	
	private String url = "http://demo.guru99.com/v4";
	
	@BeforeTest
	public void invokeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\keith\\Desktop\\Selenium Testing\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(url);
	}
	
	
	@Test(priority=0)
	public void verifyTitleOfThePage() {
		
		String expectedTitle = "Guru99 Bank Home Page";
		
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority=1)
	public void verifyLogin() {
		
		WebElement userId = driver.findElement(By.name("uid"));
		
		WebElement userPassword = driver.findElement(By.name("password"));
		
		WebElement loginButton = driver.findElement(By.name("btnLogin"));
		
		userId.sendKeys("mngr577627");
		userPassword.sendKeys("EjYpery");
		
		loginButton.click();
	}
	
	@Test(priority=2)
	public void addCustomer() {
		
		WebElement addCustomerLink = driver.findElement(By.linkText("New Customer"));
		
		addCustomerLink.click();
		
		driver.findElement(By.name("name")).sendKeys("Keith Barn");
		
		driver.findElement(By.xpath("//input[@value='f']")).click();
		
		driver.findElement(By.name("dob")).sendKeys("05/05/1995");
		
		driver.findElement(By.name("addr")).sendKeys("30566 NewYork dr");
		
		driver.findElement(By.name("pinno")).sendKeys("555555");
		
		driver.findElement(By.name("state")).sendKeys("California");
		
		driver.findElement(By.name("city")).sendKeys("Las Vegas");
		
		driver.findElement(By.name("telephoneno")).sendKeys("45444445555");
		
		driver.findElement(By.name("emailid")).sendKeys("abc1er425@xyze.com");
		
		driver.findElement(By.name("password")).sendKeys("Poiy@123");
		
		driver.findElement(By.name("sub")).click();
		
		
		
	}
	
	@Test(priority=3)
	public void getCustomerId() {
		
		String customerId = driver.findElement(By.xpath("//table[@id='customer']/tbody/tr[4]/td[2]")).getText();
		
		System.out.println("ID: " + customerId);
	}
}
