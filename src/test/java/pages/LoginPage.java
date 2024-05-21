package pages;

import baseEntities.BasePage;
import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.products.ProductsPage;

public class LoginPage extends BasePage {

    private static final String pagePath = "";
    @FindBy(id = "user-name")
    public WebElement usernameInput;
    @FindBy(id = "password")
    public WebElement passwordInput;
    @FindBy(id = "login-button")
    public WebElement loginButton;
    @FindBy(css = "h3")
    public WebElement errorMessage;
    @FindBy(className = "error-message-container")
    public WebElement errorMessageLockedOut;


    public LoginPage(WebDriver driver) {
        super(driver, false);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return usernameInput;
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    public LoginPage enterUsername(String username) {
        usernameInput.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public ProductsPage successfulLogin(User user) {
        enterUsername(user.getUsername());
        enterPassword(user.getPassword());
        clickLoginButton();

        return new ProductsPage(driver);
    }

    public LoginPage incorrectLogin(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        clickLoginButton();

        return this;
    }

    public String getErrorText() {
        return errorMessage.getText();
    }

    public String getErrorTextLockedOutUser() {
        return errorMessageLockedOut.getText();
    }
}
