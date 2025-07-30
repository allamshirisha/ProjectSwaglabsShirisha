package PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//webelement identification and declaration
		@FindBy(id="user-name")
		private WebElement usernametextfield;
		
		
		@FindBy(id="password")
		private WebElement passwordtextfield;
		
		@FindBy(id="login-button")
		private WebElement loginbutton;
		
		@FindBy(css =".login_logo")
		private WebElement loginlogo;

		
		
		//webelement intialization
		public LoginPage(WebDriver driver) {
			
			PageFactory.initElements(driver,this);
		}
		
		//WebElement utilization
		public WebElement getusernametextfield() {
			return usernametextfield;
		}
		public WebElement getpasswordtextfield() {
			return passwordtextfield;
		}
		public WebElement getloginbutton() {
			return loginbutton;
		}
		public WebElement getloginlogo() {
			return loginlogo;
		}
		
	}


