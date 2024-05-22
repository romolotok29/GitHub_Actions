package tests;

import baseEntities.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class AdditionalTests extends BaseTest {

    @Test(description = "Тест на проверку неправильного логина")
    @Description("Проверяем логин с некорректными кредами")
    @Severity(SeverityLevel.TRIVIAL)
    @Link(name = "allure link", type = "myLink", url = "https://example.org")
    @Story("Test Story")
    public void incorrectLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage
                .enterUsername("wrongUsername")
                .enterPassword(simpleUser.getPassword())
                .clickLoginButton();

        Assert.assertEquals(loginPage.getErrorText(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test(description = "Тест на проверку заблокированного пользователя")
    @Description("Проверяем логин с заблокированным пользователем")
    @Severity(SeverityLevel.NORMAL)
    @Issue("BUG-123")
    public void loginAsLockedUserTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage
                .enterUsername("locked_out_user")
                .enterPassword(simpleUser.getPassword())
                .clickLoginButton();

        Assert.assertEquals(loginPage.getErrorTextLockedOutUser(),
                "Epic sadface: Sorry, this user has been locked out.");
    }


    @Test(description = "Тест на проверку скриншота")
    @Description("Специально падающий тест")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("TMS-123")
    public void addSingleItemToCartTest() {

        LoginPage loginPage = new LoginPage(driver);

        Assert.assertEquals(
                loginPage
                        .successfulLogin(simpleUser)
                        .moveToSingleProductPage(product)
                        .addItemToCart()
                        .getAmountOfItemsInCart(), 1
        );
    }
}
