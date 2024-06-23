/**
 * GUIDED PROJECT: Create Automation Script Using Selenium and Java
 * 
 * Setup a java project for automation scripts. Run your first command on the Chrome Browser. Writing first Test Case using TestNG.
 * Interacting With Elements of Web Application. Interacting with Web Elements like radio button and Links. Interacting with web tables on a web application
 * 
 * Developer: Keith Kretz
 * Date Created: 6/23/2024
 * Last Updated: 6/23/2024
 */
package seleniumScripts;

import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 */
public class WorkingWithChrome {
	
	private ChromeDriver driver;
	
	private String url = "http://twitch.tv";
	
	public void invokeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\keith\\Desktop\\Selenium Testing\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(url);
		
	}
	
	public void getTitle() {
		
		String titleOfPage = driver.getTitle();
		
		System.out.println("Title of The Page -" + titleOfPage);
	}
	
	public void closeBrowser() {
		
		//driver.close();
		
		driver.quit();
	}
	
	public static void main(String[] args) {
		
		WorkingWithChrome wc = new WorkingWithChrome();
		
		wc.invokeBrowser();
		
		wc.getTitle();
		
		wc.closeBrowser();
	}

}
