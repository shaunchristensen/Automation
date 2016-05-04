package tests;

import browsers.Chrome;
import browsers.Firefox;
import browsers.InternetExplorer;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * Super class for unit tests.
 * 
 * @author Shaun Christensen
 */
public class UnitTest
{
    // fields
    
	protected static Chrome chrome;
	protected static Firefox firefox;
	protected static InternetExplorer internetExplorer;

	// methods

	/**
     * Quits remote web drivers after running unit tests.
     */
	@AfterClass
	public static void afterClass()
	{
		chrome.quit();
		firefox.quit();
		internetExplorer.quit();
	}

    /**
     * Creates new remote web drivers before running unit tests.
     */
    @BeforeClass
    public static void beforeClass()
    {
        chrome = new Chrome();
        firefox = new Firefox();
        internetExplorer = new InternetExplorer();
    }
}