package PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkoutpage {
	
	//identification and declaration
	@FindBy(id = "first-name")
	private WebElement firstname;

	@FindBy(id = "last-name")
	private WebElement lastname;

	@FindBy(id = "postal-code")
	private WebElement postalcode ;
	
	@FindBy(id = "continue")
	private WebElement continuebutton ;
	
	@FindBy(css = ".title")
	private WebElement CheckoutYourInformation;
	
	//intialization
	public Checkoutpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//utilisation
	
	public WebElement getfirstname() {
		return firstname;
	}

	public WebElement getlastname() {
		return lastname;
	}

	public WebElement getpostalcode() {
		return postalcode;
	}

	public WebElement getcontinuebutton() {
		return continuebutton;
	}
public WebElement getCheckoutYourInformation() {
return CheckoutYourInformation;
}
}