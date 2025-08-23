package runner;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
    features = "src/test/resources/features/Customers.feature",            // Path to your .feature files
    glue = "stepDefinition",                                                     // Step definitions package
    plugin = {"pretty", "html:target/cucumber-reports.html"},                  // For creating report.
//    dryRun = true,                                                          // Only perform Mapping of code if dryRun is 'true'.
    monochrome = true                                                  // For output more readable

)

public class TestRunner extends AbstractTestNGCucumberTests {
}
