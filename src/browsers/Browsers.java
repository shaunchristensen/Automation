package browsers;

import java.util.Arrays;
import java.util.Collection;

public class Browsers
{
    // fields

    private static Browser browserChrome;
    private static Browser browserEdge;
    private static Browser browserFirefox;
    private static Browser browserInternetExplorer;

    private static Browsers browsers = new Browsers();

    private static ThreadLocal<Browser> threadLocalChrome = new ThreadLocal<Browser>()
    {
        @Override
        protected Browser initialValue()
        {
            browserChrome = new Chrome();

            return browserChrome;
        }
    };

    private static ThreadLocal<Browser> threadLocalEdge = new ThreadLocal<Browser>()
    {
        @Override
        protected Browser initialValue()
        {
            browserEdge = new Edge();

            return browserEdge;
        }
    };

    private static ThreadLocal<Browser> threadLocalFirefox = new ThreadLocal<Browser>()
    {
        @Override
        protected Browser initialValue()
        {
            browserFirefox = new Firefox();

            return browserFirefox;
        }
    };

    private static ThreadLocal<Browser> threadLocalInternetExplorer = new ThreadLocal<Browser>()
    {
        @Override
        protected Browser initialValue()
        {
            browserInternetExplorer = new InternetExplorer();

            return browserInternetExplorer;
        }
    };

    // constructors

    private Browsers()
    {
    }

    // methods

    public Browser getBrowser(String browser)
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

    public static Browsers getBrowsers()
    {
        return browsers;
    }

    public static Collection<Object[]> getBrowserNames()
    {
        return Arrays.asList(new Object[][]
        {
            { "Chrome" },
//            { "Edge" },
            { "Firefox" },
            { "Internet Explorer" }
        });
    }

    public static void quitBrowsers()
    {
        browserChrome.quit();
        browserEdge.quit();
        browserFirefox.quit();
        browserInternetExplorer.quit();
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