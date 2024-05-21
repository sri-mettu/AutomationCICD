package srimettu.pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import srimettu.AbstractComponents.AbstractComponent;

public class SystemBackup extends AbstractComponent {
	WebDriver driver;

	public SystemBackup(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// PageFactory
	@FindBy(css = "a[href='#/systemBackups']")
	public WebElement sysbacup;
	@FindBy(xpath = "(//div[@class='mat-tab-label-content'])[2]")
	WebElement fulldb;
	@FindBy(xpath = "(//div[@class='mat-tab-label-content'])[1]")
	WebElement partdb;
	@FindBy(xpath = "(//div/button[@type='button'])[1]")
	public WebElement downloaddb;	
	@FindBy(css = "input[type='file']")
	public WebElement uploaddb;
	@FindBy(css = "button[class*='ng-star-inserted']")
	public WebElement importdb;
	@FindBy(xpath = "(//div/button[@type='button'])[2]")
	public WebElement cleardata;
	@FindBy(xpath = "(//button[@role='menuitem'])[1]")
	WebElement clearuser;
	@FindBy(xpath = "(//button[@role='menuitem'])[2]")
	WebElement clearstff;
	@FindBy(xpath = "(//button[@role='menuitem'])[3]")
	WebElement clearmap;
	@FindBy(xpath = "(//button[@role='menuitem'])[4]")
	WebElement cleardb;
	@FindBy(css = "div[role='alert']")
	public WebElement message;

	public void downloadDB() throws InterruptedException {
		sysbacup.click();
		menubutton();		
		fulldb.click();
		Thread.sleep(2000);		
		downloaddb.click();
		waitForWebElementToAppear(message);
		System.out.println(message.getText());
		
		waitForWebElementTodisAppear(message);		
		
	}
	public void uploadDB() throws InterruptedException  {
		sysbacup.click();
		menubutton();
		fulldb.click();		
		Thread.sleep(2000);
		uploaddb.sendKeys("C:\\Users\\smettu\\Downloads\\BackupDb.zip");
		importdb.click();
		waitForWebElementToAppear(message);
		System.out.println(message.getText()+" BackupDb.zip uploaded");
		waitForWebElementTodisAppear(message);		
		
		}	

}
