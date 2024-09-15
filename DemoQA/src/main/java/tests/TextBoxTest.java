package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.lang.annotation.ElementType;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commons.TestBase;
import pages.ElementPage;
import pages.HomePage;
import pages.TextBoxPage;

public class TextBoxTest extends TestCase {

	// @Test
	public void submitSuccessfully() throws InterruptedException {
		String inputFullName = "Do Hoai Thuong";
		String inputEmail = "dohoaithuong1989@gmail.com";
		String inputCurrentAdd = "Ha Noi";
		String inputPermanetAdd = "HCM";

		String actualFullName = "";
		String actualEmail = "";
		String actualCurrentAdd = "";
		String actualPermanetAdd = "";

		openTextBoxPage();

		textBoxPage.inputText(textBoxPage.lblNameInput, inputFullName);
		textBoxPage.inputText(textBoxPage.lblEmailInput, inputEmail);
		textBoxPage.inputText(textBoxPage.lblCurrentAddInput, inputCurrentAdd);
		textBoxPage.inputText(textBoxPage.lblPermanetAddInput, inputPermanetAdd);
		textBoxPage.clickSubmit();

		// assert Name field
		actualFullName = textBoxPage.getTextAfterSubmit(textBoxPage.lblNameOutput);
		assertEquals(actualFullName, inputFullName);

		// assert Email field
		actualEmail = textBoxPage.getTextAfterSubmit(textBoxPage.lblEmailOutput);
		assertEquals(actualEmail, inputEmail);

		// assert Current Add field
		actualCurrentAdd = textBoxPage.getTextAfterSubmit(textBoxPage.lblCurrentAddOutput);
		assertEquals(actualCurrentAdd, inputCurrentAdd);

		// assert Permanet Add field
		actualPermanetAdd = textBoxPage.getTextAfterSubmit(textBoxPage.lblPermanetAddOutput);
		assertEquals(actualPermanetAdd, inputPermanetAdd);

	}

	// @Test(groups = "validation")
	public void emailFormatWithoutAtSign() throws InterruptedException {

		String inputFullName = "Do Hoai Thuong";
		String inputEmail = "dohoaithuong1989gmail.com";
		String inputCurrentAdd = "Ha Noi";
		String inputPermanetAdd = "HCM";

		openTextBoxPage();

		textBoxPage.inputText(textBoxPage.lblNameInput, inputFullName);
		textBoxPage.inputText(textBoxPage.lblEmailInput, inputEmail);
		textBoxPage.inputText(textBoxPage.lblCurrentAddInput, inputCurrentAdd);
		textBoxPage.inputText(textBoxPage.lblPermanetAddInput, inputPermanetAdd);
		textBoxPage.clickSubmit();

		// check red border
		assertTrue(textBoxPage.checkRedBorder(textBoxPage.lblEmailInput));

		// check do not save in server
		assertTrue(textBoxPage.checkSaveServer(textBoxPage.lblOutputArea));

	}

	@Test(groups = "validation")
	public void emailFormatWithoutDomain() throws InterruptedException {

		String inputFullName = "Do Hoai Thuong";
		String inputEmail = "dohoaithuong1989@";
		String inputCurrentAdd = "Ha Noi";
		String inputPermanetAdd = "HCM";

		openTextBoxPage();

		textBoxPage.inputText(textBoxPage.lblNameInput, inputFullName);
		textBoxPage.inputText(textBoxPage.lblEmailInput, inputEmail);
		textBoxPage.inputText(textBoxPage.lblCurrentAddInput, inputCurrentAdd);
		textBoxPage.inputText(textBoxPage.lblPermanetAddInput, inputPermanetAdd);
		textBoxPage.clickSubmit();

		// check red border
		assertTrue(textBoxPage.checkRedBorder(textBoxPage.lblEmailInput));

		// check do not save in server
		// assertFalse(!testBase.driver.findElement(textBoxPage.lblOutputArea).isDisplayed());
		assertTrue(textBoxPage.checkSaveServer(textBoxPage.lblOutputArea));
	}

}
