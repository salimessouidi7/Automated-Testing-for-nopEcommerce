package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Commons;

public class LoginPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	// Les localisateurs
	private final By loginLink = By.linkText("Log in");
	private final By emailField = By.id("Email");
	private final By passwordField = By.id("Password");
	private final By loginButton = By.xpath("//button[@class='button-1 login-button']");
	// "//tagname[@attribut=valeur]"
	
	public void navigateToLoginPage(String email, String password) {
		Commons.clickElement(driver,loginLink);
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
		Commons.enterText(driver, emailField, email);
		Commons.enterText(driver, passwordField, password);
		Commons.clickElement(driver, loginButton);
	}
	

}
