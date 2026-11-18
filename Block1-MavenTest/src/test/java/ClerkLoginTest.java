import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClerkLoginTest {

    @Test
    public void testClerkRoleLogin() {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://localhost:5173/login");


        WebElement clerkButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@data-testid='cs-prefill-clerk']")
        ));
        clerkButton.click();

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-colorPrimary MuiButton-fullWidth MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-colorPrimary MuiButton-fullWidth css-1bkoi5y']"));
        loginButton.click();


        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//header//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-sizeMedium css-1deacqj'][2]")
        ));
        userIcon.click();


        WebElement clerkBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ul[@role='menu']//span[contains(@class, 'MuiChip-label') and (text()='CLERK' or text()='Clerk')]")
        ));

        Assertions.assertTrue(clerkBadge.isDisplayed(), "Ролята CLERK не се показва в менюто!");

        driver.quit();
    }
}
