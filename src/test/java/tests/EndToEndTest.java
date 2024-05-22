package tests;

import baseEntities.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.checkout.CheckoutCompletedPage;

public class EndToEndTest extends BaseTest {

    @Test(description = "E2E тест-сценарий")
    @Description("Проверка основного функционала на сайте https://www.saucedemo.com/")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Test Story") //влияет только на вкладку Behaviors в Allure Report
    public void e2eTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage
                .successfulLogin(simpleUser)
                .moveToSingleProductPage(product)
                .addItemToCart()
                .moveToShoppingCart()
                .moveToCheckout()
                .fillCheckoutInfo(simpleUser)
                .finishCheckout();

        CheckoutCompletedPage checkoutCompletePage = new CheckoutCompletedPage(driver);

        Assert.assertTrue(
                checkoutCompletePage
                        .isPageOpened()
        );

        Assert.assertEquals(
                checkoutCompletePage
                        .getCompleteTitleText(), "Checkout: Complete!"
        );

        Assert.assertEquals(
                checkoutCompletePage
                        .getCompleteMessageText(),
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!"
        );

        Assert.assertTrue(
                checkoutCompletePage
                        .hasBackHomeButton()
        );

    }
}