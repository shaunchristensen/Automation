package browsers;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class InternetExplorer extends Browser
{
	// constructors
    
	public InternetExplorer()
	{
/*
	    DesiredCapabilities desiredCapabilities = DesiredCapabilities.internetExplorer();
	    desiredCapabilities.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true); 
	    desiredCapabilities.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
*/
        System.setProperty("webdriver.ie.driver", "Resources/Internet Explorer/IEDriverServer.exe");

        webDriver = new InternetExplorerDriver();
        webDriver.manage().window().maximize();
	}
}