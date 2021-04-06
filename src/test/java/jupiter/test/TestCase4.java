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
		
		//Purchase Funny Cow(qty:2) and Fluffy Bunny(qty: 1)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='product-6']//p/a")));
		driver.findElement(By.xpath("//li[@id='product-6']//p/a")).click();
		driver.findElement(By.xpath("//li[@id='product-6']//p/a")).click();
		
		driver.findElement(By.xpath("//li[@id='product-4']//p/a")).click();
		
		//Open the cart menu
		WebElement cart = driver.findElement(By.linkText("Cart"));
		cart.click();
		
		//Validate the cart items
		validateCart();
		
	}

	@Test
	public void validateCart() {
		assertTrue("Funny Cow is in the cart", driver.findElement(By.xpath("//input[@value='2']")).isDisplayed());
		assertTrue("Fluffy Bunny is in the cart", driver.findElement(By.xpath("//input[@value='1']")).isDisplayed());
	}
	
}
