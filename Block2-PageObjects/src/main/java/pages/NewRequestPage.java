package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NewRequestPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public NewRequestPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private final By REQUEST_TITLE_FIELD = By.xpath("//*[@data-testid='cs-new-request-title']//input");
    private final By DESCRIPTION_FIELD = By.xpath("//textarea[@name='description']");
    private final By CATEGORY = By.xpath("//*[@data-testid='cs-new-request-category']");
    private final By HIGH_PRIORITY_BUTTON = By.xpath("//input[@name='priority' and @value='HIGH']/ancestor::label[1]");
    private final By NEXT_BUTTON = By.xpath("//button[@data-testid='cs-new-request-wizard-next']");
    private final By STREET_ADDRESS_FIELD = By.xpath("//*[@data-testid='cs-new-request-street-address']//input[@aria-invalid='false']");
    private final By CITY_FIELD = By.xpath("//input[@name='city']");
    private final By POSTAL_CODE_FIELD = By.xpath("//input[@name='postalCode']");
    private final By LOCATION_DESCRIPTION_FIELD = By.xpath("//input[@name='locationText']");
    private final By CATEGORY_BUTTON = By.xpath("//*[@id='mui-component-select-category']");
    private final By ROADS_AND_INFRASTRUCTURE_DROPDOWN = By.xpath("//*[@data-value='roads-and-infrastructure']");
    private final By EMAIL_FIELD = By.xpath("//input[@name='email']");
    private final By PHONE_FIELD = By.xpath("//input[@name='phone']");
    private final By AGREE_TERMS_FIELD = By.xpath("//*[text()='I agree to the terms and conditions']");
    private final By SUBMIT_REQUEST_BUTTON = By.xpath("//button[@data-testid='cs-new-request-wizard-submit']");
    private final By SUCCESS_MESSAGE = By.xpath("//*[@data-testid='cs-form-submit-success']");
    private final By ERROR_MESSAGE = By.xpath("//*[@data-testid='cs-form-submit-error']");
    private final By WIZARD = By.xpath("//*[@data-testid='cs-new-request-wizard']");
    private final By BACK_BUTTON = By.xpath("//button[@data-testid='cs-new-request-wizard-back']");

    public void fillInBasicInfo(String title, String description, String category) {

        driver.findElement(REQUEST_TITLE_FIELD).sendKeys(title);
        driver.findElement(DESCRIPTION_FIELD).sendKeys(description);
        driver.findElement(CATEGORY).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[@data-value='" + category + "']")
        )).click();
        driver.findElement(HIGH_PRIORITY_BUTTON).click();
        driver.findElement(NEXT_BUTTON).click();
    }

    public void fillInLocationDetails(String streetAddress, String city,String postalCode, String locationDescription){

        driver.findElement(STREET_ADDRESS_FIELD).sendKeys(streetAddress);
        driver.findElement(CITY_FIELD).sendKeys(city);
        driver.findElement(POSTAL_CODE_FIELD).sendKeys(postalCode);
        driver.findElement(LOCATION_DESCRIPTION_FIELD).sendKeys(locationDescription);
        driver.findElement(NEXT_BUTTON).click();
    }

    public void fillInContactInformation(String email, String phone){
        driver.findElement(EMAIL_FIELD).sendKeys(email);
        driver.findElement(PHONE_FIELD).sendKeys(phone);
        driver.findElement(NEXT_BUTTON).click();
    }

    public void fillAdditionalDetails() {
        driver.findElement(AGREE_TERMS_FIELD).click();
        driver.findElement(NEXT_BUTTON).click();
    }

    public void fillReviewSubmit(){

        driver.findElement(SUBMIT_REQUEST_BUTTON).click();
    }

    public boolean isDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(WIZARD)
        ).isDisplayed();
    }

    public void goBack(){
        driver.findElement(BACK_BUTTON).click();
    }

}
