package optiomaxAppTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UpdateUserRolesTest {

	WebDriver driver;

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

		Thread.sleep(6000);

		driver.get("http://app.optiomax.com/dashboard/Roles");

		Thread.sleep(6000);

	}
 
	@Test(priority = 1)
	public void testUpdateExistingUserRole() throws InterruptedException {

		WebElement updateButton = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]/div[1]/div[2]/div/a[2]"));
		updateButton.click();

		// Locate and update role fields
		WebElement roleNameField = driver.findElement(By.xpath(
				"/html/body/main/div/div/main/div/div/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/form/div/div[1]/input[2]"));
		roleNameField.clear();
		roleNameField.sendKeys("New Role");

		WebElement roleDescriptionField = driver.findElement(By.xpath(
				"/html/body/main/div/div/main/div/div/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/form/div/div[2]/textarea"));
		roleDescriptionField.clear();
		roleDescriptionField.sendKeys("New Role Description");

		// Click update button
		driver.findElement(
				By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/form/button"))
				.click();

		Thread.sleep(3000);

//        // Assertion for successful update
//        WebElement successMessage = driver.findElement(By.xpath("/div/div/div[2]"));
//        Assert.assertTrue(successMessage.isDisplayed(), "Update successful message not displayed.");
	}

//    @Test(priority = 2)
//    public void testUpdateWithoutPermissions() {
//        // Log out to simulate lack of permissions
//        // This step should be implemented separately in a logout method
//        // Log in with a user without necessary permissions
//        
//        // Repeat steps for updating an existing role
//        
//        // Assertion for failure to update
//        WebElement errorMessage = driver.findElement(By.xpath(""));
//        Assert.assertTrue(errorMessage.isDisplayed(), "Update failed error message not displayed.");
//    }

	@Test(priority = 3)
	public void testUpdateExistingRoleWithPermission() {
		// Log in with necessary permissions

		// Repeat steps for updating an existing role

		// Assertion for successful update
		WebElement successMessage = driver.findElement(By.id("successMessage"));
		Assert.assertTrue(successMessage.isDisplayed(), "Update successful message not displayed.");
	}

//    @Test(priority = 3)
//    public void testUpdateExistingRoleWithPermission() {
//        // Log in with necessary permissions
//        // This step should be implemented separately in a login method
//        
//        // Locate and update role fields
//        WebElement roleNameField = driver.findElement(By.id("roleName"));
//        roleNameField.clear();
//        roleNameField.sendKeys("new role name");
//        
//        WebElement roleDescriptionField = driver.findElement(By.id("roleDescription"));
//        roleDescriptionField.clear();
//        roleDescriptionField.sendKeys("new role description");
//        
//        // Click update button
//        driver.findElement(By.id("updateButton")).click();
//        
//        // Assertion for successful update
//        WebElement successMessage = driver.findElement(By.id("successMessage"));
//        Assert.assertTrue(successMessage.isDisplayed(), "Update successful message not displayed.");
//    }
//
//    @Test(priority = 4)
//    public void testUpdateRoleName() {
//        // Locate and update role name field only
//        WebElement roleNameField = driver.findElement(By.id("roleName"));
//        roleNameField.clear();
//        roleNameField.sendKeys("new role name");
//
//        // Click update button
//        driver.findElement(By.id("updateButton")).click();
//
//        // Assertion for successful update of role name
//        WebElement successMessage = driver.findElement(By.id("successMessage"));
//        Assert.assertTrue(successMessage.isDisplayed(), "Update successful message not displayed.");
//    }
//
//    @Test(priority = 5)
//    public void testUpdateRoleDescription() {
//        // Locate and update role description field only
//        WebElement roleDescriptionField = driver.findElement(By.id("roleDescription"));
//        roleDescriptionField.clear();
//        roleDescriptionField.sendKeys("new role description");
//
//        // Click update button
//        driver.findElement(By.id("updateButton")).click();
//
//        // Assertion for successful update of role description
//        WebElement successMessage = driver.findElement(By.id("successMessage"));
//        Assert.assertTrue(successMessage.isDisplayed(), "Update successful message not displayed.");
//    }
//
//    @Test(priority = 6)
//    public void testEmptyRoleNameUpdate() {
//        // Locate role name field and keep it empty
//        WebElement roleNameField = driver.findElement(By.id("roleName"));
//        roleNameField.clear();
//
//        // Click update button
//        driver.findElement(By.id("updateButton")).click();
//
//        // Assertion for system not allowing updating with an empty role name
//        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
//        Assert.assertTrue(errorMessage.isDisplayed(), "Empty role name error message not displayed.");
//    }
//
//    @Test(priority = 7)
//    public void testDuplicateRoleNameUpdate() {
//        // Locate role name field and enter an existing role name
//        WebElement roleNameField = driver.findElement(By.id("roleName"));
//        roleNameField.clear();
//        roleNameField.sendKeys("existing role name");
//
//        // Click update button
//        driver.findElement(By.id("updateButton")).click();
//
//        // Assertion for system not allowing updating with an existing role name
//        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
//        Assert.assertTrue(errorMessage.isDisplayed(), "Duplicate role name error message not displayed.");
//    }

	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}
