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
	@FindBy(css = "button[class='close'] span")
	WebElement x;
	@FindBy(xpath = "//a[text()='x']")
	WebElement x1;
	@FindBy(css = "div[aria-label*='Finished Loading']")
	public WebElement loadsuccess;
	@FindBy(css = "div[role='alert']")
	public WebElement message;
	@FindBy(css = "div[aria-label='Success']")
	WebElement success;
	@FindBy(css = "i[class='icon-pencil")
	WebElement edit;
	@FindBy(css = "i[class='icon-trash")
	WebElement delete;
	@FindBy(xpath = "//span/div")
	WebElement selarea;
	@FindBy(xpath = "(//span/div)[1]")
	WebElement selareagw;
	@FindBy(xpath = "(//span/div)[2]")
	WebElement selhubgw;
	@FindBy(xpath = "(//span/div)[3]")
	WebElement selpggw;
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
	@FindBy(css = "button[class='btn btn-primary']")
	WebElement delsub;
	@FindBy(css = "input[id='locationedit']")
	WebElement areaname;
	@FindBy(css = "span[class*='checkbox-inner']")
	WebElement forbiddenChk;
	@FindBy(xpath = "(//div/span)[1]")
	WebElement assndev;
	@FindBy(xpath = "(//span[contains(@class, 'multiselect__caret')])[1]")
	WebElement caret1;
	@FindBy(xpath = "(//div/span)[2]")
	WebElement assngw;
	@FindBy(xpath = "(//span[contains(@class, 'multiselect__caret')])[2]")
	WebElement caret2;
	@FindBy(css = "input[id='RSSI_tolerance-input']")
	WebElement rssi;
	@FindBy(css = "modal-container[class*='fade']")
	WebElement fade;

	public void devLoad() throws IOException, InterruptedException {
		SystemConfig config = new SystemConfig(driver);
		String ip = config.gethubIPaddr();
		menubutton();
		devicemanag.click();
		menubutton();
		loaddev.click();
		hubIPaddr.sendKeys(ip);
		submit.click();
		waitForWebElementToAppear(message);
		System.out.println(message.getText());
		waitForWebElementTodisAppear(message);
		waitForWebElementToAppear(message);
		System.out.println(message.getText());

	}

	public void editDev(int ar, int usr) throws InterruptedException {
		edit.click();
		selectAreaIndx(ar);
		seluserradio.click();
		selectUserIndx(usr);
		multiCaretuser.click();
		submit.click();
		waitForWebElementToAppear(message);
		System.out.println(message.getText()+" Device Edited");

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

	public void selectAreagw(int ar) {
		selareagw.click();
		List<WebElement> areas = driver.findElements(By.xpath("(//div/ul[2])[1]/li"));
		if (ar >= 0 && ar < areas.size()) {
			WebElement area = areas.get(ar);
			area.click();

		}
	}

	public void selectHubgw(int hub) {
		selhubgw.click();
		List<WebElement> hubs = driver.findElements(By.xpath("(//div/ul[2])[2]/li"));
		if (hub >= 0 && hub < hubs.size()) {
			WebElement h = hubs.get(hub);
			h.click();

		}
	}

	public void selectPggw(int pg) {
		selpggw.click();
		List<WebElement> grps = driver.findElements(By.xpath("(//div/ul[2])[3]/li"));
		if (pg >= 0 && pg < grps.size()) {
			WebElement grp = grps.get(pg);
			grp.click();

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

	public void assgnDevice(int[] devs) {
		assndev.click();
		List<WebElement> devices = driver.findElements(By.xpath("(//div/ul[2])[1]/li"));
		for (int dev : devs) {

			if (dev >= 0 && dev < devices.size()) {
				WebElement device = devices.get(dev);
				device.click();
			} else {
				System.out.println("Invalid index: " + dev);
			}
		}
		caret1.click();

	}

	public void assgnGateway(int[] gws) {
		assngw.click();
		List<WebElement> gateways = driver.findElements(By.xpath("(//div/ul[2])[2]/li"));
		for (int gw : gws) {

			if (gw >= 0 && gw < gateways.size()) {
				WebElement gateway = gateways.get(gw);
				gateway.click();
			} else {
				System.out.println("Invalid index: " + gw);
			}
		}
		caret2.click();

	}

	public void beaconAdd(String devicename, String macaddr) throws InterruptedException {
		mabledev.click();
		Thread.sleep(2000);
		mableadd.click();
		beacadd.click();
		devname.sendKeys(devicename);
		devmac.sendKeys(macaddr);
		addsub.click();
		waitForWebElementToAppear(message);
		System.out.println(message.getText()+" Beacon");
	}

	public void gwAdd(String devicename, String macaddr) throws InterruptedException {
		mabledev.click();
		Thread.sleep(2000);
		mableadd.click();
		gwadd.click();
		devname.sendKeys(devicename);
		devmac.sendKeys(macaddr);
		addsub.click();
		waitForWebElementToAppear(message);
		System.out.println(message.getText()+ " Gateway");
	}

	public void gwEdit(String macaddr, String rssiv, int ar, int h, int pg) throws InterruptedException {
		mabledev.click();
		Thread.sleep(2000);
		search.sendKeys(macaddr);
		search.sendKeys(Keys.ENTER);
		edit.click();
		rssi.clear();
		rssi.sendKeys(rssiv);
		selectAreagw(ar);
		selectHubgw(h);
		selectPggw(pg);
		submit.click();
		waitForWebElementToAppear(message);
		System.out.println(message.getText() + " Gateway Edited");
	}

	public void gwDelete(String macaddr) throws InterruptedException {
		mabledev.click();
		Thread.sleep(2000);
		search.sendKeys(macaddr);
		search.sendKeys(Keys.ENTER);
		delete.click();
		submit.click();
		waitForWebElementToAppear(message);
		System.out.println(message.getText() + " Gateway Deleted");
		fade.click();

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
		waitForWebElementToAppear(message);
		System.out.println(message.getText() + " Beacon Deleted");
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
		waitForWebElementToAppear(message);
		System.out.println(message.getText() + " User Assigned");
		
	}

	public void unAssgnuser(String macaddr) throws InterruptedException {
		mabledev.click();
		Thread.sleep(1000);
		search.sendKeys(macaddr);
		search.sendKeys(Keys.ENTER);
		edit.click();
		x1.click();
		submit.click();
		waitForWebElementToAppear(message);
		System.out.println(message.getText() + " User unAssigned");
	}

	public void addAlarmArea(String arname, int[] devs, int[] gws) throws InterruptedException {
		
		alarmarea.click();
		Thread.sleep(1000);
		addsub.click();
		areaname.sendKeys(arname);
		forbiddenChk.click();
		assgnDevice(devs);
		assgnGateway(gws);
		submit.click();
		waitForWebElementToAppear(message);
		System.out.println(message.getText() + " Alarm Area Created");

	}

	public void delAlarmArea(String arname) throws InterruptedException {
		alarmarea.click();
		Thread.sleep(1000);
		search.sendKeys(arname);
		search.sendKeys(Keys.ENTER);
		delete.click();
		delsub.click();
		waitForWebElementToclick(x);
		x.click();
		waitForWebElementToAppear(message);
		System.out.println(message.getText() + " Alarm Area Deleted");
	}
}
