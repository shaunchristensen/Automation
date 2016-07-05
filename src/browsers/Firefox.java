package browsers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Firefox extends Browser
{
    // constructors
    
    /**
     * Default zero-argument constructor.
     */
    public Firefox()
    {
/*
        FirefoxProfile firefoxProfile = new FirefoxProfile();    
        firefoxProfile.setPreference("browser.privatebrowsing.autostart", true);

        DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
        desiredCapabilities.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
*/
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
    }
}