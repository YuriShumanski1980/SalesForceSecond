package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewAccountModalPageTest extends BaseTest {

    @Test
    @Description("FILL IN THE ACCOUNT INFORMATION")
    public void newAccountModalPageTest() {
        loginPage
                .loginPage()
                .openHomePage();
        newAccountModalPage
                .openNewAccountPage()
                .createInformationIntoAccountNewPage("TestAccount-SalesForce", "www.twt.by", "Partner",
                        "Website for buying / selling cars", "+375 29 800 88 00",
                        "Chemicals", "26", "5th Avenue, New York, 36",
                        "Hello Wold)", "Minsk", "Belarus", "London", "GB",
                        "Хто его знает", "Panama", "8899/7766", "France")
                .clickSaveButton();
        Assert.assertEquals(newAccountModalPage.getNewAccountName(), "TestAccount-SalesForce");
        Assert.assertEquals(newAccountModalPage.getNewAccountPhone(), "+375 29 800 88 00");
        Assert.assertEquals(newAccountModalPage.getNewAccountAddress(), "5th Avenue, New York, 36");
        Assert.assertEquals(newAccountModalPage.getNewAccountAddress2(), "Minsk, Belarus Хто его знает");
        Assert.assertEquals(newAccountModalPage.getNewAccountAddress2(), "Minsk, Belarus Хто его знает");
        Assert.assertEquals(newAccountModalPage.getNewAccountState(), "Panama");
        Assert.assertEquals(newAccountModalPage.getNewAccountWebsite(), "www.twt.by");
    }
}