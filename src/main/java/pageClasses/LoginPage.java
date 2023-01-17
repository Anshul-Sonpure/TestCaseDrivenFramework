package pageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BrowserSetUp;
import utilities.ReadProperties;
import utilities.ReadTestSheet;

public class LoginPage extends BrowserSetUp{
	
	
	public LoginPage() throws Exception
	{
		
		PageFactory.initElements(driver,this);
	}
	
	//username text box
	@FindBy(xpath="//input[@id='user-name']")
	private WebElement username;
	
	
	//password testbox
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	
	//Login Button
	@FindBy(xpath="//input[@id='login-button']")
	private WebElement Login;
 	

	public void EnterUsername() throws Exception
	{
		String usrname= ReadTestSheet.getTestData(ReadProperties.getData("sheet2"),1,1);
		username.sendKeys(usrname);
		System.out.println("UserName: "+usrname);
		
	}
	
	public void EnterPassword() throws Exception
	{
		String passwd= ReadTestSheet.getTestData(ReadProperties.getData("sheet2"),1,2);
		password.sendKeys(passwd);
		System.out.println("Password: "+passwd);
	}
	
	public void ClickSubmit()
	{
		Login.click();

	}
	
	

}
