package srimettu.stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
import srimettu.pageobjects.*;

public class StepDefenitionImpl extends baseTest {
	public LandingPage landinpage;
	public Dashboard dashboard;
	public DeviceManagement devicemanagement;
	public SystemConfig sysconfig;
	public Reports reports;

	@Given("Open the browser and enter the url")
	public void Open_the_browser_and_enter_the_url() throws IOException {
		landingpage = launchApplication();

	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username, String password) throws IOException {
		dashboard = landingpage.logInApp(username, password);

	}

	@Then("Error message is displayed")
	public void invalidLogin() throws IOException {
		String lang = landingpage.selectLang();
		String errormessage = landingpage.getErrorMessage();
		if (lang.contains("en")) {
			Assert.assertEquals(
					"invalid username or password....(If forgot username or password then contact your supervisor or administrator)",
					errormessage);
		}

		else if (lang.contains("de")) {
			Assert.assertEquals(
					"Benutzername oder Passwort ungültig... (Falls Sie Ihren Benutzernamen oder Ihr Passwort vergessen haben, wenden Sie sich bitte an Ihren Vorgesetzten oder Administrator)",
					errormessage);
		}

		else if (lang.contains("fr")) {
			Assert.assertEquals(
					"nom d'utilisateur ou mot de passe invalide .... (Si vous avez oublié votre nom d'utilisateur ou votre mot de passe, contactez votre superviseur ou votre administrateur)",
					errormessage);
		}

		else if (lang.contains("sv")) {
			Assert.assertEquals(
					"ogiltigt användarnamn eller lösenord .... (Om du glömt användarnamnet eller lösenordet, kontakta din handledare eller administratör)",
					errormessage);
		}

		else if (lang.contains("es")) {
			Assert.assertEquals(
					"nombre de usuario o contraseña inválidos .... (Si olvidó el nombre de usuario o la contraseña, póngase en contacto con su supervisor o administrador)",
					errormessage);
		}

		else if (lang.contains("cs")) {
			Assert.assertEquals(
					"neplatné uživatelské jméno nebo heslo .... (Pokud jste zapomněli uživatelské jméno nebo heslo, kontaktujte svého nadřízeného nebo administrátora)",
					errormessage);
		}
		driver.quit();
	}

	@When("DASHBOARD is displayed")
	public void dashboard_is_displayed() throws IOException {
		WebElement card = driver.findElement(By.xpath("//app-card[1]//p[@class='title']"));
		String cardnm = card.getText();
		String pagename = dashboard.getPageName();
		// Assert.assertTrue(pagename.equalsIgnoreCase(string));

		if (cardnm.equalsIgnoreCase("Patient Call")) {
			Assert.assertEquals("DASHBOARD", pagename);
		}

		else if (cardnm.equalsIgnoreCase("Patientenruf")) {
			Assert.assertEquals("DASHBOARD", pagename);
		}

		else if (cardnm.equalsIgnoreCase("Appel du patient")) {
			Assert.assertEquals("TABLEAU DE BORD", pagename);
		}

		else if (cardnm.equalsIgnoreCase("Patientanrop")) {
			Assert.assertEquals("INSTRUMENTBRÄDA", pagename);
		}

		else if (cardnm.equalsIgnoreCase("Llamada del paciente")) {
			Assert.assertEquals("TABLERO", pagename);
		}

		else if (cardnm.equalsIgnoreCase("Volání Pacienta")) {
			Assert.assertEquals("INFORMAČNÍ PANEL", pagename);
		}

	}

	@And("^Beacon Alert is cleared with reason (.+)$")
	public void Beacon_Alert_is_cleared(String comment) {
		dashboard.bAlertClear(comment);
	}

	@And("^Device Status Alert is cleared with reason (.+)$")
	public void Device_Status_Alert_is_cleared(String comment) {
		dashboard.devicestatusClear(comment);
	}

	@And("^Maintenance Alert is cleared with reason (.+)$")
	public void Maintenance_Alert_is_cleared(String comment) {
		dashboard.mAlarmClear(comment);
	}

	@Then("Logout of the Application")
	public void Logout_of_the_Application() throws InterruptedException {
		dashboard.logoutApplication();
		driver.quit();
	}

	@And("Click on the menubutton")
	public void click_on_the_menubutton() {
		dashboard.menubutton();
	}

	@And("Get HubIP address")
	public void Get_HubIP_address() throws IOException, InterruptedException {
		sysconfig.gethubIPaddr();
	}

	@And("Click on device managemnet and Load the devices")
	public void Click_on_device_managemnet_and_Load_the_devices() throws IOException, InterruptedException {
		DeviceManagement devicemanagement = new DeviceManagement(driver);
		devicemanagement.devLoad();
	}

	@And("Click on device managemnet")
	public void Click_on_device_managemnet() throws IOException, InterruptedException {
		DeviceManagement devicemanagement = new DeviceManagement(driver);
		devicemanagement.devicemanag.click();
	}

	@And("^Search device id (.+)$")
	public void Search_device_id(String id) throws InterruptedException {
		DeviceManagement devicemanagement = new DeviceManagement(driver);
		dashboard.menubutton();
		devicemanagement.search(id);
	}

	@Then("^Edit device with area (.+) and user (.+)$")
	public void Edit_device(int ar, int usr) throws InterruptedException {
		DeviceManagement devicemanagement = new DeviceManagement(driver);

		devicemanagement.editDev(ar, usr);
	}

	@And("^Add the beacon devicename (.+) and MacAddress (.+)$")
	public void Add_Beacon(String devicename, String mcaddr) throws InterruptedException {
		DeviceManagement devicemanagement = new DeviceManagement(driver);
		devicemanagement.menubutton();
		devicemanagement.beaconAdd(devicename, mcaddr);
	}

	@And("Check Mable History Information")
	public void MableHistoryInformation() throws InterruptedException {
		dashboard.mabHis();
	}

	@And("Check Alarm History Information")
	public void AlarmHistoryInformation() throws InterruptedException {
		dashboard.alarmHis();
	}

	@And("Check Charts Information")
	public void ChartsInformation() throws InterruptedException {
		dashboard.chartInfo();
	}

	@Then("Click on reports")
	public void click_Reports() throws InterruptedException {
		Reports rep = new Reports(driver);
		rep.reports.click();
	}
	@And("^Generate report (.+) with user/dev (.+) or users (.+)$")
	public void report_wander_alert(int type, int urd, String usrsString) throws InterruptedException {
		 String[] usrsArray = usrsString.split(",");
	        int[] usrs = new int[usrsArray.length];
	        for (int i = 0; i < usrsArray.length; i++) {
	            usrs[i] = Integer.parseInt(usrsArray[i]);
	        }
		Reports reports = new Reports(driver);
		reports.genRep(type, urd, usrs);
	}

	@And("^Save the report with name (.+)")
	public void save_report(String nm) throws InterruptedException {
		Reports reports = new Reports(driver);
		reports.saveRep(nm);
	}

	@And("^Delete the report with name (.+)")
	public void delete_report(String nm) throws InterruptedException {
		Reports reports = new Reports(driver);
		reports.delRep(nm);
	}
}
