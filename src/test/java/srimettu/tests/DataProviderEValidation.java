package srimettu.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import srimettu.TestComponents.Retry;
import srimettu.TestComponents.baseTest;
import srimettu.pageobjects.Dashboard;
import srimettu.pageobjects.LandingPage;

public class DataProviderEValidation extends baseTest{	
	 

	@Test(enabled=true,dataProvider="getData",groups={"login"},retryAnalyzer=Retry.class)
	public void InvalidlogIn(String un,String pwd) throws IOException {			
				
		landingpage.selectLang();
		landingpage.logInApp(un, pwd);	
		System.out.println(landingpage.getErrorMessage());
		Assert.assertEquals("invalid username or password....(If forgot username or password then contact your supervisor or administrator)", landingpage.getErrorMessage());
		
			
	}
	
	@Test(enabled=true,dataProvider="getData1",groups={"login"})
	public void logInCheck(HashMap<String,String> input) throws IOException {			
				
		landingpage.selectLang();
		Dashboard dashboard = landingpage.logInApp(input.get("un"), input.get("pwd"));	
		System.out.println(dashboard.getPageName());
		Assert.assertEquals("DASHBOARD", dashboard.getPageName());
		
			
	}
	@Test(enabled=true,dataProvider="getData2",groups={"login"})
	public void logInCheckdata(HashMap<String,String> input) throws IOException {			
				
		landingpage.selectLang();
		Dashboard dashboard = ((LandingPage) landingpage).logInApp(input.get("username"), input.get("password"));	
		System.out.println(dashboard.getPageName());
		Assert.assertEquals("DASHBOARD", dashboard.getPageName());			
	}
	
	
	@DataProvider
	
	public Object[][] getData() {
		
		return new Object[][] {{"s1","s2"},{"s2","s3"}};	
		
	}
	@DataProvider
	
	public Object[][] getData1() {
		HashMap<String,String> map =new HashMap<String,String>();
		map.put("un", "s2");
		map.put("pwd", "s2");
		
		HashMap<String,String> map1 =new HashMap<String,String>();
		map1.put("un", "s3");
		map1.put("pwd", "s3");
		
		return new Object[][] {{map},{map1}};
	}
@DataProvider
	
	public Object[][] getData2() throws IOException {
		
		List<HashMap<String, String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\srimettu\\data\\dataFile.json");
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}

	}
	

