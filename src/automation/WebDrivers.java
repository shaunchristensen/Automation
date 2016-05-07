package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDrivers
{
    // fields

    private static WebDrivers webDrivers = new WebDrivers();

    ThreadLocal<WebDriver> chromeDriver = new ThreadLocal<WebDriver>()
    {
        @Override
        protected WebDriver initialValue()
        {
            return new ChromeDriver();
        }
    };

    ThreadLocal<WebDriver> edgeDriver = new ThreadLocal<WebDriver>()
    {
        @Override
        protected WebDriver initialValue()
        {
            return new EdgeDriver();
        }
    };

    ThreadLocal<WebDriver> firefoxDriver = new ThreadLocal<WebDriver>()
    {
        @Override
        protected WebDriver initialValue()
        {
            return new FirefoxDriver();
        }
    };

    ThreadLocal<WebDriver> internetExplorerDriver = new ThreadLocal<WebDriver>()
    {
        @Override
        protected WebDriver initialValue()
        {
            return new InternetExplorerDriver();
        }
    };

    // constructors

    private WebDrivers()
    {
    }

    // methods

    public static WebDrivers getWebDrivers()
    {
        return webDrivers;
    }

    public WebDriver getWebDriver(String s)
    {
        if (s.equalsIgnoreCase("Chrome"))
        {
            return chromeDriver.get();
        }
        else if (s.equalsIgnoreCase("Edge"))
        {
            return edgeDriver.get();
        }
        else if (s.equalsIgnoreCase("Firefox"))
        {
            return firefoxDriver.get();
        }
        else if (s.equalsIgnoreCase("Internet Explorer"))
        {
            return internetExplorerDriver.get();
        }
        else
        {
            throw new WebDriverException("The browser is unsupported.");
        }
    }

    public void removeWebDriver(String s)
    {
        if (s.equalsIgnoreCase("Chrome"))
        {
            chromeDriver.get().quit();
            chromeDriver.remove();
        }
        else if (s.equalsIgnoreCase("Edge"))
        {
            edgeDriver.get().quit();
            edgeDriver.remove();
        }
        else if (s.equalsIgnoreCase("Firefox"))
        {
            firefoxDriver.get().quit();
            firefoxDriver.remove();
        }
        else if (s.equalsIgnoreCase("Internet Explorer"))
        {
            internetExplorerDriver.get().quit();
            internetExplorerDriver.remove();
        }
        else
        {
            throw new WebDriverException("The browser is unsupported.");
        }
    }
}