package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(description = "Registration / logging in Sales Force")
    @Description("Enter username / password -> press enter")
    public void loginPageTest() {
        loginPage
                .loginPage()
                .openHomePage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://onliner6.lightning.force.com/lightning/page/home");
    }
}