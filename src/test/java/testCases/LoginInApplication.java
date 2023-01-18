package testCases;

import org.testng.annotations.Test;

import pageClasses.LoginPage;
import testBase.BrowserSetUp;
import utilities.ReadProperties;
import utilities.ReadTestSheet;

public class LoginInApplication extends BrowserSetUp {
	
	
	@Test
	public void executeLoginApplication() throws Exception
	{
		String testName=ReadTestSheet.getTestCase(ReadProperties.getData("sheet1"),1);
		String runMode = ReadTestSheet.getExecution();
		System.out.println("Test Case to be Executed :"+testName);
		if(testName.equalsIgnoreCase("Login to Application") && runMode.equalsIgnoreCase("yes"))
		{
			
			LoginPage loginApp = new LoginPage();
			Thread.sleep(1200);
			loginApp.EnterUsername();
			Thread.sleep(1200);
			loginApp.EnterPassword();
			Thread.sleep(1200);
			
			loginApp.ClickSubmit();
			Thread.sleep(1200);
			
		}
		else 
		{
			System.out.println("Please check TestCase Name or Execution in Excel");
		}
	}

}
