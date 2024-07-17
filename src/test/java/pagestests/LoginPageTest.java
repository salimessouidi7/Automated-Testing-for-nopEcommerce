package pagestests;

import org.testng.annotations.Test;

import pages.LoginPage;
import setup.BaseTest;
import utils.CSVUtils;

public class LoginPageTest extends BaseTest{
	
	@Test(dataProvider = "csvData", dataProviderClass = CSVUtils.class)
	public void loginPageTest(String firstname, String lastname, String day, String month, String year,
			String email, String company, String password, String confirmPassword) {
		
		LoginPage login = new LoginPage(driver);
		login.navigateToLoginPage(email, password);	
	}

}
