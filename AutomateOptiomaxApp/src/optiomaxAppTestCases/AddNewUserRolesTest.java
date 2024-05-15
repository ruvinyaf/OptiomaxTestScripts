package optiomaxAppTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddNewUserRolesTest {
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

//		WebElement sidebaricon = driver.findElement(By.xpath("/html/body/main/div/header/nav/div/div[1]/button[1]"));
//		sidebaricon.click();
//		
//		Thread.sleep(5000);
//		
//        WebElement userManagement = driver.findElement(By.xpath("/html/body/main/div/div/aside/div/ul/li[2]/ul[2]/li[1]/a"));
//        
//        // Click to expand the User Management dropdown
//        userManagement.click();
//        
//        // Wait for the dropdown sub-options to be visible
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement roleSubOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div/div/aside/div/ul/li[2]/ul[2]/li[1]/a")));
//        roleSubOption.click();

	}

	@Test(priority = 1)
	public void verifyAddNewUserRoleButton() throws InterruptedException {
		// Click on the "Add New User Role" button
		WebElement addNewUserRoleButton = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/button"));
		addNewUserRoleButton.click();

		// Assert that the Add New User Role popup window is displayed
//        WebElement addNewUserRolePopup = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]"));
//        Assert.assertTrue(addNewUserRolePopup.isDisplayed());

		WebElement closeButton = driver.findElement(
				By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div[1]/button"));
		closeButton.click();

	}

	@Test(priority = 2)
	public void testAddNewUserRoleWithValidInputs() {
		WebElement addNewUserRoleButton = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/button"));
		addNewUserRoleButton.click();

		// Fill in the necessary fields with valid data
		WebElement roleNameInput = driver.findElement(By.xpath(
				"/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[1]/input"));
		roleNameInput.sendKeys("Test Role");

		WebElement roleDescriptionInput = driver.findElement(By.xpath(
				"/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[1]/input"));
		roleDescriptionInput.sendKeys("Test Description");

		WebElement createButton = driver.findElement(
				By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/button"));
		createButton.click();
		// Assert that the new user role is added successfully
		WebElement successMessage = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[1]"));
		Assert.assertTrue(successMessage.isDisplayed());

		clear();

		WebElement closeButton = driver.findElement(
				By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div[1]/button"));
		closeButton.click();
	}

	@Test(priority = 3)
	public void testAddNewUserRoleWithInvalidInputs() {
		WebElement addNewUserRoleButton = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/button"));
		addNewUserRoleButton.click();

		// Fill in the necessary fields with invalid data
		WebElement roleNameInput = driver.findElement(By.xpath(
				"/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[1]/input"));
		roleNameInput.sendKeys("");
		// Click on the "Save" button

		WebElement roleDescriptionInput = driver.findElement(By.xpath(
				"/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[2]/textarea"));
		roleDescriptionInput.sendKeys("Test Description");

		WebElement createButton = driver.findElement(
				By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/button"));
		createButton.click();

		clear();

		// Assert that an error message is displayed
//        WebElement errorMessage = driver.findElement(By.xpath("errorMessage"));
//        Assert.assertTrue(errorMessage.isDisplayed());

		WebElement closeButton = driver.findElement(
				By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div[1]/button"));
		closeButton.click();
	}

	@Test(priority = 4)
	public void verifyErrorHandlingWithoutRequiredFields() throws InterruptedException {
		WebElement addNewUserRoleButton = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/button"));
		addNewUserRoleButton.click();

		Thread.sleep(3000);
		
		// Attempt to save without filling in required fields
		WebElement createButton = driver.findElement(
				By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/button"));
		createButton.click();

		clear();

		WebElement closeButton = driver.findElement(
				By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div[1]/button"));
		closeButton.click();

		// Assert that error messages are displayed for each required field
//        WebElement roleNameError = driver.findElement(By.id("roleNameError"));
//        WebElement permissionsError = driver.findElement(By.id("permissionsError"));
//        Assert.assertTrue(roleNameError.isDisplayed() && permissionsError.isDisplayed());
	}

	@Test(priority = 5)
	public void testAddNewUserRoleWithDuplicateRoleName() throws InterruptedException {

		driver.navigate().refresh();

		Thread.sleep(3000);

		WebElement addNewUserRoleButton = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/button"));
		addNewUserRoleButton.click();

		WebElement roleNameInput = driver.findElement(By.xpath(
				"/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[1]/input"));
		roleNameInput.sendKeys("hr manager");

		WebElement roleDescriptionInput = driver.findElement(By.xpath(
				"/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[1]/input"));
		roleDescriptionInput.sendKeys("Test Description");

		WebElement createButton = driver.findElement(
				By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/button"));
		createButton.click();

		// Assert that an error message is displayed
//        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
//        Assert.assertTrue(errorMessage.isDisplayed());

		clear();

		WebElement closeButton = driver.findElement(
				By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div[1]/button"));
		closeButton.click();
	}

	@Test(priority = 6)
	public void verifyAddingRoleWithIdenticalData() throws InterruptedException {

		driver.navigate().refresh();

		Thread.sleep(3000);

		WebElement addNewUserRoleButton = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/button"));
		addNewUserRoleButton.click();

		WebElement roleNameInput = driver.findElement(By.xpath(
				"/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[1]/input"));
		roleNameInput.sendKeys("main admin");

		WebElement roleDescriptionInput = driver.findElement(By.xpath(
				"/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[1]/input"));
		roleDescriptionInput.sendKeys("test");

		clear();

//        WebElement createButton = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/button"));
//        createButton.click();
//        
//        // Assert that an error message is displayed
////        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
////        Assert.assertTrue(errorMessage.isDisplayed());
//        
//        WebElement closeButton = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div[1]/button"));
//        closeButton.click();
	}

//
	
//	@Test(priority = 7)
//	public void testAddNewUserRoleWithoutNecessaryPermissions() throws InterruptedException {
//
//		driver.navigate().refresh();
//
//		Thread.sleep(3000);
//
//		WebElement addNewUserRoleButton = driver
//				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/button"));
//		addNewUserRoleButton.click();
//
//		WebElement roleNameInput = driver.findElement(By.xpath(
//				"/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[1]/input"));
//		roleNameInput.sendKeys("main admin");
//
//		WebElement roleDescriptionInput = driver.findElement(By.xpath(
//				"/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[1]/input"));
//		roleDescriptionInput.sendKeys("test");
//
//		clear();
//
//        WebElement createButton = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/button"));
//        createButton.click();
//
//        // Assert that an error message is displayed
////        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
////        Assert.assertTrue(errorMessage.isDisplayed());
//        
//        WebElement closeButton = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div[1]/button"));
//        closeButton.click();
//	}

	@Test(priority = 8)
	public void verifyAddingUserRoleWithSpecialCharacters() throws InterruptedException {

		driver.navigate().refresh();

		Thread.sleep(3000);

		WebElement addNewUserRoleButton = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/button"));
		addNewUserRoleButton.click();

		WebElement roleNameInput = driver.findElement(By.xpath(
				"/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[1]/input"));
		roleNameInput.sendKeys("!@#$%^&*()");

		WebElement roleDescriptionInput = driver.findElement(By.xpath(
				"/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[1]/input"));
		roleDescriptionInput.sendKeys("test");

		clear();

//        WebElement createButton = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/button"));
//        createButton.click();
//    	
//        // Assert that the new user role is added successfully
////        WebElement successMessage = driver.findElement(By.id("successMessage"));
////        Assert.assertTrue(successMessage.isDisplayed());
//        
//        WebElement closeButton = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div[1]/button"));
//        closeButton.click();
	}

	public void clear() {
		WebElement roleNameInput = driver.findElement(By.xpath(
				"/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[1]/input"));
		roleNameInput.clear();

		WebElement roleDescriptionInput = driver.findElement(By.xpath(
				"/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div/div[1]/input"));
		roleDescriptionInput.clear();
	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}
