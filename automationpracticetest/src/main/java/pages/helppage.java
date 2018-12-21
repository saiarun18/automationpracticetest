package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class helppage {
	private static WebElement element = null;
	
	public static WebElement simplesearchlink(WebDriver driver) {
			element = driver.findElement(By.xpath("//a[contains(text(),'Simple Search Example')]"));
		    return element;
		}
}
