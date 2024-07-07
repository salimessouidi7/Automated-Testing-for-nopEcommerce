package pagestests;

import org.testng.annotations.*;
import setup.BaseTest;
import pages.RegisterPage;

public class RegisterPageTest extends BaseTest {

	String firstname = "test";
	String lastname = "test1";
	String day = "12";
	String month = "April";
	String year = "2002";
	String email = "test@gmail.com";
	String company = "asd";
	String password = "123456";
	String confirmPassword = "123456";

	@Test
	public void registerPageTest() {
		RegisterPage regPage = new RegisterPage(driver);
		int dayInt = Integer.parseInt(day);
		int yearInt = Integer.parseInt(year);

		regPage.register(firstname, lastname, dayInt, month, yearInt, email, company, password, confirmPassword);
	}
}
