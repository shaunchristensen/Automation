package tests;

import browsers.Browser;
import org.junit.Test;

/**
 * Sub class for My Messages unit tests.
 * 
 * @author Shaun Christensen
 */
public class MyMessages extends UnitTest
{
    // methods
    
    public void eh2(Browser b)
    {
        b.setURL("https://staging.inthinc.com/tiwipro/app/messages/");
    }
    
    @Test
    public void ChromeEditMyAccount()
    {
        eh2(chrome);
    }

    @Test
    public void FirefoxEditMyAccount()
    {
        eh2(firefox);
    }

    @Test
    public void InternetExplorerEditMyAccount()
    {
        eh2(internetExplorer);
    }
}