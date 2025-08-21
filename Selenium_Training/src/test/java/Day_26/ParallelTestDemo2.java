package Day_26;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ParallelTestDemo2 {
	WebDriver driver;
	
	@Test
	public void test1() {
		System.out.println("Test 1 done.");
	}
	@Test
	public void test2() {
		System.out.println("Test 2 done.");
	}
}
