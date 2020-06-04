package googlePakage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\GoogleTest\\Resouces\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.navigate().to("http://www.inviul.com");
	  String actualTitle = driver.getTitle();
	  driver.manage().window().maximize();
	  String expectedTitle = "Free Selenium Tutorials | TestNG Tutorials | Cucumber Tutorials | Inviul";
	  if(actualTitle.equalsIgnoreCase(expectedTitle))
	  System.out.println("Title Matched");
	  else
	  System.out.println("Title didn't match");
	  
	  WebElement logo=driver.findElement(By.xpath("//*[@id=\"logo\"]/a/img"));
	  if(logo.isDisplayed())
	  {
		  System.out.println("showing logo");
	  }else {
		  System.out.println("not");
	  }
	  
	 driver.close();
	  }
	  
  }

