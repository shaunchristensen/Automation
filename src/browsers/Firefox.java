package browsers;

import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Sub class for Firefox browser.
 * 
 * @author Shaun Christensen
 */
public class Firefox extends Browser
{
    // fields
    
    FirefoxDriver firefoxDriver;

    // constructors
    
    /**
     * Default zero-argument constructor.
     */
    public Firefox()
    {
        hashtableStrings.put("browser", "Firefox");

        remoteWebDriver = new FirefoxDriver();
        remoteWebDriver.manage().window().maximize();
    }
}