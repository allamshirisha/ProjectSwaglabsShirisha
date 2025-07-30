package PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productpage {
	
	// webelement identification and declaration
	

	
		
		@FindBy(id = "shopping_cart_container")
		
		private WebElement carticon;
		
		
		

		// webelement intialization
		public Productpage(WebDriver driver) {

			PageFactory.initElements(driver, this);
		}

		// WebElement utilization

		public WebElement getcarticon() {
			return carticon;
		}

}
