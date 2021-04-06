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

public class TestCase4 {

	WebDriver driver = new ChromeDriver();

	public void submitContact() {
		// Prime the web browser and Contact Form page for testing.
		driver.get("https://jupiter.cloud.planittesting.com/#/");
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Shop")));
		WebElement shop = driver.findElement(By.linkText("Shop"));
		shop.click();
	}

	
}
