package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import pages.PracticeFormPage;

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

	public void inputText(WebElement locator, String inputData) {
		locator.sendKeys(inputData);
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

	public void inputMultipleToCombobox(WebElement locator, String inputValue) {
		String[] listValues = inputValue.split(", ");

		for (int i = 0; i < listValues.length; i++) {
			locator.sendKeys(listValues[i]);
			locator.sendKeys(Keys.ENTER);
		}
	}

	public void inputDropdown(WebElement locator, String inputValue) {
		locator.sendKeys(inputValue);
		locator.sendKeys(Keys.ENTER);
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

	public void uploadFile(WebElement locator, String filePath) {
		locator.sendKeys(filePath);
	}

	public void clickSubmit(WebElement locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", locator);

		locator.click();
	}

}
