package OrangeHRM.HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;

public class LoginPage extends BaseClass{
	
	private WebElement getUserName = driver.findElement(By.id("txtUsername"));
	private WebElement getPassword = driver.findElement(By.id("txtPassword"));
	private WebElement getSubmitButton = driver.findElement(By.id("btnLogin"));
	
	
	
	
	
	public String setLoginsPageTitle(){
		return driver.getTitle();
	}
	
	public WebElement setUserName() {
		return getUserName;
		
	}
	
	public WebElement setPassword() {
		return getPassword;
		
	}
	
	public void clickOnSubmit() {
		 getSubmitButton.click();;
		
	}

}
