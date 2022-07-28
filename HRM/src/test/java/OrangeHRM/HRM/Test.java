package OrangeHRM.HRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Test {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); 
	WebDriver	driver = new ChromeDriver(); 
	driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	driver.findElement(By.id("btnLogin")).click();
	
	Actions a = new Actions(driver);
	a.clickAndHold(driver.findElement(By.id("menu__Performance"))).build().perform();
	a.clickAndHold(driver.findElement(By.id("menu_performance_Configure"))).build().perform();
	a.click(driver.findElement(By.id("menu_performance_searchKpi"))).build().perform();
	
	List<WebElement> jobTitleValues = driver.findElements(By.xpath("//select[@id='kpi360SearchForm_jobTitleCode']/option"));

	String jobTitle = "QA Lead";
	for (WebElement e : jobTitleValues) {
		if (e.getText().equalsIgnoreCase(jobTitle)) {
			e.click();
			break;
		}
	}
	
	driver.findElement(By.id("searchBtn")).click();
	
	List<WebElement> verifySearchResult=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]"));
	for (WebElement e : verifySearchResult) {
		//Thread.sleep(5000);
		String jobTitleF= e.getText();
		System.out.println(jobTitleF);

		Assert.assertEquals(jobTitle, jobTitleF);
	}
	
	

	}

}
