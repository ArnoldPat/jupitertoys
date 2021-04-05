package testNGpack;


//Import Packages, Libraries & Dependencies
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Case1 {
	
	@BeforeTest
	// Instantiate the browser type for the test, prime the Contact Form page for testing etc.
	WebDriver driver = new ChromeDriver();
	driver.get("https://jupiter.cloud.planittesting.com/#/");
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Contact")));
	WebElement contact = driver.findElement(By.linkText("Contact"));
	contact.click();

  public void f() {
	  
	  	
	  @Test
	  @AfterTest
	  
  }
}
