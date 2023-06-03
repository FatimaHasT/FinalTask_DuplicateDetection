package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Scanner;

public class
SmokeTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;


    @Parameters("browser")
    @BeforeTest
    public void setup(final String browser) {
        driver = WebDriverSetup.getWebDriver(browser);
        driver.get("https://demo.placelab.com/");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Parameters({ "email", "password" })
    @Test

    public void testValidLoginandDD(final String email, final String password) {

        loginPage.verifyLoginPageElements();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.submitLoginForm();

        final String expectedRole = "Group Admin";
        final String actualRole = homePage.getUserRole();
        Assert.assertEquals(actualRole, expectedRole, "Validate user role for logged in user.");

        driver.findElement(By.id("create-menu")).click();

        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.id("duplicatedetection")).click();

        try {
            Thread.sleep(10000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));

        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String filePath = "C:\\Users\\semir\\Downloads\\duplicate_detection.txt";
        fileInput.sendKeys(filePath);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//*[@id=\"selects_container\"]/button")).click();

        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        homePage.clickUserRole();
        Assert.assertTrue(homePage.isSignOutLinkDisplayed());

        homePage.clickSignOutLink();
        Assert.assertTrue(loginPage.isLoginFormDisplayed());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }

    @DataProvider(name = "credentials")
    public Object[][] provideCredentials() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        scanner.close();

        return new Object[][] {{ email, password }};
    }
}
