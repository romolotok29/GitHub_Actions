package pages.products;

import baseEntities.BasePage;
import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ShoppingCartPage;

public class SingleProductPage extends BasePage {

    private static final String pagePath = "inventory-item.html?id=";
    @FindBy(id = "add-to-cart")
    public WebElement addToCartButton;
    @FindBy(css = ".shopping_cart_link")
    public WebElement shoppingCartButton;

    public SingleProductPage(WebDriver driver) {
        super(driver, true);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return addToCartButton;
    }

    @Override
    protected String getPagePath() {
        return pagePath + Product.getProductId();
    }

    public SingleProductPage addItemToCart() {
        addToCartButton.click();
        return this;
    }


    public ShoppingCartPage moveToShoppingCart() {
        shoppingCartButton.click();
        return new ShoppingCartPage(driver);
    }

    public int getAmountOfItemsInCart() {
        return Integer.parseInt(shoppingCartButton.getText());
    }
}
