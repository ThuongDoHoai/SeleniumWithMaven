package tests;

import org.testng.annotations.Test;

import pages.UploadDownloadPage;

public class UploadDownloadTest extends TestCase {

	@Test
	public void downloadSuccessfully() throws InterruptedException {

		UploadDownloadPage uploadDownloadPage = new UploadDownloadPage(testBase.driver, CONFIG_FILE);

		uploadDownloadPage.openUploadDownloadPage();
		uploadDownloadPage.testBase.downloadFile(uploadDownloadPage.btnDownload);

	}

	@Test
	public void uploadFileSuccessfully() {
		UploadDownloadPage uploadDownloadPage = new UploadDownloadPage(testBase.driver, CONFIG_FILE);
		uploadDownloadPage.openUploadDownloadPage();

	}

}
