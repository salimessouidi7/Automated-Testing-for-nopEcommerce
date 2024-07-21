package pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Commons;

public class AddItemToCart {

	private WebDriver driver;
	private WebDriverWait wait;

	public AddItemToCart(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Les localisateurs

	private final By addTocratButton = By
			.xpath("//*[@id=\"main\"]/div/div/div/div/div[4]/div[2]/div[1]/div/div[2]/div[3]/div[2]/button[1]");
	private final By ramSelect = By.id("product_attribute_2");
	private final By hddButton = By.id("product_attribute_3_6");
	private final By addbutton = By.id("add-to-cart-button-1");
	private final By viewShoppingCart = By.linkText("shopping cart");
	private final By productname = By.className("product-name");

	public void addProductToCart(String ramvalue, String expectedText) {
		
		Commons.scrollToElement(driver, addTocratButton);
		Commons.clickElement(driver, addTocratButton);

		wait.until(ExpectedConditions.visibilityOfElementLocated(ramSelect));
		
		WebElement ram = driver.findElement(ramSelect);

		Select select = new Select(ram);

		select.selectByValue(ramvalue);

		Commons.clickElement(driver, hddButton);
		Commons.clickElement(driver, addbutton);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewShoppingCart));
		Commons.clickElement(driver, viewShoppingCart);

		Commons.compareText(driver, productname,expectedText);
	}

}
