package srimettu.tests;

import java.io.IOException;

import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;
import srimettu.TestComponents.*;
import srimettu.pageobjects.Dashboard;
import srimettu.pageobjects.UserManagement;

public class UserManagementTest extends baseTest{		

	@Test(enabled=false)
	public void userAdd() throws IOException {
		landingpage.selectLang();		
		Dashboard dashboard=landingpage.loginApplication();
		System.out.println("Login Success");
		landingpage.menubutton();		
		UserManagement userManagement = new UserManagement(driver);		
		userManagement.addUser("Auto", "User", "20/07/1975", "0123456789", "user@user.com", "AutoAdd");
		System.out.println("User Added");
		dashboard.logoutApplication();
		
	}
	@Test(enabled=false)
	public void userEdit() throws IOException, InterruptedException {
		landingpage.selectLang();		
		Dashboard dashboard=landingpage.loginApplication();		
		landingpage.menubutton();		
		UserManagement userManagement = new UserManagement(driver);		
		userManagement.eidtUser("A1","U1");
		System.out.println("User Edited");
		dashboard.logoutApplication();
		
	}
	@Test(enabled=true)
	public void assignDev() throws IOException, InterruptedException {
		landingpage.selectLang();		
		Dashboard dashboard=landingpage.loginApplication();		
		landingpage.menubutton();		
		UserManagement userManagement = new UserManagement(driver);		
		userManagement.assignDev();
		System.out.println("User Device Assigned");
		dashboard.logoutApplication();
		
	}
	@Test(enabled=true,dependsOnMethods= {"assignDev"})
	public void unassignDev() throws IOException, InterruptedException {
		landingpage.selectLang();		
		Dashboard dashboard=landingpage.loginApplication();		
		landingpage.menubutton();		
		UserManagement userManagement = new UserManagement(driver);		
		userManagement.unassignDev("test");
		System.out.println("User Device Un-Assigned");
		dashboard.logoutApplication();
		
	}
	@Test(enabled=true)
	public void userDelete() throws IOException, InterruptedException {
		landingpage.selectLang();		
		Dashboard dashboard=landingpage.loginApplication();		
		landingpage.menubutton();		
		UserManagement userManagement = new UserManagement(driver);		
		userManagement.userDel("test");
		System.out.println("User Deleted");
		dashboard.logoutApplication();
		
	}
	
	
}
