package optiomaxAppTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProfileMenuTest {
	private WebDriver driver;

	@BeforeClass
	public void setUp() throws InterruptedException {
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

		WebElement sidebaricon = driver.findElement(By.xpath("/html/body/main/div/header/nav/div/div[1]/button[1]"));
		sidebaricon.click();

		Thread.sleep(5000);

	}

	@Test(priority = 1)
	public void testProfileImageFunctionality() {
		WebElement profileImage = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/button[4]/img"));
		// Add assertions to test profile image functionality
		Assert.assertTrue(profileImage.isDisplayed(), "Profile image is not displayed.");

	}

	@Test(priority = 2)
	public void testAccessMyProfile() {
		WebElement profileDropdown = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/button[4]/img"));
		profileDropdown.click();
		WebElement myProfileOption = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[4]/div/ul[1]/li[1]/a"));
		myProfileOption.click();
		// Add assertions to verify navigation to My Profile page
//        Assert.assertEquals(driver.getCurrentUrl(), "expected_url_of_my_profile_page", "My Profile page is not opened.");

	}

	@Test(priority = 3)
	public void testAccessAccountSettings() {
		WebElement profileDropdown = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/button[4]/img"));
		profileDropdown.click();
		WebElement accountSettingsOption = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[4]/div/ul[1]/li[2]/a"));
		accountSettingsOption.click();
		// Add assertions to verify navigation to Account Settings page
//        Assert.assertEquals(driver.getCurrentUrl(), "expected_url_of_account_settings_page", "Account Settings page is not opened.");

	}

	@Test(priority = 4)
	public void testAccessMyLikes() {
		WebElement profileDropdown = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/button[4]/img"));
		profileDropdown.click();
		WebElement myLikesOption = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[4]/div/ul[2]/li[1]/a"));
		myLikesOption.click();
		// Add assertions to verify navigation to My Likes page
//        Assert.assertEquals(driver.getCurrentUrl(), "expected_url_of_my_likes_page", "My Likes page is not opened.");

	}

	@Test(priority = 5)
	public void testAccessCollections() {
		WebElement profileDropdown = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/button[4]/img"));
		profileDropdown.click();
		WebElement collectionsOption = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[4]/div/ul[2]/li[2]/a"));
		collectionsOption.click();
		// Add assertions to verify navigation to Collections page
//        Assert.assertEquals(driver.getCurrentUrl(), "expected_url_of_collections_page", "Collections page is not opened.");
	}

	@Test(priority = 6)
	public void testSignOut() {
		WebElement profileDropdown = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/button[4]/img"));
		profileDropdown.click();
		WebElement signOutOption = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[4]/div/ul[3]/li/form/button"));
		signOutOption.click();
		// Add assertions to verify successful sign out
//        Assert.assertEquals(driver.getCurrentUrl(), "expected_url_of_sign_in_page", "Sign out failed.");

	}

	@Test(priority = 7)
	public void testAccessDropdownMenuWithoutUserInteraction() {
		WebElement profileDropdown = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/button[4]/img"));
		Actions actions = new Actions(driver);
		actions.moveToElement(profileDropdown).perform();
		// Add assertions to verify that the dropdown menu does not open
		// Assert.assertFalse(driver.findElement(By.xpath("//xpath_to_dropdown_menu")).isDisplayed(),
		// "Dropdown menu opened without user interaction.");
		// Add more assertions if needed

	}

	@Test(priority = 8)
	public void testVisibilityOfUserNameAndEmail() {
		WebElement userName = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[4]/div/div/span[1]"));
		WebElement email = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[4]/div/div/span[2]"));
		// Add assertions to verify visibility of user's name and email address
		Assert.assertTrue(userName.isDisplayed(), "User name is not displayed.");
		Assert.assertTrue(email.isDisplayed(), "Email address is not displayed.");

	}

	@Test(priority = 9)
	public void testSmoothOperationOfDropdownMenu() {

		WebElement profileIcon = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/button[4]/img"));
		profileIcon.click();
		// Wait for the dropdown menu to be visible
		WebElement dropdownMenu = driver.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[4]"));
		Assert.assertTrue(dropdownMenu.isDisplayed(), "Dropdown menu should be visible");
	}

	@Test(priority = 10)
	public void testNonResponsivenessOfDropdownMenuOnClickingOutside() {
		WebElement profileDropdown = driver
				.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/button[4]/img"));
		profileDropdown.click();
		// WebElement outsideElement =
		// driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div/div/h3"));
		// outsideElement.click();
		// Add assertions to verify that the dropdown menu does not close
		// Assert.assertTrue(driver.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[4]")).isDisplayed(),
		// "Dropdown menu closed on clicking outside.");

	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
