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

public class SingleListItemRemove {
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

//Test 2:Test 2: Validate that a single list item could be removed using the remove button 
//when a single checkbox is selected.
	@Test
	public void validateSingleListItemRemovedUsingRemoveButton() {

		// WebElement SingleList = driver.findElement(By.name("todo[0]"));// doesn't
		// work this path

		WebElement SingleList = driver.findElement(By.xpath("//*[@id=\"todos-content\"]/form/ul/li[1]/input"));
		SingleList.click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SingleList));
		
		// Assertion: 

		By NSS_TODO_HEADER_FIELD = By.xpath("//*[@id=\"label-first\"]/b");
		Assert.assertTrue("Wrong page", driver.findElement(NSS_TODO_HEADER_FIELD).isDisplayed());
		System.out.println("The result is " + driver.findElement(NSS_TODO_HEADER_FIELD).isDisplayed());
		driver.findElement(By.name("submit")).click();

	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
