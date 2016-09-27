package browsers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox extends Browser
{
    // constructors
    
    public Firefox()
    {
        // Version 0.10.0
        System.setProperty("webdriver.gecko.driver", "Resources/Firefox/geckodriver.exe");

        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }
}