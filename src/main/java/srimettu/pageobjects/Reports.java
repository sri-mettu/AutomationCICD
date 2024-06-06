package srimettu.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import srimettu.AbstractComponents.AbstractComponent;

public class Reports extends AbstractComponent {
	WebDriver driver;

	public Reports(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// PageFactory
	@FindBy(css = "a[href='#/reports']")
	public WebElement reports;
	@FindBy(xpath = "(//div[@class='mat-tab-label-content'])[1]")
	WebElement gennew;
	@FindBy(xpath = "(//div[@class='mat-tab-label-content'])[2]")
	WebElement isocp;
	@FindBy(xpath = "(//div[@class='mat-tab-label-content'])[3]")
	WebElement saved;
	@FindBy(xpath = "(//div[@class='mat-tab-label-content'])[4]")
	WebElement lastgen;
	@FindBy(xpath = "//input[@type='datetime']")
	WebElement stdt;
	@FindBy(css = "button[aria-label='Previous month']")
	WebElement prvmnth;
	@FindBy(xpath = "(//span[@class='owl-dt-calendar-cell-content'])[3]")
	WebElement date;
	@FindBy(xpath = "(//span[contains(@class, 'owl-dt-control-button-content ')])[2]")
	WebElement apply;
	@FindBy(css = "div[class*='cdk-overlay-container']")
	WebElement backdrop;
	@FindBy(xpath = "(//i[contains(@class, 'icon-calendar')])[1]")
	WebElement cal1;
	@FindBy(xpath = "(//span[@class='mat-radio-inner-circle'])[2]")
	WebElement radiomab;
	@FindBy(xpath = "//span/div[@class='ng-star-inserted']")
	WebElement rpttyp;
	@FindBy(xpath = "(//span[@class='dropdown-btn'])[2]")
	public WebElement selusr;	
	@FindBy(css = "button[type='submit']")
	public WebElement submit;
	@FindBy(css = "div[class*='modal-footer'] button[type='submit']")
	public WebElement delsubmit;
	@FindBy(xpath = "(//button[contains(@class, 'addButtonContent')])[3]")
	public WebElement saverep;
	@FindBy(css = "input[type='text']")
	public WebElement repnm;
	@FindBy(xpath = "(//i[contains (@class, 'icon-trash icon')])[1]")
	public WebElement delete;	
	@FindBy(css = "div[role='alert']")
	public WebElement message;	
	

	public void selReptypIndx(int rep) throws InterruptedException {		
		rpttyp.click();
		
		List<WebElement> reps = driver.findElements(By.xpath("(//div//ul[2])[1]/li"));
		
			if (rep >= 0 && rep < reps.size()) {
			WebElement report = reps.get(rep);			
			report.click();		
			System.out.println("Report Type: "+rpttyp.getText());
		}	
			else {
				System.out.println("Invalid index: " + rep);
			}
				}
	public void selectUserIndx(int usr) throws InterruptedException {		
		selusr.click();
		
		List<WebElement> users = driver.findElements(By.xpath("(//div//ul[2])[2]/li"));
		
			if (usr >= 0 && usr < users.size()) {
			WebElement user = users.get(usr);			
			user.click();	
			System.out.println("User: "+user.getText());
		}
			
			else {
				System.out.println("Invalid index: " + usr);
			}
			selusr.click();
				}	
	public void selectUsers(int[] usrs) throws InterruptedException {
		selusr.click();
		List<WebElement> users = driver.findElements(By.xpath("(//div//ul[2])[2]/li"));
		for (int usr : usrs) {
			if (usr >= 0 && usr < users.size()) {
				WebElement user = users.get(usr);
				user.click();
				System.out.println("User: "+user.getText());
			} else {
				System.out.println("Invalid index: " + usr);
			}
		}
		selusr.click();
		
		
	}
	public void selUserorDev(int urd) throws InterruptedException {		
		selusr.click();
		
		List<WebElement> uords = driver.findElements(By.xpath("(//div//ul[2])[2]/li"));
		
			if (urd >= 0 && urd < uords.size()) {
			WebElement uord = uords.get(urd);			
			uord.click();	
			System.out.println("Device/User Type: "+selusr.getText());
		}
			
			else {
				System.out.println("Invalid index: " + urd);
			}
			
				}	
private void closeCalendarWithJS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            // Check if the element exists before trying to modify it
            WebElement calendarWindow = driver.findElement(By.cssSelector("div[class*='cdk-overlay-pane owl-dt-popup']")); // Adjust the locator as necessary
            js.executeScript("arguments[0].style.display='none';", calendarWindow);
        } catch (NoSuchElementException e) {
            System.out.println("Calendar window element not found.");
        }
    }
	public void genRep(int typ,int urd, int[] usrs) throws InterruptedException {		
		//int[] usrs = {1,2};
		menubutton();		
		gennew.click();	
		radiomab.click();
		stdt.click();		
		prvmnth.click();
		date.click();	
		waitForWebElementToclick(apply);		
		apply.click();		
		closeCalendarWithJS();
		Thread.sleep(2000);
		backdrop.click();
		waitForWebElementTodisAppear(backdrop);			
		selReptypIndx(typ);
		if (rpttyp.getText().contains("Escort Event")) {
			selUserorDev(urd);}
		else if (rpttyp.getText().contains("Mable Device Status")) {
			selUserorDev(urd);}
		else {
			selectUsers(usrs);}
		
		submit.click();			
	}	
	public void saveRep(String nm) throws InterruptedException {
		
		//menubutton();
		lastgen.click();
		waitForWebElementToclick(saverep);
		saverep.click();
		Thread.sleep(2000);
		repnm.sendKeys(nm);
		submit.click();		
		waitForWebElementToAppear(message);
		System.out.println(message.getText()+" Report Saved");	
	}	
	public void delRep(String nm) throws InterruptedException {		
		
		//menubutton();
		saved.click();	
		waitForWebElementToAppear(repnm);
		repnm.sendKeys(nm);
		Thread.sleep(2000);		
		delete.click();	
		Thread.sleep(2000);
		delsubmit.click();		
		waitForWebElementToAppear(message);
		System.out.println(message.getText()+" Report Deleted");	
	}	
}
