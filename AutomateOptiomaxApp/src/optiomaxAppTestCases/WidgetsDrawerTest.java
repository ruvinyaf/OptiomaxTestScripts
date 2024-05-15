package optiomaxAppTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WidgetsDrawerTest {
	private WebDriver driver;

	@BeforeClass
	public void setUp() throws InterruptedException {
		// Setup ChromeDriver or other WebDriver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Janodya\\eclipse-workspace\\AutomateOptiomaxApp\\Resources Files\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Navigate to the web page
		driver.get("http://app.optiomax.com/");

		WebElement emailField = driver.findElement(By.id("email"));
		WebElement passwordField = driver.findElement(By.id("password"));
		WebElement rememberMeCheckbox = driver.findElement(By.id("remember"));
		WebElement signInButton = driver
				.findElement(By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button"));

		emailField.sendKeys("chamoddushyantha2017@gmail.com");
		passwordField.sendKeys("UMwI4u3w");

		// Check the "Remember me" checkbox
		rememberMeCheckbox.click();

		// Click the sign-in button
		signInButton.click();

		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void verifyWidgetsDrawerIcon() {
		WebElement drawerIcon = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[2]/button"));
		Assert.assertTrue(drawerIcon.isDisplayed(), "Widgets drawer icon is not displayed");
	}

	@Test(priority = 2)
	public void verifyWidgetsButtonFuctionality() {
		WebElement drawerIcon = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[2]/button"));
		drawerIcon.click();
	}

	@Test(priority = 3)
	public void verifyNavigationToAnalyticsSection() throws InterruptedException {

		driver.navigate().refresh();

		WebElement drawerIcon = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[2]/button"));
		drawerIcon.click();

		Thread.sleep(3000);

		// Click on Analytics category
		WebElement analyticsCategory = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[3]/div/div/div[1]/div/p[1]"));
		analyticsCategory.click();

		// Assert navigation to Analytics section
//        String pageTitle = driver.getTitle(); 
//        Assert.assertEquals(pageTitle, "Analytics Page", "Did not navigate to Analytics section");
	}

	@Test(priority = 4)
	public void verifyNavigationToBillingsSection() {

		driver.navigate().refresh();

		WebElement drawerIcon = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[2]/button"));
		drawerIcon.click();

		// Click on Billings category
		WebElement billingsCategory = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[3]/div/div/div[1]/div/p[2]"));
		billingsCategory.click();
		// Assert navigation to Billings section
//        String pageTitle = driver.getTitle(); 
//        Assert.assertEquals(pageTitle, "Billings Page", "Did not navigate to Billings section");
	}

	@Test(priority = 5)
	public void verifyNavigationToTenantSection() {

		driver.navigate().refresh();

		WebElement drawerIcon = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[2]/button"));
		drawerIcon.click();

		// Click on Tenant category
		WebElement tenantCategory = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[3]/div/div/div[1]/div/p[3]"));
		tenantCategory.click();
		// Assert navigation to Tenant section
//        String pageTitle = driver.getTitle();
//        Assert.assertEquals(pageTitle, "Tenant Page", "Did not navigate to Tenant section");
	}

	@Test(priority = 6)
	public void verifySearchBarFunctionality() {

		driver.navigate().refresh();

		WebElement drawerIcon = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[2]/button"));
		drawerIcon.click();

		WebElement searchBar = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[3]/div/form/div/input"));
		searchBar.sendKeys("Analytics");
		WebElement searchButton = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[3]/div/form/div/button"));
		searchButton.click();
		// Implement assertions
	}

	@Test(priority = 7)
	public void verifySearchWithInvalidQuery() {

		driver.navigate().refresh();

		WebElement drawerIcon = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[2]/button"));
		drawerIcon.click();

		WebElement searchBar = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[3]/div/form/div/input"));
		searchBar.sendKeys("Invalid Query");
		WebElement searchButton = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[3]/div/form/div/button"));
		searchButton.click();
//        WebElement searchResultsMessage = driver.findElement(By.xpath(""));
//        Assert.assertTrue(searchResultsMessage.getText().contains("No results found"), "Search with invalid query did not return no results found message");
	}

	@Test(priority = 8)
	public void verifySearchingWithinSpecificCategory() {

		driver.navigate().refresh();

		WebElement drawerIcon = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[2]/button"));
		drawerIcon.click();

		WebElement analyticsCategory = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[3]/div/div/div[1]/div/p[1]"));
		analyticsCategory.click();
		WebElement searchBar = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[3]/div/form/div/input"));
		searchBar.sendKeys("Specific Query");
		WebElement searchButton = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[3]/div/form/div/button"));
		searchButton.click();
		// Implement assertions for searching within specific category
	}

	@Test(priority = 9)
	public void verifySelectionOfNonExistentWidget() {

		driver.navigate().refresh();

		WebElement drawerIcon = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[2]/button"));
		drawerIcon.click();

		WebElement searchBar = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[3]/div/form/div/input"));
		searchBar.sendKeys("Non-Existent Widget");
		WebElement searchButton = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[3]/div/form/div/button"));
		searchButton.click();
//        WebElement noResultsMessage = driver.findElement(By.xpath(""));
//        Assert.assertTrue(noResultsMessage.isDisplayed(), "No results message not displayed for non-existent widget");
	}

	@Test(priority = 10)
	public void verifyExcessiveSearchInput() {

		driver.navigate().refresh();

		WebElement drawerIcon = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[2]/button"));
		drawerIcon.click();

		WebElement searchBar = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[3]/div/form/div/input"));
		searchBar.sendKeys("This is a very long search query that exceeds the limit");
		WebElement searchButton = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[3]/div/form/div/button"));
		searchButton.click();
//        WebElement errorMessage = driver.findElement(By.xpath(""));
//        Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed for excessive search input");
	}

	@Test(priority = 11)
	public void verifyWidgetFunctionalityAfterSelection() throws InterruptedException {

		driver.navigate().refresh();

		WebElement drawerIcon = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[2]/button"));
		drawerIcon.click();

		Thread.sleep(3000);

		// Click on Analytics category
		WebElement analyticsCategory = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[3]/div/div/div[1]/div/p[1]"));
		analyticsCategory.click();

		WebElement lineGraphWidget = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[3]/div/div/div[3]/div/div[1]"));
		lineGraphWidget.click();

		Thread.sleep(3000);

		WebElement dataGrid = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div"));
		Assert.assertTrue(dataGrid.isDisplayed(), "Error message not displayed for excessive search input");
		
		// add more assertions

	}

	@AfterClass
	public void tearDown() {
		// Close the WebDriver instance
		driver.quit();
	}
}
