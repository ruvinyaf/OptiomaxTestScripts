package optiomaxAppTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserPermissionTest {

	private WebDriver driver;

	@BeforeClass
	public void setUp() throws InterruptedException {
		// Set up WebDriver
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

		driver.get("http://app.optiomax.com/dashboard/Roles");

		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void testAllUserPermissions() throws InterruptedException {

		WebElement permissionButton = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]/div[1]/div[2]/div/a[1]"));
		permissionButton.click();

		Thread.sleep(3000);

		// Verify all user permissions are correctly displayed and can be toggled
		WebElement roleManagementSection = driver.findElement(By.xpath(
				"/html/body/main/div/div/main/div/div/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/form/div/ul/li/ul/li[1]/div[1]/label/div"));
		WebElement userManagementSection = driver.findElement(By.xpath(
				"/html/body/main/div/div/main/div/div/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/form/div/ul/li/ul/li[2]/div[1]/label/div"));

//        // Check Role Management section
//        verifyPermissionsToggle(roleManagementSection);
//
//        // Check User Management section
//        verifyPermissionsToggle(userManagementSection);
	}

	@Test(priority = 2)
	public void testAssignPermissionsToRoles() throws InterruptedException {

		WebElement permissionButton = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]/div[1]/div[2]/div/a[1]"));
		permissionButton.click();

		Thread.sleep(3000);

		// Test the ability to assign permissions to specific roles
		WebElement givePermissionsToToggle = driver.findElement(By.xpath(
				"/html/body/main/div/div/main/div/div/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/form/div/ul/li/ul/li[1]/div[2]/div[4]/label/div"));
		givePermissionsToToggle.click();
		// Assert.assertTrue(givePermissionsToToggle.getAttribute("class").contains("active"));
	}

	@Test(priority = 3)
	public void testUpdateUserRolePermissions() {
		// Verify updating a user role's permissions
		WebElement updateRoleToggle = driver.findElement(By.xpath(""));
		updateRoleToggle.click();
		Assert.assertTrue(updateRoleToggle.getAttribute("class").contains("active"));
	}

	@Test(priority = 4)
	public void testCreateRolePermission() {
		// Test create role permission functionality
		WebElement createRoleToggle = driver.findElement(By.xpath(""));
		createRoleToggle.click();
		Assert.assertTrue(createRoleToggle.getAttribute("class").contains("active"));
	}

	@Test(priority = 5)
	public void testUpdateRolePermission() {
		// Test update role permission functionality
		WebElement updateRoleToggle = driver.findElement(By.xpath(""));
		updateRoleToggle.click();
		Assert.assertTrue(updateRoleToggle.getAttribute("class").contains("active"));
	}

	@Test(priority = 6)
	public void testDeleteRolePermission() {
		// Test delete role permission functionality
		WebElement deleteRoleToggle = driver.findElement(By.xpath(""));
		deleteRoleToggle.click();
		Assert.assertTrue(deleteRoleToggle.getAttribute("class").contains("active"));
	}

	@Test(priority = 7)
	public void testCreateUserPermission() {
		// Test create user permission functionality
		WebElement createUserToggle = driver.findElement(By.xpath(""));
		createUserToggle.click();
		Assert.assertTrue(createUserToggle.getAttribute("class").contains("active"));
	}

	@Test(priority = 8)
	public void testUpdateUserPermission() {
		// Test update user permission functionality
		WebElement updateUserToggle = driver.findElement(By.xpath(""));
		updateUserToggle.click();
		Assert.assertTrue(updateUserToggle.getAttribute("class").contains("active"));
	}

	@Test(priority = 9)
	public void testDeleteUserPermission() {
		// Test delete user permission functionality
		WebElement deleteUserToggle = driver.findElement(By.xpath(""));
		deleteUserToggle.click();
		Assert.assertTrue(deleteUserToggle.getAttribute("class").contains("active"));
	}

	@Test(priority = 10)
	public void testUserStatusChange() {
		// Test user status change functionality
		WebElement userStatusChangeToggle = driver.findElement(By.xpath(""));
		userStatusChangeToggle.click();
		Assert.assertTrue(userStatusChangeToggle.getAttribute("class").contains("active"));
	}

	@Test(priority = 11)
	public void testUserPasswordReset() {
		// Test user password reset functionality
		WebElement userPasswordResetToggle = driver.findElement(By.xpath(""));
		userPasswordResetToggle.click();
		Assert.assertTrue(userPasswordResetToggle.getAttribute("class").contains("active"));
	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		if (driver != null) {
			driver.quit();
		}
	}

	private void verifyPermissionsToggle(WebElement section) {
		// Check if all toggle switches in the section are present and can be toggled
		String[] permissions = { "View", "Create", "Update", "Delete", "Give Permissions to" };
		for (String permission : permissions) {
			WebElement toggleSwitch = section
					.findElement(By.xpath("//div[text()='" + permission + "']/following-sibling::label"));
			toggleSwitch.click(); // Toggle the switch
			Assert.assertTrue(toggleSwitch.getAttribute("class").contains("active")); // Check if the switch is toggled
																						// on
			toggleSwitch.click(); // Toggle back to original state
			Assert.assertFalse(toggleSwitch.getAttribute("class").contains("active")); // Check if the switch is toggled
																						// off
		}
	}
}
