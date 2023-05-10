package testPAck;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pomPACK.LoginPage;

public class TC_LogIn_001 extends BaseClass {
	
//	WebDriver driver;
	LoginPage log;	
	
	SoftAssert art;
	
		@BeforeClass
		public void beforeClass()
		{
			log = new LoginPage(driver);
			
			art= new SoftAssert();
		}
		
		@BeforeMethod
		public void beforeMethod()
		{
			
		}
		
		@Test
		public void verifyLogin()
		{
			logger =report.createTest("verifyURL");
			
			log.verifyUsername("Admin");
			
			log.verifyPassword("admin123");
			
			log.verifyLogin();
			
			String expectedResult="https://opensource-demo.orangehrmlive.com/web/index.php/dashboaassdfx";
			
			String actualResult= driver.getCurrentUrl();
			
			art.assertEquals(expectedResult, actualResult);
			
			art.assertAll();
			
			
		}
		
		
		
		@AfterClass
		public void afterClass()
		{
		//	driver.quit();
		}
}
