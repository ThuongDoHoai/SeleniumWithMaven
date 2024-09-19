package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.TestBase;

public class PracticeFormPage extends Pages {

	public WebElement inputFirstName = drPage.findElement(By.id("firstName"));
	public WebElement inputLastName = drPage.findElement(By.id("lastName"));
	public WebElement inputEmail = drPage.findElement(By.id("userEmail"));
	public WebElement inputPhone = drPage.findElement(By.id("userNumber"));
	public WebElement inputSubject = drPage.findElement(By.id("subjectsInput"));
	public WebElement inputCurrentAdd = drPage.findElement(By.id("currentAddress"));
	public WebElement inputSate = drPage.findElement(By.id("state"));
	public WebElement inputCity = drPage.findElement(By.id("city"));

	public PracticeFormPage(WebDriver driver) {
		super(driver);
	}

	public void inputData(String name, String email, String gender, String phone, String DOB, String subject,
			String hobbies, String currentAdd, String stateCity) {

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
			break;
		case "Female":
			pathGender = "//label[@for='gender-radio-2']";
			break;
		case "Other":
			pathGender = "//label[@for='gender-radio-3']";
			break;
		}

		WebElement checkGender = drPage.findElement(By.xpath(pathGender));

		JavascriptExecutor js = (JavascriptExecutor) drPage;
		js.executeScript("arguments[0].scrollIntoView(true);", checkGender);

		checkGender.click();

	}

	public void inputHobbies(String hobbies) {
		String pathHobbies = "";

		switch (hobbies) {
		case "Sports":
			pathHobbies = "//label[@for='hobbies-checkbox-1']";
			break;
		case "Reading":
			pathHobbies = "//input[@id='hobbies-checkbox-2']";
			break;
		case "Music":
			pathHobbies = "//input[@id='hobbies-checkbox-3']";
			break;
		}

		WebElement checkHobbies = drPage.findElement(By.xpath(pathHobbies));

		JavascriptExecutor js = (JavascriptExecutor) drPage;
		js.executeScript("arguments[0].scrollIntoView(true);", checkHobbies);

		checkHobbies.click();
	}

	public void inputDropdown(WebElement locator, String inputOption) {
		Select selectDropdown = new Select(locator);
		selectDropdown.selectByVisibleText(inputOption);
	}
}
