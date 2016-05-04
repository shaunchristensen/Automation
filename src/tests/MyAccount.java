package tests;

import browsers.Browser;
import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 * Sub class for My Account unit tests.
 * 
 * @author Shaun Christensen
 */
public class MyAccount extends UnitTest
{
    // methods
    
    public void viewMyAccount(Browser b)
    {
        b.setURL(b.getString("account"));
        assertEquals(b.getString("account"), b.getURL());
        b.takeScreenshot("My Account - View");
    }
    
    public void displayChangePassword(Browser b)
    {
        b.setURL(b.getString("account"));
        b.click(By.id("myAccountpassword"));
        assertTrue(b.isDisplayed(By.id("changePasswordPanelContainer")));
        b.takeScreenshot("My Account - Change Password - Display");
    }

    // figure out wait until, check inner html/take screenshot
    // rawr
    public void errorChangePasswordRequired(Browser b)
    {
        b.setURL(b.getString("account"));
        b.click(By.id("myAccountpassword"));        
        b.click(By.id("changePasswordForm:changePasswordSubmit"));
        assertTrue(b.isDisplayed(By.id("changePasswordPanelContainer")));
        b.takeScreenshot("My Account - Change Password - Error - Required");
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void cancelChangePassword(Browser b)
    {
        b.setURL(b.getString("account"));
        b.click(By.id("myAccountpassword"));

        if (b.isDisplayed(By.id("changePasswordPanelHeader")))
        {
            b.setText(By.id("changePasswordForm:oldPassword"), b.getString("password"));
            b.setText(By.id("changePasswordForm:newPassword"), "password");
            b.setText(By.id("changePasswordForm:confirmPassword"), "password");
            b.click(By.id("changePasswordForm:changePasswordCancel"));
        }
        else
        {
            fail("ID changePasswordPanelHeader is not displayed.");
        }

        b.logOut();
        b.setURL(b.getString("account"));

        assertEquals("Unable to log in. Invalid credentials.", b.getString("account"), b.getURL());
    }

    // view my account
    // edit my account
    // not edit my account
    // change password
    
	public void submitEditAccount(Browser b)
	{
		b.setURL("https://staging.inthinc.com/tiwipro/app/account");
		
		String myAccountLocale = b.getText(By.id("myAccountLocale"));
		String myAccountMeasurementType = b.getText(By.id("myAccountMeasurementType"));
		String myAccountFuelEfficiency = b.getText(By.id("myAccountFuelEfficiency"));
		String myAccountPriEmail = b.getText(By.id("myAccountPriEmail"));
		String myAccountSecEmail = b.getText(By.id("myAccountSecEmail"));
		String myAccountPriPhone = b.getText(By.id("myAccountPriPhone"));
		String myAccountSecPhone = b.getText(By.id("myAccountSecPhone"));
		String myAccountPriText = b.getText(By.id("myAccountPriText"));
		String myAccountSecText = b.getText(By.id("myAccountSecText"));
		String myAccountInfo = b.getText(By.id("myAccountInfo"));
		String myAccountWarn = b.getText(By.id("myAccountWarn"));
		String myAccountCrit = b.getText(By.id("myAccountCrit"));
		String myAccountMapType = b.getText(By.id("myAccountMapType"));
		String myAccountLayersArrow = b.getText(By.id("myAccountLayersArrow"));
		
		b.click(By.id("myAccountEdit"));

		b.sendKeys(By.id("my_form:editAccountLocale"), Keys.DOWN, 1);
		
        b.click(By.id("my_form:editAccountSave"));
	}
 
	// tests
	
    @Test
    public void chromeViewMyAccount()
    {
        viewMyAccount(chrome);
    }

    @Test
    public void firefoxViewMyAccount()
    {
        viewMyAccount(firefox);
    }

    @Test
    public void internetExplorerViewMyAccount()
    {
        viewMyAccount(internetExplorer);
    }

    @Test
    public void chromeDisplayChangePassword()
    {
        displayChangePassword(chrome);
    }

    @Test
    public void firefoxDisplayChangePassword()
    {
        displayChangePassword(firefox);
    }

    @Test
    public void internetExplorerDisplayChangePassword()
    {
        displayChangePassword(internetExplorer);
    }

    @Test
    public void chromeErrorChangePasswordRequired()
    {
        errorChangePasswordRequired(chrome);
    }

    @Test
    public void firefoxErrorChangePasswordRequired()
    {
        errorChangePasswordRequired(firefox);
    }

    @Test
    public void internetExplorerErrorChangePasswordRequired()
    {
        errorChangePasswordRequired(internetExplorer);
    }
 
    @Test
    public void chromeCancelChangePassword()
    {
        cancelChangePassword(chrome);
    }

    @Test
    public void firefoxCancelChangePassword()
    {
        cancelChangePassword(firefox);
    }

    @Test
    public void internetExplorerCancelChangePassword()
    {
        cancelChangePassword(internetExplorer);
    }

   @Test
    public void chromeSubmitEditAccount()
    {
        submitEditAccount(chrome);
    }

    @Test
    public void firefoxSubmitEditAccount()
    {
        submitEditAccount(firefox);
    }

    @Test
    public void internetExplorerSubmitEditAccount()
    {
        submitEditAccount(internetExplorer);
    }
    
}