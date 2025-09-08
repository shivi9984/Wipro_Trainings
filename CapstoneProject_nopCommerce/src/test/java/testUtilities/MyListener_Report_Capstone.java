package testUtilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.Tests_NopCommerce;
import utilities.Constants;


public class MyListener_Report_Capstone implements ITestListener {
	WebDriver driver;
	
	ExtentSparkReporter htmlReport;
	ExtentReports extent;
	ExtentTest test;
	
	
	@Override
    public void onStart(ITestContext context) {
		System.out.println("Testing starts...");
		
		// Create Extent Report
        String reportPath = Constants.USER_DIRECTORY + "/ExtentReport.html";
        htmlReport = new ExtentSparkReporter(reportPath);
        
        // Attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReport);
        
        // System info details
        extent.setSystemInfo("Tester", "Shivam");
        extent.setSystemInfo("Machine", "MSI");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Browser", "Chrome");
        
        // Configure look of the report
        htmlReport.config().setDocumentTitle("Demo Web Shop Report");
        htmlReport.config().setReportName("Project Test Report");
        htmlReport.config().setTheme(Theme.STANDARD);
        htmlReport.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        
		
	}
	@Override
    public void onTestStart(ITestResult result) {
        System.out.println("Name of Test Started: " + result.getName());
        test = extent.createTest(result.getName()); // Create a test node in report
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
        test.log(Status.PASS, "Test Passed: " + result.getName());
      
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        test.log(Status.FAIL, "Test Failed: " + result.getName());
        test.fail(result.getThrowable());
        
        // Get driver instance from the failing test class
        Object testClass = result.getInstance();
        driver = ((Tests_NopCommerce) testClass).driver;

        // Create Screenshots folder if not exists
        File destDir = new File("Screenshots");
        if (!destDir.exists()) {
            destDir.mkdir();
        }

        
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String fileName = result.getName() + "_" + timeStamp + ".png";

        // screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(destDir, fileName);

        try {
            Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved: " + destFile.getPath());
            
         // Attach screenshot to extent report
            test.addScreenCaptureFromPath(destFile.getAbsolutePath(), result.getName());
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
        test.log(Status.SKIP, "Test Skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("Test failed due to timeout: " + result.getName());
        test.log(Status.FAIL, "Test failed due to timeout: " + result.getName());
    }


    @Override
    public void onFinish(ITestContext context) {
    	System.out.println("All Test Cases Ended......");
    	extent.flush(); // add all logs into the report
    }
}
