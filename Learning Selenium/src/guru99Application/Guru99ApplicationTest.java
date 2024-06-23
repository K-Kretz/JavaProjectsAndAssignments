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
import org.testng.annotations.Test;

public class Guru99ApplicationTest {
	
	private ChromeDriver driver;
	
	private String url = "http://demo.guru99.com/v4";
	
	@BeforeMethod
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
}
