package Support;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ItemPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager
{
    private WebDriver driver;
    private CartPage cartPage;
    private HomePage homePage;
    private ItemPage itemPage;

    public PageObjectManager(WebDriver driver)
    {
        this.driver = driver;
    }

    public HomePage getHomePage()
    {
        return (homePage == null)? homePage = new HomePage(driver): homePage;
    }

    public ItemPage getItemPage()
    {
        return (itemPage == null)? itemPage = new ItemPage(driver): itemPage;
    }

    public CartPage getCartPage()
    {
        return (cartPage == null)? cartPage = new CartPage(driver) : cartPage;
    }
}
