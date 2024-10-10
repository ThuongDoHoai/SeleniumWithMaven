package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.RadioButtonPage;

public class RadioButtonTest extends TestCase {

	@Test
	public void checkDefaultSelection() throws InterruptedException {
		testBase.openPage();
		RadioButtonPage radioButtonPage = new RadioButtonPage(testBase.driver);

		radioButtonPage.openRadioButtonPage();

		assertTrue(radioButtonPage.isCheckDefault(radioButtonPage.rdYes, radioButtonPage.rdImpressive,
				radioButtonPage.rdNo));
	}

}
