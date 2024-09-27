package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.PracticeFormPage;

public class PracticeFormTest extends TestCase {

	//@Test
	public void inputSuccessfully() {
		// raw data input
		String fistName = "Hoa";
		String lastName = "Dao";
		String email = "abc@gmail.com";
		String gender = "Other";
		String phone = "0948242456";
		String inputDate = "13 January 1989";
		String subject = "Maths, Chemistry";
		String hobbies = "Sports, Reading, Music";
		String filePath = "C:\\Users\\Phong\\Downloads\\kitty-cat-kitten-pet-45201.jpeg";
		String currentAdd = " xin chao cac ban \nha ha";
		String state = "Haryana";
		String city = "Karnal";

		// Prepare expected result
		String expectedStudentName = fistName + " " + lastName;
		String[] splittedDOB = inputDate.split(" ");
		String expectedDOB = splittedDOB[0] + " " + splittedDOB[1] + "," + splittedDOB[2];
		String expectCurrentAdd = currentAdd.replace("\n", "").trim();
		String expectedStateCity = state + " " + city;
		// Get expected file name
		int index = filePath.lastIndexOf("\\");
		String expectedFileName = filePath.substring(index + 1);

		openPracticeFormPage();

		practiceFormPage.inputData(fistName, lastName, email, gender, phone, inputDate, subject, hobbies, filePath,
				currentAdd, state, city);
		testBase.clickSubmit(practiceFormPage.submitButton);

		String[] actualOutput = practiceFormPage.getTextAfterSubmit();

		// verify inputed data
		assertEquals(actualOutput[1], expectedStudentName);
		assertEquals(actualOutput[3], email);
		assertEquals(actualOutput[5], gender);
		assertEquals(actualOutput[7], phone);
		assertEquals(actualOutput[9], expectedDOB);
		assertEquals(actualOutput[11], subject);
		assertEquals(actualOutput[13], hobbies);
		assertEquals(actualOutput[15], expectedFileName);
		assertEquals(actualOutput[17], expectCurrentAdd);
		assertEquals(actualOutput[19], expectedStateCity);
	}
	
	@Test
	public void checkMandatoryField() {
		
		openPracticeFormPage();
		
		WebElement radioMale = testBase.driver.findElement(By.xpath("//label[text()='Male']//preceding-sibling::input"));
		WebElement radioFemale = testBase.driver.findElement(By.xpath("//label[text()='Female']//preceding-sibling::input"));
		WebElement radioOther = testBase.driver.findElement(By.xpath("//label[text()='Other']//preceding-sibling::input"));
		WebElement DOB = testBase.driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
		WebElement checkboxSport = testBase.driver.findElement(By.xpath("//label[text()='Sports']//preceding-sibling::input"));
		WebElement checkboxReading = testBase.driver.findElement(By.xpath("//label[text()='Reading']//preceding-sibling::input"));
		WebElement checkboxMusic = testBase.driver.findElement(By.xpath("//label[text()='Music']//preceding-sibling::input"));
		WebElement picture = testBase.driver.findElement(By.xpath("//input[@id='uploadPicture']"));
		WebElement currentAdd = testBase.driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
		WebElement sate = testBase.driver.findElement(By.xpath("//input[@id='react-select-3-input']"));
		WebElement city = testBase.driver.findElement(By.xpath("//input[@id='react-select-4-input']"));
		
		
		assertTrue(practiceFormPage.checkRequiredField(practiceFormPage.inputFirstName));
		assertTrue(practiceFormPage.checkRequiredField(practiceFormPage.inputLastName));
		assertTrue(practiceFormPage.checkRequiredField(radioMale));
		assertTrue(practiceFormPage.checkRequiredField(radioFemale));
		assertTrue(practiceFormPage.checkRequiredField(radioOther));
		assertTrue(practiceFormPage.checkRequiredField(practiceFormPage.inputPhone));
		
		
		assertFalse(practiceFormPage.checkRequiredField(DOB));
		assertFalse(practiceFormPage.checkRequiredField(practiceFormPage.inputSubject));
		assertFalse(practiceFormPage.checkRequiredField(practiceFormPage.inputEmail));
		assertFalse(practiceFormPage.checkRequiredField(checkboxSport));
		assertFalse(practiceFormPage.checkRequiredField(checkboxReading));
		assertFalse(practiceFormPage.checkRequiredField(checkboxMusic));
		
		assertFalse(practiceFormPage.checkRequiredField(picture));
		assertFalse(practiceFormPage.checkRequiredField(currentAdd));
		assertFalse(practiceFormPage.checkRequiredField(sate));
		assertFalse(practiceFormPage.checkRequiredField(city));
	}

}
