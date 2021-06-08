package Pages;

import elements.DropDown;
import elements.Input;
import elements.SaveButton;
import elements.TextArea;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewAccountModalPage extends BasePage {

    public NewAccountModalPage(WebDriver driver) {
        super(driver);
    }

    private static final String URL_NEW_ACCOUNT = "https://onliner6.lightning.force.com/lightning/o/Account/new";
    private static final By ACCOUNT_NAME = By.xpath("//*[contains(@class,'highlights slds-clearfix')]/descendant::span[text() ='TestAccount-SalesForce']");
    private static final By ACCOUNT_PHONE = By.xpath("//*[contains(@class,'highlights slds-clearfix')]//descendant::a[text() ='+375 29 800 88 00']");
    private static final By ACCOUNT_ADDRESS = By.xpath("//*[contains(@class,'highlights slds-clearfix')]//descendant::div[text() ='5th Avenue, New York, 36']");
    private static final By ACCOUNT_ADDRESS2 = By.xpath("//*[contains(@class,'highlights slds-clearfix')]//descendant::div[text() ='Minsk, Belarus Хто его знает']");
    private static final By ACCOUNT_STATE = By.xpath("//*[contains(@class,'highlights slds-clearfix')]//descendant::div[text() ='Panama']");
    private static final By ACCOUNT_WEBSITE = By.xpath("//*[contains(@class,'highlights slds-clearfix')]//descendant::a[text() ='www.twt.by']");

    @Step("Open accounts page")
    public NewAccountModalPage openNewAccountPage() {
        driver.get(URL_NEW_ACCOUNT);
        return this;
    }

    @Step("Fill in the information on the account page.")
    public NewAccountModalPage createInformationIntoAccountNewPage
            (String accountName, String website, String option, String description, String phoneNumber,
             String option2, String numberOfEmployees, String billingStreet, String shippingStreet,
             String billingCity, String billingState, String shippingCity, String shippingState,
             String billingZip, String billingCountry, String shippingZip, String shippingCountry) {
        new Input(driver, "Account Name").writeText(accountName);
        new DropDown(driver, "Type").select(option);
        new Input(driver, "Website").writeText(website);
        new TextArea(driver, "Description").writeTextDescription(description);
        new Input(driver, "Phone").writeText(phoneNumber);
        new DropDown(driver, "Industry").select(option2);
        new Input(driver, "Employees").writeText(numberOfEmployees);
        new TextArea(driver, "Billing Street").writeTextDescription(billingStreet);
        new TextArea(driver, "Shipping Street").writeTextDescription(shippingStreet);
        new Input(driver, "Billing City").writeText(billingCity);
        new Input(driver, "Billing State").writeText(billingState);
        new Input(driver, "Shipping City").writeText(shippingCity);
        new Input(driver, "Shipping State").writeText(shippingState);
        new Input(driver, "Billing Zip").writeText(billingZip);
        new Input(driver, "Billing Country").writeText(billingCountry);
        new Input(driver, "Shipping Zip").writeText(shippingZip);
        new Input(driver, "Shipping Country").writeText(shippingCountry);
        return this;
    }

    @Step("Save account")
    public NewAccountModalPage clickSaveButton() {
        new SaveButton(driver).clickSaveButton();
        return this;
    }

    public String getNewAccountName() {
        return driver.findElement(ACCOUNT_NAME).getText();
    }

    public String getNewAccountPhone() {
        return driver.findElement(ACCOUNT_PHONE).getText();
    }

    public String getNewAccountAddress() {
        return driver.findElement(ACCOUNT_ADDRESS).getText();
    }

    public String getNewAccountAddress2() {
        return driver.findElement(ACCOUNT_ADDRESS2).getText();
    }

    public String getNewAccountState() {
        return driver.findElement(ACCOUNT_STATE).getText();
    }

    public String getNewAccountWebsite() {
        return driver.findElement(ACCOUNT_WEBSITE).getText();
    }
}