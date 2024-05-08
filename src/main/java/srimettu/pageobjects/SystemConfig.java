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

public class SystemConfig extends AbstractComponent {
	WebDriver driver;

	public SystemConfig(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// PageFactory
	@FindBy(css = "a[href='#/systemSetup']")
	public WebElement sysconfig;
	@FindBy(xpath = "(//span[contains(@class, 'mat-content')] )[2]")
	WebElement ipconfig;
	@FindBy(xpath = "(//tr/td[1])[2]")
	WebElement ekipaddr;
	@FindBy(xpath = "(//span[contains(@class, 'mat-content')] )[4]")
	public WebElement availHub;
	@FindBy(xpath = "(//tr[@class='ng-star-inserted']/td)[5]")
	public WebElement hubip;
	@FindBy(xpath = "(//span[contains(@class, 'mat-content')] )[5]")
	public WebElement intAlarm;
	@FindBy(css = "span[class*='checkbox-inner']")
	WebElement intAlmchkbox;
	@FindBy(css = "button[type='submit']")
	WebElement submit;
	@FindBy(css = "button[class*='btn-secondary']")
	WebElement cancel;

	public String getekIPaddr() {
		sysconfig.click();
		menubutton();
		ipconfig.click();
		ekipaddr.getText();
		System.out.println("EkoMs IP: " + ekipaddr.getText());
		return ekipaddr.getText();

	}

	public String gethubIPaddr() throws IOException, InterruptedException {

		sysconfig.click();
		menubutton();
		availHub.click();
		System.out.println("HubIP : " + hubip.getText());
		return hubip.getText();

	}

	public void intAlarm() throws InterruptedException {
		sysconfig.click();
		menubutton();
		intAlarm.click();
		if (intAlmchkbox.isSelected()) {
			cancel.click();
		} else {
			intAlmchkbox.click();
			submit.click();
			System.out.println("Integrated Alarm Enabled");
		}

	}

}
