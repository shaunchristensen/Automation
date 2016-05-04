package browsers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Sub class for Chrome browser.
 * 
 * @author Shaun Christensen
 */
public class Chrome extends Browser
{
    // fields
    
    ChromeDriver chromeDriver;
    ChromeOptions chromeOptions;

    // constructors
    
    /**
     * Default zero-argument constructor.
     */
    public Chrome()
    {
    	chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        hashtableStrings.put("browser", "Chrome");

        remoteWebDriver = new ChromeDriver(chromeOptions);
    }
}