package srimettu.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.core.cli.Main;
import srimettu.TestComponents.baseTest;
import srimettu.pageobjects.Dashboard;
import srimettu.pageobjects.LandingPage;
import srimettu.pageobjects.SystemConfig;
import srimettu.pageobjects.DeviceManagement;

public class StepDefenitionImpl extends baseTest{
	public LandingPage landinpage;
	public Dashboard dashboard;
	public DeviceManagement devicemanagement;
	public SystemConfig sysconfig;
	@Given("Open the browser and enter the url")
	public void Open_the_browser_and_enter_the_url() throws IOException {
		landingpage = launchApplication();
		
	}
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username, String password) throws IOException { 
		dashboard = landingpage.logInApp(username, password);
	}
	
	@Given("{string} message is displayed")
	public void invalidLogin(String string) {
		String errormessage = landingpage.getErrorMessage();
		Assert.assertTrue(errormessage.equalsIgnoreCase(string));
		driver.quit();
	}
	
	@When("{string} is displayed")
	public void dashboard_is_displayed (String string) {
		String pagename = dashboard.getPageName();
		Assert.assertTrue(pagename.equalsIgnoreCase(string));
	}
	@And ("^Beacon Alert is cleared with reason (.+)$")
	public void Beacon_Alert_is_cleared(String comment) {	
		dashboard.bAlertClear(comment);				
	}
	@And ("^Device Status Alert is cleared with reason (.+)$")
	public void Device_Status_Alert_is_cleared(String comment) {	
		dashboard.devicestatusClear(comment);				
	}
	@And ("^Maintenance Alert is cleared with reason (.+)$")
	public void Maintenance_Alert_is_cleared(String comment) {	
		dashboard.mAlarmClear(comment);
	}
	
	@Then ("Logout of the Application")
	public void Logout_of_the_Application() throws InterruptedException {		
		dashboard.logoutApplication();
		driver.quit();
	}
	@And ("Click on the menubutton")
	public void click_on_the_menubutton() {
		dashboard.menubutton();
	}
	@And ("Get HubIP address")
	public void Get_HubIP_address() throws IOException, InterruptedException {
		sysconfig.gethubIPaddr();
	}
	@And ("Click on device managemnet and Load the devices")
	public void Click_on_device_managemnet_and_Load_the_devices() throws IOException, InterruptedException {
		DeviceManagement devicemanagement =new DeviceManagement(driver);
		devicemanagement.devLoad();
	}
	@And ("Click on device managemnet")
	public void Click_on_device_managemnet() throws IOException, InterruptedException {
		DeviceManagement devicemanagement =new DeviceManagement(driver);
		devicemanagement.devicemanag.click();
	}
	@And ("^Search device id (.+)$")
	public void Search_device_id(String id) throws InterruptedException {
		DeviceManagement devicemanagement =new DeviceManagement(driver);
		dashboard.menubutton();
		devicemanagement.search(id);
	}
	@Then ("^Edit device with area (.+) and user (.+)$")
	public void Edit_device(int ar, int usr) throws InterruptedException {
		DeviceManagement devicemanagement =new DeviceManagement(driver);
		
		devicemanagement.editDev(ar, usr);
	}
	@And ("^Add the beacon devicename (.+) and MacAddress (.+)$")
	public void Add_Beacon(String devicename, String mcaddr) throws InterruptedException {
		DeviceManagement devicemanagement =new DeviceManagement(driver);
		devicemanagement.menubutton();
		devicemanagement.beaconAdd(devicename, mcaddr);
	}
	@And ("Check Mable History Information")
	public void MableHistoryInformation() throws InterruptedException {
		dashboard.mabHis();
	}
	@And ("Check Alarm History Information")
	public void AlarmHistoryInformation() throws InterruptedException {
		dashboard.alarmHis();
	}
	@And ("Check Charts Information")
	public void ChartsInformation() throws InterruptedException {
		dashboard.chartInfo();
	}
}
