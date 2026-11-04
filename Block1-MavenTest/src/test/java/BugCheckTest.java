import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BugCheckTest {

    @Test
    public void testBugCheckLoginButtonText() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.get("http://localhost:5173/login");

        WebElement administratorButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='cs-prefill-administrator']")));
        administratorButton.click();

        WebElement loginButton = driver.findElement(By.xpath("//button[@data-testid='cs-login-submit']"));
        loginButton.click();

        // 2. Отиваме в Testing Flags

        WebElement testingFlagsMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@href='/admin/testing-flags']")
        ));
        testingFlagsMenu.click();

        // 3. Включваме флага „Login Button Text Wrong“

        WebElement masterSwitch = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(), 'Master Control')]/ancestor::div[contains(@class, 'MuiAlert')]//span[contains(@class, 'MuiSwitch-root')]")
        ));
        masterSwitch.click();

        // 4. Търсим и активираме флаг „Login Button Text Wrong“ чрез полето за търсене (вижда се на снимката долу вляво)
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@placeholder='Search flags...']")
        ));
        searchBox.sendKeys("Login Button Text Wrong");

        // Кликваме върху превключвателя на намерените резултати за този флаг

        WebElement flagSwitch = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(), 'Login Button Text Wrong')]/ancestor::tr//span[contains(@class, 'MuiSwitch-root')] | //*[contains(text(), 'Login Button Text Wrong')]/following::span[contains(@class, 'MuiSwitch-root')][1]")
        ));
        flagSwitch.click();

     //    5. Излизаме от системата (Logout) от потребителското меню в горния десен ъгъл
        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//header//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-sizeMedium css-1deacqj'][2]")
        ));
        userIcon.click();

        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@data-testid='cs-user-logout']")
        ));
        logoutButton.click();

        // 6. Връщаме се на Login страницата
        driver.get("http://localhost:5173/login");
        WebElement buggedLoginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='cs-login-submit']")));

        // 7. Проверка: тестът ТРЯБВА ДА ПАДНЕ тук с ясно съобщение, защото флагът е променил текста на бутона
        Assertions.assertEquals("Login", buggedLoginButton.getText(),
                "ГРЕШКА: Тестът падна успешно, защото флагът 'Login Button Text Wrong' е активен и промени текста на бутона!");

        // ⚠️ Тъй като тестът няма try/finally и ще падне на горния ред,
        // след като затворите браузъра, не забравяйте ръчно да изключите флага от панела!
        driver.quit();
    }
}
