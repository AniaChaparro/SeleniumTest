package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class CartPage extends PageObject
{
    @FindBy(xpath ="//*[@class = 'descriptionTd']/*/a")
    private WebElement description;

    @FindBy(xpath ="//*[@class = 'costColumn']")
    private WebElement price;

    @FindBy(xpath ="//*/td[@class ='quantityTd']/input")
    private WebElement quantity;

    public CartPage(WebDriver driver)
    {
        super(driver);
    }

    public String getDescription()
    {
        return description.getText();
    }
    public String getQuantity(){return quantity.getAttribute("value");}
}
