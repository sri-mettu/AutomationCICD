package srimettu.tests;

import java.io.IOException;

import org.testng.annotations.Test;
import srimettu.TestComponents.*;
import srimettu.pageobjects.Dashboard;
import srimettu.pageobjects.DeviceManagement;
import srimettu.pageobjects.SystemConfig;
import srimettu.pageobjects.UserManagement;

public class deviceManagementTest extends baseTest {

	@Test(enabled = true)
	public void loadDevice() throws IOException, InterruptedException {
		landingpage.selectLang();
		Dashboard dashboard = landingpage.loginApplication();
		System.out.println("Login Success");
		landingpage.menubutton();
		DeviceManagement deviceManagement = new DeviceManagement(driver);
		deviceManagement.devLoad();
		dashboard.logoutApplication();

	}

	@Test(enabled = true)
	public void deviceEdit() throws IOException, InterruptedException {
		landingpage.selectLang();
		Dashboard dashboard = landingpage.loginApplication();
		landingpage.menubutton();
		DeviceManagement deviceManagement = new DeviceManagement(driver);
		deviceManagement.devicemanag.click();
		landingpage.menubutton();
		deviceManagement.search("1033333");
		deviceManagement.editDev(1, 1);
		dashboard.logoutApplication();
	}

	@Test(enabled = true)
	public void addBeacon() throws IOException, InterruptedException {
		landingpage.selectLang();
		Dashboard dashboard = landingpage.loginApplication();
		landingpage.menubutton();
		DeviceManagement deviceManagement = new DeviceManagement(driver);
		deviceManagement.devicemanag.click();
		landingpage.menubutton();
		deviceManagement.beaconAdd("autoBeacon", "123456789102");
		dashboard.logoutApplication();

	}

	@Test(enabled = true, dependsOnMethods = { "unAssignUser" })
	public void delBeacon() throws IOException, InterruptedException {
		landingpage.selectLang();
		Dashboard dashboard = landingpage.loginApplication();
		landingpage.menubutton();
		DeviceManagement deviceManagement = new DeviceManagement(driver);
		deviceManagement.devicemanag.click();
		landingpage.menubutton();
		deviceManagement.delbeac("123456789102");
		dashboard.logoutApplication();

	}

	@Test(enabled = true)
	public void assignUser() throws IOException, InterruptedException {
		landingpage.selectLang();
		Dashboard dashboard = landingpage.loginApplication();
		landingpage.menubutton();
		DeviceManagement deviceManagement = new DeviceManagement(driver);
		deviceManagement.devicemanag.click();
		landingpage.menubutton();
		deviceManagement.assgnUser("123456789102", 1);
		dashboard.logoutApplication();

	}

	@Test(enabled = true)
	public void unAssignUser() throws IOException, InterruptedException {
		landingpage.selectLang();
		Dashboard dashboard = landingpage.loginApplication();
		landingpage.menubutton();
		DeviceManagement deviceManagement = new DeviceManagement(driver);
		deviceManagement.devicemanag.click();
		landingpage.menubutton();
		deviceManagement.unAssgnuser("123456789102");
		dashboard.logoutApplication();

	}

}
