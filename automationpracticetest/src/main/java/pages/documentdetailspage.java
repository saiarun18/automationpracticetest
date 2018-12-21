package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class documentdetailspage {
	
	private static WebElement element = null;
	 
	 public static WebElement documentdetail(WebDriver driver) {
			element = driver.findElement(By.xpath("//h2[contains(text(),'Document Details')]"));
		    return element;
		}
	 
	 public static WebElement backbutton(WebDriver driver) {
			element = driver.findElement(By.xpath("//button[text()='Back']"));
		    return element;
		}
}
