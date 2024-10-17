package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import pages.WebTablePage;
import tests.models.Employee;

public class WebTableTest extends TestCase {
	
	public int timeout;

	// @Test
	public void registerNewAccountSuccessfully() throws InterruptedException {

		WebTablePage webTablePage = new WebTablePage(testBase.driver, CONFIG_FILE);
		webTablePage.openWebTablePage();

		Employee employee1 = new Employee();
		employee1.firstName = "Alden 1 *";
		employee1.lastName = "Gentry 1";
		employee1.age = "42";
		employee1.email = "abc@gmail.com";
		employee1.salary = "2323";
		employee1.deparment = "Math";

		// register new Employee
		testBase.clickButton(webTablePage.btnAdd);
		webTablePage.register(employee1);

		int i = webTablePage.getNumberOfValidDataInTable(webTablePage.firstNameColumn);

		Employee actualRestul = webTablePage.getDataInARow(webTablePage.rowXpath, i);

		String stringExpectedResult = employee1.firstName + employee1.lastName + employee1.age + employee1.email
				+ employee1.salary + employee1.deparment;

		String stringActualResult = actualRestul.firstName + actualRestul.lastName + actualRestul.age
				+ actualRestul.email + actualRestul.salary + actualRestul.deparment;

		System.out.println(stringActualResult);
		System.out.println(stringExpectedResult);
		
		assertEquals(stringActualResult, stringExpectedResult);

	}

	@Test
	public void searchByFirstNameSuccessfully() throws InterruptedException {

		WebTablePage webTablePage = new WebTablePage(testBase.driver, CONFIG_FILE);
		webTablePage.openWebTablePage();

		Employee employee1 = new Employee();
		employee1.firstName = "Thuong1";
		employee1.lastName = "Gentry 1";
		employee1.age = "42";
		employee1.email = "abc@gmail.com";
		employee1.salary = "2323";
		employee1.deparment = "Math";

		Employee employee2 = new Employee();
		employee2.firstName = "Thuong2";
		employee2.lastName = "Gentry 2";
		employee2.age = "42";
		employee2.email = "abc@gmail.com";
		employee2.salary = "2323";
		employee2.deparment = "Math";

		Employee employee3 = new Employee();
		employee3.firstName = "Thuong3";
		employee3.lastName = "Gentry 3";
		employee3.age = "42";
		employee3.email = "abc@gmail.com";
		employee3.salary = "2323";
		employee3.deparment = "Math";

		String searchKeyWord = "Thuong";

		// register new Employee
		testBase.clickButton(webTablePage.btnAdd);
		webTablePage.register(employee1);
		testBase.clickButton(webTablePage.btnAdd);
		webTablePage.register(employee2);
		testBase.clickButton(webTablePage.btnAdd);
		webTablePage.register(employee3);
		
		timeout= Integer.valueOf(configurations.getConfigValueByKey("short_time"));

		testBase.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));

		// search to define expect result
		List<String> expectedSearchResult = webTablePage.search(webTablePage.firstNameColumn, webTablePage.rowXpath,
				searchKeyWord);
		System.out.println(expectedSearchResult);

		// search on Web
		testBase.driver.findElement(webTablePage.txtSearchBox).sendKeys(searchKeyWord);
		List<String> acutalSearchResult = webTablePage.getDataInColumnAfterSearch(webTablePage.firstNameColumn);
		System.out.println(acutalSearchResult);

		assertEquals(acutalSearchResult, expectedSearchResult);
	}

}