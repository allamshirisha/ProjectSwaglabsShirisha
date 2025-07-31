package TestDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LearningAdvancedReport {

	public static void main(String[] args) {

		// create the spark report
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvancedReports/reports.html");

		// configure the sparkreport information
		spark.config().setDocumentTitle("Regression Testing For the swaglabs");
		spark.config().setReportName("RegressionSuite");
		spark.config().setTheme(Theme.STANDARD);
       //create the Extentreport
		ExtentReports report = new ExtentReports();

		// Attach the spark report and Extent report
		report.attachReporter(spark);

		// configure the system information in extent report
		report.setSystemInfo("DeviceName", "siri");
		report.setSystemInfo("OperatingSystem", "WINDOWS 11");
		report.setSystemInfo("Browser:", "Chrome");
		report.setSystemInfo("BrowserVersion", "chrome-138.0.7204.169");

		// create the test information

		ExtentTest test = report.createTest("RegressionTest");

		// steps information
		test.log(Status.INFO, "Step1:Launching The Browser Succesfully");

		test.log(Status.INFO, "Step2:Navigate to the application via url Succesfully");

		test.log(Status.INFO, "Step3:Verified the webpage Succesfully");

		if (true == true) {
			test.log(Status.PASS, "Step4:Verified the Webelement Displayed Succesfully");
		} else {
			test.log(Status.FAIL, "Step4:Verified the Webelement not Displayed Succesfully");

		}

		test.log(Status.SKIP, "Step5:Element is Hidden Succesfully");

		// Flush the Report information
		report.flush();

	}

}
