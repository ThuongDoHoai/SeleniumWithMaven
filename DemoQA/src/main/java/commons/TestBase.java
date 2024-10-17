package commons;

import java.io.File;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.ConfigurationGroupMethods;

public class TestBase {

	public WebDriver driver;
	public int timeout;
	public String downloadDir = System.getProperty("user.dir") + "\\testdata";

	public TestBase(String configFile) {
		Configurations configurations = new Configurations(configFile);
		timeout = Integer.valueOf(configurations.getConfigValueByKey("short_time"));
	}

	public TestBase() {
	}

	public void openSingleBrowser(String url, String browser) throws InterruptedException {

		if (browser.equalsIgnoreCase("Chrome")) {
//			String projectPath = System.getProperty("user.dir");
//			System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
//			driver = new ChromeDriver();

			ChromeOptions chromeOptions = new ChromeOptions();

			

			chromeOptions.setExperimentalOption("prefs", Map.of("download.default_directory", downloadDir,
					"download.prompt_for_download", false, "directory_upgrade", true));

			driver = new ChromeDriver(chromeOptions);

		} else if (browser.equalsIgnoreCase("Edge")) {
			EdgeOptions edgeOptions = new EdgeOptions();
			driver = new EdgeDriver(edgeOptions);
		} else if (browser.equalsIgnoreCase("Safari")) {
			// SafariOptions safariOptions = new SafariOptions();
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
	}

	public void inputText(By byLocator, String inputData) {
		WebElement element = driver.findElement(byLocator);
		element.sendKeys(inputData);
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

	public void uploadFile(By btnUpload, String filePath) {
		WebElement element = driver.findElement(btnUpload);
		element.sendKeys(filePath);
	}

	public boolean downloadFile(By btnDownload) {
		WebElement element = driver.findElement(btnDownload);
		// click on the button to download the file
		element.click();

		// verify the downloaded file
		File downloadedFile = new File(downloadDir + File.separator + "sampleFile.jpeg");
		System.out.println(downloadedFile);
		if (downloadedFile.exists()) {
			System.out.println("File download successfully!");
			return true;
		} else {
			System.out.println("File download failed.");
			return false;
		}
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

		waitForElemnetDisplayable(locator);

		element.click();
	}

	public String getTextByLocator(By byLocator) {
		String result = "";
		result = driver.findElement(byLocator).getText();
		return result;
	}

	public void waitForElemnetDisplayable(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitForAtLeastOneElementArePresent(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

}
