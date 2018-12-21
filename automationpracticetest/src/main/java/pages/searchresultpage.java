package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import sourcemethods.SeMethods;

public class searchresultpage extends SeMethods{

	public searchresultpage() throws IOException {
		super();	
	}

	public static String rowscount;
	
	public static List<WebElement> listelement=null;
	
	public static WebDriver driver;
	
	 private static WebElement element = null;
	 
	 public static WebElement Addtocartbuttons(WebDriver driver) {
		 element=driver.findElement(By.xpath("(//button[contains(text(),'Add To Cart')])[1]"));
		    return element;
		}
	 public static WebElement Cartbutton(WebDriver driver) {
		element = driver.findElement(By.xpath("//li[@id='shopCartNav']/a/img[1]"));	
		 return element;
			}
	 public static WebElement Regular_Addtocart(WebDriver driver,String key) {
			element = driver.findElement(By.xpath(list.getProperty(key)));	
			 return element;
				}
	 
	 public static WebElement Rowsperpage(WebDriver driver){
		 element=driver.findElement(By.xpath("//select[@id='rpp']"));
		 return element;
	 }
	 
	 public static WebElement documentlist(WebDriver driver){
		  element= driver.findElement(By.xpath("(//a[@class='popimg'])[1]"));
		 return element;
	 }

	 public static List<WebElement> Searchresult_totaldocuments(WebDriver driver,String key) {
	    listelement=driver.findElements(By.xpath(list.getProperty(key)));
		return listelement;
	}
	 public static String rows(String key)
	 {
		rowscount=list.getProperty(key);
		return rowscount; 
	 }
	 
	 
	 
}
