package pagestests;

import org.testng.annotations.*;
import setup.BaseTest;
import utils.CSVUtils;
import pages.RegisterPage;

public class RegisterPageTest extends BaseTest {

	
	@Test(priority = 1)
	public void verifyElementOfRegisterTest() {
		new RegisterPage(driver).verifyRegisterPageElements();
	}

	@Test(priority = 2,dataProvider = "csvData", dataProviderClass = CSVUtils.class)
	public void registerPageTest(String firstname, String lastname, String day, String month, String year,
			String email, String company, String password, String confirmPassword) {
		
		int dayInt = Integer.parseInt(day);
		int yearInt = Integer.parseInt(year);

		new RegisterPage(driver).register(firstname, lastname, dayInt, month, yearInt, email, company, password, confirmPassword);
	}
}
