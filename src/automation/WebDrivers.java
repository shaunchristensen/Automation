package automation;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDrivers
{
    // fields

	private static ChromeDriver chromeDriver;
	private static EdgeDriver edgeDriver;
	private static FirefoxDriver firefoxDriver;
	private static InternetExplorerDriver internetExplorerDriver;

	private static ThreadLocal<WebDriver> threadLocalChrome = new ThreadLocal<WebDriver>()
	{
    	@Override
    	protected WebDriver initialValue()
    	{
            System.setProperty("webdriver.chrome.driver", "Resources/Chrome/chromedriver.exe");

            chromeDriver = new ChromeDriver();
    	    chromeDriver.manage().window().maximize();

    	    return chromeDriver;
    	}
	};

    private static ThreadLocal<WebDriver> threadLocalEdge = new ThreadLocal<WebDriver>()
	{
    	@Override
    	protected WebDriver initialValue()
    	{
            System.setProperty("webdriver.edge.driver", "Resources/Edge/MicrosoftWebDriver.exe");

            edgeDriver = new EdgeDriver();
    		edgeDriver.manage().window().maximize();

    	    return edgeDriver;
    	}
	};

    private static ThreadLocal<WebDriver> threadLocalFirefox = new ThreadLocal<WebDriver>()
	{
    	@Override
    	protected WebDriver initialValue()
    	{
    		firefoxDriver = new FirefoxDriver();
    		firefoxDriver.manage().window().maximize();

    	    return firefoxDriver;
    	}
	};

    private static ThreadLocal<WebDriver> threadLocalInternetExplorer = new ThreadLocal<WebDriver>()
	{
    	@Override
    	protected WebDriver initialValue()
    	{
            System.setProperty("webdriver.ie.driver", "Resources/Internet Explorer/IEDriverServer.exe");

            internetExplorerDriver = new InternetExplorerDriver();
    		internetExplorerDriver.manage().window().maximize();

    	    return internetExplorerDriver;
    	}
	};

	private static WebDrivers webDrivers = new WebDrivers();

    // constructors

    private WebDrivers()
    {
	}

    // methods

    public static Collection<Object[]> getBrowsers()
    {
		return Arrays.asList(new Object[][]
		{
			{ "Chrome" },
			{ "Edge" },
			{ "Firefox" },
			{ "Internet Explorer" }
		});
    }

    public WebDriver getWebDriver(String browser)
    {
    	if (browser.equalsIgnoreCase("Chrome"))
        {
        	return threadLocalChrome.get();
        }
        else if (browser.equalsIgnoreCase("Edge"))
        {
        	return threadLocalEdge.get();
        }
        else if (browser.equalsIgnoreCase("Firefox"))
        {
        	return threadLocalFirefox.get();
        }
        else if (browser.equalsIgnoreCase("Internet Explorer"))
        {
        	return threadLocalInternetExplorer.get();
        }
        else
        {
        	return null;
        }
    }

    public static WebDrivers getWebDrivers()
    {
        return webDrivers;
    }

    public static void quitWebDrivers()
    {
    	chromeDriver.quit();
    	edgeDriver.quit();
    	firefoxDriver.quit();
    	internetExplorerDriver.quit();
    }

    public void removeThreadLocal(String browser)
    {
        if (browser.equalsIgnoreCase("Chrome"))
        {
        	threadLocalChrome.get().quit();
        	threadLocalChrome.remove();
        }
        else if (browser.equalsIgnoreCase("Edge"))
        {
        	threadLocalEdge.get().quit();
        	threadLocalEdge.remove();
        }
        else if (browser.equalsIgnoreCase("Firefox"))
        {
        	threadLocalFirefox.get().quit();
        	threadLocalFirefox.remove();
        }
        else if (browser.equalsIgnoreCase("Internet Explorer"))
        {
        	threadLocalInternetExplorer.get().quit();
        	threadLocalInternetExplorer.remove();
        }
    }
}