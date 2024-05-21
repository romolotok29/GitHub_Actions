package pages.checkout;

import baseEntities.BasePage;
import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutInfoPage extends BasePage {

    private static final String pagePath = "checkout-step-one.html";
    @FindBy(id = "first-name")
    public WebElement firstNameInput;
    @FindBy(id = "last-name")
    public WebElement lastNameInput;
    @FindBy(id = "postal-code")
    public WebElement postalCodeInput;
    @FindBy(id = "continue")
    public WebElement continueButton;

    public CheckoutInfoPage(WebDriver driver) {
        super(driver, false);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return firstNameInput;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    public CheckoutOverviewPage fillCheckoutInfo(User user) {
        firstNameInput.sendKeys(user.getFirstName());
        lastNameInput.sendKeys(user.getLastName());
        postalCodeInput.sendKeys(user.getPostalCode());
        continueButton.click();

        return new CheckoutOverviewPage(driver);
    }
}
