package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.TestBase;

public class PracticeFormPage extends Pages {

	public WebElement inputFirstName = drPage.findElement(By.id("firstName"));
	public WebElement inputLastName = drPage.findElement(By.id("lastName"));
	public WebElement inputEmail = drPage.findElement(By.id("userEmail"));
	public WebElement inputPhone = drPage.findElement(By.id("userNumber"));
	public WebElement inputSubject = drPage.findElement(By.xpath("//input[@id='subjectsInput']"));
	public WebElement inputCurrentAdd = drPage.findElement(By.id("currentAddress"));


	public PracticeFormPage(WebDriver driver) {
		super(driver);
	}

	public void inputData(String firstName, String lastName, String email, String gender, String phone, String DOB,
			String subject, String hobbies, String currentAdd, String state, String city) {
		inputText(inputFirstName, firstName);
		inputText(inputLastName, lastName);
		inputText(inputEmail, email);
		inputGender(gender);
		inputText(inputPhone, phone);
		inputDate(DOB);
		inputText(inputSubject, subject);
		inputHobbies(hobbies);
		inputText(inputCurrentAdd, currentAdd);
		inputStateCity(state, city);
	}

	public void inputText(WebElement locator, String inputData) {
		locator.sendKeys(inputData);
	}

	public void inputDate(String inputDate) {
		String[] inputDateSpit = inputDate.split(" ");
		String pathDate = "//div[@class='react-datepicker__day react-datepicker__day--0" + inputDateSpit[0] + "']";

		drPage.findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();

		WebElement year = drPage.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		Select selectYear = new Select(year);
		selectYear.selectByVisibleText(inputDateSpit[2]);

		WebElement month = drPage.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		Select selectMonth = new Select(month);
		selectMonth.selectByVisibleText(inputDateSpit[1]);

		drPage.findElement(By.xpath(pathDate)).click();

	}

	public void inputGender(String gender) {
		String pathGender = "";

		switch (gender) {
		case "Male":
			pathGender = "//label[@for='gender-radio-1']";
			// pathGender = "//input[@id='gender-radio-1']";

			break;
		case "Female":
			pathGender = "//label[@for='gender-radio-2']";
			break;
		case "Other":
			pathGender = "//label[@for='gender-radio-3']";
			break;
		}

		WebElement element = drPage.findElement(By.xpath(pathGender));

		JavascriptExecutor js = (JavascriptExecutor) drPage;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();

		// WebElement element = new WebDriverWait(drPage,
		// Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='gender-radio-1']")));
		// ((JavascriptExecutor)drPage).executeScript("arguments[0].click();", element);

	}

	public void inputHobbies(String hobbies) {
		String pathHobbies = "";

		switch (hobbies) {
		case "Sports":
			pathHobbies = "//label[@for='hobbies-checkbox-1']";
			break;
		case "Reading":
			pathHobbies = "//label[@for='hobbies-checkbox-2']";
			break;
		case "Music":
			pathHobbies = "//label[@for='hobbies-checkbox-3']";
			break;
		}

		WebElement checkHobbies = drPage.findElement(By.xpath(pathHobbies));

		JavascriptExecutor js = (JavascriptExecutor) drPage;
		js.executeScript("arguments[0].scrollIntoView(true);", checkHobbies);

		checkHobbies.click();
	}

	public void inputStateCity(String inputState, String inputCity) {
		WebElement elementState = drPage.findElement(By.xpath("//input[@id='react-select-3-input']"));
		JavascriptExecutor js = (JavascriptExecutor) drPage;
		js.executeScript("arguments[0].scrollIntoView(true);", elementState);

		elementState.sendKeys(inputState);
		elementState.sendKeys(Keys.ENTER);

		WebElement elementCity = drPage.findElement(By.xpath("//input[@id='react-select-4-input']"));
		js.executeScript("arguments[0].scrollIntoView(true);", elementCity);

		elementCity.sendKeys(inputCity);
		elementCity.sendKeys(Keys.ENTER);

	}

	public void clickSubmit() {
		WebElement submitButton = drPage.findElement(By.xpath("//button[@id='submit']"));

		JavascriptExecutor js = (JavascriptExecutor) drPage;
		js.executeScript("arguments[0].scrollIntoView(true);", submitButton);

		submitButton.click();
	}

	public String[] getTextAfterSubmit() {

		List<WebElement> listOutput = drPage.findElements(By.xpath("//div[@class='table-responsive']//tbody//td"));

		int i = 0;

		String[] output = new String [20];

		for (WebElement e : listOutput) {
			output[i] = e.getText();
			i++;
		}

		return output;

	}
}
