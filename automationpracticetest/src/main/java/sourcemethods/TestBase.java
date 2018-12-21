package sourcemethods;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	
	
	public static WebDriver driver = null;
	 
	 @BeforeSuite		
	 public void initialize() throws IOException, InterruptedException{
		 
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		 driver = new ChromeDriver(); 
		 //To maximize browser
		                driver.manage().window().maximize();
		         //Implicit wait
		        	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 //To open facebook
		                driver.get("https://ocmideeds.com/");
		                Thread.sleep(10000);
		 
		 }
	 
	 
	 /*public void startApp(String browser, String url) {
				if (browser.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
					driver = new ChromeDriver();
				} 
				else if (browser.equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
					driver = new FirefoxDriver();
				}
				else if(browser.equalsIgnoreCase("ie"))
				{
				   System.setProperty("webdriver.ie.driver", "./drivers/MicrosoftWebDriver.exe");
				   driver = new InternetExplorerDriver();
				}
				driver.manage().window().maximize();
				driver.get(url);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				System.out.println("The Browser "+browser+" has been Launched Successfully");

			}
 
	 @AfterSuite
	 //Test cleanup
	 public void TeardownTest()
	    {
	        TestBase.driver.quit();
	    }*/
	
	 
	}


