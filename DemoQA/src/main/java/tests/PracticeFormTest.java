package tests;

import org.testng.annotations.Test;
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
		String phone ="0948242456";
		String inputDate = "13 January 1989";
		String subject ="Maths, Chemistry";
		String hobbies = "Sports, Reading, Music";
		String filePath ="C:\\Users\\Phong\\Downloads\\kitty-cat-kitten-pet-45201.jpeg";
		String fileName ="kitty-cat-kitten-pet-45201.jpeg";
		String currentAdd =" xin chao cac ban \nha ha";
		String state = "Haryana";
		String city = "Karnal";
		
		String expectedStudentName = fistName + " " + lastName;
		
		String[] DOB = inputDate.split(" ");
	    String expectedDOB = DOB[0]+ " "+ DOB[1] +","+DOB[2];
	    
	    String expectCurrentAdd = currentAdd.replace("\n", "").trim();
				
	    String expectedStateCity = state + " " + city;
	    
	    
	    openPracticeFormPage();

	    practiceFormPage.inputData(fistName, lastName, email, gender, phone, inputDate, subject, hobbies,filePath, currentAdd, state, city);
		
		testBase.clickSubmit(practiceFormPage.submitButton);
		
		String[] actualOutput = practiceFormPage.getTextAfterSubmit();
		
		//verify Student Name
		assertEquals(actualOutput[1], expectedStudentName);
		
		//verify Student Email
		assertEquals(actualOutput[3], email);
		
		//verify Gender
		assertEquals(actualOutput[5], gender);
		
		//verify Phone
		assertEquals(actualOutput[7], phone);
		
		//verify inputDate
		assertEquals(actualOutput[9], expectedDOB);
		
		//verify subject
		assertEquals(actualOutput[11], subject);
		
		//verify hobbies
		assertEquals(actualOutput[13], hobbies);
		
		//verify uploadFile
		assertEquals(actualOutput[15], fileName);
				
		//verify currentAdd
		assertEquals(actualOutput[17], expectCurrentAdd);
		
		//verify State City
		assertEquals(actualOutput[19], expectedStateCity);
	}


}
