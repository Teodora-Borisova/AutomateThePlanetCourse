import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FieldAgentTest {

    @Test
    public void FieldAgentLogin()  {

            WebDriver driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            driver.get("http://localhost:5173/login");


            WebElement fieldAgentButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@data-testid='cs-prefill-field-agent']")
            ));
            fieldAgentButton.click();

            WebElement loginButton = driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-colorPrimary MuiButton-fullWidth MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-colorPrimary MuiButton-fullWidth css-1bkoi5y']"));
            loginButton.click();


            WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//header//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-sizeMedium css-1deacqj'][2]")
            ));
            userIcon.click();


            WebElement fieldAgendBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@data-testid='cs-user-menu']//span[contains(@class,'MuiChip-label')]")
            ));

            Assertions.assertTrue(fieldAgendBadge.isDisplayed(), "Ролята FILEDAGENT не се показва в менюто!");

            driver.quit();
        }
    }
