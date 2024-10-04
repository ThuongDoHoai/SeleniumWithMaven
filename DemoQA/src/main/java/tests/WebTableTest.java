package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import pages.WebTablePage;
import tests.models.Employee;

public class WebTableTest extends TestCase {

	@Test
	public void registerNewAccountSuccessfully() throws InterruptedException {

		WebTablePage webTablePage = new WebTablePage(testBase.driver);
		webTablePage.openWebTablePage();

		Employee employee1 = new Employee();
		employee1.firstName = "Alden 1 *";
		employee1.lastName = "Gentry 1";
		employee1.email = "abc@gmail.com";
		employee1.age = "42";
		employee1.salary = "2323";
		employee1.deparment = "Math";

		// register new Employee
		testBase.clickButton(webTablePage.btnAdd);
		webTablePage.register(employee1);

		String expectedResult = employee1.firstName + employee1.lastName + employee1.age + employee1.email
				+ employee1.salary + employee1.deparment;

		int numberOfValueInTable = webTablePage.getDataInTable(webTablePage.txtDataInRow).size();

		String actualResult = webTablePage.getDataInTable(webTablePage.txtDataInRow).get(numberOfValueInTable - 1);

		assertEquals(actualResult, expectedResult);

	}

	// @Test
	public void searchByFirstNameSuccessfully() throws InterruptedException {

		WebTablePage webTablePage = new WebTablePage(testBase.driver);
		webTablePage.openWebTablePage();

		Employee employee1 = new Employee();
		employee1.firstName = "Alden 1 *";
		employee1.lastName = "Gentry 1";
		employee1.email = "abc@gmail.com";
		employee1.age = "42";
		employee1.salary = "2323";
		employee1.deparment = "Math";

		Employee employee2 = new Employee();
		employee2.firstName = "Alden 2";
		employee2.lastName = "Gentry 2";
		employee2.email = "abc@gmail.com";
		employee2.age = "42";
		employee2.salary = "2323";
		employee2.deparment = "Math";

		Employee employee3 = new Employee();
		employee3.firstName = "Alden 3 *";
		employee3.lastName = "Gentry 3";
		employee3.email = "abc@gmail.com";
		employee3.age = "42";
		employee3.salary = "2323";
		employee3.deparment = "Math";

		String searchKeyWord = "ce";

		// register new Employee
		testBase.clickButton(webTablePage.btnAdd);
		webTablePage.register(employee1);
		testBase.clickButton(webTablePage.btnAdd);
		webTablePage.register(employee2);
		testBase.clickButton(webTablePage.btnAdd);
		webTablePage.register(employee3);

		// set page become 100 rows
		webTablePage.setNumberOfRow(webTablePage.txtNumberOfRow);

		// search to define expect result
		List<String> expectedSearchResult = webTablePage.search(webTablePage.txtDataInRow, searchKeyWord);

		// input search key word
		testBase.inputText(webTablePage.txtSearchBox, searchKeyWord);
		List<String> actualSearchResult = webTablePage.getDataInTable(webTablePage.txtDataInRow);

		assertEquals(actualSearchResult, expectedSearchResult);

	}

}