package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.documentdetailspage;
import pages.searchresultpage;
import pages.shoppingcart;
import sourcemethods.SeMethods;

public class searchresults extends SeMethods{

	
	//Verify the Search results are showing in the Search result page.
	
public searchresults() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

@Test(priority=1)
public void verifysearchresult() throws InterruptedException
{
	startApp("chrome", "https://ocmideeds.com/");
	waitElementtobevisible(Homepage.homelink(driver));
	Thread.sleep(2000);
	Homepage.searchtextbox(driver).sendKeys("smith");
	waitElementtobevisible(Homepage.searchbutton(driver));
	Homepage.searchbutton(driver).click();
	waitElementtobevisible(searchresultpage.Addtocartbuttons(driver));
	Assert.assertTrue(searchresultpage.Addtocartbuttons(driver).isDisplayed());
	driver.manage().deleteAllCookies();
	
} 

//Verify Document details page loaded 
	@Test(priority = 2)
	public void verify_documentdetails() throws InterruptedException
	{
        Homepage.homelink(driver).click();
		waitElementtobevisible(Homepage.homelink(driver));
		Homepage.searchtextbox(driver).sendKeys("smith");
		waitElementtobevisible(Homepage.searchbutton(driver));
		Homepage.searchbutton(driver).click();
		waitElementtobevisible(searchresultpage.documentlist(driver));
		searchresultpage.documentlist(driver).click();
        documentdetailspage.documentdetail(driver).isDisplayed();
        driver.manage().deleteAllCookies();
        Thread.sleep(2000);
	}
		
	//Verify the user redirect back to the search result page while click on "Back" button in the document details page.
	@Test(priority = 3)
	public void verify_backbutton_documentdetails() throws InterruptedException
	{
		
		waitElementtobevisible(Homepage.homelink(driver));
		Homepage.homelink(driver).click();
		Homepage.searchtextbox(driver).sendKeys("smith");
		waitElementtobevisible(Homepage.searchbutton(driver));
		Homepage.searchbutton(driver).click();
		waitElementtobevisible(searchresultpage.documentlist(driver));
		searchresultpage.documentlist(driver).click();
        documentdetailspage.documentdetail(driver).isDisplayed();
        waitElementtobevisible(documentdetailspage.backbutton(driver));
        documentdetailspage.backbutton(driver).click();
        waitElementtobevisible(searchresultpage.documentlist(driver));
        searchresultpage.documentlist(driver).isDisplayed();
        driver.manage().deleteAllCookies();
	}

// Verify the document is added to the Cart successfully and navigate to the Paypal payment page successfully.

@Test(priority=4)
public void verifydocumentaddedtocart() throws InterruptedException
{
	Homepage.homelink(driver).click();
	waitElementtobevisible(Homepage.homelink(driver));
	Homepage.searchtextbox(driver).sendKeys("smith");
	waitElementtobevisible(Homepage.searchbutton(driver));
	Homepage.searchbutton(driver).click();
	waitElementtobevisible(searchresultpage.Addtocartbuttons(driver));
	Assert.assertTrue(searchresultpage.Addtocartbuttons(driver).isDisplayed());
	searchresultpage.Addtocartbuttons(driver).click();
	waitElementtobevisible(searchresultpage.Cartbutton(driver));
	searchresultpage.Cartbutton(driver).click();
	shoppingcart.paypalbutton(driver).click();
	Assert.assertTrue(shoppingcart.paypay_login(driver).isDisplayed(), "Redirected to Paypal payment page successfully");	
	driver.manage().deleteAllCookies();
	Thread.sleep(2000);
}	
}
