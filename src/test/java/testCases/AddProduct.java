package testCases;

import org.testng.annotations.Test;

import pageClasses.LoginPage;
import pageClasses.ProductPage;
import testBase.BrowserSetUp;
import utilities.ReadProperties;
import utilities.ReadTestSheet;

public class AddProduct extends BrowserSetUp {
	
	public LoginPage loginApp;
	public ProductPage prodpage;
	
	@Test
	public void executeAddProduct() throws Exception
	{
		String testName=ReadTestSheet.getTestCase(ReadProperties.getData("sheet1"),2);
		String runMode = ReadTestSheet.getExecution(2);
		System.out.println("Test Case to be Executed :"+testName +" & RunMode is :"+runMode);
		if(testName.equalsIgnoreCase("Add Product") && runMode.equalsIgnoreCase("yes"))
		{
			loginApp = new LoginPage();
			loginApp.LoginApp();
			prodpage = new ProductPage();
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
			System.out.println("Please check TestCase Name or RunMode in Excel");
		}
	}

}
