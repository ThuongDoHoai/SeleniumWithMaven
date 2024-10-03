package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestBase {

	public WebDriver driver;

	public void openPage() throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://demoqa.com/");

		// sleep 5s
		Thread.sleep(5000);

		driver.manage().window().maximize();
	}

	public void inputText(By byLocator, String inputData) {
		WebElement element = driver.findElement(byLocator);
		element.sendKeys(inputData);
	}

	public void inputRadio(String xpath, String selectedOption) {
		String realXpath = xpath.replace("{@param}", selectedOption);
		WebElement element = driver.findElement(By.xpath(realXpath));
		element.click();
	}

	public void inputCheckbox(String xpath, String selectedOption) {
		String[] listValue = selectedOption.split(", ");

		for (int i = 0; i < listValue.length; i++) {
			String realXpath = xpath.replace("{@param}", listValue[i]);
			WebElement element = driver.findElement(By.xpath(realXpath));
			element.click();
		}
	}

	public void inputMultipleToCombobox(By byLocator, String inputValue) {
		WebElement element = driver.findElement(byLocator);
		String[] listValues = inputValue.split(", ");

		for (int i = 0; i < listValues.length; i++) {
			element.sendKeys(listValues[i]);
			element.sendKeys(Keys.ENTER);
		}
	}

	public void inputDropdown(By byLocator, String inputValue) {
		WebElement element = driver.findElement(byLocator);
		element.sendKeys(inputValue);
		element.sendKeys(Keys.ENTER);
	}

	public void inputDateByClickDatePicker(String firstClick, String locatorYear, String locatorMonth, String pathDate,
			String inputValue) {
		String[] inputDateSplit = inputValue.split(" ");

		WebElement elementClick = driver.findElement(By.xpath(firstClick));
		elementClick.click();

		WebElement elmentYear = driver.findElement(By.xpath(locatorYear));
		Select selectYear = new Select(elmentYear);
		selectYear.selectByVisibleText(inputDateSplit[2]);

		WebElement elementMonth = driver.findElement(By.xpath(locatorMonth));
		Select selectMonth = new Select(elementMonth);
		selectMonth.selectByVisibleText(inputDateSplit[1]);

		String newPathDate = pathDate.replace("{@param}", inputDateSplit[0]);
		WebElement elementDate = driver.findElement(By.xpath(newPathDate));
		elementDate.click();
	}

	public void uploadFile(By byLocator, String filePath) {
		WebElement element = driver.findElement(byLocator);
		element.sendKeys(filePath);
	}

	public void scollToElement(By byLocator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(byLocator);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void clickButton(By locator) throws InterruptedException {
		WebElement element = driver.findElement(locator);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);

		Thread.sleep(500);

		element.click();
	}

}
