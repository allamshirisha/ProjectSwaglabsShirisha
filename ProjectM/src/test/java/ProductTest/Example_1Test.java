package ProductTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericlibrary.BaseConfig;

public class Example_1Test extends BaseConfig {

	@Test
	public void orderproduct() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement fifthprd = driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']"));

		fifthprd.click();

		WebElement addtocart1 = driver.findElement(By.xpath("//button[@id='add-to-cart']"));

		addtocart1.click();

		driver.navigate().back();

		WebElement fourthprd = driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']"));

		fourthprd.click();

		WebElement addtocart2 = driver.findElement(By.xpath("//button[@id='add-to-cart']"));

		addtocart2.click();

		driver.navigate().back();

		WebElement thirdprd = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));

		thirdprd.click();

		WebElement addtocart3 = driver.findElement(By.xpath("//button[@id='add-to-cart']"));

		addtocart3.click();

		WebElement shoppingcart = driver.findElement(By.xpath("//div[@id='shopping_cart_container']"));

		shoppingcart.click();

		WebElement checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
		checkout.click();

		// wait method

		WebElement element1 = driver.findElement(By.xpath("(//input[@type='text'])[1]"));

		WebElement element2 = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));

		WebElement element3 = driver.findElement(By.xpath("//input[@name='postalCode']"));

		// validate the checkout button
		if (element1.isDisplayed() && element1.isEnabled() && element2.isDisplayed() && element2.isEnabled()
				&& element3.isDisplayed() && element3.isEnabled()) {
			System.out.println("element is displayed");
			System.out.println("element is enabled");
		}

		else {
			System.out.println("element is not displayed");
			System.out.println("element is not enabled");

		}

		// perform login actions
		element1.sendKeys("allam");
		element2.sendKeys("siri");
		element3.sendKeys("500072");

		// click on continue button
		driver.findElement(By.xpath("//input[@id='continue']")).click();

		// click on finish button
		driver.findElement(By.xpath("//button[@name='finish']")).click();

		// verify the confirmation msg
		WebElement msg = driver.findElement(By.xpath("//h2[@class='complete-header']"));
		System.out.println(msg.getText());

	}
}
