package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.moneyrediffpage;
import sourcemethods.SeMethods;

public class Dynamicwebtable_practice extends SeMethods{

	public Dynamicwebtable_practice() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void findrowsandcolumn() throws InterruptedException
	{	
		startApp("Chrome","URL");
		Thread.sleep(4000);
		moneyrediffpage.rowsandcolumn(driver);	
	}
	
	
	//To identify the particular row and column
	@Test
	public void particular_row_column()
		{
			moneyrediffpage.particular_row_column(driver, 4, 3);
		}
	}
	

