package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class advancedpage {
		
	private static WebElement element = null;
	 
	 public static WebElement homelink(WebDriver driver) {
			element = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		    return element;
		}

	public static WebElement orderslink(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[contains(text(),'Orders')]"));
		 
	    return element;
	}
}
	
	
	
	
	
	
	
	


