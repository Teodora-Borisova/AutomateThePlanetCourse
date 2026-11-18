import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdministratorTest {

    @Test

    public void AdministratorLogin() {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://localhost:5173/login");


        WebElement administratorButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@data-testid='cs-prefill-administrator']")
        ));
        administratorButton.click();

        WebElement loginButton = driver.findElement(By.xpath("//button[@data-testid='cs-login-submit']"));
        loginButton.click();


        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//header//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-sizeMedium css-1deacqj'][2]")
        ));
        userIcon.click();


        WebElement adminBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@data-testid='cs-user-menu']//span[contains(@class,'MuiChip-label')]")
        ));

        Assertions.assertTrue(adminBadge.isDisplayed(), "Ролята ADMINISTRATOR не се показва в менюто!");

        driver.quit();
    }
}
