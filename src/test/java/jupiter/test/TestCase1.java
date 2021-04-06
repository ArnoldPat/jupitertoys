package jupiter.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.*;
import static org.testng.Assert.assertTrue;

public class TestCase1 {
	
	WebDriver driver = new ChromeDriver();
	
	public void submitContact() {
	
		// Prime the web browser and Contact Form page for testing.
		driver.get("https://jupiter.cloud.planittesting.com/#/");
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Contact")));
		WebElement contact = driver.findElement(By.linkText("Contact"));
		contact.click();
		
		// TestCase1a: Click on submit button with empty mandatory fields
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Submit']")));
		WebElement submit = driver.findElement(By.xpath("//*[.='Submit']"));
		submit.click();
		
		
		// Check if inline help is displayed. Validate that submit form test has failed.	
		validateEmpty();
		
		
		// TestCase1b: Populate Mandatory fields and validate
		WebElement fnametxt = driver.findElement(By.xpath("//input[@id='forename']"));
		WebElement emailtxt = driver.findElement(By.xpath("//input[@id='email']"));
		WebElement msgtxt = driver.findElement(By.xpath("//input[@id='message']"));
		
		fnametxt.sendKeys("John");
		emailtxt.sendKeys("john.dee@monad.com");
		msgtxt.sendKeys("Lorem Ipsum");
			
		// Check if error messages .
		validateMandatory();
	}


	@Test
	private void validateEmpty() {
		assertTrue("Verification failed. Forename error-inline text is visible.", driver.findElement(By.xpath("//input[@id='forename']")).isEnabled());
		assertTrue("Verification failed. Email error-inline text is visible.", driver.findElement(By.xpath("//input[@id='email']")).isEnabled());
		assertTrue("Verification failed. Message error-inline text is visible.", driver.findElement(By.xpath("//textarea[@id='message']")).isEnabled());
	}

	@Test
	private void validateMandatory() {
		assertTrue("Verification successful. Forename error-inline text is not visible.", driver.findElement(By.xpath("//input[@id='forename']")).isEnabled());
		assertTrue("Verification successful. Email error-inline text is not visible.", driver.findElement(By.xpath("//input[@id='email']")).isEnabled());
		assertTrue("Verification successful. Message error-inline text is not visible.", driver.findElement(By.xpath("//textarea[@id='message']")).isEnabled());
	}
}
