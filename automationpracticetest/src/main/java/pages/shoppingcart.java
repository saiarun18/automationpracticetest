package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import sourcemethods.SeMethods;

public class shoppingcart extends SeMethods{
	
 public shoppingcart() throws IOException {
		super();
	}
private static WebElement element = null;
	 
	 public static WebElement paypalbutton(WebDriver driver) {
			element = driver.findElement(By.xpath("//input[@name='paypal_submit'][1]"));
		    return element;
		}
	 
	 public static WebElement paypay_login(WebDriver driver) {
			element = driver.findElement(By.xpath("//a[contains(text(),'Log In')]"));
		    return element;
		}
	 
	//Tarrant county Shopping cart page
	 public static WebElement paybutton(WebDriver driver,String key)
	 {
		 element= driver.findElement(By.xpath(list.getProperty(key)));
		 return element;
	 }

}





