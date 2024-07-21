package pagestests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddItemToCart;
import setup.BaseTest;

public class AddItemToCartTest extends BaseTest {

    @Test(priority = 1, dataProvider = "addItemData")
    public void addItemTest(String ramvalue, String expectedText) {
        AddItemToCart additem = new AddItemToCart(driver);
        additem.addProductToCart(ramvalue, expectedText);
    }

    @DataProvider(name = "addItemData")
    public Object[][] getData() {
        return new Object[][] {
            {"3", "Build your own computer"}
        };
    }
}
