package browsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser
{
    // fields

    protected WebDriver webDriver;

    protected WebElement webElement;

    // constructors
    
    public Browser()
    {
    }

    // methods

    public void click(By by)
    {
        getWebElement(by).click();
    }

    public void close()
    {
        webDriver.close();
    }

    protected Boolean getJavaScriptPredicate(String javaScript)
    {
        return new WebDriverWait(webDriver, 10).until(ExpectedConditions.javaScriptThrowsNoExceptions(javaScript));
    }

    public String getText(By by)
    {
        return getWebElement(by).getText();
    }

    public String getURL(String url) throws Exception
    {
        if (getJavaScriptPredicate("window.location.href == '" + url + "'"))
        {
            return url;
        }
        else
        {
            return webDriver.getCurrentUrl();
        }
    }

    protected WebElement getWebElement(By by)
    {
        return new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void quit()
    {
        webDriver.quit();
    }

    public void setText(By by, String text)
    {
        webElement = getWebElement(by);
        webElement.clear();
        webElement.sendKeys(text);
    }
    
    public void setURL(String URL)
    {
        webDriver.get(URL);
    }
}