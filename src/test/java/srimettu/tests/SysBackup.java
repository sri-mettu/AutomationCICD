package srimettu.tests;

import java.io.IOException;

import org.testng.annotations.Test;
import srimettu.TestComponents.*;
import srimettu.pageobjects.Dashboard;
import srimettu.pageobjects.DeviceManagement;
import srimettu.pageobjects.SystemBackup;
import srimettu.pageobjects.SystemConfig;
import srimettu.pageobjects.UserManagement;

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

	@Test(enabled = true)
	public void uploadDB() throws IOException, InterruptedException {
		landingpage.selectLang();
		Dashboard dashboard = landingpage.loginApplication();
		landingpage.menubutton();
		SystemBackup bacup = new SystemBackup(driver);
		bacup.uploadDB();
		dashboard.logoutApplication();
	}

	@Test(enabled = false)
	public void intAlarm() throws IOException, InterruptedException {
		landingpage.selectLang();
		Dashboard dashboard = landingpage.loginApplication();
		landingpage.menubutton();
		SystemConfig config = new SystemConfig(driver);
		config.intAlarm();
		dashboard.logoutApplication();

	}

}
