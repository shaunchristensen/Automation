package browsers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.edge.EdgeDriver;

public class Edge extends Browser
{
    // constructors
    
    public Edge()
    {
        // Version 3.14393
        System.setProperty("webdriver.edge.driver", "Resources/Edge/MicrosoftWebDriver.exe");

        webDriver = new EdgeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }
}