package utils;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Commons {
	 static WebDriver driver;
	 
	public static void enterText(WebDriver driver,By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public static void clickElement(WebDriver driver,By locator) {
        driver.findElement(locator).click();
    }
    
    public static void selectByVisibleText(WebDriver driver,By locator, String text) {
        WebElement element = driver.findElement(locator);
        new Select(element).selectByVisibleText(text);
    }
    
    public static void verifyElementPresenceAndVisibility(WebDriver driver,By locator) {
        assertTrue(isElementPresent(driver,locator), "Element not present: " + locator);
        assertTrue(isElementDisplayed(driver,locator), "Element not displayed: " + locator);
    }
    
    public static boolean isElementPresent(WebDriver driver,By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isElementDisplayed(WebDriver driver,By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public static void compareText(WebDriver driver,By locator, String expectedText) {
		// msg actual dans la site
		WebElement registrationMsg = driver.findElement(locator);
		assertEquals(registrationMsg.getText(), expectedText, "Confirmation message mismatch");

	}
    
 // Method to scroll down until element is found
    public static void scrollToElement(WebDriver driver, By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean elementFound = false;

        while (!elementFound) {
            // Check if the element is present on the page
            if (driver.findElements(locator).size() > 0) {
                elementFound = true;
            } else {
                // Scroll down by a certain amount of pixels
                js.executeScript("window.scrollBy(0, 500);");
            }
        }
    }

}
