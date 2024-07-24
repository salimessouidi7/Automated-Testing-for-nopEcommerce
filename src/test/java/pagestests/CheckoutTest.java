package pagestests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.CheckoutProcess;
import setup.BaseTest;

public class CheckoutTest extends BaseTest {

	@Test(priority = 1, dataProvider = "checkoutData")
	public void checkouProcessTest(String country, String state ,String city, String addressOne, String addressTwo, String zip, String phone, String fax) {

		new CheckoutProcess(driver).checkoutPage(country, state, city, addressOne, addressTwo, zip, phone, fax);

	}

	@DataProvider(name = "checkoutData")
	public Object[][] getData() {
		return new Object[][] { { "United States", "Alabama", "palestine", "gaza", "khan younes", "12254", "1515456465", "151545156" } };
	}
}
