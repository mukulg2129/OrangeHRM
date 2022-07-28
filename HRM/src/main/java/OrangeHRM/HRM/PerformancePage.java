package OrangeHRM.HRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;

public class PerformancePage extends BaseClass {
	
	private WebElement getKpiMessage = driver.findElement(By.xpath("//div[@id='divFormContainer']/div[1]/h1"));
	private WebElement getKpiDropdown = driver.findElement(By.id("kpi360SearchForm_jobTitleCode"));
	private List<WebElement> getDropdownValues = driver.findElements(By.xpath("//select[@id='kpi360SearchForm_jobTitleCode']/option"));
	private WebElement getKpiSearchButton = driver.findElement(By.id("searchBtn"));
	private List<WebElement> getFilterValues = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]"));
	
	
	
	//
	
	public WebElement setKpiMessage() {
		return getKpiMessage;
		
	}
	public void setKpiDropdown() {
		 getKpiDropdown.click();
		
	}
	public List<WebElement> setDropdownValues() {
		return getDropdownValues;
		
	}
	public void setSearchButton() {
		 getKpiSearchButton.click();
		
	}
	public List<WebElement> setFilterValues() {
		return getFilterValues;
		
	}

	

}
