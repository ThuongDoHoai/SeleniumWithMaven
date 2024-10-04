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

	public By txtNumberOfRow = By.xpath("//select[@aria-label='rows per page']");
	public String txtDataInRow = "//*[@class='rt-tbody']/div[@param]//div[@class='rt-td']";

	public By btnAdd = By.id("addNewRecordButton");
	public By btnSubmit = By.id("submit");

	public WebTablePage(WebDriver driver) {
		super(driver);
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

	public void setNumberOfRow(By locator) {
		WebElement element = testBase.driver.findElement(locator);
		Select selectNumberOfRow = new Select(element);
		selectNumberOfRow.selectByVisibleText("100 rows");
	}

	public String getDataInOneRow(By locator) {
		List<WebElement> elements = testBase.driver.findElements(locator);
		String result = "";
		if (elements.get(0).getText().isBlank() || elements.get(0).getText().isEmpty())
			return "NO DATA";
		else {
			for (WebElement e : elements) {
				result = result + e.getText();
			}
			return result.trim();
		}
	}

	public List<String> search(String xpath, String searchKeyWords) {
		List<String> searchResult = new ArrayList<String>();
		String newxpath = null;
		String dataInRow;
		int i = 1;

		do {
			newxpath = xpath.replace("@param", String.valueOf(i));
			By locator = By.xpath(newxpath);
			dataInRow = getDataInOneRow(locator);
			if (dataInRow.equals("NO DATA"))
				break;
			else {
				if (dataInRow.contains(searchKeyWords)) {
					searchResult.add(i - 1, dataInRow);
					System.out.println(searchResult.get(i - 1));
				}
			}
			i++;
		} while (true);

		return searchResult;
	}

	public List<String> getDataInTable(String xpath) {
		List<String> dataInTable = new ArrayList<String>();
		String newxpath = null;
		String dataInRow;
		int i = 1;

		do {
			newxpath = xpath.replace("@param", String.valueOf(i));
			By locator = By.xpath(newxpath);
			dataInRow = getDataInOneRow(locator);
			if (dataInRow.equals("NO DATA"))
				break;
			else {
				dataInTable.add(i - 1, dataInRow);
				System.out.println(dataInTable.get(i - 1));
			}
			i++;
		} while (true);

		return dataInTable;
	}

	public boolean checkLatestRecord(String xpath, String dataNewRecord) {
		List<String> dataInTable = new ArrayList<String>();
		dataInTable = getDataInTable(xpath);
		int index = dataInTable.size();
		System.out.println(index +"    aaaaaaaaaaa   "+dataInTable.get(index-1));
		if (dataInTable.get(index-1).trim().equals(dataNewRecord))
			return true;
		else
			return false;
	}
}