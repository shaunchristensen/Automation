package browsers;

import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Sub class for Internet Explorer browser.
 * 
 * @author Shaun Christensen
 */
public class InternetExplorer extends Browser
{
    // fields
    
	InternetExplorerDriver internetExplorerDriver;

	// constructors
    
    /**
     * Default zero-argument constructor.
     */
	public InternetExplorer()
	{
        hashtableStrings.put("browser", "Internet Explorer");

        remoteWebDriver = new InternetExplorerDriver();//desiredCapabilities);
        remoteWebDriver.manage().window().maximize();
	}
}