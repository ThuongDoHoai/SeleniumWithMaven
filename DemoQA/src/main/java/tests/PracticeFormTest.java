package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.PracticeFormPage;
import tests.models.StudentRegister;

public class PracticeFormTest extends TestCase {

	 @Test (groups = "Happy case")
	public void inputSuccessfully() throws InterruptedException {

		StudentRegister studentRegister = new StudentRegister();

		studentRegister.fistName = "Hoa";
		studentRegister.lastName = "Dao";
		studentRegister.email = "abc@gmail.com";
		studentRegister.gender = "Other";
		studentRegister.phone = "0948242456";
		studentRegister.DOB = "13 January 1989";
		studentRegister.subject = "Maths, Chemistry";
		studentRegister.hobbies = "Sports, Reading, Music";
		studentRegister.filePath = System.getProperty("user.dir") + "\\testdata\\kitty-cat-kitten-pet-45201.jpeg";

		studentRegister.currentAdd = " xin chao cac ban \nha ha";
		studentRegister.state = "Haryana";
		studentRegister.city = "Karnal";

		// start input data
		PracticeFormPage practiceFormPage = new PracticeFormPage(testBase.driver);
		practiceFormPage.openPracticeFormPage();
		
		practiceFormPage.inputData2(studentRegister);
		testBase.clickButton(practiceFormPage.btnSubmit);

		String actualStudentName = practiceFormPage.getTableValue(practiceFormPage.tableValueXpath, "Student Name");
		assertEquals(actualStudentName, studentRegister.fistName + " " + studentRegister.lastName);

		String actualDOB = practiceFormPage.getTableValue(practiceFormPage.tableValueXpath, "Date of Birth");
		int index = studentRegister.DOB.lastIndexOf(" ");
		System.out.println(index);
		String expectedDOB = studentRegister.DOB.replace(Character.toString(studentRegister.DOB.charAt(index)),",");
		assertEquals(actualDOB, expectedDOB);

		int index2 = studentRegister.filePath.lastIndexOf("\\");
		String expectedFileName = studentRegister.filePath.substring(index2 + 1);

	}

	//@Test(groups = "Validation case")
	public void submitDataUnsuccessfully() throws InterruptedException {

		PracticeFormPage practiceFormPage = new PracticeFormPage(testBase.driver);
		practiceFormPage.openPracticeFormPage();
		
		testBase.scollToElement(practiceFormPage.btnSubmit);
		testBase.clickButton(practiceFormPage.btnSubmit);

		assertTrue(practiceFormPage.getCssBorderValue(practiceFormPage.txtFirstName, "#dc3545"));

	}

}
