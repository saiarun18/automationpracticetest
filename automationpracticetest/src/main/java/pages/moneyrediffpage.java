package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;

import sourcemethods.SeMethods;


public class moneyrediffpage extends SeMethods{
	
	public moneyrediffpage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static WebElement element = null;
	 
	 public static WebElement homelink(WebDriver driver) {
			element = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		    return element;
		}

	public static WebElement orderslink(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[contains(text(),'Orders')]"));
		 
	    return element;
	}
	
	public static void rowsandcolumn(WebDriver driver)
	{
		List  col = driver.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
        System.out.println("No of cols are : " +col.size()); 
        //No.of rows 
        List  rows = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr[7]/td[1]")); 
        System.out.println("No of rows are : " + rows.size());	
	}
	
	
	public static void particular_row_column(WebDriver driver,int row,int column)
	{
		WebElement baseTable = driver.findElement(By.tagName("table"));
		  
		 //To find third row of table
		 WebElement tableRow = baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+row+"]"));
        String rowtext = tableRow.getText();
		 System.out.println("Third row of table : "+rowtext);
		    
		    //to get 3rd row's 2nd column data
		    WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+row+"]/td["+column+"]"));
		    String valueIneed = cellIneed.getText();
		    System.out.println("Cell value is : " + valueIneed); 
	}
}
	
	


