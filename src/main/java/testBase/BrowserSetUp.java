package testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadProperties;

public class BrowserSetUp {
	
public static WebDriver driver = null;
	
	
	public static WebDriver initDriver() throws Exception
	{
		String browser =ReadProperties.getData("browser");
		System.out.println("Browser initialized as :"+browser);
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.silentOutput", "true");
			driver=new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			
		}
		else
		{
			System.out.println(browser+" Didn't matched any browser specified in properties file");
		}
		return driver;
	}
	
protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	
	
	
	@BeforeClass
    public void Setup() throws Exception{
		WebDriver webdriver = BrowserSetUp.initDriver();
		threadLocalDriver.set(webdriver);
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		getDriver().get(ReadProperties.getData("appurl"));
	}
	 //get thread-safe driver
    public static WebDriver getDriver(){
        
        return threadLocalDriver.get();
    }

    @AfterClass
    public void tearDown()
    {
    	getDriver().quit();
    	threadLocalDriver.remove();
    }
	
	

}