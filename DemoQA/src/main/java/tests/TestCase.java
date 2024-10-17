package tests;

import java.lang.module.Configuration;

import org.testng.annotations.BeforeTest;

import commons.Configurations;
import commons.TestBase;

public class TestCase {

	public final String CONFIG_FILE = System.getProperty("user.dir") + "\\src\\main\\resources\\Config.properties";
	
	public Configurations configurations = new Configurations(CONFIG_FILE);
	public TestBase testBase = new TestBase(CONFIG_FILE);
	
	@BeforeTest
	public void openPage() throws InterruptedException {
		testBase.openSingleBrowser(configurations.getConfigValueByKey("url"),"chrome");
	}
	
	

}