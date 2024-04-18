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

public class StepDefenitionImpl extends baseTest{
	public LandingPage landinpage;
	public Dashboard dashboard;
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
		Thread.sleep(2000);
		dashboard.logoutApplication();
	}

}
