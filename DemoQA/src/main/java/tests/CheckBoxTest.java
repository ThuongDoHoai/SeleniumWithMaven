package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.CheckBoxPage;

public class CheckBoxTest extends TestCase {
	
	@Test
	public void verifyCheckBoxCorrectly() throws InterruptedException {
		
		CheckBoxPage checkBoxPage = new CheckBoxPage(testBase.driver);
		checkBoxPage.openCheckBoxPage();
		//check default checking of check box HOME
		assertFalse(checkBoxPage.verifyCheckingOfCheckBox(checkBoxPage.chbHome));
		
		
		checkBoxPage.clickButton(checkBoxPage.chbHome);
		String expectedLabel = "You have selected : home desktop notes commands documents workspace react angular veu office public private classified general downloads wordFile excelFile";
		String actualLabel = checkBoxPage.getLableResult(checkBoxPage.lblResult);
		//check the displaying of label
		assertEquals(actualLabel, expectedLabel);
	
		checkBoxPage.clickButton(checkBoxPage.arrHome);
		String[] labelCheckBoxes = {"Home", "Desktop","Documents","Downloads"}; 
		assertTrue(checkBoxPage.checkLabelCheckBoxes(labelCheckBoxes));
		assertTrue(checkBoxPage.checkCheckingOfCheckBoxes());
		
	}

}