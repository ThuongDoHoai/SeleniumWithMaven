package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.PracticeFormPage;

public class PracticeFormTest extends TestCase {

	@Test
	public void inputSuccessfully() {
		String fistName ="Hoa";
		String lastName ="Dao";
		String email ="abc@gmail.com";
		String gender = "Other";
		String phone ="977793489384";
		String inputDate = "13 January 1989";
		String subject ="Ha ha ha";
		String hobbies = "Reading";
		String currentAdd =" xin chao cac ban \n ha ha";
		String state = "Haryana";
		String city = "Karnal";
		
		String expectedStudentName = fistName + " " + lastName;
		String expectedStateCity = state + " " + city;
				

		
		openPracticeFormPage();

		practiceFormPage.inputData(fistName, lastName, email, gender, phone, inputDate, subject, hobbies, currentAdd, state, city);
		practiceFormPage.clickSubmit();
		
		//verify output
		String actualStudentName = practiceFormPage.getTextAfterSubmit()[1];
		assertEquals(actualStudentName, expectedStudentName);
		
		String actualStudentEmail = practiceFormPage.getTextAfterSubmit()[3];
		assertEquals(actualStudentEmail, email);
		
	}

}
