package pages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyPresenceOfElement {
    private WebDriver driver;
    private WebDriverWait wait;
    private RegisterPage registerPage;

    public VerifyPresenceOfElement(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        registerPage = new RegisterPage(driver);
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

//    public void verifyRegisterPageElements() {
//        assertTrue(isElementPresent(registerPage.registerButton), "Register button is not present");
//        assertTrue(isElementDisplayed(registerPage.registerButton), "Register button is not displayed");
//
//        assertTrue(isElementPresent(registerPage.genderMaleRadioButton), "Gender male radio button is not present");
//        assertTrue(isElementDisplayed(registerPage.genderMaleRadioButton), "Gender male radio button is not displayed");
//
//        assertTrue(isElementPresent(registerPage.firstNameField), "First name field is not present");
//        assertTrue(isElementDisplayed(registerPage.firstNameField), "First name field is not displayed");
//
//        assertTrue(isElementPresent(registerPage.lastNameField), "Last name field is not present");
//        assertTrue(isElementDisplayed(registerPage.lastNameField), "Last name field is not displayed");
//
//        assertTrue(isElementPresent(registerPage.dayOfBirthField), "Day of birth field is not present");
//        assertTrue(isElementDisplayed(registerPage.dayOfBirthField), "Day of birth field is not displayed");
//
//        assertTrue(isElementPresent(registerPage.monthOfBirthField), "Month of birth field is not present");
//        assertTrue(isElementDisplayed(registerPage.monthOfBirthField), "Month of birth field is not displayed");
//
//        assertTrue(isElementPresent(registerPage.yearOfBirthField), "Year of birth field is not present");
//        assertTrue(isElementDisplayed(registerPage.yearOfBirthField), "Year of birth field is not displayed");
//
//        assertTrue(isElementPresent(registerPage.emailField), "Email field is not present");
//        assertTrue(isElementDisplayed(registerPage.emailField), "Email field is not displayed");
//
//        assertTrue(isElementPresent(registerPage.companyField), "Company field is not present");
//        assertTrue(isElementDisplayed(registerPage.companyField), "Company field is not displayed");
//
//        assertTrue(isElementPresent(registerPage.passwordField), "Password field is not present");
//        assertTrue(isElementDisplayed(registerPage.passwordField), "Password field is not displayed");
//
//        assertTrue(isElementPresent(registerPage.confirmPasswordField), "Confirm password field is not present");
//        assertTrue(isElementDisplayed(registerPage.confirmPasswordField), "Confirm password field is not displayed");
//
//        assertTrue(isElementPresent(registerPage.registerSubmitButton), "Register submit button is not present");
//        assertTrue(isElementDisplayed(registerPage.registerSubmitButton), "Register submit button is not displayed");
//
//        assertTrue(isElementPresent(registerPage.registrationMessage), "Registration message is not present");
//        assertTrue(isElementDisplayed(registerPage.registrationMessage), "Registration message is not displayed");
//
//        assertTrue(isElementPresent(registerPage.logoutButton), "Logout button is not present");
//        assertTrue(isElementDisplayed(registerPage.logoutButton), "Logout button is not displayed");
//    }
}
