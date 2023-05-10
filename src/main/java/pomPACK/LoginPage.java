package pomPACK;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import pomUtility.Wait;

public class LoginPage 
{	WebDriver driver;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[text()=' Login ']")
	private WebElement login;
	
	
	public LoginPage(WebDriver driver)
	{	
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void verifyUsername(String uname) 
	{
		
		username.sendKeys(uname);
	}
	
	public void verifyPassword(String pword) 
	{
		
		password.sendKeys(pword);
	}
	
	public void verifyLogin()
	{
		Wait.waitForElement("//button[text()=' Login ']",5, driver);
		login.click();
//		boolean b= login.isEnabled();
		
		
	}
}
