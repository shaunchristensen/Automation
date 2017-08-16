package tests;

import automation.Parallelized;
import automation.Retry;
import browsers.Browser;
import browsers.Browsers;
import org.openqa.selenium.By;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.rules.ErrorCollector;
import org.junit.rules.TestName;

@RunWith(Parallelized.class)
public class Deployment
{
	// fields

	protected Browser browser;
	protected String stringAssetsV2;
	protected String stringBrowser;
	protected String stringConfigurator;
	protected String stringDomain;
	protected String stringForms;
	protected String stringKiosk;
	protected String stringPassword;
	protected String stringPortal;
	protected String stringPortalNoteAPI;
	protected String stringUsername;
	protected String stringUtility;
	protected String stringVersion;

	// constructors

	public Deployment(String browserName)
	{
		stringBrowser = browserName;

		stringDomain = ".inthinc.com/";
		stringAssetsV2 = stringDomain + "assets_v2/";
		stringConfigurator = stringDomain + "configurator/";
		stringForms = stringDomain + "forms/";
		stringKiosk = stringDomain + "hoskiosk/app/current";
		stringPortal = stringDomain + "tiwipro/app/dashboard/";
		stringPortalNoteAPI = stringDomain + "portal_note_api/";
		stringUtility = stringDomain + "tiwiproutil/secured/dao.faces";

		stringUsername = "automation";
		stringPassword = "0ttom@tion";

		stringVersion = "Version: 2.6.5 20170801-0037 415";
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

	protected String logInAssetsV2(String server) throws Exception
	{
		String url = "https://" + server + stringAssetsV2;

		browser.setURL(url);
		browser.setText(By.id("username"), stringUsername);
		browser.setText(By.id("password"), stringPassword);
		browser.click(By.cssSelector("#fm1 > button"));

		String s = browser.getURL(url);

		System.out.println("\n" + testName.getMethodName() + "\n\nURL\nExpected: " + url + "\n  Actual: " + s + "\n");

	   return s;
	}

	protected String logInConfigurator(String server) throws Exception
	{
		String url = "https://" + server + stringConfigurator;

		browser.setURL(url);
		browser.setText(By.id("username"), stringUsername);
		browser.setText(By.id("password"), stringPassword);
		browser.click(By.cssSelector("#fm1 > button"));

		String s = browser.getURL(url);

		System.out.println("\n" + testName.getMethodName() + "\n\nURL\nExpected: " + url + "\n  Actual: " + s + "\n");

	   return s;
	}

	protected String logInForms(String server) throws Exception
	{
		String url = "https://" + server + stringForms;

		browser.setURL(url);
		browser.setText(By.id("username"), stringUsername);
		browser.setText(By.id("password"), stringPassword);
		browser.click(By.cssSelector("#fm1 > button"));

		String s = browser.getURL(url);

		System.out.println("\n" + testName.getMethodName() + "\n\nURL\nExpected: " + url + "\n  Actual: " + s + "\n");

	   return s;
	}

	protected String logInKiosk(String server) throws Exception
	{
		String url = "https://" + server + stringKiosk;

		browser.setURL(url);
		browser.setText(By.id("j_username"), stringUsername);
		browser.setText(By.id("j_password"), Character.toUpperCase(stringUsername.charAt(0)) + stringUsername.substring(1));
		browser.click(By.id("loginLogin"));

		String s = browser.getURL(url);

		System.out.println("\n" + testName.getMethodName() + "\n\nURL\nExpected: " + url + "\n  Actual: " + s + "\n");

	   return s;
	}

	protected String logInPortal(String server) throws Exception
	{
		String url = "https://" + server + stringPortal;

		browser.setURL(url);
		browser.setText(By.id("username"), stringUsername);
		browser.setText(By.id("password"), stringPassword);
		browser.click(By.cssSelector("#fm1 > button"));

		String s = browser.getText(By.id("footerForm:version"));

		System.out.println("\n" + testName.getMethodName() + "\n\nVersion\nExpected: " + stringVersion + "\n  Actual: " + s + "\n");

		return s;
	}

	protected String logInPortal(String server, String hostname) throws Exception
	{
		String url = "https://" + server + stringPortal;

		browser.setURL(url);
		browser.setText(By.id("username"), stringUsername);
		browser.setText(By.id("password"), stringPassword);
		browser.click(By.cssSelector("#fm1 > button"));

		String s = browser.getText(By.id("footerForm:hostname"));

		if (s.contains(hostname))
		{
			System.out.println("\n" + testName.getMethodName() + "\n\nHostname\nExpected: " + hostname + "\nActual: " + s);

			s = browser.getText(By.id("footerForm:version"));

			System.out.println("Version\nExpected: " + stringVersion + "\n  Actual: " + s + "\n");

			return s;
		}
		else
		{
			System.out.println("\n" + testName.getMethodName() + "\n\nHostname\nExpected: " + hostname + "\nActual: " + s + "\n");

			throw new Exception("Invalid hostname\nExpected: " + hostname + "\n  Actual: " + s);
		}
   }

	protected String logInPortalNoteAPI(String server) throws Exception
	{
		String url = "https://" + server + stringPortalNoteAPI;

		browser.setURL(url);

		String s = browser.getTitle();

		System.out.println("\n" + testName.getMethodName() + "\n\nTitle\nExpected:\n  Actual: " + s + "\n");

		return s;
	}

	protected String logInUtility(String server) throws Exception
	{
		String url = "https://" + server + stringUtility;

		browser.setURL(url.replace("secured/dao.faces",  ""));
		browser.setText(By.id("j_username"), stringUsername);
		browser.setText(By.id("j_password"), stringPassword);
		browser.click(By.id("login_btn"));

		String s = browser.getURL(url);

		System.out.println("\n" + testName.getMethodName() + "\n\nURL\nExpected: " + url + "\n  Actual: " + s + "\n");

	   return s;
	}
}