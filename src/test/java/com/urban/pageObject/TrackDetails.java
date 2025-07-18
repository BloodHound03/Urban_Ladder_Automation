package com.urban.pageObject;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
 
public class TrackDetails extends BasePage {
	
	public TrackDetails(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = ("//input[@placeholder = 'Order Number']"))
	WebElement orderId;
	
	@FindBy(xpath = ("//input[@placeholder = 'Phone Number']"))
	WebElement phoneNo;
	
	@FindBy(xpath = ("//span[normalize-space()='Submit']"))
	WebElement submitBtn;
	
	@FindBy(xpath = ("//div[@id='app-container']//main//p[1]"))
	WebElement msg;
	
	public void orderInput(String orderID) {
		orderId.sendKeys(orderID);
	}
	
	public void phoneNoInput(String phoneNO) {
		phoneNo.sendKeys(phoneNO);
	}
	
	public void Click() {
		submitBtn.click();
	}
	
	public String message() {
		wait.until(ExpectedConditions.visibilityOf(orderId));
		return msg.getText();
	}
	
}



//p[@class='_33bg3']