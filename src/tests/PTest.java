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
	private Browser browser;

	// constructors

	public PTest(String browser)
	{
		stringBrowser = browser;
	}

	// methods

	@After
	public void removeThreadLocal()
	{
//		Browsers.getBrowsers().removeThreadLocal(stringBrowser);
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
    public void logInUtility() throws Exception
    {
        browser.setURL("https://qa.inthinc.com/tiwiproutil");
        browser.setText(By.id("j_username"), "automation");
        browser.setText(By.id("j_password"), "password");
        browser.click(By.xpath("//button[@type='submit']"));

        assertEquals("inthinc Utilities", browser.getTitle());

        browser.setURL("https://qa.inthinc.com/tiwiproutil/logout");
    }

    @Test
    public void logInConfigurator() throws Exception
    {
        browser.setURL("https://qa.inthinc.com/configurator");
        browser.setText(By.id("username"), "automation");
        browser.setText(By.id("password"), "password");
        browser.click(By.xpath("//button[@type='submit']"));

        assertEquals("The Configurator - Edit Single Setting", browser.getTitle());

//        browser.setURL("https://qa.inthinc.com/configurator/j_spring_cas_security_logout");
        browser.setURL("https://qa.inthinc.com/tiwipro/logout");
    }

    @Test
    public void logInKiosk() throws Exception
    {
        browser.setURL("https://qa.inthinc.com/hoskiosk");
        browser.setText(By.id("j_username"), "Automation");
        browser.setText(By.id("j_password"), "Automation");
        browser.click(By.id("loginLogin"));

        assertEquals("HOS Driver", browser.getTitle());

        browser.setURL("https://qa.inthinc.com/hoskiosk/logout");
    }

    @Test
    public void logInPortal() throws Exception
    {
        browser.setURL("https://qa.inthinc.com/tiwipro");
        browser.setText(By.id("username"), "automation");
        browser.setText(By.id("password"), "password");
        browser.click(By.xpath("//button[@type='submit']"));

        assertEquals("Version: 2.5.12-SNAPSHOT 20160613-1836 1244", browser.getText(By.id("footerForm:version")));

        browser.setURL("https://qa.inthinc.com/tiwipro/logout");
    }
}