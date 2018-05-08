package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject
{
    @FindBy(id = "searchTerm")
    private WebElement searchField;

    @FindBy(id = "btnSearch")
    private WebElement searchButton;

    @FindBy(xpath ="//*/div[@class ='zeroResult']/*/h2[1]")
    private WebElement errorMessage;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchItem(String item)
    {
        searchField.clear();
        searchField.sendKeys(item);
    }

    public String getErrorMessage()
    {
        return errorMessage.getText();
    }
    public ItemPage goToItemPage()
    {
        searchButton.click();
        return new ItemPage(driver);
    }
}
