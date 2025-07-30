package PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartpage {
	
	@FindBy(id = "continue-shopping")
	private WebElement continueshoppingbutton;
	
	@FindBy(id = "checkout")
	private WebElement checkoutbutton;
	
	@FindBy(css = ".title")
	private WebElement cart;
	
	// intialisation
	public cartpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization
	public WebElement getcontinueshoppingbutton() {

		return continueshoppingbutton;

	}
	public WebElement getcheckoutbutton() {

		return checkoutbutton;
	}
	
public WebElement getcart() {
	return cart;
	
}
}
