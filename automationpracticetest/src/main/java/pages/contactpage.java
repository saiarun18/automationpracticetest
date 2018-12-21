package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import sourcemethods.SeMethods;

public class contactpage extends SeMethods{

	public contactpage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static WebElement element = null;
	public static String key=null;
	 
	public static WebElement contactinfo(WebDriver driver,String key) {
		element = driver.findElement(By.xpath(list.getProperty(key)));
	    return element;
	}
}
