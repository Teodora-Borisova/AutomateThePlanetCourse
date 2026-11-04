import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SupervisorLoginTest {

    @Test
    public void testCitizenRoleLogin(){

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://localhost:5173/login");


        WebElement supervisorButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@data-testid='cs-prefill-supervisor']")
        ));
        supervisorButton.click();

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-colorPrimary MuiButton-fullWidth MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-colorPrimary MuiButton-fullWidth css-1bkoi5y']"));
        loginButton.click();


        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//header//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-sizeMedium css-1deacqj'][2]")
        ));
        userIcon.click();


        WebElement supervisorBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@data-testid='cs-user-menu']//span[contains(@class,'MuiChip-label')]")
        ));

        Assertions.assertTrue(supervisorBadge.isDisplayed(), "Ролята SUPERVISOR не се показва в менюто!");

        driver.quit();
    }
    }




