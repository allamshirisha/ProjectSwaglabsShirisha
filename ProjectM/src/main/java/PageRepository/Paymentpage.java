package PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Paymentpage {
	
	//identification and declaration
		@FindBy(id = "finish")
		private WebElement finishbutton;
		
		@FindBy(css = ".title")
		private WebElement payment;
		
		//intializtion
		public Paymentpage(WebDriver driver) {
			PageFactory.initElements(driver,this);
			
		}

		//utilisation
		public WebElement getfinishbutton() {
			return finishbutton;
		}
		public WebElement getpayment() {
			return payment;
		}
}
