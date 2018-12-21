package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import sourcemethods.SeMethods;

public class Homepage extends SeMethods{
	
	 public Homepage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static WebElement element = null;
	public static String key=null;
	 
	 public static WebElement homelink(WebDriver driver) {
			element = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		    return element;
		}

	 public static WebElement homelinknew(WebDriver driver,String key) {
			element = driver.findElement(By.xpath(list.getProperty(key)));
		    return element;
		}
 	 
	public static WebElement Advancedbutton(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@id='btnSearch']/following-sibling::a"));
	    return element;
	}
	
	public static WebElement FAQlink(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[contains(text(),'FAQ')]"));
	    return element;
	}
	
	public static WebElement Helplink(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[contains(text(),'Help')]"));
	    return element;
	}
	
	public static WebElement searchtextbox(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//input[@id='searchbox']"));
		return element;
	}
	
	public static WebElement searchbutton(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//button[@id='btnSearch']"));
		return element;
	}
	
	public static WebElement Alert_login_link(WebDriver driver)
	{
	element=driver.findElement(By.xpath("//a[contains(text(),'Log In')]"));
	return element;	
	}

	public static WebElement Orders_link(WebDriver driver,String key)
	{
		element=driver.findElement(By.xpath(list.getProperty(key)));
		return element;	
	}

	public static WebElement contact_link(WebDriver driver,String key)
	{
		element=driver.findElement(By.xpath(list.getProperty(key)));
		return element;	
	}
}



