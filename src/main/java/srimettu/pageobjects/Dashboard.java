package srimettu.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import srimettu.AbstractComponents.AbstractComponent;

public class Dashboard extends AbstractComponent {
	WebDriver driver;
	
	public Dashboard(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div[class='pageName']")
	WebElement pageNameDB;

	@FindBy(xpath = "//app-card[6]")
	WebElement maintenanceAlarm;
	@FindBy(xpath = "//app-card[6]//b")
	WebElement mAlarmCount;	
	@FindBy(xpath= "//app-card[10]")
	WebElement devicestatusAlert;
	@FindBy(xpath= "//app-card[10]//b")
	WebElement dsAlertCount;
	@FindBy(xpath = "(//textarea[@type='text'])[1]")	
	WebElement MtextBox;
	@FindBy(xpath = "(//mat-row/mat-cell/span/button)[1]")
	WebElement mClear;
	@FindBy(xpath = "//app-card[9]")
	WebElement beaconAlert;
	@FindBy(xpath = "//app-card[9]//b")
	WebElement bAlertCount;
	@FindBy(xpath = "(//button[@class='clearbutton'])[1]")
	WebElement bClear;
	@FindBy(id = "reason-input")
	WebElement reasonBox;		
	@FindBy(css = "button[type='submit']")
	WebElement bSubmit;
	@FindBy(css="button[class='close']")
	WebElement bclose;
	@FindBy(css = "i[class*='logout']")
	WebElement logout;
	@FindBy(css = "#mat-button-toggle-3-button")
	WebElement mableHistory;
	@FindBy(css = "div[class='tableTitle']")
	public
	WebElement htitle;
	@FindBy(id = "mat-button-toggle-2-button")
	public
	WebElement alarmHistory;
	@FindBy(id = "mat-button-toggle-1-button")
	public
	WebElement charts;
	@FindBy(xpath = "(//div[@class='chart-title'])[1]")
	public
	WebElement charttitle;
	@FindBy(css = "div[role='alert']")
	public WebElement message;


	public String getPageName() {
		
		waitForWebElementToAppear(pageNameDB);
		return pageNameDB.getText();
		
	}

	public void mAlarmClear(String reason) {
if (mAlarmCount.getText().contains("0")) {			
			System.out.println("No Maintenance Alarm present");
		}else {
		maintenanceAlarm.click();
		MtextBox.sendKeys(reason);
		mClear.click();
		waitForWebElementToAppear(message);
		System.out.println(message.getText()+" Maintenance Alarm Cleared");}		

	}
	public void devicestatusClear(String reason) {
		if (dsAlertCount.getText().contains("0")) {			
			System.out.println("No Device Status Alert present");
		}else {
		devicestatusAlert.click();
		bClear.click();
		reasonBox.sendKeys(reason);
		bSubmit.click();
		waitForWebElementToAppear(message);
		System.out.println(message.getText()+" Device Status Alert Cleared");}		

	}

	public void bAlertClear(String reason) {
		if (bAlertCount.getText().contains("0")) {			
			System.out.println("No Beacon Alert present");
		}else {
		beaconAlert.click();
		bClear.click();
		reasonBox.sendKeys(reason);		
		bSubmit.click();
		bclose.click();
		waitForWebElementToAppear(message);
		System.out.println(message.getText()+" Beacon Alert Cleared");}

	}
	public void logoutApplication() throws InterruptedException {
		
		menubutton();			
		scrollLogout();
		logout.click();
		System.out.println("Logged Out");
		
	}
public String mabHis() throws InterruptedException {
	
		scrollWindow();
		mableHistory.click();
		System.out.println(htitle.getText());
		return htitle.getText();
		
		
	}
public String alarmHis() throws InterruptedException {				
	scrollWindow();
	alarmHistory.click();
	System.out.println(htitle.getText());
	return htitle.getText();
	
	
}
public String chartInfo() throws InterruptedException {				
	scrollWindow();
	charts.click();
	waitForWebElementToAppear(charttitle);
	System.out.println(charttitle.getText());
	return charttitle.getText();
	
	
}
}
