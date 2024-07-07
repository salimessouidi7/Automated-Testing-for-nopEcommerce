package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Les localisateurs 
	
	private final By registerButton = By.linkText("Register");
    private final By loginButton = By.linkText("Log in");
    private final By logoutButton = By.linkText("Log out");
    private final By genderMaleRadioButton = By.id("gender-male");
    private final By firstNameField = By.id("FirstName");
    private final By lastNameField = By.id("LastName");
    private final By dayOfBirthField = By.name("DateOfBirthDay");
    private final By monthOfBirthField = By.name("DateOfBirthMonth");
    private final By yearOfBirthField = By.name("DateOfBirthYear");
    private final By emailField = By.id("Email");
    private final By companyField = By.id("Company");
    private final By passwordField = By.id("Password");
    private final By confirmPasswordField = By.id("ConfirmPassword");
    private final By registerSubmitButton = By.id("register-button");
    private final By registrationMessage = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]");
    private final By loginMessage = By.xpath("//*[@id=\"main\"]/div/div/div/div[1]");
    private final By loginSubmitButton = By.className("login-button");
    
    public void register(String firstname, String lastname, int day, String month,
            int year, String email, String company, String password, String confirmPassword) {
    	driver.findElement(registerButton).click();
    	driver.findElement(genderMaleRadioButton).click();
    	driver.findElement(firstNameField).sendKeys(firstname);
    	driver.findElement(lastNameField).sendKeys(lastname);
    	
    }

}
