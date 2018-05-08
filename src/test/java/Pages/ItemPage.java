package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends PageObject
{
    @FindBy(xpath = "//*/div[@class = 'add-to-basket-container']/*/button")
    private WebElement addToBasketButton;

    @FindBy(xpath = "//*/i[@class = 'icon-cart']")
    private WebElement cartIcon;

    @FindBy(xpath = "//*/i[@class='icon icon-rs_82-pointer-up']")
    private WebElement incrementItems;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public void addToBasket()
    {
        addToBasketButton.click();
    }

    public void incrementProductItems(){incrementItems.click();}

    public CartPage goToCart()
    {
        cartIcon.click();
        return new CartPage(driver);
    }
}
