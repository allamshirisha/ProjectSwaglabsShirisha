package genericlibrary;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import PageRepository.LoginPage;
import PageRepository.Logoutpage;

public class BaseConfig {

	public WebDriver driver;
	public static WebDriver staticdriver;
	public SoftAssert saobj;
	public String url;
	public String username;
	public String password;
	public String firstname;
	public String lastname;
	public String postalcode;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;

	
	@BeforeTest
	public void ReportSetup() {
		// create the spark report
		spark = new ExtentSparkReporter("./AdvancedReports/reports.html");

		// configure the sparkreport information
		spark.config().setDocumentTitle("Regression Testing For the swaglabs");
		spark.config().setReportName("RegressionSuite");
		spark.config().setTheme(Theme.STANDARD);
		// create the Extentreport
		report = new ExtentReports();

		// Attach the spark report and Extent report
		report.attachReporter(spark);

		// configure the system information in extent report
		report.setSystemInfo("DeviceName", "siri");
		report.setSystemInfo("OperatingSystem", "WINDOWS 11");
		report.setSystemInfo("Browser:", "Chrome");
		report.setSystemInfo("BrowserVersion", "chrome-138.0.7204.169");
	}

	@AfterTest
	public void ReportTerminate() {
		// Flush the Report information
		report.flush();

	}
	 @Parameters("Browser")
	@BeforeClass
	public void Browsersetup(String browsername) {
		saobj = new SoftAssert();
		//String browsername = "edge";
		// url = PropertiesLibrary.readData("url");

		// open the browser
		driver = WebDriverLibrary.openBrowser(browsername);
		staticdriver = driver;
		Reporter.log("browser opened sucessfully", true);

		// maximize
		WebDriverLibrary.maximizeBrowser();
		// driver.manage().window().maximize();
		Reporter.log("browser maximised sucessfully", true);

		// wait
		WebDriverLibrary.Waitstatement();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// navigate to the application via url
		WebDriverLibrary.navToApp(PropertiesLibrary.readData("url"));
		// driver.get(url);
		Reporter.log("url entered sucessfully", true);

		// verify the page using title
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		Reporter.log("page verified sucessfully", true);

		Reporter.log("browser set up done", true);
	}

	@BeforeMethod
	public void login() throws InterruptedException {
		// wait
		WebDriverLibrary.Waitstatement();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// username = PropertiesLibrary.readData("username");
		// password = PropertiesLibrary.readData("password");
		// firstname = ExcelLibrary.readsingledata("Batch_M14_Details", 1, 0);
		// lastname = ExcelLibrary.readsingledata("Batch_M14_Details", 1, 1);

		// postalcode = ExcelLibrary.readsingledata("Batch_M14_Details", 1, 2);

		// create an object for pom class
		LoginPage lpobj = new LoginPage(driver);

		// validate the usernametextfields
		Assert.assertTrue(lpobj.getusernametextfield().isDisplayed());
		Assert.assertTrue(lpobj.getusernametextfield().isEnabled());
		Reporter.log("validated username  sucessfully", true);

		// validate the passwordtextfields
		Assert.assertTrue(lpobj.getpasswordtextfield().isDisplayed());
		Assert.assertTrue(lpobj.getpasswordtextfield().isEnabled());
		Reporter.log("validated password sucessfully", true);

		String logo = lpobj.getloginlogo().getText();

		System.out.println(logo);

		// use the WebElement from pom class
		// perform login
		// enter the username in usernametextfield
		WebDriverLibrary.enterTheData(lpobj.getusernametextfield(), PropertiesLibrary.readData("username"));
		// lpobj.getusernametextfield().sendKeys(username);
		Reporter.log("username entered sucessfully", true);
		// enter the password in passwordtextfield
		WebDriverLibrary.enterTheData(lpobj.getpasswordtextfield(), PropertiesLibrary.readData("password"));
		Reporter.log("password entered sucessfully", true);

		// lpobj.getpasswordtextfield().sendKeys(password);

		// enter the login button
		WebDriverLibrary.elementClick(lpobj.getloginbutton());

		// lpobj.getloginbutton().click();
		Reporter.log("login done sucessfully", true);

		Thread.sleep(4000);

	}

	@AfterMethod
	public void logout() {

		// wait
		WebDriverLibrary.Waitstatement();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// create logout object

		Logoutpage lgobj = new Logoutpage(driver);

		// validate the menubar
		Assert.assertTrue(lgobj.gethamburger().isDisplayed());
		Assert.assertTrue(lgobj.gethamburger().isEnabled());
		Reporter.log("validated menubar sucessfully", true);

		// validate the logoutbutton
		Assert.assertTrue(lgobj.getlogoutbutton().isEnabled());
		saobj.assertEquals(lgobj.getlogoutbutton().isDisplayed(), true);

		Reporter.log("validated logout sucessfully", true);

		// click on menubar
		WebDriverLibrary.elementClick(lgobj.gethamburger());
		Reporter.log("menubar clicked sucessfully", true);

		// lgobj.gethamburger().click();

		// click on logoutbutton
		WebDriverLibrary.elementClick(lgobj.getlogoutbutton());

		Reporter.log("logoutbutton clicked sucessfully", true);

		// lgobj.getlogoutbutton().click();

		Reporter.log("logout", true);
	}

	@AfterClass
	public void BrowserTerminate() {
		// close the browser
		WebDriverLibrary.closeAllWindows();
		// driver.quit();
		Reporter.log("allwindows closed sucessfully", true);

		Reporter.log("browser terminate done", true);

	}

	@DataProvider

	public Object[][] checkOutInfo() {
		Object[][] data = new Object[1][3];

		data[0][0] = ExcelLibrary.readsingledata("Batch_M14_Details", 1, 0);

		data[0][1] = ExcelLibrary.readsingledata("Batch_M14_Details", 1, 1);
		;

		data[0][2] = ExcelLibrary.readsingledata("Batch_M14_Details", 1, 2);

		return data;

	}
}
