package testCases;

import org.testng.annotations.Test;

import pageClasses.LoginPage;
import pageClasses.ProductPage;
import testBase.BrowserSetUp;
import utilities.ReadProperties;
import utilities.ReadTestSheet;

public class AddProduct extends BrowserSetUp {
	
	
	
	@Test
	public void executeAddProduct() throws Exception
	{
		String testName=ReadTestSheet.getTestCase(ReadProperties.getData("sheet1"),2);
		String runMode = ReadTestSheet.getExecution();
		System.out.println("Test Case to be Executed :"+testName);
		if(testName.equalsIgnoreCase("Add Product") && runMode.equalsIgnoreCase("yes"))
		{
			LoginPage loginApp = new LoginPage();
			Thread.sleep(1200);
			loginApp.EnterUsername();
			Thread.sleep(1200);
			loginApp.EnterPassword();
			Thread.sleep(1200);
			
			loginApp.ClickSubmit();
			Thread.sleep(1200);
			ProductPage prodpage = new ProductPage();
			prodpage.addToCart();
			Thread.sleep(3200);
			prodpage.Checkout();
			Thread.sleep(3200);
			prodpage.EnterCheckoutInfo();
			Thread.sleep(3200);
			prodpage.ValidateTotal();
			Thread.sleep(3200);
			prodpage.ValidateCheckout();
			Thread.sleep(3200);
			
		}
		else 
		{
			System.out.println("Please check TestCase Name or Execution in Excel");
		}
	}

}
