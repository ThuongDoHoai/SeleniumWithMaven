package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadDownloadPage extends Page {
	
	public By btnDownload = By.id("downloadButton");
	public By btnUpload = By.id("uploadFile");

	public UploadDownloadPage(WebDriver driver, String configFile) {
		super(driver, configFile);
	}
}
