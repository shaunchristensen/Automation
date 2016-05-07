package tests;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;

@RunWith(Parallelized.class)
public class PTest {
//  private String platform;
  private String browserName;
//  private String browserVersion;
private static ChromeDriver chromeDriver;
private static EdgeDriver edgeDriver;
private static FirefoxDriver firefoxDriver;
private static InternetExplorerDriver internetExplorerDriver;


@Parameterized.Parameters
  public static LinkedList<String[]> getEnvironments() throws Exception {
    LinkedList<String[]> env = new LinkedList<String[]>();
    env.add(new String[]{Platform.WINDOWS.toString(), "Chrome", "27"});
    env.add(new String[]{Platform.WINDOWS.toString(), "Edge", "1"});
    env.add(new String[]{Platform.WINDOWS.toString(),"Firefox","20"});
    env.add(new String[]{Platform.WINDOWS.toString(),"Internet Explorer","9"});

    //add more browsers here

    return env;
  }

   public PTest(String platform, String browserName, String browserVersion)
{
//    this.platform = platform;
    this.browserName = browserName;
//    this.browserVersion = browserVersion;
  }

  private WebDriver driver;

  @Before
  public void setUp() throws Exception {
    DesiredCapabilities capability = new DesiredCapabilities();
//    capability.setCapability("platform", platform);
    capability.setCapability("browser", browserName);
//    capability.setCapability("browserVersion", browserVersion);

    if (browserName.equalsIgnoreCase("Chrome"))
    {
        driver = chromeDriver;
    }
    else if (browserName.equalsIgnoreCase("Edge"))
    {
//        driver = edgeDriver;
    }
    else if (browserName.equalsIgnoreCase("Firefox"))
    {
        driver = firefoxDriver;
    }
    else if (browserName.equalsIgnoreCase("Internet Explorer"))
    {
        driver = internetExplorerDriver;
    }
  }

  @BeforeClass
  public void initChromeVariables() {
      System.setProperty("webdriver.chrome.driver", "Resources/Chrome/chromedriver.exe");
      // fix later
//      System.setProperty("webdriver.edge.driver", "Resources/Edge/chromedriver.exe");
      System.setProperty("webdriver.ie.driver", "Resources/Internet Explorer/IEDriverServer.exe");

      chromeDriver = new ChromeDriver();
      chromeDriver.manage().window().maximize();
//      edgeDriver = new EdgeDriver();
//      edgeDriver.manage().window().maximize();
      firefoxDriver = new FirefoxDriver();
      firefoxDriver.manage().window().maximize();
      internetExplorerDriver = new InternetExplorerDriver();
      internetExplorerDriver.manage().window().maximize();
  }

  @Test
  public void testSimple() throws Exception {
    driver.get("http://www.google.com");
    WebElement element = driver.findElement(By.name("q"));
    element.sendKeys("inthinc");
    element.submit();
    driver = new Augmenter().augment(driver);
    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFile(srcFile, new File("Screenshot.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testSimple2() throws Exception {
    driver.get("http://qa.inthinc.com");
    WebElement element = driver.findElement(By.name("username"));
    element.sendKeys("automation");
    element = driver.findElement(By.name("password"));
    element.sendKeys("T@k3Th3Wh33l");
    element.submit();
    driver = new Augmenter().augment(driver);
    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFile(srcFile, new File("Screenshot2.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testSimple3() throws Exception {
    driver.get("http://www.google.com");
    WebElement element = driver.findElement(By.name("q"));
    element.sendKeys("football");
    element.submit();
    driver = new Augmenter().augment(driver);
    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFile(srcFile, new File("Screenshot3.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testSimple4() throws Exception {
    driver.get("http://qa.inthinc.com");
    WebElement element = driver.findElement(By.name("username"));
    element.sendKeys("automation");
    element = driver.findElement(By.name("automation"));
    element.sendKeys("T@k3Th3Wh33l");
    element.submit();
    driver = new Augmenter().augment(driver);
    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFile(srcFile, new File("Screenshot4.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testSimple5() throws Exception {
    driver.get("http://www.google.com");
    WebElement element = driver.findElement(By.name("q"));
    element.sendKeys("cats");
    element.submit();
    driver = new Augmenter().augment(driver);
    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFile(srcFile, new File("Screenshot5.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @AfterClass
  public void tearDown() throws Exception {
      chromeDriver.quit();
//      edgeDriver.quit();
      firefoxDriver.quit();
      internetExplorerDriver.quit();
  }
}