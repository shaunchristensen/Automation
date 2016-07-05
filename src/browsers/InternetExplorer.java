package browsers;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplorer extends Browser
{
	// constructors
    
	public InternetExplorer()
	{
	    DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	    capabilities.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true); 
	    capabilities.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");

        System.setProperty("webdriver.ie.driver", "Resources/Internet Explorer/IEDriverServer.exe");

        webDriver = new InternetExplorerDriver();
        webDriver.manage().window().maximize();
	}
}