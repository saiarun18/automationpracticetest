
package sourcemethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class SeMethods implements WdMethods 
{
public static Properties list = new Properties();

public SeMethods() throws IOException {
	// super();

	loadPropertyFile(new File(System.getProperty("user.dir").concat("/objectrepository.properties")));
	
}

public void loadPropertyFile(File file) throws IOException {
	FileInputStream fis = new FileInputStream(file);
		list.load(fis);
	
}


	public static WebDriver driver=null;
	public void startApp(String browser, String url) {
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
		driver.get(list.getProperty(url));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("The Browser "+browser+" has been Launched Successfully");

	}

	public void Assertequals(String actual,String expected)
	{	
		Assert.assertEquals(actual, expected);
	}

	public void waitElementtobevisible(WebElement element)
	{		
		 WebDriverWait wait = new WebDriverWait(driver,40);
		    wait.until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement locateElement(String locValue) {
		// TODO Auto-generated method stub
		return null;
	}

	public void type(WebElement ele, String data) {
		ele.sendKeys(data);
		System.out.println("The Value have been entered Successfully "+data);
	}

	public void click(WebElement ele) {
		ele.click();
		System.out.println("Element is clicked Successfully");
	}

	public String getText(WebElement ele) {
		// TODO Auto-generated method stub
		return null;
	}

	public void selectDropDownUsingText(WebElement ele, String key) {
		Select dropdown=new Select(ele);
		dropdown.selectByVisibleText(list.getProperty(key));
		
	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		Select dropdown=new Select(ele);
		dropdown.selectByIndex(index);

	}
	
	public void selectDropDownUsingvalue(WebElement ele, String value) {
		Select dropdown=new Select(ele);
		dropdown.selectByValue(value);
	}
	
	public void deselectDropDownUsingtext(WebElement ele,String value)
	{
		Select dropdown=new Select(ele);
		dropdown.deselectByVisibleText(value);
	}
	
	public void switchtotab()
	{
		String parent=driver.getWindowHandle();
		Set<String>s1=driver.getWindowHandles();
		Iterator<String> I1= s1.iterator();
		while(I1.hasNext())
		{
		  String child_window=I1.next();
		  if(!parent.equals(child_window))
		  {
		    driver.switchTo().window(child_window);
		  }
		}
	}
	
	public void switchtoHome()
	{
		driver.switchTo().defaultContent();
	}
	
	public void switchtoframe(int frameno)
	{
		driver.switchTo().frame(frameno);
	}
	
	public void close()
	{
		driver.close();
	}
	
	
	
	public boolean verifyTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub

	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub

	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void switchToWindow(int index) {
		// TODO Auto-generated method stub

	}

	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void acceptAlert() {
		
		Alert alert=driver.switchTo().alert();
		alert.accept();

	}

	public void dismissAlert() {
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}

	public String getAlertText() {
		Alert alert=driver.switchTo().alert();
		String alerttext=alert.getText();
		System.out.println(alerttext);
		return alerttext;
	}

	public void takeSnap() {
		// TODO Auto-generated method stub

	}

	public void closeBrowser() {
		// TODO Auto-generated method stub

	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub

	}
	
	public void gettitle()
	{
		System.out.println(driver.getTitle());
	}
	
	public void SwitchTochildwindow()
	{
		String mainWindow=driver.getWindowHandle();
		Set<String> set =driver.getWindowHandles();
		Iterator<String> itr= set.iterator();
		while(itr.hasNext()){
			 String childWindow=itr.next();
			 if(!mainWindow.equals(childWindow)){
				 driver.switchTo().window(childWindow);
				 System.out.println(driver.switchTo().window(childWindow).getTitle());
				 driver.close();
				 }
				 }	
	}
	
	public String actual(String key)
	{
		String actual=list.getProperty(key);
		return actual;
	}
	
	
	
	public void SwitchToMainwindow()
	{
		driver.switchTo().defaultContent();
	}
	
	
	@Override
	public WebElement locateElement(String locator, String locValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
