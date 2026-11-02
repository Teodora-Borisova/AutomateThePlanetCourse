import org.jspecify.annotations.Nullable;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;


import java.util.List;
import java.util.Set;

public class LoginPageTest {

    @Test
    public void verifyLoginPage() {


        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:5173/login");

        WebElement loginTitleText = driver.findElement(By.xpath("//h1[text()='City Services Login']"));
        WebElement loginButtonText = driver.findElement(By.xpath("//button[@data-testid='cs-login-submit']"));

        Assertions.assertEquals("City Services Login", loginTitleText.getText(),"The Login Title Text is not correct");
        Assertions.assertEquals("Login", loginButtonText.getText(), "The Login Button text is not as expected");

        driver.quit();

    }

}
