package testCases;

import org.testng.annotations.Test;
import pageClasses.ProductPage;
import testBase.BrowserSetUp;
import utilities.ReadProperties;
import utilities.ReadTestSheet;

public class AddProduct extends BrowserSetUp {
	
	
	
	@Test
	public void executeAddProduct() throws Exception
	{
		String testName=ReadTestSheet.getTestCase(ReadProperties.getData("sheet1"));
		String runMode = ReadTestSheet.getExecution();
		System.out.println("Test Case to be Executed :"+testName);
		if(testName.equalsIgnoreCase("Add Product") && runMode.equalsIgnoreCase("yes"))
		{
			
			ProductPage prodpage = new ProductPage();
			System.out.println("Test Case to be Executed :"+testName);
			prodpage.addToCart();
			prodpage.Checkout();
			prodpage.EnterCheckoutInfo();
			prodpage.ValidateTotal();
			prodpage.ValidateCheckout();
			driver.quit();
			
		}
		else 
		{
			System.out.println("Please check TestCase Name or Execution in Excel");
		}
	}

}
