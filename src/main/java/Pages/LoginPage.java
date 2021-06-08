package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    private static final String URL = "https://onliner6.my.salesforce.com/";
    private static final String LOGIN = "shuma-abgm@force.com";
    private static final String PASSWORD = "&YP39TJUrqxy!Mp*";
    private static final By LOGIN_BUTTON = By.id("Login");

    public LoginPage loginPage(){
        driver.get(URL);
        return this;
    }

    @Step("The user is logged into the account")
    public void openHomePage(){
        driver.findElement(By.id("username")).sendKeys(LOGIN);
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        driver.findElement(LOGIN_BUTTON).click();
        new HomePage(driver);
        driver.getCurrentUrl();
    }
}