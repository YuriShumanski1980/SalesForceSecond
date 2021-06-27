package Pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final String URL = "https://onliner6.my.salesforce.com/";
    private static final By LOGIN_BUTTON = By.id("Login");

    public LoginPage loginPage() {
        log.info("Open login page");
        driver.get(URL);
        return this;
    }

    @Step("The user is logged into the account")
    public void loginAndGoToHomePage(String username, String password) {
        log.info(String.format("Fill in username: %s in Login field", username));
        driver.findElement(By.id("username")).sendKeys(username);
        log.info(String.format("Fill in password: %s in password field", password));
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        new HomePage(driver);
    }
}