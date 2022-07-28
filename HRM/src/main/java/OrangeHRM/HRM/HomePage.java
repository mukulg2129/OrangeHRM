package OrangeHRM.HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;

public class HomePage extends BaseClass{
	
	private WebElement getDashboardMessage = driver.findElement(By.xpath("//div[@class='head']/h1"));
	private WebElement getPerformanceTab = driver.findElement(By.id("menu__Performance"));
	private WebElement getPerformanceConfigureTab = driver.findElement(By.id("menu_performance_Configure"));
	private WebElement getPerformanceConfigureKpiTab = driver.findElement(By.id("menu_performance_searchKpi"));
	
	
	
	
	
	public String setWelcomeMessage() {
		return getDashboardMessage.getText();
		
	}
	
	public WebElement clickOnPerformanceTab() {
		return getPerformanceTab;
		
	}
	public WebElement clickOnPerformanceConfigureTab() {
		return getPerformanceConfigureTab;
		
	}
	public WebElement clickOnPerformanceConfigureKpiTab() {
		return getPerformanceConfigureKpiTab;
		
	}
	
	

}
