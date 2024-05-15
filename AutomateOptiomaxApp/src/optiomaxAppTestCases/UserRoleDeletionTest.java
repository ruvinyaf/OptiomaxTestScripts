package optiomaxAppTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserRoleDeletionTest {
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
	public void testSuccessfulDeletion() {

		WebElement deleteUserRoleButton = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]/div[1]/div[2]/div/a[3]"));
		deleteUserRoleButton.click();

		// Enter correct input and click delete button
		WebElement inputField = driver.findElement(By.xpath(
				"/html/body/main/div/div/main/div/div/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/form/div/div/input[3]"));
		inputField.sendKeys("New Admin User");
		WebElement deleteButton = driver.findElement(By
				.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/form/button"));
		deleteButton.click();

		// Assert deletion success message or verify the absence of the element after
		// deletion
//        WebElement successMessage = driver.findElement(By.xpath(""));
//        Assert.assertTrue(successMessage.isDisplayed());
	}

	@Test(priority = 2)
	public void testDeletionFailureIncorrectInput() {

		WebElement deleteUserRoleButton = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]/div[1]/div[2]/div/a[3]"));
		deleteUserRoleButton.click();

		// Enter incorrect input and click delete button
		WebElement inputField = driver.findElement(By.xpath(
				"/html/body/main/div/div/main/div/div/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/form/div/div/input[3]"));
		inputField.sendKeys("incorrect role name");
		WebElement deleteButton = driver.findElement(By
				.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/form/button"));
		deleteButton.click();
		
		driver.navigate().refresh();

		// Assert error message or verify the absence of the element after deletion
		// failure
//        WebElement errorMessage = driver.findElement(By.xpath(""));
//        Assert.assertTrue(errorMessage.isDisplayed());
	}

	@Test(priority = 3)
	public void testNoInputDeletion() {

		WebElement deleteUserRoleButton = driver
				.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]/div[1]/div[2]/div/a[3]"));
		deleteUserRoleButton.click();

		// Click delete button without entering any input
		WebElement deleteButton = driver.findElement(By
				.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/form/button"));
		deleteButton.click();

		// Assert error message or verify the absence of the element after deletion
		// failure
//        WebElement errorMessage = driver.findElement(By.xpath(""));
//        Assert.assertTrue(errorMessage.isDisplayed());
		
		WebElement closeButton = driver.findElement(By
				.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/div[1]/button"));
		closeButton.click();

	}

	@Test(priority = 4)
	public void testCloseButtonFunctionality() {
		// Click close button
		WebElement closeButton = driver.findElement(By.xpath(""));
		closeButton.click();
		// Assert that the popup window is closed (you may need to handle the absence of
		// the window)
		Assert.assertFalse(driver.findElements(By.xpath("")).size() > 0);
		
	}

	@Test(priority = 5)
	public void testCloseAfterIncorrectInput() {
		// Enter incorrect input and click close button
		WebElement inputField = driver.findElement(By.xpath(
				"/html/body/main/div/div/main/div/div/div[2]/div[1]/div[3]/div[2]/div/div/div[2]/form/div/div/input[3]"));
		inputField.sendKeys("incorrect role name");
		WebElement closeButton = driver.findElement(
				By.xpath("/html/body/main/div/div/main/div/div/div[2]/div[1]/div[3]/div[2]/div/div/div[2]/div[1]"));
		closeButton.click();
//        // Assert that the popup window is closed (you may need to handle the absence of the window)
//        Assert.assertFalse(driver.findElements(By.xpath("")).size() > 0);

	}

	@AfterClass
	public void tearDown() {
		// Close the browser session
		driver.quit();
	}

}
