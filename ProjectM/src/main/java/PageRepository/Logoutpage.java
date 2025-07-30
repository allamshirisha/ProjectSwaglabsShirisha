package PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logoutpage {

	// identification and declaration
	@FindBy(id = "react-burger-menu-btn")
	private WebElement hamburger;

	@FindBy(id = "logout_sidebar_link")
	private WebElement logoutbutton;

	// intialization
	public Logoutpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization

	public WebElement gethamburger() {
		return hamburger;

	}

	public WebElement getlogoutbutton() {
		return logoutbutton;

	}

}
