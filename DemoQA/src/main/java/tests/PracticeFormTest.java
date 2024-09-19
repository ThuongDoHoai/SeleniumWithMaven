package tests;

import org.testng.annotations.Test;

import pages.PracticeFormPage;

public class PracticeFormTest extends TestCase {

	@Test
	public void inputSuccessfully() {
		String inputDate = "13 January 1989";
		String gender = "Male";
		String hobbies = "Sports";
		String state = "Haryana";
		String city = "Karnal";

		openPracticeFormPage();

		practiceFormPage.inputDate(inputDate);
		practiceFormPage.inputGender(gender);
		practiceFormPage.inputHobbies(hobbies);

	}

}
