package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CheckBoxTest extends TestCase {

	// @Test
	public void checkCheckBoxDefaultDisplay() {
		openCheckBoxPage();
		assertTrue(checkBoxPage.getUnCheckingStatus(checkBoxPage.checkBoxHome));
	}

	// @Test
	public void checkDisplayResult() {
		openCheckBoxPage();

		String expectedText = "You have selected : home desktop notes commands documents workspace react angular veu office public private classified general downloads wordFile excelFile";

		checkBoxPage.clickCheckBoxHome();
		String actualText = checkBoxPage.getTextAfterClick();

		assertEquals(actualText, expectedText);
	}

	@Test
	public void checkSubCheckBoxs() {
		String[] expectLable = { "Home", "Desktop", "Documents", "Downloads" };
		int index = 0;

		openCheckBoxPage();
		checkBoxPage.clickCheckBoxHome();
		checkBoxPage.clickArrowHome();

		List<WebElement> checkBoxs = checkBoxPage.drPage.findElements(By.xpath("//span[@class='rct-checkbox']/*[name()='svg']"));
		List<WebElement> titles = checkBoxPage.drPage.findElements(By.xpath("//span[@class='rct-title']"));

		while (index < 4) {
			assertTrue(checkBoxPage.getCheckingStatus(checkBoxs.get(index)));
			assertEquals(checkBoxPage.getlableSubCheckBoxs(titles.get(index)), expectLable[index]);
			index++;
		}

	}
}