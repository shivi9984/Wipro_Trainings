package utilities;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static final Logger log = LogManager.getLogger(ExtentManager.class.getName());
	private static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		if(extent == null) {
			createInstance();
		}
		return extent;
	}
	
	public static synchronized ExtentReports createInstance() {
		String fileName = Util.getReportName();
		String reportDirectory = Constants.REPORTS_DIRECTORY;
		new File(reportDirectory).mkdir();
		String path = reportDirectory + fileName;
		log.info("************Report Path************");
		log.info(path);
		log.info("************Report Path************");
		
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(path);
		// Configure look of the report
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("Automation Run");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(fileName);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		
		extent = new ExtentReports();
		// System info details
		extent.setSystemInfo("Organization", "Let's KodeIt");
		extent.setSystemInfo("Automation Framework", "Selenium WebDriver");
		extent.setSystemInfo("Tester", "Shivam");
        extent.setSystemInfo("Machine", "MSI");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Browser", "Chrome");
        // Don't forget to attach report
        extent.attachReporter(htmlReporter);
        
        return extent;
		
	}
}
