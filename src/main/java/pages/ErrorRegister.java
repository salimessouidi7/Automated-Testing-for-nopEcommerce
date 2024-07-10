package pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ErrorRegister {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	WebElement registrationMsg;
	
	
	public ErrorRegister(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	// les localisateurs
	private final By registerButton = By.linkText("Register");
	private final By FirstNameError = By.id("FirstName-error");
	private final By registerSubmitButton = By.id("register-button");
	
	public void FirstName_error() {
		driver.findElement(registerButton).click();
		driver.findElement(registerSubmitButton).click();
		
		registrationMsg = driver.findElement(FirstNameError);
        // Compare the actual alert text with the expected value
        String expectedText = "First name is required.";
        assertEquals(registrationMsg.getText(), expectedText, "Confirmation message mismatch");
		
	}

}
