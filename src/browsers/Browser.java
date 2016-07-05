package browsers;

import java.io.File;
import java.util.Hashtable;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Browser
{
    // fields

    protected WebDriver webDriver;

    protected final Hashtable<String, String> hashtableStrings = new Hashtable<String, String>();

    // constructors
    
    public Browser()
    {
        hashtableStrings.put("screenshots", "C:/Regression/Screenshots/");
        hashtableStrings.put("reports", "C:/Regression/Reports/");
        hashtableStrings.put("password", "password");
        hashtableStrings.put("username", "automation");
        hashtableStrings.put("dashboard", "https://staging.inthinc.com/tiwipro/app/dashboard");
        hashtableStrings.put("logout", "https://staging.inthinc.com/tiwipro/logout");
        hashtableStrings.put("login",  "https://staging.inthinc.com/cas/login");
        hashtableStrings.put("account", "https://staging.inthinc.com/tiwipro/app/account");
    }

    // methods
    
    public void close()
    {
        webDriver.close();        
    }

    public void quit()
    {
        webDriver.quit();
    }

    public String getURL()
    {
        return webDriver.getCurrentUrl();
    }
    
    public void setURL(String URL)
	{
        webDriver.get(URL);

	    if (getURL().matches("^" + getString("login") + ".*$"))
	    {
	        logIn();
	    }
	}
    
    public String getTitle()
    {
        return webDriver.getTitle();
    }

    public String getText(By by)
    {
        return webDriver.findElement(by).getText();
    }
    
    public void setText(By by, String text)
    {
        webDriver.findElement(by).clear();
        webDriver.findElement(by).sendKeys(text);
    }
    
    public void click(By by)
    {
        webDriver.findElement(by).click();
    }
    
    public void submit(By by)
    {
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
    
    public String getValue(By by, String value)
    {
        return webDriver.findElement(by).getCssValue(value);        
    }

    public String getAttribute(By by, String attribute)
    {
        return webDriver.findElement(by).getAttribute(attribute);
    }
}