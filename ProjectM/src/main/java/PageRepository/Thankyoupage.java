package PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Thankyoupage {
	
	@FindBy(id = "back-to-products")
	private WebElement backhomebutton;
	
	@FindBy(css =".title")
	private WebElement thankyou;
	
	//intialisation
	
	public Thankyoupage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	


	//utilization
	public WebElement getbackhomebutton() {
		return backhomebutton;
	}

	public WebElement getthankyou() {
		return thankyou;
	}
}
