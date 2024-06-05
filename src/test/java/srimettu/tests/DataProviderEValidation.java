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
	 

	@Test(enabled=true,dataProvider="getData",groups={"login"})
	public void InvalidlogIn(String un,String pwd) throws IOException, InterruptedException {			
				
		String lang = landingpage.selectLang();		
		landingpage.logInApp(un, pwd);	
		String errormessage = landingpage.getErrorMessage();
				
		if (lang.contains("en")){			
			Assert.assertEquals("invalid username or password....(If forgot username or password then contact your supervisor or administrator)", errormessage);}
		
		else if (lang.contains("de")){
			Assert.assertEquals("Benutzername oder Passwort ungültig... (Falls Sie Ihren Benutzernamen oder Ihr Passwort vergessen haben, wenden Sie sich bitte an Ihren Vorgesetzten oder Administrator)", errormessage);}
				
			else if (lang.contains("fr")){
				Assert.assertEquals("nom d'utilisateur ou mot de passe invalide .... (Si vous avez oublié votre nom d'utilisateur ou votre mot de passe, contactez votre superviseur ou votre administrateur)", errormessage);}
		
			else if (lang.contains("sv")){
				Assert.assertEquals("ogiltigt användarnamn eller lösenord .... (Om du glömt användarnamnet eller lösenordet, kontakta din handledare eller administratör)", errormessage);}

		
			else if (lang.contains("es")){
				Assert.assertEquals("nombre de usuario o contraseña inválidos .... (Si olvidó el nombre de usuario o la contraseña, póngase en contacto con su supervisor o administrador)", errormessage);}


			else if (lang.contains("cs")){
				Assert.assertEquals("neplatné uživatelské jméno nebo heslo .... (Pokud jste zapomněli uživatelské jméno nebo heslo, kontaktujte svého nadřízeného nebo administrátora)", errormessage);}		
				}
	
	@Test(enabled=false,dataProvider="getData1",groups={"login"},retryAnalyzer=Retry.class)
	public void logInCheck(HashMap<String,String> input) throws IOException {			
				
		landingpage.selectLang();
		Dashboard dashboard = landingpage.logInApp(input.get("un"), input.get("pwd"));	
		System.out.println(dashboard.getPageName());
		Assert.assertEquals("DASHBOARD", dashboard.getPageName());
		
			
	}
	@Test(enabled=false,dataProvider="getData2",groups={"login"})
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
	

