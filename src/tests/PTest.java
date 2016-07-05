package tests;

import automation.Parallelized;

import browsers.Browser;
import browsers.Browsers;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;

@RunWith(Parallelized.class)
public class PTest
{
	// fields

	private String stringBrowser;
	private String stringVersion;
	private Browser browser;

	// constructors

	public PTest(String browser)
	{
		stringBrowser = browser;
		stringVersion = "Version: 2.5.12 20160623-2141 330";
	}

	// methods

	@After
	public void removeThreadLocal()
	{
		Browsers.getBrowsers().removeThreadLocal(stringBrowser);
	}

	@AfterClass
	public static void quitBrowsers()
	{
	    Browsers.quitBrowsers();
	}

	@Before
	public void getBrowser()
	{
	    browser = Browsers.getBrowsers().getBrowser(stringBrowser);
	}

	@Parameters(name = "{0}")
	public static Collection<Object[]> getBrowsers()
	{
		return Browsers.getBrowserNames();
	}

    @Test
    public void logInConfiguratorBarrick() throws Exception
    {
        assertEquals("The Configurator - Edit Single Setting", logInConfigurator("https://barrick.inthinc.com"));
    }

    @Test
    public void logInKioskBarrick() throws Exception
    {
        assertEquals("HOS Driver", logInKiosk("https://barrick.inthinc.com"));
    }

    @Test
    public void logInPortalBarrick() throws Exception
    {
        assertEquals(stringVersion, logInPortal("https://barrick.inthinc.com"));
    }

    @Test
    public void logInUtilityBarrick() throws Exception
    {
        assertEquals("inthinc Utilities", logInUtility("https://barrick.inthinc.com"));
    }

    @Test
    public void logInConfiguratorChevron() throws Exception
    {
        assertEquals("The Configurator - Edit Single Setting", logInConfigurator("https://chevron.inthinc.com"));
    }

    @Test
    public void logInKioskChevron() throws Exception
    {
        assertEquals("HOS Driver", logInKiosk("https://chevron.inthinc.com"));
    }

    @Test
    public void logInPortalChevron() throws Exception
    {
        assertEquals(stringVersion, logInPortal("https://chevron.inthinc.com"));
    }

    @Test
    public void logInUtilityChevron() throws Exception
    {
        assertEquals("inthinc Utilities", logInUtility("https://chevron.inthinc.com"));
    }

    @Test
    public void logInConfiguratorCintas() throws Exception
    {
        assertEquals("The Configurator - Edit Single Setting", logInConfigurator("https://cintas.inthinc.com"));
    }

    @Test
    public void logInKioskCintas() throws Exception
    {
        assertEquals("HOS Driver", logInKiosk("https://cintas.inthinc.com"));
    }

    @Test
    public void logInPortalCintas() throws Exception
    {
        assertEquals(stringVersion, logInPortal("https://cintas.inthinc.com"));
    }

    @Test
    public void logInUtilityCintas() throws Exception
    {
        assertEquals("inthinc Utilities", logInUtility("https://cintas.inthinc.com"));
    }

    @Test
    public void logInConfiguratorLDS() throws Exception
    {
        assertEquals("The Configurator - Edit Single Setting", logInConfigurator("https://lds.inthinc.com"));
    }

    @Test
    public void logInKioskLDS() throws Exception
    {
        assertEquals("HOS Driver", logInKiosk("https://lds.inthinc.com"));
    }

    @Test
    public void logInPortalLDS() throws Exception
    {
        assertEquals(stringVersion, logInPortal("https://lds.inthinc.com"));
    }

    @Test
    public void logInUtilityLDS() throws Exception
    {
        assertEquals("inthinc Utilities", logInUtility("https://lds.inthinc.com"));
    }

    @Test
    public void logInConfiguratorMy() throws Exception
    {
        assertEquals("The Configurator - Edit Single Setting", logInConfigurator("https://my.inthinc.com"));
    }

    @Test
    public void logInKioskMy() throws Exception
    {
        assertEquals("HOS Driver", logInKiosk("https://my.inthinc.com"));
    }

    @Test
    public void logInPortalMy() throws Exception
    {
        assertEquals(stringVersion, logInPortal("https://my.inthinc.com"));
    }

    @Test
    public void logInUtilityMy() throws Exception
    {
        assertEquals("inthinc Utilities", logInUtility("https://my.inthinc.com"));
    }

    @Test
    public void logInConfiguratorSchlumberger() throws Exception
    {
        assertEquals("The Configurator - Edit Single Setting", logInConfigurator("https://schlumberger.inthinc.com"));
    }

    @Test
    public void logInKioskSchlumberger() throws Exception
    {
        assertEquals("HOS Driver", logInKiosk("https://schlumberger.inthinc.com"));
    }

    @Test
    public void logInPortalSchlumberger() throws Exception
    {
        assertEquals(stringVersion, logInPortal("https://schlumberger.inthinc.com"));
    }

    @Test
    public void logInUtilitySchlumberger() throws Exception
    {
        assertEquals("inthinc Utilities", logInUtility("https://schlumberger.inthinc.com"));
    }

    @Test
    public void logInConfiguratorWeatherford() throws Exception
    {
        assertEquals("The Configurator - Edit Single Setting", logInConfigurator("https://weatherford.inthinc.com"));
    }

    @Test
    public void logInKioskWeatherford() throws Exception
    {
        assertEquals("HOS Driver", logInKiosk("https://weatherford.inthinc.com"));
    }

    @Test
    public void logInPortalWeatherford() throws Exception
    {
        assertEquals(stringVersion, logInPortal("https://weatherford.inthinc.com"));
    }

    @Test
    public void logInUtilityWeatherford() throws Exception
    {
        assertEquals("inthinc Utilities", logInUtility("https://weatherford.inthinc.com"));
    }

    public String logInConfigurator(String host) throws Exception
    {
        browser.setURL(host + "/configurator/j_spring_cas_security_logout");
        browser.setURL(host + "/configurator");
        browser.setText(By.id("username"), "automation");
        browser.setText(By.id("password"), "0ttom@tion");
        browser.click(By.xpath("//button[@type='submit']"));

        browser.takeScreenshot("logInConfigurator");
        return browser.getTitle();
    }

    public String logInKiosk(String host) throws Exception
    {
        browser.setURL(host + "/hoskiosk/logout");
        browser.setURL(host + "/hoskiosk");
        browser.setText(By.id("j_username"), "Automation");
        browser.setText(By.id("j_password"), "Automation");
        browser.click(By.id("loginLogin"));

        return browser.getTitle();
    }

    public String logInPortal(String host) throws Exception
    {
        browser.setURL(host + "/tiwipro/logout");
        browser.setURL(host + "/tiwipro");
        browser.setText(By.id("username"), "automation");
        browser.setText(By.id("password"), "0ttom@tion");
        browser.click(By.xpath("//button[@type='submit']"));

        browser.takeScreenshot("logInPortal");
        return browser.getText(By.id("footerForm:version"));
    }

    public String logInUtility(String host) throws Exception
    {
        browser.setURL(host + "/tiwiproutil/logout");
        browser.setURL(host + "/tiwiproutil");
        browser.setText(By.id("j_username"), "automation");
        browser.setText(By.id("j_password"), "0ttom@tion");
        browser.click(By.xpath("//button[@type='submit']"));

        return browser.getTitle();
    }
}