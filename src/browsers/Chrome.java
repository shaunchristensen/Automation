package browsers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Chrome extends Browser
{
    // constructors
    
    public Chrome()
    {
/*
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("incognito");

        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
*/
        System.setProperty("webdriver.chrome.driver", "Resources/Chrome/chromedriver.exe");

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }
}