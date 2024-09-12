package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public WebDriver driver;
			
	public void openPage() throws InterruptedException {	
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe"); //sai dau, phai chu y la \\
		
		driver = new ChromeDriver(); //thieu khoi tao bien
		
		driver.get("https://demoqa.com/");
		
		//sleep 5s
		Thread.sleep(5000);
		
		driver.manage().window().maximize(); 
	}
	
}
