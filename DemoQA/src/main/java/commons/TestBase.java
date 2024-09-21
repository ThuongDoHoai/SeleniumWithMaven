package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public WebDriver driver;
			
	public void openPage() throws InterruptedException {	
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe"); 
		
		driver = new ChromeDriver(); 
		
		driver.get("https://demoqa.com/");
		
		//sleep 5s
		Thread.sleep(5000);
		
		driver.manage().window().maximize(); 
	}
	
	public void inputText(WebElement locator, String inputData) {
		locator.sendKeys(inputData);
	}
	
}
