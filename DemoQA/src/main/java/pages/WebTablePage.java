package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import tests.models.Employee;

public class WebTablePage extends Page {

	public By txtFirstName = By.id("firstName");
	public By txtLastName = By.id("lastName");
	public By txtEmail = By.id("userEmail");
	public By txtAge = By.id("age");
	public By txtSalary = By.id("salary");
	public By txtDepartment = By.id("department");

	public By txtSearchBox = By.id("searchBox");

	public String rowXpath = "//*[@class='rt-tbody']/div[@param]//div[@class='rt-td']";
	public By firstNameColumn = By.xpath("//*[@class='rt-tbody']//div[@class='rt-td'][1]");

	public By btnAdd = By.id("addNewRecordButton");
	public By btnSubmit = By.id("submit");

	public WebTablePage(WebDriver driver, String configFile) {
		super(driver, configFile);
	}

	public void register(Employee employee) throws InterruptedException {
		testBase.inputText(txtFirstName, employee.firstName);
		testBase.inputText(txtLastName, employee.lastName);
		testBase.inputText(txtEmail, employee.email);
		testBase.inputText(txtAge, employee.age);
		testBase.inputText(txtSalary, employee.salary);
		testBase.inputText(txtDepartment, employee.deparment);

		testBase.clickButton(btnSubmit);
	}

	public boolean isCheckValidRow(String xpath) {
		List<WebElement> elements = testBase.driver.findElements(By.xpath(xpath));
		for (int i = 0; i < 6; i++) {
			if (elements.get(i).getText().isBlank() || elements.get(i).getText().isEmpty())
				return false;
		}

		return true;
	}

	public List<String> search(By locatorColumn, String locatorRow, String searchWord) {
		List<WebElement> elements = testBase.driver.findElements(locatorColumn);
		String newSearchWord = searchWord.toLowerCase();
		List<String> result = new ArrayList<String>();

		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).getText().toLowerCase().contains(newSearchWord)) {
				String newLocatorRow = locatorRow.replace("@param", String.valueOf(i + 1));

				if (isCheckValidRow(newLocatorRow) == true) {
					result.add(elements.get(i).getText());
				}
			}
		}
		return result;
	}

	public List<String> getDataInColumnAfterSearch(By locatorColumn) {
		List<WebElement> elements = testBase.driver.findElements(locatorColumn);
		List<String> result = new ArrayList<String>();
		int i = 0;

		while (i < elements.size()) {
			if (elements.get(i).getText().isBlank() || elements.get(i).getText().isEmpty())
				i++;
			else {
				result.add(elements.get(i).getText());
				i++;
			}
		}
		return result;
	}

	public int getNumberOfValidDataInTable(By locatorColumn) {
		List<WebElement> elements = testBase.driver.findElements(locatorColumn);
		int count = 0;

		int i = 0;

		while (i < elements.size()) {
			if (elements.get(i).getText().isBlank() || elements.get(i).getText().isEmpty())
				i++;
			else {
				count++;
				i++;
			}
		}

		return count;
	}

	public Employee getDataInARow(String rowXpath, int i) {
		By locator = By.xpath(rowXpath.replace("@param", String.valueOf(i)));

		List<WebElement> elements = testBase.driver.findElements(locator);

		Employee employee = new Employee();

		employee.firstName = elements.get(0).getText();
		employee.lastName = elements.get(1).getText();
		employee.age = elements.get(2).getText();
		employee.email = elements.get(3).getText();
		employee.salary = elements.get(4).getText();
		employee.deparment = elements.get(5).getText();

		return employee;
	}
}