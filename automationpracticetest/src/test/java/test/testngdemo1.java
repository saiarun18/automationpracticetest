package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;
import pages.Homepage;
import pages.advancedpage;
import pages.contactpage;
import pages.documentdetailspage;
import pages.faq;
import pages.helppage;
import pages.orderspage;
import pages.searchresultpage;
import pages.shoppingcart;
import sourcemethods.SeMethods;
import sourcemethods.TestBase;

public class testngdemo1 extends SeMethods {

	public testngdemo1() throws IOException {
		super();
	}
	
	//Verify the application launched successfully
	@Test(priority = 1)
	public void verifyapplaunch() throws InterruptedException {
		startApp("chrome","URL");
	    actual("actualURL");
	    System.out.println(actual("actualURL"));
		String expected = driver.getCurrentUrl();
		assertEquals(actual("actualURL"), expected);
		System.out.println("Application launched successfully");
	}

   //Verify the faq page loaded successfully
    @Test(priority=2)
	public void verifyfaqpageload() throws InterruptedException
	{
		waitElementtobevisible(Homepage.FAQlink(driver));
		Homepage.FAQlink(driver).click();
		WebElement overview= faq.Documentdeliverylink(driver);
		waitElementtobevisible(faq.Overviewlink(driver));
	    Assert.assertTrue(overview.isDisplayed());	
	    Thread.sleep(2000);
	}
	
	// Verfiy the help page loaded successfully from the Home page 
	@Test(priority=3)
	public void verifyhelppageload() throws InterruptedException
	{
		waitElementtobevisible(Homepage.Helplink(driver));
		Homepage.Helplink(driver).click();
		WebElement simplesearch=helppage.simplesearchlink(driver);
	waitElementtobevisible(helppage.simplesearchlink(driver));
	Assert.assertTrue(simplesearch.isDisplayed());
	Thread.sleep(3000);
	}
	
	// Verfiy the Orders page loaded successfully from the Home page 
	@Test(priority=4)
	public void verifyorderspageload() throws InterruptedException 
	{
		waitElementtobevisible(Homepage.Orders_link(driver,"orderslink"));
		Homepage.Orders_link(driver, "orderslink").click();
        waitElementtobevisible(orderspage.orderdetails(driver, "orderdetails"));
        Assert.assertTrue(orderspage.orderdetails(driver, "orderdetails").isDisplayed());
        Thread.sleep(3000);
	} 
	
	// Verfiy the Contact page loaded successfully from the Home page 
	@Test(priority=5)
	public void verifycontactpageload() throws InterruptedException
	{
	 Thread.sleep(3000);
	 try{
		Homepage.contact_link(driver, "contactlink").isDisplayed();
		Thread.sleep(3000);
			Homepage.contact_link(driver, "contactlink").click();
			Thread.sleep(2000);
			waitElementtobevisible(contactpage.contactinfo(driver, "contactinfo"));
			Assert.assertTrue(contactpage.contactinfo(driver, "contactinfo").isDisplayed());
		}
		catch(Exception e )
		{
			System.out.println("Contact page is not applicable for this county");
		}
	}
	

	// Verify the user redirected to Advanced page successfully while click on Advanced button in the Super search Home page.
	@Test(priority=6)
    public void verifyadvancedpage() throws InterruptedException
    {
		Homepage.homelinknew(driver, "homelinknew").click();
	    waitElementtobevisible(Homepage.homelinknew(driver, "homelinknew"));
	    Thread.sleep(3000);
	    waitElementtobevisible(Homepage.Advancedbutton(driver));
		Homepage.Advancedbutton(driver).click();
		Thread.sleep(5000);
		String Advanced_URL=driver.getCurrentUrl();
		String expected_URL="https://ocmideeds.com/#advanced";
		Assert.assertEquals(Advanced_URL,expected_URL);
		Thread.sleep(4000);
		driver.manage().deleteAllCookies();	
   }
	
	// Verify the documents are available in the search results page as per Rows per page section set up. 
	@Test(priority=7)
	public void verifyrowsperpage() throws InterruptedException
	{
		waitElementtobevisible(Homepage.homelink(driver));
		Homepage.homelinknew(driver, "homelinknew").click();
		Thread.sleep(3000);
		Homepage.searchtextbox(driver).sendKeys("smith");
		waitElementtobevisible(Homepage.searchbutton(driver));
		Homepage.searchbutton(driver).click();
		waitElementtobevisible(searchresultpage.Rowsperpage(driver));
		Thread.sleep(5000);
		searchresultpage.Rowsperpage(driver).click();
		Thread.sleep(5000);
		selectDropDownUsingText(searchresultpage.Rowsperpage(driver), "rowsperpageoption");
		waitElementtobevisible(searchresultpage.documentlist(driver));
		Thread.sleep(5000);
		int row=searchresultpage.Searchresult_totaldocuments(driver, "totaldocuments").size();
		System.out.println(row);
		String s1=searchresultpage.rows("rowsperpageoption");
		System.out.println(s1);
		String s2=Integer.toString(row);
		System.out.println(s2);
		Assert.assertTrue(s1.equals(s2));	
		driver.manage().deleteAllCookies();
	}
	
	
	
		//Verify the Search results are showing in the Search result page.	
		@Test(priority=8)
		public void verifysearchresult() throws InterruptedException
		{
			waitElementtobevisible(Homepage.homelink(driver));
			Homepage.homelink(driver).click();
			Thread.sleep(2000);
			Homepage.searchtextbox(driver).sendKeys("smith");
			waitElementtobevisible(Homepage.searchbutton(driver));
			Homepage.searchbutton(driver).click();
			Thread.sleep(2000);
			waitElementtobevisible(searchresultpage.Addtocartbuttons(driver));
			Assert.assertTrue(searchresultpage.Addtocartbuttons(driver).isDisplayed());
			driver.manage().deleteAllCookies();		
		} 

		//Verify Document details page loaded 
			@Test(priority = 9)
			public void verify_documentdetails() throws InterruptedException
			{
		        Homepage.homelink(driver).click();
				waitElementtobevisible(Homepage.homelink(driver));
				Thread.sleep(2000);
				Homepage.searchtextbox(driver).sendKeys("smith");
				waitElementtobevisible(Homepage.searchbutton(driver));
				Homepage.searchbutton(driver).click();
				Thread.sleep(3000);
				waitElementtobevisible(searchresultpage.documentlist(driver));
				searchresultpage.documentlist(driver).click();
		        documentdetailspage.documentdetail(driver).isDisplayed();
		        driver.manage().deleteAllCookies();
		        Thread.sleep(2000);
			} 
				
			//Verify the user redirect back to the search result page while click on "Back" button in the document details page.
			@Test(priority = 10)
			public void verify_backbutton_documentdetails() throws InterruptedException
			{
				
				waitElementtobevisible(Homepage.homelink(driver));
				Homepage.homelink(driver).click();
				Homepage.searchtextbox(driver).sendKeys("smith");
				Thread.sleep(3000);
				waitElementtobevisible(Homepage.searchbutton(driver));
				Homepage.searchbutton(driver).click();
				Thread.sleep(3000);
				waitElementtobevisible(searchresultpage.documentlist(driver));
				searchresultpage.documentlist(driver).click();
				waitElementtobevisible(documentdetailspage.documentdetail(driver));
				Thread.sleep(6000);
		        documentdetailspage.documentdetail(driver).isDisplayed();
		        Thread.sleep(3000);
		        waitElementtobevisible(documentdetailspage.backbutton(driver));
		        documentdetailspage.backbutton(driver).click();
		        Thread.sleep(4000);
		        waitElementtobevisible(searchresultpage.documentlist(driver));
		        searchresultpage.documentlist(driver).isDisplayed();
		        driver.manage().deleteAllCookies();
		        Thread.sleep(3000);
			} 
			
			@Test(priority=11)
	public void verifydocumentaddedtocart() throws InterruptedException {
		// Homepage.homelink(driver).click();
		waitElementtobevisible(Homepage.homelink(driver));
		Homepage.searchtextbox(driver).sendKeys("sam");
		Thread.sleep(5000);
		waitElementtobevisible(Homepage.searchbutton(driver));
		Homepage.searchbutton(driver).click();
		Thread.sleep(4000);
		waitElementtobevisible(searchresultpage.Addtocartbuttons(driver));
		Thread.sleep(2000);
		Assert.assertTrue(searchresultpage.Addtocartbuttons(driver).isDisplayed());
		searchresultpage.Addtocartbuttons(driver).click();
		Thread.sleep(3000);
		try {
			searchresultpage.Regular_Addtocart(driver, "Regular_Addtocart").isDisplayed();
			Thread.sleep(3000);
			searchresultpage.Regular_Addtocart(driver, "Regular_Addtocart").click();
		} catch (Exception e) {
			waitElementtobevisible(searchresultpage.Cartbutton(driver));
		}
		Thread.sleep(3000);
		waitElementtobevisible(searchresultpage.Cartbutton(driver));
		searchresultpage.Cartbutton(driver).click();
		Thread.sleep(3000);
		try {
			shoppingcart.paypalbutton(driver).isDisplayed();
			shoppingcart.paypalbutton(driver).click();
			waitElementtobevisible(shoppingcart.paypay_login(driver));
			Assert.assertTrue(shoppingcart.paypay_login(driver).isDisplayed(),
					"Redirected to Paypal payment page successfully");
			driver.manage().deleteAllCookies();
			Thread.sleep(2000);
		} catch (Exception e) {
			shoppingcart.paybutton(driver, "paybutton").click();
			Thread.sleep(4000);
			switchtoframe(0);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@type='email']")).sendKeys("success");
			driver.manage().deleteAllCookies();	
		}
	}
		
	/*
		
			//Verify the log in hyperlink in the Super search Home page successfully redirected to the Alerts application.
		
			@Test(priority=9)
			public void veriyalertspage_redirection() throws InterruptedException
			{
				waitElementtobevisible(Homepage.homelink(driver));
				Thread.sleep(3000);
				Homepage.Alert_login_link(driver).click();
				Thread.sleep(3000);
				switchtotab();
				String Alert_URL=driver.getCurrentUrl();
				System.out.println(Alert_URL);
				close();	
			}
		
	

	@Test(priority = 2)
	public void verifylink() throws InterruptedException {
		
		Homepage.Advancedbutton(driver).click();
		
		Thread.sleep(5000);
		
		java.util.List<WebElement> links = driver.findElements(By.tagName("label"));
		
		for (int i = 1; i<links.size(); i++)
		{
			links.get(i).getText().compareTo(anotherString)
		}
		
		System.out.println("Total no. of links" + links.size());
	}

	
	 * @Test(priority=2) public void orderslink() throws Exception {
	 * 
	 * waitElementtobevisible(Homepage.orderslink(driver));
	 * Homepage.orderslink(driver).click();
	 * 
	 * Thread.sleep(10000);
	 * 
	 * waitElementtobevisible(Homepage.homelink(driver));
	 * Homepage.homelink(driver).click();
	 * 
	 * 
	 * }*/
	 
}
