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
	
	
	@Test
	public void verifyTitleOfThePage() {
		
		String expectedTitle = "Guru99 Bank Home Page";
		
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
	}
}
