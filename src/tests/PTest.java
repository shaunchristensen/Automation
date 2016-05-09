package tests;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automation.Parallelized;
import automation.WebDrivers;

@RunWith(Parallelized.class)
public class PTest
{
	// fields

	private String stringBrowser;
	private WebDriver webDriver;

	// constructors

	public PTest(String browser)
	{
		stringBrowser = browser;
	}

	// methods

	@After
	public void removeThreadLocal()
	{
//		WebDrivers.getWebDrivers().removeThreadLocal(stringBrowser);
	}

	@AfterClass
	public static void quitWebDrivers()
	{
		WebDrivers.quitWebDrivers();
	}

	@Before
	public void getWebDriver()
	{
		webDriver = WebDrivers.getWebDrivers().getWebDriver(stringBrowser);
	}

	@Parameters(name = "{0}")
	public static Collection<Object[]> getBrowsers()
	{
		return WebDrivers.getBrowsers();
	}

  @Test
  public void testSimple() throws Exception {
	  webDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
	  ArrayList<String> tabs = new ArrayList<String> (webDriver.getWindowHandles());

	  webDriver.switchTo().window(tabs.get(tabs.size() - 1));
	  webDriver.get("http://www.google.com");
    WebElement element = webDriver.findElement(By.id("lst-ib"));
    element.sendKeys("inthinc");
    element.submit();
//	  driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
    System.out.println("testSimple " + stringBrowser);
  }

  @Test
  public void testSimple2() throws Exception {
	  webDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
	  System.out.println(1);
	  ArrayList<String> tabs = new ArrayList<String> (webDriver.getWindowHandles());
	  System.out.println(2);

	  webDriver.switchTo().window(tabs.get(tabs.size() - 1));
	  System.out.println(3);
	  webDriver.get("http://qa.inthinc.com");
	  System.out.println(4);
    WebElement element = webDriver.findElement(By.id("username"));
	  System.out.println(5);
    element.sendKeys("schristensen");
	  System.out.println(6);
    element = webDriver.findElement(By.id("password"));
	  System.out.println(7);
    element.sendKeys("pushit955");
	  System.out.println(8);
    element.submit();
	  System.out.println(9);
	  webDriver.get("https://qa.inthinc.com/tiwipro/logout");
	  System.out.println(10);
	//  driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
    System.out.println("testSimple2 " + stringBrowser);
  }

  @Test
  public void testSimple3() throws Exception {
	  webDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
	  ArrayList<String> tabs = new ArrayList<String> (webDriver.getWindowHandles());

	  webDriver.switchTo().window(tabs.get(tabs.size() - 1));
	  webDriver.get("http://www.google.com");
    WebElement element = webDriver.findElement(By.id("lst-ib"));
    element.sendKeys("football");
    element.submit();
//	  driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
    System.out.println("testSimple3 " + stringBrowser);
    }

  @Test
  public void testSimple4() throws Exception {
	  webDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
	  ArrayList<String> tabs = new ArrayList<String> (webDriver.getWindowHandles());

	  webDriver.switchTo().window(tabs.get(tabs.size() - 1));
	  webDriver.get("http://qa.inthinc.com");
    WebElement element = webDriver.findElement(By.id("username"));
    element.sendKeys("schristensen");
    element = webDriver.findElement(By.id("password"));
    element.sendKeys("pushit955");
    element.submit();
    webDriver.get("https://qa.inthinc.com/tiwipro/logout");
//	  driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
    System.out.println("testSimple4 " + stringBrowser);
  }

  @Test
  public void testSimple5() throws Exception {
	  webDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
	  ArrayList<String> tabs = new ArrayList<String> (webDriver.getWindowHandles());

	  webDriver.switchTo().window(tabs.get(tabs.size() - 1));
	  webDriver.get("http://www.google.com");
    WebElement element = webDriver.findElement(By.id("lst-ib"));
    element.sendKeys("cats");
    element.submit();
    System.out.println("testSimple5 " + stringBrowser);
  }
}