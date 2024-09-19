package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.annotation.ElementType;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.TestBase;
import pages.ElementPage;
import pages.HomePage;
import pages.TextBoxPage;

public class TextBoxTest extends TestCase {

	//@Test
	public void submitSuccessfully() throws InterruptedException {

		String inputFullName = "Do Hoai Thuong";
		String inputEmail = "abc@gmail.com";
		String inputCurrentAdd = "HN";
		String inputPermenantAdd = "HCM";

		String actualOuput = "";

		openTexBoxPage();

		textBoxPage.inputData(textBoxPage.lblInputFullName, inputFullName);
		textBoxPage.inputData(textBoxPage.lblInputEmail, inputEmail);
		textBoxPage.inputData(textBoxPage.lblInputCurrentAdd, inputCurrentAdd);
		textBoxPage.inputData(textBoxPage.lblInputPermanentAdd, inputPermenantAdd);
		textBoxPage.clickSubmit();

		actualOuput = textBoxPage.getTextAfterSubmit(textBoxPage.lblOuputFullName);
		assertEquals(actualOuput, inputFullName);

		actualOuput = textBoxPage.getTextAfterSubmit(textBoxPage.lblOutputEmail);
		assertEquals(actualOuput, inputEmail);

		actualOuput = textBoxPage.getTextAfterSubmit(textBoxPage.lblOutputCurrentAdd);
		assertEquals(actualOuput, inputCurrentAdd);

		actualOuput = textBoxPage.getTextAfterSubmit(textBoxPage.lblOutputPermanentAdd);
		assertEquals(actualOuput, inputPermenantAdd);

	}

	@Test(groups = "validation case: without @ in email")
	public void submiInvalidEmail_1() throws InterruptedException {
		String inputFullName = "Do Hoai Thuong";
		String inputEmail = "abcgmail.com";
		String inputCurrentAdd = "HN";
		String inputPermenantAdd = "HCM";

		openTexBoxPage();

		textBoxPage.inputData(textBoxPage.lblInputFullName, inputFullName);
		textBoxPage.inputData(textBoxPage.lblInputEmail, inputEmail);
		textBoxPage.inputData(textBoxPage.lblInputCurrentAdd, inputCurrentAdd);
		textBoxPage.inputData(textBoxPage.lblInputPermanentAdd, inputPermenantAdd);
		textBoxPage.clickSubmit();
		
		assertTrue(textBoxPage.getErrorField(textBoxPage.lblInputEmail));
		assertTrue(textBoxPage.getUnSaveServe(textBoxPage.lblOuputArea));
	}

	@Test(groups = "validation case: without @ in email")
	public void submiInvalidEmail_2() throws InterruptedException {
		String inputFullName = "Do Hoai Thuong";
		String inputEmail = "abc@";
		String inputCurrentAdd = "HN";
		String inputPermenantAdd = "HCM";

		openTexBoxPage();

		textBoxPage.inputData(textBoxPage.lblInputFullName, inputFullName);
		textBoxPage.inputData(textBoxPage.lblInputEmail, inputEmail);
		textBoxPage.inputData(textBoxPage.lblInputCurrentAdd, inputCurrentAdd);
		textBoxPage.inputData(textBoxPage.lblInputPermanentAdd, inputPermenantAdd);
		textBoxPage.clickSubmit();
		
		assertTrue(textBoxPage.getErrorField(textBoxPage.lblInputEmail));
		assertTrue(textBoxPage.getUnSaveServe(textBoxPage.lblOuputArea));
	}
}