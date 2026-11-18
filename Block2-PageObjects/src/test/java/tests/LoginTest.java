package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLoginPage() {

        driver.get(BASE_URL);

        WebElement loginPageHeading = driver.findElement(By.xpath("//div//h1[text()='City Services Login']"));
        WebElement loginButtonText = driver.findElement(By.xpath("//button[@data-testid='cs-login-submit']"));

        Assertions.assertEquals("City Services Login", loginPageHeading.getText(), "BUG DETECTED: Incorrect login page");
        Assertions.assertEquals("Login", loginButtonText.getText(), "BUG DETECTED: Incorrect Submit button");
    }



}

//public class LoginTests extends BaseTest {
//    private static final String CITIZEN_EMAIL = "john@example.com";
//    private static final String PASSWORD = "password123";
//
//    private LoginPage loginPage;
//    private Header header;
//
//    @BeforeEach
//    void openLoginPage() {
//        loginPage = new LoginPage(driver, wait, BASE_URL).open();
//        header = new Header(driver, wait);
//    }
//
//    @Test
//    void citizenLogsInSuccessfully() {
//        loginPage.login(CITIZEN_EMAIL, PASSWORD);
//
//        wait.until(ExpectedConditions.urlContains("/dashboard"));
//        Assertions.assertTrue(header.isDisplayed(), "Header is not displayed after login");
//        Assertions.assertEquals("CITIZEN", header.getUserRole(), "Wrong role in the user menu");
//
//        header.logout();
//        Assertions.assertTrue(loginPage.isLoginButtonDisplayed(), "Login page is not shown after logout");
//    }
//
//    @Test
//    void wrongPasswordShowsError() {
//        loginPage.login(CITIZEN_EMAIL, "wrongPassword");
//
//        Assertions.assertFalse(loginPage.getErrorMessage().isBlank(), "Error message is empty");
//        Assertions.assertTrue(driver.getCurrentUrl().contains("/login"), "User left the login page");
//    }
//}
