package pages.products;

import baseEntities.BasePage;
import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage {

    private static final String pagePath = "inventory.html";
    @FindBy(css = "[id*='_title_link']")
    public List<WebElement> productsList;


    public ProductsPage(WebDriver driver) {
        super(driver, true);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return productsList.get(3);
    }

    @Override
    protected String getPagePath() {
        return pagePath;
    }

    public WebElement getProductByName(String productName) {
        for (WebElement element :
                productsList) {
            if (element.getText().contains(productName)) {
                return element;
            }
        }
        return null;
    }

    public SingleProductPage moveToSingleProductPage(Product product) {
        getProductByName(product.getProductName()).click();
        return new SingleProductPage(driver);
    }
}
