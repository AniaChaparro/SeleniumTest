package Support;

public class TestContext
{
    private WebDriverGenerator webDriver;
    private PageObjectManager pageObjectManager;

    public TestContext()
    {
        webDriver = new WebDriverGenerator();
        pageObjectManager = new PageObjectManager(webDriver.getDriver());
    }

    public PageObjectManager getPageObjectManager()
    {
        return pageObjectManager;
    }

    public WebDriverGenerator getWebDriver()
    {
        return webDriver;
    }
}
