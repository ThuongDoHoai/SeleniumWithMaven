package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import tests.models.StudentRegister;

public class PracticeFormPage extends Page {

	// all element in Practice Form Page
	public By txtFirstName = By.id("firstName");
	public By txtLastName = By.id("lastName");
	public By txtEmail = By.id("userEmail");

	public String rdGenderXpath = "//label[text()='{@param}']";

	public By txtMobile = By.id("userNumber");

	// element of Date field
	public String txtDobXpath = "//input[@id='dateOfBirthInput']";
	public String drYear = "//select[@class='react-datepicker__year-select']";
	public String drMonth = "//select[@class='react-datepicker__month-select']";
	public String lblDate = "//div[contains(@class,'react-datepicker__day') and not(contains(@class,'outside-month')) and text()='{@param}']";

	public By txtSubject = By.xpath("//input[@id='subjectsInput']");

	public String chkHobbiesXpath = "//label[text()='{@param}']";

	public By txtUpload = By.id("uploadPicture");

	public By txtCurrentAdd = By.id("currentAddress");
	public By txtState = By.xpath("//input[@id='react-select-3-input']");
	public By txtCity = By.xpath("//input[@id='react-select-4-input']");

	public By btnSubmit = By.id("submit");

	public String tableValueXpath = "//td[text()='{@param}']//following-sibling::td";

	public PracticeFormPage(WebDriver driver) {
		super(driver);
	}

	public void inputData2(StudentRegister studentRegister) {

		testBase.inputText(txtFirstName, studentRegister.fistName);
		testBase.inputText(txtLastName, studentRegister.lastName);
		testBase.inputText(txtEmail, studentRegister.email);
		testBase.inputRadio(rdGenderXpath, studentRegister.gender);

		testBase.inputText(txtMobile, studentRegister.phone);
		testBase.inputDateByClickDatePicker(txtDobXpath, drYear, drMonth, lblDate, studentRegister.DOB);
		testBase.inputMultipleToCombobox(txtSubject, studentRegister.subject);

		// scroll page down
		testBase.scollToElement(btnSubmit);

		// continue input data
		testBase.inputCheckbox(chkHobbiesXpath, studentRegister.hobbies);
		testBase.uploadFile(txtUpload, studentRegister.filePath);
		testBase.inputText(txtCurrentAdd, studentRegister.currentAdd);
		testBase.inputDropdown(txtState, studentRegister.state);
		testBase.inputDropdown(txtCity, studentRegister.city);

	}

	public String[] getTextAfterSubmit() {

		List<WebElement> listOutput = testBase.driver.findElements(By.xpath("//div[@class='table-responsive']//tbody//td"));

		int i = 0;

		String[] output = new String[20];

		for (WebElement e : listOutput) {
			output[i] = e.getText();
			i++;
		}

		return output;

	}

	public boolean getErrorField(WebElement locator) {
		String attributeValue = locator.getAttribute("required");

		if (attributeValue.contains("field-error")) {
			return true;
		} else
			return false;
	}

	public boolean checkRequiredField(By byLocator) {
		WebElement elment = testBase.driver.findElement(byLocator);

		String checkMandatory = elment.getAttribute("required");
		if (checkMandatory != null)
			return true;
		else
			return false;
	}

	public String getTableValue(String xpath, String lblField) {
		String newXpath = xpath.replace("{@param}", lblField);
		WebElement element = testBase.driver.findElement(By.xpath(newXpath));
		return element.getText();
	}

	public boolean getCssBorderValue(By byLocator, String expectedColor) {
		WebElement elment = testBase.driver.findElement(byLocator);
		String cssColor = elment.getCssValue("border-color");

		String actualColor = Color.fromString(cssColor).asHex();

		if (actualColor.equals(expectedColor)) {
			return true;
		}
		return false;
	}

}
