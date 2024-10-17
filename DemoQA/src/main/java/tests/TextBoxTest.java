package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.TextBoxPage;

public class TextBoxTest extends TestCase {
	
	//@Test (groups ="Happy case")
	public void inputSuccessfully() throws InterruptedException {
		
		String fullName = "abc";
		String email = "acddga@gmail.com";
		String currAdd = "HN";
		String perAdd = "HCM";
		
		TextBoxPage textBoxPage = new TextBoxPage(testBase.driver, CONFIG_FILE);
		textBoxPage.openTextBoxPage();
		textBoxPage.inputDataAllField(fullName, email, currAdd, perAdd);
		
		
		String actualName = textBoxPage.getTextAfterSubmit(textBoxPage.outputName);
		String actualEmail = textBoxPage.getTextAfterSubmit(textBoxPage.outputEmail);
		String actualCurrAdd = textBoxPage.getTextAfterSubmit(textBoxPage.outputCurrAdd);
		String actualPerAdd = textBoxPage.getTextAfterSubmit(textBoxPage.outputPerAdd);
		
		assertEquals(actualName, fullName);
		assertEquals(actualEmail, email);
		assertEquals(actualCurrAdd, currAdd);
		assertEquals(actualPerAdd, perAdd);
	}
	
	
	@Test (groups ="Validation case")
	public void inputUnSuccessfullyWithoutDomain() throws InterruptedException {
		String fullName = "abc";
		String email = "acddga@";
		String currAdd = "HN";
		String perAdd = "HCM";
		
		TextBoxPage textBoxPage = new TextBoxPage(testBase.driver, CONFIG_FILE);
		textBoxPage.openTextBoxPage();
		textBoxPage.inputDataAllField(fullName, email, currAdd, perAdd);
		
		assertTrue(textBoxPage.checkErrorField(textBoxPage.txtEmail));
	}

}