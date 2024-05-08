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

public class DeviceManagement extends AbstractComponent {
	WebDriver driver;

	public DeviceManagement(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// PageFactory
	@FindBy(css = "a[href='#/deviceManagement']")
	public WebElement devicemanag;
	@FindBy(xpath = "(//div[@class='mat-tab-label-content'])[1]")
	WebElement devices;
	@FindBy(xpath = "(//div[@class='mat-tab-label-content'])[2]")
	WebElement mabledev;
	@FindBy(xpath = "(//div[@class='mat-tab-label-content'])[3]")
	WebElement alarmarea;
	@FindBy(xpath = "//div/input")
	WebElement search;
	@FindBy(css = "button[class*='addButtonContent']")
	WebElement loaddev;
	@FindBy(id = "ip-input")
	WebElement hubIPaddr;
	@FindBy(css = "button[type='submit']")
	WebElement submit;
	@FindBy(css = "button[class*='btn-secondary']")
	WebElement close;
	@FindBy(css = "button[class='close']")
	WebElement x;
	@FindBy(xpath = "//a[text()='x']")
	WebElement x1;
	@FindBy(css = "div[aria-label*='Finished Loading']")
	WebElement loadsuccess;
	@FindBy(css = "div[aria-label='Success']")
	WebElement success;
	@FindBy(css = "i[class='icon-pencil")
	WebElement edit;
	@FindBy(css = "i[class='icon-trash")
	WebElement delete;
	@FindBy(xpath = "//span/div")
	WebElement selarea;
	@FindBy(xpath = "(//span[@class='mat-radio-inner-circle'])[2]")
	WebElement seluserradio;
	@FindBy(css = "span[class='mat-radio-inner-circle']")
	WebElement selusrradio1;
	@FindBy(xpath = "(//input[@class='mat-radio-input'])[1]")
	WebElement selstaffradio;
	@FindBy(xpath = "(//div/span)[3]")
	WebElement selstaffdrop;
	@FindBy(xpath = "(//div/span)[2]")
	WebElement seluserdrop;
	@FindBy(xpath = "//div/span")
	WebElement seluserdrop1;
	@FindBy(xpath = "(//span[@class='dropdown-multiselect__caret'])[1]")
	WebElement multiCaretarea;
	@FindBy(xpath = "(//span[@class='dropdown-multiselect__caret'])[2]")
	WebElement multiCaretstaff;
	@FindBy(xpath = "(//span[@class='dropdown-multiselect__caret'])[2]")
	WebElement multiCaretuser;
	@FindBy(xpath = "(//button[contains(@class, 'addButtonContent')])[1]")
	WebElement mableadd;
	@FindBy(css = "mat-radio-button[value='Beacon']")
	WebElement beacadd;
	@FindBy(css = "mat-radio-button[value='Gateway']")
	WebElement gwadd;
	@FindBy(css = "input[formcontrolname='deviceName']")
	WebElement devname;
	@FindBy(css = "input[formcontrolname='macAddress']")
	WebElement devmac;
	@FindBy(css = "button[class*='btn-primary']")
	WebElement addsub;

	public void devLoad() throws IOException, InterruptedException {
		SystemConfig config = new SystemConfig(driver);
		String ip = config.gethubIPaddr();
		menubutton();
		devicemanag.click();
		menubutton();
		loaddev.click();
		hubIPaddr.sendKeys(ip);
		submit.click();
		waitForWebElementToAppear(loadsuccess);
		System.out.println(loadsuccess.getText());

	}

	public void editDev(int ar, int usr) throws InterruptedException {
		edit.click();
		selectAreaIndx(ar);
		seluserradio.click();
		selectUserIndx(usr);
		multiCaretuser.click();
		submit.click();

	}

	public void selectArea(String ar) {
		selarea.click();
		List<WebElement> areas = driver.findElements(By.xpath("//div/ul[2]/li"));
		for (WebElement area : areas) {
			if (area.getText().equalsIgnoreCase(ar)) {
				area.click();
				break;
			}
		}
	}

	public void selectAreaIndx(int ar) {
		selarea.click();
		List<WebElement> areas = driver.findElements(By.xpath("(//div/ul[2])[1]/li"));
		if (ar >= 0 && ar < areas.size()) {
			WebElement area = areas.get(ar);
			area.click();

		}
	}

	public void selectStaff(String stff) {
		selstaffdrop.click();
		List<WebElement> staffs = driver.findElements(By.xpath("//div/ul[2]/li"));
		for (WebElement staff : staffs) {
			if (staff.getText().equalsIgnoreCase(stff)) {
				staff.click();
				break;
			}
		}
	}

	public void selectStaffIndx(int stff) {
		selstaffdrop.click();
		List<WebElement> staffs = driver.findElements(By.xpath("(//div/ul[2])[3]/li"));
		if (stff >= 0 && stff < staffs.size()) {
			WebElement staff = staffs.get(stff);
			staff.click();

		}
	}

	public void selectUser(String usr) {
		seluserdrop.click();
		List<WebElement> users = driver.findElements(By.xpath("//div/ul[2]/li"));
		for (WebElement user : users) {
			if (user.getText().equalsIgnoreCase(usr)) {
				user.click();
				break;
			}
		}
	}

	public void selectUserIndx(int usr) {
		seluserdrop.click();
		List<WebElement> users = driver.findElements(By.xpath("(//div/ul[2])[2]/li"));
		if (usr >= 0 && usr < users.size()) {
			WebElement user = users.get(usr);
			user.click();

		}
	}

	public void selectUser1(String usr) {
		seluserdrop1.click();
		List<WebElement> users = driver.findElements(By.xpath("//div/ul[2]/li"));
		for (WebElement user : users) {
			if (user.getText().equalsIgnoreCase(usr)) {
				user.click();
				break;
			}
		}
	}

	public void selectUserindx1(int usr) {
		seluserdrop1.click();
		List<WebElement> users = driver.findElements(By.xpath("//div/ul[2]/li"));

		if (usr >= 0 && usr < users.size()) {
			WebElement user = users.get(usr);
			user.click();
		} else {
			System.out.println("Invalid index: " + usr);
		}

	}

	public void beaconAdd(String devicename, String macaddr) throws InterruptedException {
		mabledev.click();
		Thread.sleep(2000);
		mableadd.click();
		beacadd.click();
		devname.sendKeys(devicename);
		devmac.sendKeys(macaddr);
		addsub.click();
		System.out.println("Beacon Added");
	}

	public void delbeac(String macaddr) throws InterruptedException {
		mabledev.click();
		Thread.sleep(1000);
		search.sendKeys(macaddr);
		search.sendKeys(Keys.ENTER);
		delete.click();
		Thread.sleep(2000);
		submit.click();
		Thread.sleep(2000);
		System.out.println("Beacon Deleted");
	}

	public void assgnUser(String macaddr, int usr) throws InterruptedException {

		mabledev.click();
		Thread.sleep(1000);
		search.sendKeys(macaddr);
		search.sendKeys(Keys.ENTER);
		edit.click();
		selusrradio1.click();
		Thread.sleep(2000);
		selectUserindx1(usr);
		seluserdrop1.click();
		submit.click();
		System.out.println("User Assigned");
	}

	public void unAssgnuser(String macaddr) throws InterruptedException {
		mabledev.click();
		Thread.sleep(1000);
		search.sendKeys(macaddr);
		search.sendKeys(Keys.ENTER);
		edit.click();
		x1.click();
		submit.click();
		System.out.println("User unAssigned");
	}
}
