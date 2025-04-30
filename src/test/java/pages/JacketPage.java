package pages;

import context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JacketPage extends BasePage{
    public JacketPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "#option-label-size-143-item-170")
    public WebElement sizeButton;

    @FindBy(css = "#option-label-color-93-item-58")
    public WebElement colorButton;

    @FindBy(css = "#product-addtocart-button")
    public WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='action showcart']")
    public WebElement cartButton;

    @FindBy(xpath = "//a[@class='action viewcart']")
    public WebElement viewCartButton;

    @FindBy(css = ".counter-number")
    public WebElement cartItemCount;

    public void addToCart(){
        context.wait.until(ExpectedConditions.elementToBeClickable(sizeButton));
        sizeButton.click();
        context.wait.until(ExpectedConditions.elementToBeClickable(colorButton));
        colorButton.click();
        context.wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
        context.wait.until(ExpectedConditions.textToBePresentInElement(cartItemCount, "1"));
        context.wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();
        context.wait.until(ExpectedConditions.elementToBeClickable(viewCartButton));
        viewCartButton.click();
    }




}
