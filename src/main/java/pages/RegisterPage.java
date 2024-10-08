package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	WebElement selectmonthOfBirth;
	Select select;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Les localisateurs 
	
	private final By registerButton = By.linkText("Register");
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
    //private final By logoutFromRegistration= By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");
    private final By logoutButton = By.linkText("Log out");
    
    public void register(String firstname, String lastname, int day, String month,
            int year, String email, String company, String password, String confirmPassword) {
    	driver.findElement(registerButton).click();
    	driver.findElement(genderMaleRadioButton).click();
    	driver.findElement(firstNameField).sendKeys(firstname);
    	driver.findElement(lastNameField).sendKeys(lastname);

    	
    	driver.findElement(dayOfBirthField).sendKeys(String.valueOf(day));
		//driver.findElement(monthOfBirthField).sendKeys(month);
    	
    	// Localisez l'élément <select> par son nom
        selectmonthOfBirth = driver.findElement(monthOfBirthField);

        // Créez une instance de la classe Select et passez l'élément <select> comme paramètre
        select = new Select(selectmonthOfBirth);

        // Sélectionnez l'option par sa valeur
        //select.selectByValue("7");
        select.selectByVisibleText(month);
        
		driver.findElement(yearOfBirthField).sendKeys(String.valueOf(year));
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(companyField).sendKeys(company);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
		driver.findElement(registerSubmitButton).click();
		
		
		// msg actual dans la site 
		WebElement registrationMsg = driver.findElement(registrationMessage);
        // Compare the actual alert text with the expected value
        String expectedText = "Your registration completed";
        assertEquals(registrationMsg.getText(), expectedText, "Confirmation message mismatch");
         
        driver.findElement(logoutButton).click();
    	
    }
    
    // Method to check if the element is present on the page
    private boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Method to check if the element is displayed on the page
    private boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public void verifyRegisterPageElements() {
    	wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com/"));
    	
        assertTrue(isElementPresent(registerButton), "Register button is not present");
        assertTrue(isElementDisplayed(registerButton), "Register button is not displayed");
        
        driver.findElement(registerButton).click();

        assertTrue(isElementPresent(genderMaleRadioButton), "Gender male radio button is not present");
        assertTrue(isElementDisplayed(genderMaleRadioButton), "Gender male radio button is not displayed");

        assertTrue(isElementPresent(firstNameField), "First name field is not present");
        assertTrue(isElementDisplayed(firstNameField), "First name field is not displayed");

        assertTrue(isElementPresent(lastNameField), "Last name field is not present");
        assertTrue(isElementDisplayed(lastNameField), "Last name field is not displayed");

        assertTrue(isElementPresent(dayOfBirthField), "Day of birth field is not present");
        assertTrue(isElementDisplayed(dayOfBirthField), "Day of birth field is not displayed");

        assertTrue(isElementPresent(monthOfBirthField), "Month of birth field is not present");
        assertTrue(isElementDisplayed(monthOfBirthField), "Month of birth field is not displayed");

        assertTrue(isElementPresent(yearOfBirthField), "Year of birth field is not present");
        assertTrue(isElementDisplayed(yearOfBirthField), "Year of birth field is not displayed");

        assertTrue(isElementPresent(emailField), "Email field is not present");
        assertTrue(isElementDisplayed(emailField), "Email field is not displayed");

        assertTrue(isElementPresent(companyField), "Company field is not present");
        assertTrue(isElementDisplayed(companyField), "Company field is not displayed");

        assertTrue(isElementPresent(passwordField), "Password field is not present");
        assertTrue(isElementDisplayed(passwordField), "Password field is not displayed");

        assertTrue(isElementPresent(confirmPasswordField), "Confirm password field is not present");
        assertTrue(isElementDisplayed(confirmPasswordField), "Confirm password field is not displayed");

        assertTrue(isElementPresent(registerSubmitButton), "Register submit button is not present");
        assertTrue(isElementDisplayed(registerSubmitButton), "Register submit button is not displayed");
    }

}
