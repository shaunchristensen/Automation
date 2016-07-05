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
// http://www.seleniumhq.org/docs/04_webdriver_advanced.jsp
        FirefoxProfile firefoxProfile = new FirefoxProfile();    
        firefoxProfile.setPreference("browser.privatebrowsing.autostart", true);

        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
    }
}