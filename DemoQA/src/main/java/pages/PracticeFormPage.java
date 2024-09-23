package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PracticeFormPage extends Pages {

	public WebElement inputFirstName = drPage.findElement(By.id("firstName"));
	public WebElement inputLastName = drPage.findElement(By.id("lastName"));
	public WebElement inputEmail = drPage.findElement(By.id("userEmail"));
	public WebElement inputPhone = drPage.findElement(By.id("userNumber"));
	public WebElement inputSubject = drPage.findElement(By.xpath("//input[@id='subjectsInput']"));
	public WebElement inputCurrentAdd = drPage.findElement(By.id("currentAddress"));
	public WebElement inputState = drPage.findElement(By.xpath("//input[@id='react-select-3-input']"));
	public WebElement inputCity = drPage.findElement(By.xpath("//input[@id='react-select-4-input']"));
	public WebElement uploadButton = drPage.findElement(By.id("uploadPicture"));

	public String genderXpath = "//label[text()='{@param}']";
	public String hobbiesXpath = "//label[text()='{@param}']";

	public WebElement submitButton = drPage.findElement(By.xpath("//button[@id='submit']"));

	public PracticeFormPage(WebDriver driver) {
		super(driver);
	}

	public void inputData(String firstName, String lastName, String email, String gender, String phone, String DOB,
			String subject, String hobbies, String filePath, String currentAdd, String state, String city) {
		testBase.inputText(inputFirstName, firstName);
		testBase.inputText(inputLastName, lastName);
		testBase.inputText(inputEmail, email);
		testBase.inputRadio(genderXpath, gender);
		testBase.inputText(inputPhone, phone);
		inputDate(DOB);
		testBase.inputMultipleToCombobox(inputSubject, subject);

		// scroll page down
		JavascriptExecutor js = (JavascriptExecutor) drPage;
		js.executeScript("arguments[0].scrollIntoView(true);", submitButton);

		// continue input data
		testBase.inputCheckbox(hobbiesXpath, hobbies);
		testBase.uploadFile(uploadButton, filePath);
		testBase.inputText(inputCurrentAdd, currentAdd);
		testBase.inputDropdown(inputState, state);
		testBase.inputDropdown(inputCity, city);
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

	public String[] getTextAfterSubmit() {

		List<WebElement> listOutput = drPage.findElements(By.xpath("//div[@class='table-responsive']//tbody//td"));

		int i = 0;

		String[] output = new String[20];

		for (WebElement e : listOutput) {
			output[i] = e.getText();
			i++;
		}

		return output;

	}
}
