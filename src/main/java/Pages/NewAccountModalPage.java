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
    private static final String COMMON_ELEMENT = "//*[@id='brandBand_2']";
    private static final String ACCOUNT_NAME = COMMON_ELEMENT + "//descendant::span[contains(.,'%s')]";
    private static final String ACCOUNT_PHONE = COMMON_ELEMENT + "//descendant::a[contains(.,'%s')]";
    private static final String ACCOUNT_ADDRESS = COMMON_ELEMENT + "//slot/lightning-formatted-address/a/div[contains(.,'%s')]";
    private static final String ACCOUNT_ADDRESS2 = COMMON_ELEMENT + "//slot/lightning-formatted-address/a/div[contains(.,'%s')]";
    private static final String ACCOUNT_STATE = COMMON_ELEMENT + "//slot/lightning-formatted-address/a/div[contains(.,'%s')]";
    private static final String ACCOUNT_WEBSITE = COMMON_ELEMENT + "//descendant::a[contains(.,'%s')]";

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

    public String getNewAccountName(String accountName) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_NAME, accountName))).getText();
    }

    public String getNewAccountPhone(String phone) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_PHONE, phone))).getText();
    }

    public String getNewAccountAddress(String address) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_ADDRESS, address))).getText();
    }

    public String getNewAccountAddress2(String address2) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_ADDRESS2, address2))).getText();
    }

    public String getNewAccountState(String state) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_STATE, state))).getText();
    }

    public String getNewAccountWebsite(String website) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_WEBSITE, website))).getText();
    }
}