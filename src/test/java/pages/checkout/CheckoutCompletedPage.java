package pages.checkout;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletedPage extends BasePage {

    private static final String pagePath = "checkout-complete.html";
    @FindBy(css = ".title")
    public WebElement completeTitle;
    @FindBy(css = ".complete-text")
    public WebElement completeMessage;
    @FindBy(id = "back-to-products")
    public WebElement backHomeButton;

    public CheckoutCompletedPage(WebDriver driver) {
        super(driver, false);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return backHomeButton;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    public String getCompleteTitleText(){
        return completeTitle.getText();
    }

    public String getCompleteMessageText() {
        return completeMessage.getText();
    }

    public boolean hasBackHomeButton() {
        return backHomeButton.isDisplayed();
    }
}
