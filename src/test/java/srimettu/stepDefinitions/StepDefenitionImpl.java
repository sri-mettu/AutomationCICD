package srimettu.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
}
