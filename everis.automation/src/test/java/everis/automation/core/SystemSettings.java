package everis.automation.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SystemSettings {
	
	private static final String URL = "http://automationpractice.com/index.php";
	private WebDriver driver;

	public SystemSettings() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
}
