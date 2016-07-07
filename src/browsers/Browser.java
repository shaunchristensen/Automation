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

//    protected final Hashtable<String, String> hashtableStrings = new Hashtable<String, String>();

    // constructors
    
    public Browser()
    {
        /*
        hashtableStrings.put("screenshots", "C:/Regression/Screenshots/");
        hashtableStrings.put("reports", "C:/Regression/Reports/");
        hashtableStrings.put("password", "password");
        hashtableStrings.put("username", "automation");
        hashtableStrings.put("dashboard", "https://staging.inthinc.com/tiwipro/app/dashboard");
        hashtableStrings.put("logout", "https://staging.inthinc.com/tiwipro/logout");
        hashtableStrings.put("login",  "https://staging.inthinc.com/cas/login");
        hashtableStrings.put("account", "https://staging.inthinc.com/tiwipro/app/account");
        */
    }

    // methods
    
    public void click(By by)
    {
        setWebElement(by);

        webElement.click();
    }

    public void close()
    {
        webDriver.close();        
    }

    public String getText(By by)
    {
        setWebElement(by);

        return webElement.getText();
    }

/*
    public String getTitle()
    {
        return webDriver.getTitle();
    }
*/
    public String getURL()
    {
        return webDriver.getCurrentUrl();
    }

    public void quit()
    {
        webDriver.quit();
    }

    public void setText(By by, String text)
    {
        setWebElement(by);

        webElement.clear();
        webElement.sendKeys(text);
    }
    
    public void setURL(String URL)
    {
        webDriver.get(URL);
/*
        if (getURL().matches("^" + getString("login") + ".*$"))
        {
            logIn();
        }
*/
    }

    protected void setWebElement(By by)
    {
        webElement = (new WebDriverWait(webDriver, 10)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

/*
    public void submit(By by)
    {
        // fix
        webDriver.findElement(by).submit();
    }

    public void logIn()
    {
        ((RemoteWebDriver) webDriver).findElementById("username").sendKeys(getString("username"));
        ((RemoteWebDriver) webDriver).findElementById("password").sendKeys(getString("password"));
        
        submit(By.id("password"));
    }

    public void logOut()
    {
        setURL(getString("logout"));
    }
    
    public void sendKeys(By by, Keys keys, int count)
    {
        for (int i = 0; i < count; i++)
        {
            webDriver.findElement(by).sendKeys(keys);
        }
    }
    
    public boolean isDisplayed(By by)
    {
        return webDriver.findElement(by).isDisplayed();
    }

    public String getString(String s)
    {
        return hashtableStrings.get(s);
    }
    
    public void takeScreenshot(String s)
    {
        try
        {
            File f = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);           

            FileUtils.copyFile(f, new File(getString("screenshots") + "/" + getString("browser") + "/" + s + ".png"));
        }
        catch (Exception e)
        {
            System.out.println("Error: Unable to take screenshot. " + e.getMessage());
        }
    }
*/
    /*
    public String getValue(By by, String value)
    {
        return webDriver.findElement(by).getCssValue(value);        
    }

    public String getAttribute(By by, String attribute)
    {
        return webDriver.findElement(by).getAttribute(attribute);
    }
    */
}