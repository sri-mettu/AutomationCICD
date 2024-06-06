package srimettu.tests;

import java.io.IOException;

import org.testng.annotations.Test;
import srimettu.TestComponents.*;
import srimettu.pageobjects.Dashboard;
import srimettu.pageobjects.DeviceManagement;
import srimettu.pageobjects.SystemConfig;
import srimettu.pageobjects.UserManagement;
import srimettu.pageobjects.*;

public class ReportsTest extends baseTest {

	@Test(enabled = true)
	public void genanddelReport() throws IOException, InterruptedException {
		int[] usrs= {1,2};
		landingpage.selectLang();
		Dashboard dashboard = landingpage.loginApplication();
		System.out.println("Login Success");
		landingpage.menubutton();
		Reports report = new Reports(driver);
		report.reports.click();
		report.genRep(1, 0, usrs);		
		report.saveRep("test01");
		report.delRep("test01");
		dashboard.logoutApplication();

	}

	
}
