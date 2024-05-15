package optiomaxAppTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddNewUsersTest {

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

		driver.get("http://app.optiomax.com/dashboard/users");

		Thread.sleep(6000);
    }

    @Test(priority = 1)
    public void testAllInputFieldsDisplayed() throws InterruptedException {
    	
    	addUser();
    	
    	Thread.sleep(5000);
    	
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div[1]/label")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div[2]/label")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div[3]/label")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[1]/label")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[3]/button")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[2]/label")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[4]/label")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[2]/div/label/div/p[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/button")).isDisplayed());

        driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div[1]/button")).click(); 
    }

    @Test(priority = 2)
    public void testValidUserInformationCanBeSaved() throws InterruptedException {
    	
    	//addUser();
    	
    	driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/button")).click();
    	
    	Thread.sleep(5000);
    	
        driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div[1]/input")).sendKeys("testuser");
        driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div[2]/input")).sendKeys("testuser@example.com");
        driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div[3]/input")).sendKeys("Test User");
        driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[1]/input")).sendKeys("1234567890");
//        driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[3]/button")).sendKeys("Admin");
        
        WebElement roleDropdown = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[3]/button"));
        roleDropdown.click();
        roleDropdown.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[3]/div[2]/div/ul/li[2]/div/input")).click();
        Assert.assertEquals(roleDropdown.getAttribute("value"), "new admin");
        
        driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[3]/button")).click();
        
        driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[2]/input")).sendKeys("123 Test Street");
        driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[4]/textarea")).sendKeys("This is a test user.");

        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/button")).click();

        // Add assertions to verify user is saved
        WebElement successMessage = driver.findElement(By.id("successMessage"));
        Assert.assertTrue(successMessage.isDisplayed());
        
        Assert.assertTrue(successMessage.isDisplayed());
        
        Thread.sleep(3000);
        
       driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div[1]/button")).click();
    }

    @Test(priority = 3)
    public void testSaveUserWithOptionalFieldsBlank() throws InterruptedException {
    	
    	WebElement addNewUserButton = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/button"));
    	addNewUserButton.click();
    	
        WebElement username = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div[1]/input"));
        WebElement email = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div[2]/input"));
        WebElement name = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div[3]/input"));
        WebElement phoneNumber = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[1]/input"));
        WebElement roleDropdown = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[3]/button"));
        WebElement address = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[2]/input"));
        WebElement selectRole = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[3]/div[2]/div/ul/li[2]/div/input"));
        WebElement title = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div[2]/h3"));
        
        username.sendKeys("testuser2");
        email.sendKeys("testuser2@example.com");
        name.sendKeys("Test User 2");
        phoneNumber.sendKeys("1234567890");
        roleDropdown.click();
        selectRole.click();
        title.click();
        address.sendKeys("123 Test Street");

        WebElement saveButton = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/button"));
        saveButton.click();

        // Add assertions to verify user is saved
//        WebElement successMessage = driver.findElement(By.id("successMessage"));
//        Assert.assertTrue(successMessage.isDisplayed());
        
        clear();
        
        Thread.sleep(3000);
        
       WebElement closeButton = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div[1]/button"));
       closeButton.click();
       
    }
    
    @Test(priority = 4)
    public void testRoleCanBeAddedToUser() {
    	
    	driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/button")).click();
    	
        WebElement roleDropdown = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[3]/button"));
        roleDropdown.click();
        roleDropdown.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[3]/div[2]/div/ul/li[2]/div/input")).click();
        Assert.assertEquals(roleDropdown.getAttribute("value"), "new admin");
        
        clear();
    }
    
    @Test(priority = 5)
    public void testImageUpload() {
    	
    	driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/button")).click();
    	
        WebElement uploadElement = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[2]/div/label/div"));
        uploadElement.sendKeys("C:\\Users\\Janodya\\Downloads\\img.png");

        driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/button")).click();

        // Add assertions to verify image upload is successful
//        WebElement successMessage = driver.findElement(By.id("successMessage"));
//        Assert.assertTrue(successMessage.isDisplayed());
        
        clear();

    }

//    @Test(priority = 6)
//    public void testOnlySupportedFileTypesCanBeUploaded() {
//    	
//    	driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/button")).click();
//    	
//        WebElement uploadElement = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[2]/div/label/div"));
//        uploadElement.sendKeys("C:\\Users\\Janodya\\Downloads\\Test.txt");
//
//        driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/button")).click();
//
////        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
////        Assert.assertTrue(errorMessage.isDisplayed());
//        
//        clear();
//    }
//
//    @Test(priority = 7)
//    public void testImageResolutionRestriction() {
//    	
//    	driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/button")).click();
//    	
//        WebElement uploadElement = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[2]/div/label/div"));
//        uploadElement.sendKeys("path/to/large/image.jpg");
//
//        driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/button")).click();
//
////        WebElement errorMessage = driver.findElement(By.xpath("errorMessage"));
////        Assert.assertTrue(errorMessage.isDisplayed());
//        
//        clear();
//    }
//
//    @Test(priority = 8)
//    public void testValidRolesAssignment() {
//    	
//    	driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/button")).click();
//    	
//        WebElement roleDropdown = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[3]/button"));
//        roleDropdown.click();
//        roleDropdown.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[3]/div[2]/div/ul/li[1]/div/input")).click();
//        Assert.assertEquals(roleDropdown.getAttribute("value"), "super admin");
//
//        roleDropdown.click();
//        roleDropdown.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[3]/div[2]/div/ul/li[2]/div/input")).click();
//        Assert.assertEquals(roleDropdown.getAttribute("value"), "new admin");
//        
//        clear();
//    }
//
////    @Test(priority = 9)
////    public void testErrorOnAlreadyAssignedRole() {
////    	
////    	    	driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/button")).click();
////    	
////        // Assuming user already has a role assigned
////        WebElement roleDropdown = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[3]/button"));
////        roleDropdown.click();
////        roleDropdown.findElement(By.xpath("//option[. = 'Admin']")).click();
////        driver.findElement(By.id("saveButton")).click();
////
////        // Assign the same role again
////        roleDropdown.click();
////        roleDropdown.findElement(By.xpath("//option[. = 'Admin']")).click();
////        driver.findElement(By.id("saveButton")).click();
////
////        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
////        Assert.assertTrue(errorMessage.isDisplayed());
////        
////        clear();
////    }
//
//    @Test(priority = 10)
//    public void testErrorOnInvalidCharacters() {
//    	
//    	driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/button")).click();
//    	
//        driver.findElement(By.id("user_name")).sendKeys("invalid@username");
//        driver.findElement(By.id("email")).sendKeys("invalidemail");
//        driver.findElement(By.id("contact_no")).sendKeys("invalidphone");
//
//        driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/button")).click();
//
////        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
////        Assert.assertTrue(errorMessage.isDisplayed());
//        
//        clear();
//    }
//
//    @Test(priority = 11)
//    public void testErrorOnDuplicateEmail() {
//    	
//    	driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/button")).click();
//    	
//    	driver.findElement(By.id("user_name")).sendKeys("testuser3");
//        driver.findElement(By.id("email")).sendKeys("duplicate@example.com");
//        driver.findElement(By.id("contact_no")).sendKeys("Test User 3");
//
//        driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/button")).click();
//
////        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
////        Assert.assertTrue(errorMessage.isDisplayed());
//        
//        clear();
//    }
//
//    @Test(priority = 12)
//    public void testErrorOnInvalidPhoneNumberFormat() {
//    	
//    	driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/button")).click();
//    	
//    	driver.findElement(By.id("user_name")).sendKeys("testuser4");
//        driver.findElement(By.id("email")).sendKeys("testuser4@example.com");
//        driver.findElement(By.id("contact_no")).sendKeys("invalidphone");
//
//        driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/button")).click();
//
////        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
////        Assert.assertTrue(errorMessage.isDisplayed());
//        
//        clear();
//    }
    
    public void addUser() {
    	driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/button")).click();
    	
    }
    
	public void clear() {
        driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div[1]/input")).clear();
        driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div[2]/input")).clear();
        driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div[3]/input")).clear();
        driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[1]/input")).clear();
        driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[3]/button")).clear();
        driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[2]/input")).clear();
        driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[4]/textarea")).clear();
         
        
        WebElement username = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div[1]/input"));
        WebElement email = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div[2]/input"));
        WebElement name = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div[3]/input"));
        WebElement phoneNumber = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[1]/input"));
        WebElement roleDropdown = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[3]/button"));
        WebElement address = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[2]/input"));
        WebElement description = driver.findElement(By.xpath("/html/body/main/div/div/main/div/div/div[1]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[4]/textarea"));
        
        username.clear();
        email.clear();        
        name.clear();
        phoneNumber.clear();
        roleDropdown.clear();
        address.clear();
        description.clear();
	}
	
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

