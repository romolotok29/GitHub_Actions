package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.checkout.CheckoutInfoPage;

public class ShoppingCartPage extends BasePage {

    private static final String pagePath = "cart.html";
    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    public ShoppingCartPage(WebDriver driver) {
        super(driver, true);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return checkoutButton;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    public CheckoutInfoPage moveToCheckout() {
        checkoutButton.click();
        return new CheckoutInfoPage(driver);
    }
}
