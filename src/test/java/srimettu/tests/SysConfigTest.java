package srimettu.tests;

import java.io.IOException;

import org.testng.annotations.Test;
import srimettu.TestComponents.*;
import srimettu.pageobjects.Dashboard;
import srimettu.pageobjects.DeviceManagement;
import srimettu.pageobjects.SystemConfig;
import srimettu.pageobjects.UserManagement;

public class SysConfigTest extends baseTest {

	@Test(enabled = true)
	public void ekIP() throws IOException, InterruptedException {
		landingpage.selectLang();
		Dashboard dashboard = landingpage.loginApplication();
		System.out.println("Login Success");
		landingpage.menubutton();
		SystemConfig config = new SystemConfig(driver);
		config.getekIPaddr();
		dashboard.logoutApplication();

	}

	@Test(enabled = true)
	public void hubIP() throws IOException, InterruptedException {
		landingpage.selectLang();
		Dashboard dashboard = landingpage.loginApplication();
		landingpage.menubutton();
		SystemConfig config = new SystemConfig(driver);
		config.gethubIPaddr();
		dashboard.logoutApplication();
	}

	@Test(enabled = true)
	public void intAlarm() throws IOException, InterruptedException {
		landingpage.selectLang();
		Dashboard dashboard = landingpage.loginApplication();
		landingpage.menubutton();
		SystemConfig config = new SystemConfig(driver);
		config.intAlarm();
		dashboard.logoutApplication();

	}

}
