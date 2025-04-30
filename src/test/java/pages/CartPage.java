package pages;

import context.TestContext;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    public CartPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "h1.page-title span.base")
    public WebElement cartPageTitle;

    @FindBy(name = "cart[748801][qty]")
    public WebElement quantityInCart;

    @FindBy(xpath = "//tr[@class='item-info']//strong[@class='product-item-name']/a[text()='Montana Wind Jacket']")
    public WebElement productNameInCart;

    public boolean isOnCartPage() {
        return cartPageTitle.getText().equals("Shopping Cart");
    }

    public boolean isCorrectProductInCart(String expectedName) {
        return productNameInCart.getText().equalsIgnoreCase(expectedName);
    }

}
