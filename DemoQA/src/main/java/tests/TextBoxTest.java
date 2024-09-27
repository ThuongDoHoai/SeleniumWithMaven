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

	@Test
	public void submitSuccessfully() throws InterruptedException {

		String inputFullName = "Do Hoai Thuong";
		String inputEmail = "abc@gmail.com";
		String inputCurrentAdd = "HN";
		String inputPermenantAdd = "HCM";

		String actualOuput = "";

		openTexBoxPage();

		testBase.inputText(textBoxPage.inputFullName, inputFullName);
		testBase.inputText(textBoxPage.inputEmail, inputEmail);
		testBase.inputText(textBoxPage.inputCurrentAdd, inputCurrentAdd);
		testBase.inputText(textBoxPage.inputPermanentAdd, inputPermenantAdd);

		textBoxPage.clickSubmit();

		actualOuput = textBoxPage.getTextAfterSubmit(textBoxPage.outputFullName);
		assertEquals(actualOuput, inputFullName);

		actualOuput = textBoxPage.getTextAfterSubmit(textBoxPage.outputEmail);
		assertEquals(actualOuput, inputEmail);

		actualOuput = textBoxPage.getTextAfterSubmit(textBoxPage.outputCurrentAdd);
		assertEquals(actualOuput, inputCurrentAdd);

		actualOuput = textBoxPage.getTextAfterSubmit(textBoxPage.outputPermanentAdd);
		assertEquals(actualOuput, inputPermenantAdd);

	}

	@Test(groups = "validation case: without @ in email")
	public void submiInvalidEmail_1() throws InterruptedException {
		String inputFullName = "Do Hoai Thuong";
		String inputEmail = "abcgmail.com";
		String inputCurrentAdd = "HN";
		String inputPermenantAdd = "HCM";

		openTexBoxPage();

		testBase.inputText(textBoxPage.inputFullName, inputFullName);
		testBase.inputText(textBoxPage.inputEmail, inputEmail);
		testBase.inputText(textBoxPage.inputCurrentAdd, inputCurrentAdd);
		testBase.inputText(textBoxPage.inputPermanentAdd, inputPermenantAdd);
		textBoxPage.clickSubmit();

		assertTrue(textBoxPage.getErrorField(textBoxPage.inputEmail));
		assertTrue(textBoxPage.getUnSaveServe(textBoxPage.outputArea));
	}

	@Test(groups = "validation case: without @ in email")
	public void submiInvalidEmail_2() throws InterruptedException {
		String inputFullName = "Do Hoai Thuong";
		String inputEmail = "abc@";
		String inputCurrentAdd = "HN";
		String inputPermenantAdd = "HCM";

		openTexBoxPage();

		testBase.inputText(textBoxPage.inputFullName, inputFullName);
		testBase.inputText(textBoxPage.inputEmail, inputEmail);
		testBase.inputText(textBoxPage.inputCurrentAdd, inputCurrentAdd);
		testBase.inputText(textBoxPage.inputPermanentAdd, inputPermenantAdd);
		textBoxPage.clickSubmit();

		assertTrue(textBoxPage.getErrorField(textBoxPage.inputEmail));
		assertTrue(textBoxPage.getUnSaveServe(textBoxPage.outputArea));
	}
}