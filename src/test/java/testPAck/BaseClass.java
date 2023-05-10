package testPAck;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import testUTility.StaticBrowser;
import testUTility.TestProof;

public class BaseClass 
{	
	static WebDriver driver;
	public static ExtentReports report;
	public static ExtentHtmlReporter extents;
	public static ExtentTest logger;
	
	@Parameters({"browser"})
	
	@BeforeTest
	public void setup(String browser)
	{	
		driver=StaticBrowser.browserLaunch(browser, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		this.driver=driver;
		
		report = new ExtentReports();
		
		extents = new ExtentHtmlReporter("test-output\\Reports\\"+System.currentTimeMillis()+"abc.html");
		
		report.attachReporter(extents);
		
		
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\driver\\chromedriver.exe");
//		ChromeOptions options=new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		driver = new ChromeDriver(options); 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if (result.getStatus()== ITestResult.FAILURE)
		{
			String path= TestProof.capturePageScreenshot(driver);
			
			logger.fail("this test is failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			
			
		}
		report.flush();
	}
	
	@AfterTest
	public void teardown()
	{
		//driver.quit();
	}
}
