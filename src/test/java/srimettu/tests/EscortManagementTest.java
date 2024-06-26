package srimettu.tests;

import java.io.IOException;

import org.testng.annotations.Test;
import srimettu.TestComponents.*;
import srimettu.pageobjects.Dashboard;
import srimettu.pageobjects.EscortManagement;
import srimettu.pageobjects.UserManagement;

public class EscortManagementTest extends baseTest{		

	@Test(enabled=true)
	public void addEscortEvent() throws IOException, InterruptedException {
		landingpage.selectLang();		
		Dashboard dashboard=landingpage.loginApplication();
		System.out.println("Login Success");
		landingpage.menubutton();		
		EscortManagement escortManagement = new EscortManagement(driver);		
		escortManagement.addEvent(14, 10, 14, 30);
		System.out.println("Escort Event Added");
		dashboard.logoutApplication();
		
	}
	@Test(enabled=true)
	public void deleteEscortEvent() throws IOException, InterruptedException {
		landingpage.selectLang();		
		Dashboard dashboard=landingpage.loginApplication();
		System.out.println("Login Success");
		landingpage.menubutton();		
		EscortManagement escortManagement = new EscortManagement(driver);		
		escortManagement.delEvent("Test to delete Escort event");
		System.out.println("Escort Event Deleted");
		dashboard.logoutApplication();
		
	}
	
	
}
