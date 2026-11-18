package tests;

import base.BaseTest;
import components.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LoginPage;
import pages.MyRequestPage;
import pages.NewRequestPage;

public class NewRequestTest extends BaseTest {

    @Test
    public void createHighPriorityRequestTest() {

        LoginPage loginPage = new LoginPage(driver, wait);
        Header header = new Header(driver, wait);
        MyRequestPage myRequestsPage = new MyRequestPage(driver, wait);
        NewRequestPage newRequestPage = new NewRequestPage(driver, wait);

        loginPage.open();

        WebElement citizenButton = wait.until(ExpectedConditions.elementToBeClickable(  //mot sur
                By.xpath("//div[@class='MuiBox-root css-0']/p[text()='Citizen']")
        ));
        citizenButton.click();

        WebElement loginButton = driver.findElement
                (By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-colorPrimary MuiButton-fullWidth MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-colorPrimary MuiButton-fullWidth css-1bkoi5y']"));
        loginButton.click();


        loginPage.CitizenRoleLogin();
        header.openNewRequests();

        String requestTitle = "Sewage pipe break out"; //+ System.currentTimeMillis();

        newRequestPage
                .fillInBasicInfo(requestTitle, "Sewage pipe is flooding the street - Podpolkovnik Kalitin 23 in city Of varna", "water-and-utilities" );

        newRequestPage
                .fillInLocationDetails("Podpolkovnik Kalitin 23", "Varna", "9010", "At the right side");

        newRequestPage
                .fillInContactInformation("te@gmail.com", "08973452233");

        newRequestPage
                .fillAdditionalDetails();
        newRequestPage
                .fillReviewSubmit();

        header.openMyRequests();

        myRequestsPage.openRequest(requestTitle);

        Assertions.assertEquals(
                "SUBMITTED", myRequestsPage.getRequestStatus(),
                "BUG DETECTED: Request status is not SUBMITTED!"
        );

        Assertions.assertEquals(
                "HIGH", myRequestsPage.getRequestPriority(),
                "BUG DETECTED: Request priority is not HIGH!"
        );
    }
}
