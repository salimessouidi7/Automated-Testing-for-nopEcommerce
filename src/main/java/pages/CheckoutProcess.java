package pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutProcess {
	
	private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By agreeServiceCheckbox = By.id("termsofservice");
    private final By checkoutButton = By.id("checkout");
    private final By countrySelect = By.id("BillingNewAddress_CountryId");
    private final By stateSelect = By.id("BillingNewAddress_StateProvinceId");
    
    private final By countryOption = By.xpath("//option[normalize-space()='United States']");
    private final By stateOption = By.xpath("//option[normalize-space()='Alabama']");
    private final By cityNameField = By.id("BillingNewAddress_City");
    private final By addressOneField = By.id("BillingNewAddress_Address1");
    private final By addressTwoField = By.id("BillingNewAddress_Address2");
    private final By zipCodeField = By.id("BillingNewAddress_ZipPostalCode");
    private final By phoneNumberField = By.id("BillingNewAddress_PhoneNumber");
    private final By faxNumberField = By.id("BillingNewAddress_FaxNumber");
    private final By continueButton = By.name("save");
    private final By shippingMethodButton = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button");

    private final By paymentMethodButton = By.xpath("//button[@class='button-1 payment-method-next-step-button']");
    private final By confirmOrderButton = By.xpath("//*[@id=\"payment-info-buttons-container\"]/button");
    private final By finalConfirmOrderButton = By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button");
    private final By confirmOrderMessage = By.xpath("//div[@class='page-body checkout-data']//div[@class='section order-completed']//div[@class='title']/strong");

    private static final String EXPECTED_CONFIRMATION_MESSAGE = "Your order has been successfully processed!";

    public CheckoutProcess(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public void checkoutPage(String country, String state ,String city, String addressOne, String addressTwo, String zip, String phone, String fax) {
    	
    	driver.findElement(agreeServiceCheckbox).click();
    	driver.findElement(checkoutButton).click();
    	
    	wait.until(ExpectedConditions.elementToBeClickable(countrySelect));
    	
    	WebElement countryElement = driver.findElement(countrySelect);
    	
    	Select select1 = new Select(countryElement);
    	
    	select1.selectByVisibleText(country);
    	
    	//select state
    	wait.until(ExpectedConditions.elementToBeClickable(stateSelect));
    	
    	WebElement stateElement = driver.findElement(stateSelect);
    	
    	Select select2 = new Select(stateElement);
    	
    	wait.until(ExpectedConditions.elementToBeClickable(stateOption));
    	
    	select2.selectByVisibleText(state);
    	
    	driver.findElement(cityNameField).sendKeys(city);
    	driver.findElement(addressOneField).sendKeys(addressOne);
    	driver.findElement(addressTwoField).sendKeys(addressTwo);
    	driver.findElement(zipCodeField).sendKeys(zip);
    	driver.findElement(phoneNumberField).sendKeys(phone);
    	driver.findElement(faxNumberField).sendKeys(fax);
    	
    	driver.findElement(continueButton).click();
    	
//    	wait.until(ExpectedConditions.elementToBeClickable(shippingMethodButton));
//    	driver.findElement(shippingMethodButton).click();
    	
    	wait.until(ExpectedConditions.elementToBeClickable(shippingMethodButton)).click();;
    	
    	wait.until(ExpectedConditions.elementToBeClickable(paymentMethodButton)).click();
    	wait.until(ExpectedConditions.elementToBeClickable(confirmOrderButton)).click();
    	
    	wait.until(ExpectedConditions.elementToBeClickable(finalConfirmOrderButton)).click();
    	
    	WebElement orderConfirmMsg = driver.findElement(confirmOrderMessage);
        // Compare the actual alert text with the expected value
        assertEquals(orderConfirmMsg.getText(), EXPECTED_CONFIRMATION_MESSAGE, "Confirmation message mismatch");
    	
    	
    	
    }

}
