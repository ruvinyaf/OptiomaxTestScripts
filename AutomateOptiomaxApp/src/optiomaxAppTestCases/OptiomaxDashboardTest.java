package optiomaxAppTestCases;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class OptiomaxDashboardTest {
	WebDriver driver;

	@BeforeTest
	public void setup() throws InterruptedException {
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

		WebElement sidebaricon = driver.findElement(By.xpath("/html/body/main/div/header/nav/div/div[1]/button[1]"));
		sidebaricon.click();

		Thread.sleep(5000);
	}

	@AfterTest
	public void tearDown() {
		// Close the driver
		driver.quit();
	}

	@Test
	public void verifySidebarOptionsAccessible() throws InterruptedException {

		Thread.sleep(3000);

		// Locate sidebar options and verify each option is accessible
		WebElement sidebar = driver.findElement(By.xpath("/html/body/main/div/div/aside/div"));
		// Add test logic for checking each option's accessibility
	}

	@Test
	public void verifySidebarVisibilityOnAllPages() throws InterruptedException {

		Thread.sleep(3000);

		// Verify that the sidebar is visible on different pages
		WebElement sidebar = driver.findElement(By.xpath("/html/body/main/div/div/aside/div"));
		Assert.assertTrue(sidebar.isDisplayed(), "Sidebar should be visible on all pages");
	}

	@Test
	public void verifySearchBarFunctionality() throws InterruptedException {

		Thread.sleep(3000);

		// Verify search bar functionality
		WebElement searchBar = driver.findElement(By.name("search"));
		searchBar.sendKeys("Search Query");
		searchBar.submit();
		// Add assertions to verify search results
	}

	@Test
	public void verifyThemeToggleFunctionality() throws InterruptedException {

		Thread.sleep(3000);

		// Toggle dark mode and refresh the page
		WebElement themeToggle = driver.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[1]/div"));
		themeToggle.click();
		driver.navigate().refresh();
		// Add assertions to verify dark mode persists

		Thread.sleep(3000);

		WebElement sidebaricon1 = driver.findElement(By.xpath("/html/body/main/div/header/nav/div/div[1]/button[1]"));
		sidebaricon1.click();

		Thread.sleep(5000);
	}

	@Test
	public void testDarkModeStatePersistsOnPageRefresh() throws InterruptedException {

		Thread.sleep(3000);

		// Toggle dark mode and refresh the page
		WebElement themeToggle = driver.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[1]/div"));
		themeToggle.click();
		driver.navigate().refresh();
		// Add assertions to verify dark mode persists

		Thread.sleep(3000);

		WebElement sidebaricon1 = driver.findElement(By.xpath("/html/body/main/div/header/nav/div/div[1]/button[1]"));
		sidebaricon1.click();

		Thread.sleep(5000);
	}

	@Test
	public void verifyNotificationsBellFunctionality() throws InterruptedException {

		Thread.sleep(3000);

		// Locate the notifications bell and verify its functionality
		WebElement notificationsBell = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/button[3]"));
		notificationsBell.click();
		// Add assertions to verify notifications work correctly
	}

	@Test
	public void verifyUserProfileAccess() throws InterruptedException {

		Thread.sleep(3000);

		// Locate and verify access to the user profile
		WebElement userProfile = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/button[4]/img"));
		userProfile.click();
		// Add assertions to verify profile access
	}

	@Test
	public void verifyAccessToApps() throws InterruptedException {

		Thread.sleep(3000);

		// Locate and verify access to applications
		WebElement apps = driver.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/button[3]"));
		apps.click();
		// Add assertions to verify access to apps
	}

//    @Test
//    public void verifyRoleSubOptionUnderUserManagement() throws InterruptedException {
//    	
//    	Thread.sleep(3000);
//    	
//        // Locate 'User Management' and the 'Role' sub-option
//        WebElement userManagement = driver.findElement(By.xpath("/html/body/main/div/div/aside/div/ul/li[2]/a[1]/div"));
//        
//        Thread.sleep(3000);
//        WebElement roleSubOption = userManagement.findElement(By.xpath("/html/body/main/div/div/aside/div/ul/li[2]/ul[2]/li[1]/a"));
//        roleSubOption.click();
//        // Add assertions to verify the 'Role' sub-option works correctly
//        
//    }

	@Test
	public void verifyRoleSubOptionUnderUserManagement() throws InterruptedException {
		// Locate 'User Management' and verify the dropdown expansion
		WebElement userManagement = driver
				.findElement(By.xpath("/html/body/main/div/div/aside/div/ul/li[2]/ul[2]/li[1]/a"));

		// Click to expand the User Management dropdown
		userManagement.click();

		// Wait for the dropdown sub-options to be visible
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement roleSubOption = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/main/div/div/aside/div/ul/li[2]/ul[2]/li[1]/a")));

//        // Interact with the 'Role' sub-option
//        roleSubOption.click();
//        // Add assertions or further testing logic here
	}

	@Test
	public void verifyUsersSubOptionUnderUserManagement() throws InterruptedException {

		Thread.sleep(3000);

		// Locate 'User Management' and the 'Users' sub-option
		WebElement userManagement = driver.findElement(By.xpath("/html/body/main/div/div/aside/div/ul/li[2]/a[1]/div"));
		Thread.sleep(3000);
		WebElement usersSubOption = userManagement
				.findElement(By.xpath("/html/body/main/div/div/aside/div/ul/li[2]/ul[2]/li[2]/a"));
		usersSubOption.click();
		// Add assertions to verify the 'Users' sub-option works correctly
	}

	@Test
	public void verifyOrganizationSubOptionUnderConfig() throws InterruptedException {

		Thread.sleep(3000);

		// Locate 'Config' and the 'Organization' sub-option
		WebElement config = driver.findElement(By.xpath("/html/body/main/div/div/aside/div/ul/li[3]/a[1]/div"));

		Thread.sleep(3000);
		WebElement organizationSubOption = config
				.findElement(By.xpath("/html/body/main/div/div/aside/div/ul/li[3]/ul[2]/li/a"));

		Thread.sleep(3000);
		organizationSubOption.click();

		// Add assertions to verify the 'Organization' sub-option works correctly
	}

	@Test
	public void verifyAccessToApplicationsFromTopBar() throws InterruptedException {

		Thread.sleep(3000);

		// Locate and verify access to applications from the top bar
		WebElement topBar = driver.findElement(By.xpath("/html/body/main/div/header/nav/div"));
		Thread.sleep(3000);
		WebElement applications = topBar.findElement(By.xpath(""));
		Thread.sleep(3000);
		applications.click();
		// Add assertions to verify access to applications

	}

}