package pageClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testBase.BrowserSetUp;
import utilities.ReadProperties;
import utilities.ReadTestSheet;

public class ProductPage extends BrowserSetUp {
	
	
	//Object Repo
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	private WebElement addtoCart;
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	private WebElement cart;
	
	@FindBy(xpath="//div[@class='inventory_item_price']")
	private WebElement price;
	
	
	@FindBy(xpath="//button[@id='checkout']")
	private WebElement checkout;
	
	
	@FindBy(xpath="//input[@id='first-name']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@id='last-name']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@id='postal-code']")
	private WebElement postcode;
	
	@FindBy(xpath="//input[@id='continue']")
	private WebElement Continue;
	
	
	@FindBy(xpath="//div[@class='summary_total_label']")
	private WebElement TotalPrice;
	
	@FindBy(xpath="//button[@id='finish']")
	private WebElement finish;
	
	@FindBy(xpath="//span[text()='Checkout: Complete!']")
	private WebElement Checkout;
	
	@FindBy(xpath="//button[text()='Open Menu']")
	private WebElement Menu;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement Logout;
	
	public ProductPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void addToCart()
	{
		addtoCart.click();
		cart.click();
	}
	
	public void Checkout()
	{
		Assert.assertEquals("$29.99",price.getText());
		checkout.click();
	}
	
	public void EnterCheckoutInfo() throws Exception
	{
		firstName.sendKeys(ReadTestSheet.getTestData(ReadProperties.getData("sheet3"),1,1).toString());
		lastName.sendKeys(ReadTestSheet.getTestData(ReadProperties.getData("sheet3"),1,2).toString());
		postcode.sendKeys(ReadTestSheet.getTestData(ReadProperties.getData("sheet3"),1,2).toString());
		Continue.click();
	}
	
	
	public void ValidateTotal()
	{
		Assert.assertEquals("Total: $32.39",TotalPrice.getText());
		finish.click();
	}
	
	public  void ValidateCheckout()
	{
		
		String checkout="CHECKOUT: COMPLETE!";
		Assert.assertEquals(checkout,Checkout.getText());
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", Checkout);
	}
	
	
	public  void Logout() throws InterruptedException
	{
		
		Menu.click();
		Logout.click();
	}
	
	

}
