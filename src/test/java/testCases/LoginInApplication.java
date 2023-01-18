package testCases;

import org.testng.annotations.Test;

import pageClasses.LoginPage;
import testBase.BrowserSetUp;
import utilities.ReadProperties;
import utilities.ReadTestSheet;

public class LoginInApplication extends BrowserSetUp {
	
	public LoginPage loginApp; 
	
	@Test
	public void executeLoginApplication() throws Exception
	{
		String testName=ReadTestSheet.getTestCase(ReadProperties.getData("sheet1"),1);
		String runMode = ReadTestSheet.getExecution(1);
		System.out.println("Test Case to be Executed :"+testName +" & RunMode is :"+runMode);
		if(testName.equalsIgnoreCase("Login to Application") && runMode.equalsIgnoreCase("yes"))
		{
			
			loginApp = new LoginPage();
			loginApp.LoginApp();
			
		}
		else 
		{
			System.out.println("Please check TestCase Name or RunMode in Excel");
		}
	}

}
