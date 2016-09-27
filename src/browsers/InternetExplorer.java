package browsers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplorer extends Browser
{
	// constructors
    
	public InternetExplorer()
	{
	    // Version 2.53.1
        System.setProperty("webdriver.ie.driver", "Resources/Internet Explorer/IEDriverServer.exe");

        webDriver = new InternetExplorerDriver();
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
	}
}