package browsers;

import java.io.File;
import java.util.Hashtable;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement;

/**
 * Super class for browsers.
 * 
 * @author Shaun Christensen
 */
public class Browser
{
    // fields
    
    protected RemoteWebDriver remoteWebDriver;
    private WebElement webElement; 
    
    protected final Hashtable<String, String> hashtableStrings = new Hashtable<String, String>();
    
    // constructors
    
    public Browser()
    {
        hashtableStrings.put("screenshots", "C:/Regression/Screenshots/");
        hashtableStrings.put("reports", "C:/Regression/Reports/");
        hashtableStrings.put("password", "T@k3Th3Wh33l");
        hashtableStrings.put("username", "automation");
        hashtableStrings.put("dashboard", "https://staging.inthinc.com/tiwipro/app/dashboard");
        hashtableStrings.put("logout", "https://staging.inthinc.com/tiwipro/logout");
        hashtableStrings.put("login",  "https://staging.inthinc.com/cas/login");
        hashtableStrings.put("account", "https://staging.inthinc.com/tiwipro/app/account");

        webElement = null;
    }

    // methods
    
    public void close()
    {
        remoteWebDriver.close();        
    }

    public void quit()
    {
        remoteWebDriver.quit();
    }

    public String getURL()
    {
        return remoteWebDriver.getCurrentUrl();
    }
    
    public void setURL(String URL)
	{
	    remoteWebDriver.get(URL);

	    if (getURL().matches("^" + getString("login") + ".*$"))
	    {
	        logIn();
	    }
	}
    
    public String getTitle()
    {
        return remoteWebDriver.getTitle();
    }

    public String getText(By b)
    {
        return remoteWebDriver.findElement(b).getText();
    }
    
    public void setText(By b, String text)
    {
        remoteWebDriver.findElement(b).clear();
        remoteWebDriver.findElement(b).sendKeys(text);
    }
    
    public void click(By b)
    {
        remoteWebDriver.findElement(b).click();
    }
    
    public void submit(By b)
    {
        remoteWebDriver.findElement(b).submit();
    }
    
    public void logIn()
    {
        remoteWebDriver.findElementById("username").sendKeys(getString("username"));
        remoteWebDriver.findElementById("password").sendKeys(getString("password"));
        
        submit(By.id("password"));
    }

    public void logOut()
    {
        setURL(getString("logout"));
    }
    
    public void sendKeys(By b, Keys k, int count)
    {
        for (int i = 0; i < count; i++)
        {
            remoteWebDriver.findElement(b).sendKeys(k);
        }
    }
    
    public boolean isDisplayed(By b)
    {
        return remoteWebDriver.findElement(b).isDisplayed();
    }

    public String getString(String s)
    {
        return hashtableStrings.get(s);
    }
    
    public void takeScreenshot(String s)
    {
        try
        {
            File f = ((TakesScreenshot)remoteWebDriver).getScreenshotAs(OutputType.FILE);           

            FileUtils.copyFile(f, new File(getString("screenshots") + "/" + getString("browser") + "/" + s + ".png"));
        }
        catch (Exception e)
        {
            System.out.println("Error: Unable to take screenshot. " + e.getMessage());
        }
    }
    
    public String getValue(By b, String s)
    {
        return remoteWebDriver.findElement(b).getCssValue(s);        
    }

    public String getAttribute(By b, String s)
    {
        return remoteWebDriver.findElement(b).getAttribute(s);
    }
    
    
}