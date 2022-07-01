package validate_checkbox;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllCheckBox {
	WebDriver driver;

	@Before
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		// driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.get("http://techfios.com/test/103/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	// Test 1: Validate when the toggle all check box is CHECKED, all check boxes
	// for list items are also CHECKED ON.
	@Test
	public void loginTest() throws InterruptedException {
		
		WebElement CHECKBOX_Element = driver.findElement(By.name("allbox"));
		CHECKBOX_Element.click();

		Thread.sleep(4000);

		// Validation:--isDisplayed : T/F the element is displayed
		Boolean bool1 = CHECKBOX_Element.isDisplayed();
		
		if (bool1 == true) {
			CHECKBOX_Element.click();
		}
		System.out.println(bool1);
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}