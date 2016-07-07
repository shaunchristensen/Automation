package browsers;

import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome extends Browser
{
    // constructors
    
    public Chrome()
    {
        System.setProperty("webdriver.chrome.driver", "Resources/Chrome/chromedriver.exe");

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }
}