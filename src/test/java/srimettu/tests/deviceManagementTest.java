package srimettu.tests;

import java.io.IOException;

import org.testng.annotations.Test;
import srimettu.TestComponents.*;
import srimettu.pageobjects.Dashboard;
import srimettu.pageobjects.DeviceManagement;
import srimettu.pageobjects.UserManagement;

public class deviceManagementTest extends baseTest{		
	
	@Test(enabled=true)
	public void loadDevice() throws IOException, InterruptedException {
		landingpage.selectLang();		
		Dashboard dashboard=landingpage.loginApplication();
		System.out.println("Login Success");
		landingpage.menubutton();		
		DeviceManagement deviceManagement = new DeviceManagement(driver);		
		deviceManagement.devLoad("10.1.105.92");				
		dashboard.logoutApplication();
		
	}
	@Test(enabled=true)
	public void deviceEdit() throws IOException, InterruptedException {
		landingpage.selectLang();		
		Dashboard dashboard=landingpage.loginApplication();		
		landingpage.menubutton();	
		DeviceManagement deviceManagement = new DeviceManagement(driver);
		deviceManagement.devicemanag.click();
		landingpage.menubutton();
		deviceManagement.search("1033333");
		deviceManagement.editDev("Andy-Desk", "u 596e");
		dashboard.logoutApplication();
		
	}/*
	@Test(enabled=false,dependsOnMethods= {"userAdd"})
	public void assignDev() throws IOException, InterruptedException {
		landingpage.selectLang();		
		Dashboard dashboard=landingpage.loginApplication();		
		landingpage.menubutton();		
		UserManagement userManagement = new UserManagement(driver);		
		userManagement.assignDev();
		System.out.println("User Device Assigned");
		dashboard.logoutApplication();
		
	}
	@Test(enabled=false,dependsOnMethods= {"assignDev"})
	public void unassignDev() throws IOException, InterruptedException {
		landingpage.selectLang();		
		Dashboard dashboard=landingpage.loginApplication();		
		landingpage.menubutton();		
		UserManagement userManagement = new UserManagement(driver);		
		userManagement.unassignDev("test");
		System.out.println("User Device Un-Assigned");
		dashboard.logoutApplication();
		
	}
	@Test(enabled=true,dependsOnMethods= {"userAdd"})
	public void userDelete() throws IOException, InterruptedException {
		landingpage.selectLang();		
		Dashboard dashboard=landingpage.loginApplication();		
		landingpage.menubutton();		
		UserManagement userManagement = new UserManagement(driver);		
		userManagement.userDel("test");
		System.out.println("User Deleted");
		dashboard.logoutApplication();
		
	}*/
	
	
}
