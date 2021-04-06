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
	
		// Instantiate the browser path, prime the Contact Form page for testing.
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
		
		
		// TestCase1b: Populate Mandatory fields and validate on submit
		WebElement fnametxt = driver.findElement(By.xpath("//input[@id='forename']"));
		WebElement emailtxt = driver.findElement(By.xpath("//input[@id='email']"));
		WebElement msgtxt = driver.findElement(By.xpath("//input[@id='message']"));
		
		fnametxt.sendKeys("John");
		emailtxt.sendKeys("john.dee@monad.com");
		msgtxt.sendKeys("Lorem Ipsum");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Submit']")));
		submit.click();
		
		// Check if successful submission message is displayed.
		validateMandatory();
	}


	@Test
	private void validateEmpty() {
		assertTrue("Forename is empty.", driver.findElement(By.xpath("//input[@id='forename']")).isEnabled());
		assertTrue("Email is empty.", driver.findElement(By.xpath("//input[@id='email']")).isEnabled());
		assertTrue("Message Area is empty.", driver.findElement(By.xpath("//textarea[@id='message']")).isEnabled());
		System.out.println("Fail");
	}

	@Test
	private void validateMandatory() {
		assertTrue("Form submitted successfully.", driver.findElement(By.xpath("//strong[text()='We welcome your feedback' ]")).isEnabled());
		System.out.println("Passed");
	}
}
