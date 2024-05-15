package optiomaxAppTestCases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AppsMenuTest {

	WebDriver driver;

	@BeforeClass
	public void setUp() throws InterruptedException {
		// Setting up Chrome driver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Janodya\\eclipse-workspace\\AutomateOptiomaxApp\\Resources Files\\Chrome Driver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
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
	public void testMenuItemClickableAndHighlighted() {
		WebElement menuItem = driver.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/button[3]"));
//        Actions action = new Actions(driver);
//        action.moveToElement(menuItem).perform();
//        Assert.assertTrue(menuItem.isEnabled(), "Menu item is not clickable");
//        Assert.assertTrue(menuItem.getCssValue("background-color").contains("rgba(0, 0, 0, 0.1)"), "Menu item is not highlighted on hover");
	}

	@Test(priority = 2)
	public void testMenuItemsOrder() throws InterruptedException {
		// Implement test to verify menu items are ordered correctly
		List<WebElement> menuItems = driver
				.findElements(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[3]/div/div[2]"));
		List<String> actualOrder = new ArrayList<>();
		for (WebElement menuItem : menuItems) {
			actualOrder.add(menuItem.getText());
		}

		Thread.sleep(5000);
		List<String> expectedOrder = Arrays.asList("Sales", "Users", "Inbox", "Profile", "Settings", "Products",
				"Pricing", "Billing", "Logout");
		Thread.sleep(5000);
		Assert.assertEquals(actualOrder, expectedOrder, "Menu items are not ordered correctly");
	}

	@Test(priority = 3)
	public void testMenuItemsIcons() {
		// Implement test to verify each menu item displays the correct icon
		WebElement salesIcon = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[3]/div/div[2]/a[1]"));
		// Assert.assertEquals(salesIcon.getAttribute("src"), "expected_sales_icon_url",
		// "Sales menu item does not display correct icon");
	}

	@Test(priority = 4)
	public void testSalesPageNavigation() {
		WebElement salesMenuItem = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[3]/div/div[2]/a[1]"));
		// salesMenuItem.click();
		// Assert.assertEquals(driver.getCurrentUrl(), "expected_sales_page_url", "Sales
		// page is not navigated");
	}

	// Implement other page navigation tests for Users, Inbox, Profile, Settings,
	// Products, Pricing, Billing, Logout

	@Test(priority = 5)
	public void testUsersPageNavigation() {
		WebElement usersMenuItem = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[3]/div/div[2]/a[2]"));
//        usersMenuItem.click();
//        Assert.assertEquals(driver.getCurrentUrl(), "expected_Users_page_url", "Users page is not navigated");
	}

	@Test(priority = 6)
	public void testIndoxPageNavigation() {
		WebElement inboxMenuItem = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[3]/div/div[2]/a[3]"));
//        inboxMenuItem.click();
//        Assert.assertEquals(driver.getCurrentUrl(), "expected_Inbox_page_url", "Inbox page is not navigated");
	}

	@Test(priority = 7)
	public void testProfilePageNavigation() {
		WebElement profileMenuItem = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[3]/div/div[2]/a[4]"));
//        profileMenuItem.click();
//        Assert.assertEquals(driver.getCurrentUrl(), "expected_Profile_page_url", "Profile page is not navigated");
	}

	@Test(priority = 8)
	public void testSettingsPageNavigation() {
		WebElement settingsMenuItem = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[3]/div/div[2]/a[5]"));
//        settingsMenuItem.click();
//        Assert.assertEquals(driver.getCurrentUrl(), "expected_Settings_page_url", "Settings page is not navigated");
	}

	@Test(priority = 9)
	public void testProductsPageNavigation() {
		WebElement productsMenuItem = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[3]/div/div[2]/a[6]"));
//        productsMenuItem.click();
//        Assert.assertEquals(driver.getCurrentUrl(), "expected_Products_page_url", "Products page is not navigated");
	}

	@Test(priority = 10)
	public void testPricingPageNavigation() {
		WebElement pricingMenuItem = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[3]/div/div[2]/a[7]"));
//        pricingMenuItem.click();
//        Assert.assertEquals(driver.getCurrentUrl(), "expected_Pricing_page_url", "Pricing page is not navigated");
	}

	@Test(priority = 11)
	public void testBillingPageNavigation() {
		WebElement billingMenuItem = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[3]/div/div[2]/a[8]"));
//        billingMenuItem.click();
//        Assert.assertEquals(driver.getCurrentUrl(), "expected_Billing_page_url", "Billing page is not navigated");
	}

	@Test(priority = 12)
	public void testLogoutPageNavigation() {
		WebElement logoutMenuItem = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[3]/div/div[2]/a[9]"));
//        logoutMenuItem.click();
//        Assert.assertEquals(driver.getCurrentUrl(), "expected_Logout_page_url", "Logout page is not navigated");
	}

	@Test(priority = 13)
	public void testUnauthorizedPageAccess() {
		// Implement test to verify behavior when a user is not logged in and tries to
		// navigate to a page using the menu
		// You may need to log out the user before testing this scenario
		// Then try to access a page and verify if the user is redirected to the login
		// page or some other page indicating unauthorized access
	}

	@Test(priority = 14)
	public void testMenuResponsiveness() {
		// Implement test to verify menu's responsiveness on different screen sizes
		// You can use WebDriver's window resizing feature to test responsiveness
		Dimension smallScreen = new Dimension(480, 800);
		driver.manage().window().setSize(smallScreen);
		// Verify menu behavior on small screen
		// Restore window size after the test
		driver.manage().window().maximize();
	}

	@Test(priority = 15)
	public void testQuickMenuItemClicks() {
		// Implement test to verify behavior when quickly clicking through each menu
		// item
		// Need to add a slight delay between clicks using Thread.sleep() to simulate
		// quick clicks
		WebElement salesMenuItem = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[3]/div/div[2]/a[1]"));
		WebElement usersMenuItem = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[3]/div/div[2]/a[2]"));
		WebElement inboxMenuItem = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[3]/div/div[2]/a[3]"));
//        // Click each menu item quickly
//        salesMenuItem.click();
//        // Add a slight delay
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        usersMenuItem.click();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        inboxMenuItem.click();

	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}

// Remind to add assertions
