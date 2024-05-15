package optiomaxAppTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ThemeToggleTest {
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
	public void testSwitchToDarkMode() throws InterruptedException {

		Thread.sleep(3000);

		// Clicking on the theme toggle button to switch to dark mode
		WebElement toggleButton = driver.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[1]/div"));
		toggleButton.click();

		Thread.sleep(5000);

		// Verifying dark mode is applied
		String bodyBackgroundColor = driver.findElement(By.tagName("body")).getCssValue("background-color");
		// Assert.assertTrue(bodyBackgroundColor.equals("rgb(60, 64, 66)") ||
		// bodyBackgroundColor.equals("#000000"), "Dark mode is not applied");

		Thread.sleep(3000);

	}

	@Test(priority = 2)
	public void testSwitchToLightMode() throws InterruptedException {

		Thread.sleep(3000);

		// Clicking on the theme toggle button to switch to light mode
		WebElement toggleButton = driver.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[1]/div"));
		toggleButton.click();

		Thread.sleep(5000);

		// Verifying light mode is applied
		String bodyBackgroundColor = driver.findElement(By.tagName("body")).getCssValue("background-color");
		// Assert.assertTrue(bodyBackgroundColor.equals("rgb(255, 255, 255)") ||
		// bodyBackgroundColor.equals("#ffffff"), "Light mode is not applied");

		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void testThemePersistenceAfterRefresh() throws InterruptedException {

		Thread.sleep(3000);

		// Switching to dark mode
		testSwitchToDarkMode();

		// Refreshing the page
		driver.navigate().refresh();

		Thread.sleep(5000);

		// Verifying dark mode is persisted after refresh
		String bodyBackgroundColor = driver.findElement(By.tagName("body")).getCssValue("background-color");
		// Assert.assertTrue(bodyBackgroundColor.equals("rgb(0, 0, 0)") ||
		// bodyBackgroundColor.equals("#000000"), "Dark mode is not persisted after
		// refresh");

		Thread.sleep(3000);
	}

	@Test(priority = 4)
	public void testSmoothTransitionBetweenModes() throws InterruptedException {

		Thread.sleep(3000);

		// Clicking on the theme toggle button to switch between modes
		WebElement toggleButton = driver.findElement(By.xpath("/html/body/main/div/header/nav/div/div[3]/div[1]/div"));
		toggleButton.click();
		toggleButton.click();

		// add assertions or verifications
	}

	@AfterClass
	public void tearDown() {
		// Closing the browser
		if (driver != null) {
			driver.quit();
		}
	}
}
