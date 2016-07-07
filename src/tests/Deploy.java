package tests;

import automation.Parallelized;
import automation.Retry;
import browsers.Browser;
import browsers.Browsers;
import static org.hamcrest.Matchers.*;
import org.openqa.selenium.By;
import java.util.Collection;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.TestName;

@RunWith(Parallelized.class)
public class Deploy
{
	// fields

    private Browser browser;
	private String stringBrowser;
	private String stringConfigurator;
	private String stringKiosk;
    private String stringPassword;
    private String stringPortal;
    private String stringUsername;
    private String stringUtility;
	private String stringVersion;

	// constructors

	public Deploy(String browser)
	{
		stringBrowser = browser;
		stringConfigurator = ".inthinc.com/configurator/";
		stringKiosk = ".inthinc.com/hoskiosk/app/current";
        stringPassword = "0ttom@tion";
        stringPortal = ".inthinc.com/tiwipro/app/dashboard";
		stringUsername = "automation";
        stringUtility = ".inthinc.com/tiwiproutil/secured/dao.faces";
		stringVersion = "2.5.12";
	}

	// methods

	@After
	public void removeThreadLocal()
	{
		Browsers.getBrowsers().removeThreadLocal(stringBrowser);
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

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @Rule
    public Retry retry = new Retry(10);

    @Rule
    public TestName testName = new TestName();

    @Test
    public void logInConfiguratorBarrick() throws Exception
    {
        assertThat(logInConfigurator("barrick"), containsString(stringConfigurator));
    }

    @Test
    public void logInKioskBarrick() throws Exception
    {
        assertThat(logInKiosk("barrick"), containsString(stringKiosk));
    }

    @Test
    public void logInPortalBarrick() throws Exception
    {
        assertThat(logInPortal("barrick"), containsString(stringVersion));
    }

    @Test
    public void logInUtilityBarrick() throws Exception
    {
        assertThat(logInUtility("barrick"), containsString(stringUtility));
    }

    @Test
    public void logInConfiguratorChevron() throws Exception
    {
        assertThat(logInConfigurator("chevron"), containsString(stringConfigurator));
    }

    @Test
    public void logInKioskChevron() throws Exception
    {
        assertThat(logInKiosk("chevron"), containsString(stringKiosk));
    }

    @Test
    public void logInPortalChevron() throws Exception
    {
        assertThat(logInPortal("chevron"), containsString(stringVersion));
    }

    @Test
    public void logInUtilityChevron() throws Exception
    {
        assertThat(logInUtility("chevron"), containsString(stringUtility));
    }

    @Test
    public void logInConfiguratorCintas() throws Exception
    {
        assertThat(logInConfigurator("cintas"), containsString(stringConfigurator));
    }

    @Test
    public void logInKioskCintas() throws Exception
    {
        assertThat(logInKiosk("cintas"), containsString(stringKiosk));
    }

    @Test
    public void logInPortalCintas() throws Exception
    {
        assertThat(logInPortal("cintas"), containsString(stringVersion));
    }

    @Test
    public void logInUtilityCintas() throws Exception
    {
        assertThat(logInUtility("cintas"), containsString(stringUtility));
    }

    @Test
    public void logInConfiguratorLDS() throws Exception
    {
        assertThat(logInConfigurator("lds"), containsString(stringConfigurator));
    }

    @Test
    public void logInKioskLDS() throws Exception
    {
        assertThat(logInKiosk("lds"), containsString(stringKiosk));
    }

    @Test
    public void logInPortalLDS() throws Exception
    {
        assertThat(logInPortal("lds"), containsString(stringVersion));
    }

    @Test
    public void logInUtilityLDS() throws Exception
    {
        assertThat(logInUtility("lds"), containsString(stringUtility));
    }

    @Test
    public void logInConfiguratorMy() throws Exception
    {
        assertThat(logInConfigurator("my"), containsString(stringConfigurator));
    }

    @Test
    public void logInKioskMy() throws Exception
    {
        assertThat(logInKiosk("my"), containsString(stringKiosk));
    }

    @Test
    public void logInPortalMyWeb1() throws Exception
    {
        assertThat(logInPortal("my", "my-web1"), containsString(stringVersion));
    }

    @Test
    public void logInPortalMyWeb2() throws Exception
    {
        assertThat(logInPortal("my", "my-web2"), containsString(stringVersion));
    }

    @Test
    public void logInUtilityMy() throws Exception
    {
        assertThat(logInUtility("my"), containsString(stringUtility));
    }

    @Test
    public void logInConfiguratorSchlumberger() throws Exception
    {
        assertThat(logInConfigurator("schlumberger"), containsString(stringConfigurator));
    }

    @Test
    public void logInKioskSchlumberger() throws Exception
    {
        assertThat(logInKiosk("schlumberger"), containsString(stringKiosk));
    }

    @Test
    public void logInPortalSchlumberger() throws Exception
    {
        assertThat(logInPortal("schlumberger"), containsString(stringVersion));
    }

    @Test
    public void logInUtilitySchlumberger() throws Exception
    {
        assertThat(logInUtility("schlumberger"), containsString(stringUtility));
    }

    @Test
    public void logInConfiguratorWeatherford() throws Exception
    {
        assertThat(logInConfigurator("weatherford"), containsString(stringConfigurator));
    }

    @Test
    public void logInKioskWeatherford() throws Exception
    {
        assertThat(logInKiosk("weatherford"), containsString(stringKiosk));
    }

    @Test
    public void logInPortalWeatherford() throws Exception
    {
        assertThat(logInPortal("weatherford"), containsString(stringVersion));
    }

    @Test
    public void logInUtilityWeatherford() throws Exception
    {
        assertThat(logInUtility("weatherford"), containsString(stringUtility));
    }

    private String logInConfigurator(String silo) throws Exception
    {
        String url = "https://" + silo + stringConfigurator;

        browser.setURL(url);
        browser.setText(By.id("username"), stringUsername);
        browser.setText(By.id("password"), stringPassword);
        browser.click(By.cssSelector("#fm1 > button"));

        String s = browser.getURL();

        System.out.println(testName.getMethodName() + "\nURL - Expected: " + url + " Actual: " + s + "\n");

       return s;
    }

    private String logInKiosk(String silo) throws Exception
    {
        String url = "https://" + silo + stringKiosk;

        browser.setURL(url);
        browser.setText(By.id("j_username"), stringUsername);
        browser.setText(By.id("j_password"), Character.toUpperCase(stringUsername.charAt(0)) + stringUsername.substring(1));
        browser.click(By.id("loginLogin"));

        String s = browser.getURL();

        System.out.println(testName.getMethodName() + "\nURL - Expected: " + url + " Actual: " + s + "\n");

       return s;
    }

    private String logInPortal(String silo) throws Exception
    {
        browser.setURL("https://" + silo + stringPortal);
        browser.setText(By.id("username"), stringUsername);
        browser.setText(By.id("password"), stringPassword);
        browser.click(By.cssSelector("#fm1 > button"));

        String s = browser.getText(By.id("footerForm:version")).split("\\s+")[1];

        System.out.println(testName.getMethodName() + "\nVersion - Expected: " + stringVersion + " Actual: " + s + "\n");

        return s;
    }

    private String logInPortal(String silo, String hostname) throws Exception
    {
        browser.setURL("https://" + silo + stringPortal);
        browser.setText(By.id("username"), stringUsername);
        browser.setText(By.id("password"), stringPassword);
        browser.click(By.cssSelector("#fm1 > button"));

        String s = browser.getText(By.id("footerForm:hostname")).split("\\s+")[1];

        if (s.contains(hostname))
        {
            System.out.println(testName.getMethodName() + "\nHostname - Expected: " + hostname + " Actual: " + s);

            s = browser.getText(By.id("footerForm:version")).split("\\s+")[1];

            System.out.println("Version - Expected: " + stringVersion + " Actual: " + s + "\n");

            return s;
        }
        else
        {
            System.out.println(testName.getMethodName() + "\nHostname - Expected: " + hostname + " Actual: " + s + "\n");

            throw new Exception("Invalid hostname. Expected: " + hostname + " Actual: " + s);
        }
   }

    private String logInUtility(String silo) throws Exception
    {
        String url = "https://" + silo + stringUtility;

        browser.setURL(url);
        browser.setText(By.id("j_username"), stringUsername);
        browser.setText(By.id("j_password"), stringPassword);
        browser.click(By.id("login_btn"));

        String s = browser.getURL();

        System.out.println(testName.getMethodName() + "\nURL - Expected: " + url + " Actual: " + s + "\n");

       return s;
    }
}