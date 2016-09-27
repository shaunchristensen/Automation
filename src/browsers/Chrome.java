package browsers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome extends Browser
{
    // constructors
    
    public Chrome()
    {
        // Version 2.23
        System.setProperty("webdriver.chrome.driver", "Resources/Chrome/chromedriver.exe");

        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }
}