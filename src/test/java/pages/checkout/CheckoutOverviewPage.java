package pages.checkout;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage {

    private static final String pagePath = "checkout-step-two.html";
    @FindBy(id = "finish")
    public WebElement finishButton;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver, false);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return finishButton;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    public CheckoutCompletedPage finishCheckout() {
        finishButton.click();
        return new CheckoutCompletedPage(driver);
    }
}
