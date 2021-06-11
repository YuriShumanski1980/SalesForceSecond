package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final String URL = "https://onliner6.my.salesforce.com/";
    private static final By LOGIN_BUTTON = By.id("Login");

    public LoginPage loginPage() {
        driver.get(URL);
        return this;
    }

    @Step("The user is logged into the account")
    public void loginAndGoToHomePage(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        new HomePage(driver);
    }
}