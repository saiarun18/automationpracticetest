package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class faq {
	
	
	private static WebElement element = null;
	 
	
	 public static WebElement Overviewlink(WebDriver driver) {
			element = driver.findElement(By.xpath("//a[contains(text(),'Overview')]"));
		    return element;
		}
	 public static WebElement Documentdeliverylink(WebDriver driver) {
			element = driver.findElement(By.xpath("//a[contains(text(),'Document Delivery')]"));
		    return element;
		}
	 
	 
	 
}
