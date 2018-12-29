package crmpages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import sourcemethods.SeMethods;

public class CRMloginpage extends SeMethods{

	public CRMloginpage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static WebElement element = null;
	 
	 public static WebElement username(WebDriver driver) {
			//element = driver.findElement(By.xpath("//input[@name='username']"));
		element = driver.findElement(By.xpath(list.getProperty("usernamelocator")));
		 
		    return element;
	 }
	 
	 public static WebElement password(WebDriver driver) {
			element = driver.findElement(By.xpath(list.getProperty("passwordlocator")));
		    return element;
	 }
	 
	 public static WebElement loginbutton(WebDriver driver)
	 {
		 element=driver.findElement(By.xpath(list.getProperty("loginlocator")));
		 return element;
	 }
	 
	 
	 
	 
}
