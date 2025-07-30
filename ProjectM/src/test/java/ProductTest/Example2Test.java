package ProductTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageRepository.Checkoutpage;
import PageRepository.HomePage;
import PageRepository.LoginPage;
import PageRepository.Logoutpage;
import PageRepository.Paymentpage;
import PageRepository.Productpage;
import PageRepository.Thankyoupage;
import PageRepository.cartpage;
import genericlibrary.BaseConfig;
@Listeners(listenerlibrary.ListenersImplementation.class)
public class Example2Test extends BaseConfig {

	
	@Test(groups = "RT", priority = 1, enabled = true, invocationCount = 1,dataProvider="checkOutInfo")
	public void Addproduct(String firstname,String lastname,String postalcode) throws InterruptedException {

		// wait method
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// addproducts
		HomePage hmobj = new HomePage(driver);

		// click on 5th product
		hmobj.getfifthproduct().click();

		Assert.assertTrue(hmobj.getfifthproduct().isDisplayed());
		Assert.assertTrue(hmobj.getfifthproduct().isEnabled());

		Assert.assertTrue(hmobj.getaddtocartbutton1().isDisplayed());
		Assert.assertTrue(hmobj.getaddtocartbutton1().isEnabled());

		// click on add to cart button
		hmobj.getaddtocartbutton1().click();

		Assert.assertTrue(hmobj.getbacktoproducts1().isDisplayed());
		Assert.assertTrue(hmobj.getbacktoproducts1().isEnabled());

		// click on back to products button

		hmobj.getbacktoproducts1().click();

		// click on 4th product

		hmobj.getfourthproduct().click();

		Assert.assertTrue(hmobj.getfourthproduct().isDisplayed());
		Assert.assertTrue(hmobj.getfourthproduct().isEnabled());

		Assert.assertTrue(hmobj.getaddtocartbutton2().isDisplayed());
		Assert.assertTrue(hmobj.getaddtocartbutton2().isEnabled());

		// click on add to cart button

		hmobj.getaddtocartbutton2().click();

		Assert.assertTrue(hmobj.getbacktoproducts2().isDisplayed());
		Assert.assertTrue(hmobj.getbacktoproducts2().isEnabled());

		// click on back to products button

		hmobj.getbacktoproducts2().click();
		// click on 3rd product

		hmobj.getthirdproduct().click();

		Assert.assertTrue(hmobj.getthirdproduct().isDisplayed());
		Assert.assertTrue(hmobj.getthirdproduct().isEnabled());

		Assert.assertTrue(hmobj.getaddtocartbutton3().isDisplayed());
		Assert.assertTrue(hmobj.getaddtocartbutton3().isEnabled());

		// click on add to cart button

		hmobj.getaddtocartbutton3().click();

		Assert.assertTrue(hmobj.getbacktoproducts2().isDisplayed());
		Assert.assertTrue(hmobj.getbacktoproducts2().isEnabled());

		hmobj.getbacktoproducts2().click();

		String product = hmobj.getproducts().getText();
		System.out.println(product);

		Assert.assertEquals(driver.getTitle(), "Swag Labs");

		Thread.sleep(5000);

		// create productpage object
		Productpage ppobj = new Productpage(driver);

		Assert.assertTrue(ppobj.getcarticon().isDisplayed());
		Assert.assertTrue(ppobj.getcarticon().isEnabled());

		ppobj.getcarticon().click();

		// create cartpage object
		cartpage cpobj = new cartpage(driver);

		Assert.assertTrue(cpobj.getcheckoutbutton().isDisplayed());
		Assert.assertTrue(cpobj.getcheckoutbutton().isEnabled());

		cpobj.getcheckoutbutton().click();

		String cart = cpobj.getcart().getText();
		System.out.println(cart);

		Assert.assertEquals(driver.getTitle(), "Swag Labs");

		// create checkoutpage object
		Checkoutpage ckobj = new Checkoutpage(driver);

		ckobj.getfirstname().sendKeys(firstname); 

		ckobj.getlastname().sendKeys(lastname);

		ckobj.getpostalcode().sendKeys(postalcode);
		
		
		ckobj.getcontinuebutton().click();
		
		Reporter.log(firstname);
		Reporter.log(lastname);
		Reporter.log(postalcode);


		String CheckoutYourInformation = ckobj.getCheckoutYourInformation().getText();
		System.out.println(CheckoutYourInformation);

		// Assert.assertEquals(driver.getTitle(), "Checkout: Your Information");

		saobj.assertEquals(driver.getTitle(), "Swag Labs");
		saobj.assertAll();

		// create paymentpage object
		Paymentpage pyobj = new Paymentpage(driver);
		String payment = cpobj.getcart().getText();
		System.out.println(payment);

		Assert.assertEquals(driver.getTitle(), "Swag Labs");

		pyobj.getfinishbutton().click();

		// create thankyou object
		Thankyoupage tkobj = new Thankyoupage(driver);

		String thankyou = cpobj.getcart().getText();
		//System.out.println(thankyou);

		saobj.assertEquals(driver.getTitle(), "Swag Labs");
		saobj.assertAll();

		tkobj.getbackhomebutton().click();
		
		//Assert.fail();
		Reporter.log(thankyou,true);
	}

}
