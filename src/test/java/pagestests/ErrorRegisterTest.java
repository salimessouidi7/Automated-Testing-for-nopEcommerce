package pagestests;

import pages.ErrorRegister;
import setup.BaseTest;
import org.testng.annotations.*;

public class ErrorRegisterTest extends BaseTest{
	
	ErrorRegister error;
	@Test
	public void errorFirstNameTest() {
		error = new ErrorRegister(driver);
		
		error.FirstName_error();
	}

}
