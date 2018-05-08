package StepDefinitions;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ItemPage;
import Support.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class StepDefinitions {

    TestContext testContext;
    HomePage homePage;
    CartPage cartPage;
    ItemPage itemPage;

    public StepDefinitions(TestContext context)
    {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
        itemPage = testContext.getPageObjectManager().getItemPage();
        cartPage = testContext.getPageObjectManager().getCartPage();
    }

    @Given("^a RSComponent super web page$")
    public void a_RSComponent_super_web_page()
    {
        testContext.getWebDriver().getDriver().get("https://uk.rs-online.com/web/");
    }

    @When("^a user searches for a (.*)")
    public void a_user_searches_for_a_component(String item)
    {
        homePage.searchItem(item);
        homePage.goToItemPage();
    }

    @Then("^the page title is (.*)")
    public void the_page_title_is(String title)
    {
        Assert.assertTrue("The item does not exists",testContext.getWebDriver().getDriver().getTitle().contains(title));
    }

    @Then("^a warning message (.*) is shown")
    public void a_warning_message_is_shown(String message)
    {
        Assert.assertEquals(homePage.getErrorMessage(),message );
    }

    @And("^a user adds the item to the basket$")
    public void aUserAddsAnItemToTheBasket()
    {
        itemPage.addToBasket();
    }

    @And("^a user increments the item quantity to two$")
    public void a_user_increments_the_product_quantity_to_two()
    {
        itemPage.incrementProductItems();
    }

    @Then("^the (.*) is added to the basket$")
    public void theItemIsAddedToTheBasket(String item)
    {
        cartPage = itemPage.goToCart();
        Assert.assertEquals("Selected item is not correct", item, cartPage.getDescription());
    }

    @And("^the quantity is (.*)")
    public void theQuantityIsTwo(String number)
    {
        Assert.assertEquals("Number of items not correct", number, cartPage.getQuantity());
    }

    @When("^a user searches without specifying an item$")
    public void a_user_searches_without_specifying_an_item()
    {
        homePage.searchItem("");
        homePage.goToItemPage();
    }

    @Then("^a popup error message is shown$")
    public void a_popup_error_message_is_shown()
    {
        Alert alert = testContext.getWebDriver().getDriver().switchTo().alert();
        Assert.assertEquals("The alert message is not correct", "Please enter a search term", alert.getText());
    }

    @cucumber.api.java.After
    public void cleanUpScenario()
    {
        testContext.getWebDriver().closeDriver();
    }
}
