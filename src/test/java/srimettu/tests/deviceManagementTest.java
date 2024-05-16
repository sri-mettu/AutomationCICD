package srimettu.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import srimettu.TestComponents.baseTest;
import srimettu.pageobjects.Dashboard;
import srimettu.pageobjects.DeviceManagement;

public class deviceManagementTest extends baseTest {

	

	@Test(enabled = true)
	public void deviceEdit() throws IOException, InterruptedException {
		landingpage.selectLang();
		Dashboard dashboard = landingpage.loginApplication();
		landingpage.menubutton();
		DeviceManagement deviceManagement = new DeviceManagement(driver);
		deviceManagement.devicemanag.click();
		landingpage.menubutton();
		deviceManagement.search("1033333");
		deviceManagement.editDev(2,0);
		dashboard.logoutApplication();
	}
	/*
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
	public void addBeacon() throws IOException, InterruptedException {
		landingpage.selectLang();
		Dashboard dashboard = landingpage.loginApplication();
		landingpage.menubutton();
		DeviceManagement deviceManagement = new DeviceManagement(driver);
		deviceManagement.devicemanag.click();
		landingpage.menubutton();
		deviceManagement.beaconAdd("autoBeacon", "Beac56789102");
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
		deviceManagement.delbeac("Beac56789102");
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
		deviceManagement.assgnUser("Beac56789102", 1);
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
		deviceManagement.unAssgnuser("Beac56789102");
		dashboard.logoutApplication();

	}

	@Test(enabled = true)
	public void addGateway() throws IOException, InterruptedException {

		landingpage.selectLang();
		Dashboard dashboard = landingpage.loginApplication();
		landingpage.menubutton();
		DeviceManagement deviceManagement = new DeviceManagement(driver);
		deviceManagement.devicemanag.click();
		landingpage.menubutton();
		deviceManagement.gwAdd("Auto GW", "AB34567891CD");
		dashboard.logoutApplication();

	}

	@Test(enabled = true)
	public void editGateway() throws IOException, InterruptedException {

		landingpage.selectLang();
		Dashboard dashboard = landingpage.loginApplication();
		landingpage.menubutton();
		DeviceManagement deviceManagement = new DeviceManagement(driver);
		deviceManagement.devicemanag.click();
		landingpage.menubutton();
		deviceManagement.gwEdit("AB34567891CD", "1", 1, 0, 0);
		dashboard.logoutApplication();

	}

	@Test(enabled = true, dependsOnMethods = { "addGateway" })
	public void deleteGateway() throws IOException, InterruptedException {

		landingpage.selectLang();
		Dashboard dashboard = landingpage.loginApplication();
		landingpage.menubutton();
		DeviceManagement deviceManagement = new DeviceManagement(driver);
		deviceManagement.devicemanag.click();
		landingpage.menubutton();
		deviceManagement.gwDelete("AB34567891CD");
		dashboard.logoutApplication();

	}

	@Test(enabled = true)
	public void addAlarmArea() throws IOException, InterruptedException {
		int[] devs = { 1, 2 };
		int[] gws = { 0 };
		landingpage.selectLang();
		Dashboard dashboard = landingpage.loginApplication();
		landingpage.menubutton();
		DeviceManagement deviceManagement = new DeviceManagement(driver);
		deviceManagement.devicemanag.click();
		landingpage.menubutton();
		deviceManagement.addAlarmArea("Auto Area", devs, gws);
		dashboard.logoutApplication();

	}

	@Test(enabled = true)
	public void delAlarmArea() throws IOException, InterruptedException {
		landingpage.selectLang();
		Dashboard dashboard = landingpage.loginApplication();
		landingpage.menubutton();
		DeviceManagement deviceManagement = new DeviceManagement(driver);
		deviceManagement.devicemanag.click();
		landingpage.menubutton();
		deviceManagement.delAlarmArea("Auto Area");
		dashboard.logoutApplication();

	}
*/
}
