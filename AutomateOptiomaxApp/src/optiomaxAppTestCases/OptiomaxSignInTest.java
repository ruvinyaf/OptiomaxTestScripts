package optiomaxAppTestCases;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class OptiomaxSignInTest {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		// Set the path to the ChromeDriver executable
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Janodya\\eclipse-workspace\\AutomateOptiomaxApp\\Resources Files\\Chrome Driver\\chromedriver.exe");

		// Initialize Chrome browser
		driver = new ChromeDriver();

		// Open the Optiomax app website
		driver.get("http://app.optiomax.com/");

		// Maximize browser
		driver.manage().window().maximize();
	}

	@AfterTest
	public void teardown() {
		// Close the browser
		driver.quit();
	}

	private void signIn(String email, String password, boolean rememberMe) throws InterruptedException {
		// Locate email, password fields, and sign-in button
		WebElement emailField = driver.findElement(By.id("email"));
		WebElement passwordField = driver.findElement(By.id("password"));
		WebElement rememberMeCheckbox = driver.findElement(By.id("remember"));
		WebElement signInButton = driver
				.findElement(By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/form/button"));

		Thread.sleep(3000);

		// Clear and set values for email and password fields
		emailField.clear();
		emailField.sendKeys(email);
		passwordField.clear();
		passwordField.sendKeys(password);

		// Check the "Remember me" checkbox
		if (rememberMe) {
			rememberMeCheckbox.click();
		}

		// Click the sign-in button
		signInButton.click();

		Thread.sleep(3000);
	}

	@Test
	public void testValidEmailAndPassword() throws InterruptedException {

		Thread.sleep(3000);

		signIn("chamoddushyantha2017@gmail.com", "UMwI4u3w", false);

		Thread.sleep(3000);

		// Assert successful login
//        WebElement dashboard = driver.findElement(By.xpath("/html/body/main/div/header/nav/div/div[1]/a/img")); 
//        Assert.assertTrue(dashboard.isDisplayed());

	}

	@Test
	public void testCorrectEmailIncorrectPassword() throws InterruptedException {
		signIn("chamoddushyantha2017@gmail.com", "InCorrect123", false);
		// Assert error message or failure
		// WebElement errorMessage = driver.findElement(By.id("errorMessage"));
		// Assert.assertTrue(errorMessage.isDisplayed());

		Thread.sleep(5000);
	}

	@Test
	public void testIncorrectEmailCorrectPassword() throws InterruptedException {
		signIn("invalid.email@domain.com", "UMwI4u3w", false);
		// Assert error message or failure
		// WebElement errorMessage = driver.findElement(By.id("errorMessage"));
		// Assert.assertTrue(errorMessage.isDisplayed());

		Thread.sleep(5000);
	}

	@Test
	public void testCorrectEmailEmptyPassword() throws InterruptedException {
		signIn("chamoddushyantha2017@gmail.com", "", false);
		// Assert error message or failure
		// WebElement errorMessage = driver.findElement(By.id("errorMessage"));
		// Assert.assertTrue(errorMessage.isDisplayed());

		Thread.sleep(5000);
	}

	@Test
	public void testCorrectPasswordEmptyEmail() throws InterruptedException {
		signIn("", "chamoddushyantha2017@gmail.com", false);
		// Assert error message or failure
		// WebElement errorMessage = driver.findElement(By.id("errorMessage"));
		// Assert.assertTrue(errorMessage.isDisplayed());

		Thread.sleep(5000);
	}

	@Test
	public void testEmptyEmailEmptyPassword() throws InterruptedException {
		signIn("", "", false);
		// Assert error message or failure
		// WebElement errorMessage = driver.findElement(By.id("errorMessage"));
		// Assert.assertTrue(errorMessage.isDisplayed());

		Thread.sleep(5000);
	}

	@Test
	public void testInvalidEmailFormat() throws InterruptedException {
		signIn("testuser@optimax", "UMwI4u3w", false);
		// Assert error message or failure
		// WebElement errorMessage = driver.findElement(By.id("errorMessage"));
		// Assert.assertTrue(errorMessage.isDisplayed());

		Thread.sleep(5000);
	}

	@Test
	public void testUnregisteredEmail() throws InterruptedException {
		signIn("unregistered.email@domain.com", "ValidPassword123!", false);
		// Assert error message or failure
		// WebElement errorMessage = driver.findElement(By.id("errorMessage"));
		// Assert.assertTrue(errorMessage.isDisplayed());
	}

	@Test
	public void testRememberMeFunctionality() throws InterruptedException {
		// Perform sign-in with "Remember me" checked
		signIn("chamoddushyantha2017@gmail.com", "UMwI4u3w", true);

		// Perform assertions for "Remember me" functionality
		// This may require logging out and then navigating back to the sign-in page to
		// check if the email is prefilled

		Thread.sleep(5000);
	}

//    @Test
//    public void testSpecialCharactersInEmail() throws InterruptedException {
//        signIn("special!char@domain.com", "ValidPassword123!", false);
//        // Assert error message or failure 
//        //WebElement errorMessage = driver.findElement(By.id("errorMessage"));
//        //Assert.assertTrue(errorMessage.isDisplayed());
//    }

	@Test
	public void testLeadingTrailingSpacesInEmail() throws InterruptedException {
		signIn("  valid.email@domain.com  ", "UMwI4u3w", false);
		// Assert error message or failure
		// WebElement errorMessage = driver.findElement(By.id("errorMessage"));
		// Assert.assertTrue(errorMessage.isDisplayed());

		Thread.sleep(5000);
	}

	@Test
	public void testLeadingTrailingSpacesInPassword() throws InterruptedException {
		signIn("chamoddushyantha2017@gmail.com", "  UMwI4u3w  ", false);
		// Assert error message or failure
		// WebElement errorMessage = driver.findElement(By.id("errorMessage"));
		// Assert.assertTrue(errorMessage.isDisplayed());

		Thread.sleep(5000);
	}

	@Test
	public void testInvalidCharactersInEmail() throws InterruptedException {
		signIn("invalid@chars*domain.com", "UMwI4u3w", false);
		// Assert error message or failure
		// WebElement errorMessage = driver.findElement(By.id("errorMessage"));
		// Assert.assertTrue(errorMessage.isDisplayed());

		Thread.sleep(5000);
	}

	@Test
	public void testExceedingMaxLengthInEmail() throws InterruptedException {
		// Generate a long email string
		String longEmail = "longemail".repeat(20) + "@domain.com";
		signIn(longEmail, "ValidPassword123!", false);

		// Assert error message or failure
		// WebElement errorMessage = driver.findElement(By.id("errorMessage"));
		// Assert.assertTrue(errorMessage.isDisplayed());
	}

	@Test
	public void testExceedingMaxLengthInPassword() throws InterruptedException {
		// Generate a long password string
		String longPassword = "longpassword".repeat(10);
		signIn("valid.email@domain.com", longPassword, false);

		// Assert error message or failure
		WebElement errorMessage = driver.findElement(By.id("errorMessage"));
		Assert.assertTrue(errorMessage.isDisplayed());

	}

}
