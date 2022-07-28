package OrangeHRM.HRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import junit.framework.Assert;

public class PerfromancePageTest extends BaseClass {

	LoginPageTest loginPageTest;
	HomePage homePage;
	PerformancePage performancePage;

	@BeforeMethod

	// call browser and login in the application
	public void setup() {
		loginPageTest = new LoginPageTest();
		loginPageTest.setup();
		loginPageTest.getTitle();
		loginPageTest.Login();

	}

	@Test(priority = 0)
	public void perfromanceKpisPage() throws InterruptedException  {

		// redirect to Kpi's Page.

		homePage = new HomePage();
		Actions a = new Actions(driver);
		a.clickAndHold(homePage.clickOnPerformanceTab()).build().perform();
		
		a.clickAndHold(homePage.clickOnPerformanceConfigureTab()).build().perform();
		a.click(homePage.clickOnPerformanceConfigureKpiTab()).build().perform();

		// Validate the Redirection of KpiPage
		performancePage = new PerformancePage();

		String actualText = performancePage.setKpiMessage().getText();
		String expectedText = "Search Key Performance Indicators";

		Assert.assertEquals(actualText, expectedText);

		// validate the Search Key Performance Indicators Functionality.

		Assert.assertEquals(performancePage.setKpiMessage().isEnabled(), true);

		// Filter By Job Title.

		performancePage.setKpiDropdown();

		List<WebElement> jobTitleValues = performancePage.setDropdownValues();

		String jobTitle = prop.getProperty("jobtitle");
		for (WebElement e : jobTitleValues) {
			if (e.getText().equalsIgnoreCase(jobTitle)) {
				e.click();
				break;
			}
		}

		performancePage.setSearchButton();
		//Thread.sleep(5000);

		List<WebElement> verifySearchResult=performancePage.setFilterValues();
		List<WebElement> verifySearchResults=performancePage.setFilterValues();
		//Thread.sleep(5000);
		for (WebElement e : verifySearchResults) {
			
			String jobTitleF= e.getText();
			

			Assert.assertEquals(jobTitle, jobTitleF);
		}

	}

}
