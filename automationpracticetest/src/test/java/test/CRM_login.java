package test;

import java.io.IOException;

import org.testng.annotations.Test;

import crmpages.CRMloginpage;
import sourcemethods.SeMethods;

public class CRM_login extends SeMethods{

	public CRM_login() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void launchapp()
	{
	startApp("chrome", "Freecrmurl");	
	}
	
	
	@Test
	public void userlogin()
	{
		waitElementtobevisible(CRMloginpage.username(driver));
		CRMloginpage.username(driver).sendKeys(list.getProperty("username"));
		waitElementtobevisible(CRMloginpage.password(driver));
		CRMloginpage.password(driver).sendKeys(list.getProperty("password"));
		waitElementtobevisible(CRMloginpage.loginbutton(driver));
		CRMloginpage.loginbutton(driver).click();
				
	}	
}
