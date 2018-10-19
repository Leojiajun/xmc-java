package com.xcm.puppy;

import org.testng.annotations.Test;

import com.xcm.puppy.page.LoginPage;

public class AppTest extends BaseTest {
	
	private LoginPage loginPage;

	@Test(alwaysRun = true, dataProvider = "data4Demo", dataProviderClass = com.xcm.puppy.util.StaticDataProvider.class,
			description = "Test Login Scenario")
	public void testApp(String username, String password, String expectation) {
		
		loginPage =  new LoginPage(driver);
		addThinkTime(60000);
		loginPage.login(username, password);
		addThinkTime(60000);
		// Assert if the fact match the expectation
	}
	
	private void addThinkTime(long ms)
	{
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}

}
