package srimettu.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import srimettu.TestComponents.baseTest;
import srimettu.pageobjects.Dashboard;
import srimettu.pageobjects.SystemBackup;

public class SysBackup extends baseTest {

	@Test(enabled = true)
	public void downloadDB() throws IOException, InterruptedException {
		landingpage.selectLang();
		Dashboard dashboard = landingpage.loginApplication();		
		landingpage.menubutton();
		SystemBackup bacup = new SystemBackup(driver);
		bacup.downloadDB();
		dashboard.logoutApplication();

	}

	@Test(enabled = true,dependsOnMethods= {"downloadDB"})
	public void uploadDB() throws IOException, InterruptedException {
		landingpage.selectLang();
		Dashboard dashboard = landingpage.loginApplication();
		landingpage.menubutton();
		SystemBackup bacup = new SystemBackup(driver);
		bacup.uploadDB();
		dashboard.logoutApplication();
	}

	@Test(enabled = true)
	public void newBackup() throws IOException, InterruptedException {
		landingpage.selectLang();
		Dashboard dashboard = landingpage.loginApplication();
		landingpage.menubutton();
		SystemBackup bacup = new SystemBackup(driver);
		bacup.newBacup("BackupOnly","Users");
		
		dashboard.logoutApplication();
	}
	@Test(enabled = true, dependsOnMethods= {"newBackup"})
	public void deleteBackup() throws IOException, InterruptedException {
		landingpage.selectLang();
		Dashboard dashboard = landingpage.loginApplication();
		landingpage.menubutton();
		SystemBackup bacup = new SystemBackup(driver);
		bacup.delBacup();
		dashboard.logoutApplication();
	}

}
