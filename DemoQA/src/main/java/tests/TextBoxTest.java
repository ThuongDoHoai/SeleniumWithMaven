package tests;

import java.lang.annotation.ElementType;

import org.testng.annotations.Test;

import commons.TestBase;
import pages.ElementPage;
import pages.HomePage;
import pages.TextBoxPage;

public class TextBoxTest extends TestBase {

	@Test
	public void submitSuccessfully() throws InterruptedException {		
		openPage();		
		HomePage homePage = new HomePage(driver);		
		ElementPage elementPage = homePage.clickElementMenu();
		TextBoxPage textBoxPage = elementPage.clickTextBox();
		textBoxPage.inputValidData();
		textBoxPage.clickSubmitValid();
		//sleep 5s
		Thread.sleep(5000);
		driver.close();
	}
	
	@Test
	public void emailFormatWrong_1() throws InterruptedException {
		openPage();		
		HomePage homePage = new HomePage(driver);		
		ElementPage elementPage = homePage.clickElementMenu();
		TextBoxPage textBoxPage = elementPage.clickTextBox();
		textBoxPage.inputInValidData_1();
		textBoxPage.clickSubmitInvalid_1();
		//sleep 5s
		Thread.sleep(5000);
		driver.close();	
	} 
	
	@Test
	public void emailFormatWrong_2() throws InterruptedException {
		openPage();		
		HomePage homePage = new HomePage(driver);		
		ElementPage elementPage = homePage.clickElementMenu();
		TextBoxPage textBoxPage = elementPage.clickTextBox();
		textBoxPage.inputInValidData_2();
		textBoxPage.clickSubmitInvalid_2();
		//sleep 5s
		Thread.sleep(5000);
		driver.close();		
	} 
}
