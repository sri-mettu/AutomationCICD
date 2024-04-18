package srimettu.tests;

import java.io.IOException;

import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;
import srimettu.TestComponents.*;
import srimettu.pageobjects.Dashboard;

public class StandAloneTest extends baseTest{			
	
	@Test(groups= {"alertClear"},enabled=true,retryAnalyzer=Retry.class)
	public void mAlarmClear() throws IOException {
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		//LandingPage landingpage = new LandingPage(driver);
		//landingpage.maxbrowser();
		//Dashboard dashAlerts = new Dashboard(driver);
		//landingpage.goTo("http://10.1.110.49");
		
		landingpage.selectLang();
		//Dashboard dashboard=landingpage.loginApplication("s2", "s2");
		Dashboard dashboard=landingpage.loginApplication();
		dashboard.mAlarmClear("M Alarm Clear Test");
		dashboard.logoutApplication();
		
	}
	

	@Test(groups= {"alertClear"},enabled=true)
	public void bAlertClear() throws IOException {
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		//LandingPage landingpage = new LandingPage(driver);
		//Dashboard dashAlerts = new Dashboard(driver);
		//landingpage.maxbrowser();
		//landingpage.goTo("http://10.1.110.51");
		//LandingPage landingpage=launchApplication();
		landingpage.selectLang();
		//landingpage.loginApplication("s2", "s2");
		Dashboard dashboard=landingpage.loginApplication();
		dashboard.bAlertClear("Beacon Alert Clear Test");
		dashboard.logoutApplication();
		
	}

	@Test(enabled=true)
	public void logIn() throws IOException {
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();	
		//LandingPage landingpage=launchApplication();
		//LandingPage landingpage = new LandingPage(driver);		
		//landingpage.maxbrowser();
		//landingpage.goTo("http://10.1.110.50");
		landingpage.selectLang();
		//landingpage.loginApplication("s1", "s1");	
		landingpage.loginApplication();	
		
	}
	@Test(dependsOnMethods= {"logIn"})
	public void logOut() throws IOException {
		//landingpage.loginApplication("s1", "s1");	
		landingpage.loginApplication();
		Dashboard dashboard = new Dashboard(driver);
		dashboard.logoutApplication();;
	}
	
}
