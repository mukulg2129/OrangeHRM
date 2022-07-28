package OrangeHRM.HRM;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class LoginPageTest extends BaseClass {
	
	LoginPage loginPage;
	HomePage homePage;
	
	
	public LoginPageTest() {super();}

	
	@BeforeMethod
	
	//Call Browser
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		
	}
	
	@Test(priority =0)
	//Get Title of Application
	public void getTitle() {
		String actualTitle= loginPage.setLoginsPageTitle();
		String expectedTitle= "OrangeHRM";
		Assert.assertEquals(actualTitle, expectedTitle );
	}
	@Test(priority = 1)
	//Login in Application
	public void Login() {
		
		String userName=prop.getProperty("username");
		String password=prop.getProperty("password");
		loginPage.setUserName().sendKeys(userName);
		loginPage.setPassword().sendKeys(password);
		loginPage.clickOnSubmit();
		homePage=new HomePage();
		
		//validate the redirection on Home Page after Login.
		
		String actualWelcomeMessage=homePage.setWelcomeMessage();
	    String expectedWelcomeMessage="Dashboard";
		Assert.assertEquals(actualWelcomeMessage, expectedWelcomeMessage);
	}

	//close Browser
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
