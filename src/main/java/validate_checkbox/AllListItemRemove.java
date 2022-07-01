package validate_checkbox;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import junit.framework.Assert;

public class AllListItemRemove {
	WebDriver driver;

	@Before
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("http://techfios.com/test/103/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

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

	@Test
	public void RemoveAllListItem() throws InterruptedException {
		System.out.println("Removed checked from check list items");
		WebElement RemoveAllList = driver.findElement(By.xpath("/html/body/div[3]/input[1]"));

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(RemoveAllList));

		RemoveAllList.click();
		Thread.sleep(4000);

		By NSS_TODO_HEADER_FIELD = By.xpath("//*[@id=\"label-first\"]/b");
		Assert.assertEquals("Wrong page", "NSS-TODO List v 1.1", driver.findElement(NSS_TODO_HEADER_FIELD).getText());
		System.out.println("The result is " + driver.findElement(NSS_TODO_HEADER_FIELD).getText());
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
