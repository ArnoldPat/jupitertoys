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

public class TestCase3 {

	WebDriver driver = new ChromeDriver();

	public void submitContact() {

		// Prime the web browser and Contact Form page for testing.
		driver.get("https://jupiter.cloud.planittesting.com/#/");
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Contact")));
		WebElement contact = driver.findElement(By.linkText("Contact"));
		contact.click();

		// Populate Mandatory fields with invalid data, and validate on submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='forename']")));
		WebElement fnametxt = driver.findElement(By.xpath("//input[@id='forename']"));
		WebElement emailtxt = driver.findElement(By.xpath("//input[@id='email']"));
		WebElement msgtxt = driver.findElement(By.xpath("//input[@id='message']"));

		fnametxt.sendKeys("$@#252$");
		emailtxt.sendKeys("123%@#$");
		msgtxt.sendKeys("@#$@#$");

		WebElement submit = driver.findElement(By.xpath("//*[.='Submit']"));
		submit.click();

		// Check if successful submission message is displayed.
		validateMandatory();
	}
	
	private void validateMandatory() {
		assertTrue("Verification failed. Invalid characters did not return error.", driver.findElement(By.xpath("//strong[contains(text(),'Thanks')]")).isEnabled());
	}
}
