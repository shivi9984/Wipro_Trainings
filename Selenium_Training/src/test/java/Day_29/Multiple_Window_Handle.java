package Day_29;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Multiple_Window_Handle {
	
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test
	public void handleWindow() {
		String parentWindow = driver.getWindowHandle();
		
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		Set<String> windows = driver.getWindowHandles();
		for(String w : windows) {
			if(!w.equals(parentWindow)) {
				driver.switchTo().window(w);
//				Thread.sleep(2000);
//				driver.close();
				
			}
		}
		
		System.out.println("Child Window Title: " + driver.getTitle());

		driver.switchTo().window(parentWindow);
	}

}
