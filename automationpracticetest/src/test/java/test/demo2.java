package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import sourcemethods.SeMethods;

public class demo2 {

	public demo2() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	WebDriver wd;


	public void tablevalue(int i,int j)
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("http://money.rediff.com/gainers/bsc/daily/groupa?"); 
		 wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 WebElement baseTable = wd.findElement(By.tagName("table"));
		  
		 //To find third row of table
		 WebElement tableRow = baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[+i+]"));
        String rowtext = tableRow.getText();
		 System.out.println("Third row of table : "+rowtext);
		    
		    //to get 3rd row's 2nd column data
		    WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[+i+]/td[+j+]"));
		    String valueIneed = cellIneed.getText();
		    System.out.println("Cell value is : " + valueIneed); 
		    wd.close();
	}
	
	public static void main(String[] args) throws IOException {
		
		demo2 d2=new demo2();
		d2.tablevalue(3, 2);
		
		
	}
}
