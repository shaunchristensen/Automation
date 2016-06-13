package browsers;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox extends Browser
{
    // constructors
    
    /**
     * Default zero-argument constructor.
     */
    public Firefox()
    {
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
    }
}