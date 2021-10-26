package org.test;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BowserLaunch extends BaseClass {
	@Test(dataProvider="sample")
	public static void enterCredentials(String username,String password) {
	  
		browserLaunch("https://adactinhotelapp.com/");
		Date d =new Date();
		System.out.println(d);
		
		AdactinLogin a= new AdactinLogin();
		WebElement username2 = a.getUsername();
		sendkeys(username2, username);
		
		WebElement password2 = a.getPassword();
		sendkeys(password2, password);
		
		Date d1 = new Date();
		System.out.println(d1);

	}
    @DataProvider(name="sample")
	public static  Object[][] data() throws IOException{
		return new Object[][] {
			//{"Gowthaman","722HAM"}
			{"SuguAravind","sugu@3005"}
		
	
		
		};	
		
	}
}
