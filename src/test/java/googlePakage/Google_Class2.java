package googlePakage;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class Google_Class2 {
	
	WebDriver driver = null;
	String BaseURL = "https://www.google.com/";

	@BeforeMethod
	public void beforeMethod() {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\GoogleTest\\Resouces\\chromedriver.exe");
		   driver = new ChromeDriver();
			driver.get(BaseURL);

	}
	
	@Test
	public void f() throws InterruptedException {
		driver.get(BaseURL);
		String title = driver.getTitle();
		System.out.println("Your title is :" + title);

		String URL = driver.getCurrentUrl();
		if (URL.equals(BaseURL)) {
			System.out.println("CORRECT URL is Opening ");
		} else {
			System.out.println("False");
		}

		int PS = driver.getPageSource().length();
		System.out.println("Page source " + PS);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

		Random random = new Random();
		String[] originsArray = { "ABCD", "test", "selenium", "testng" };
		WebElement origin = driver.findElement(By.name("q"));
		origin.sendKeys(originsArray[random.nextInt(originsArray.length)]);
		System.out.println("Your searched value is :" + origin.getAttribute("value"));

		origin.sendKeys(Keys.ENTER);

		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
