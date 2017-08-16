package tests;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.junit.Test;

public class DeploymentBarrick extends Deployment {
	// constructors

	public DeploymentBarrick(String browserName)
	{
		super(browserName);
	}

	// methods

    @SuppressWarnings("deprecation")
	@Test
    public void logInAssetsV2Barrick() throws Exception
    {
        assertThat(logInAssetsV2("barrick"), containsString(stringAssetsV2));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInConfiguratorBarrick() throws Exception
    {
        assertThat(logInConfigurator("barrick"), containsString(stringConfigurator));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInFormsBarrick() throws Exception
    {
        assertThat(logInForms("barrick"), containsString(stringForms));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInKioskBarrick() throws Exception
    {
        assertThat(logInKiosk("barrick"), containsString(stringKiosk));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInPortalBarrick() throws Exception
    {
        assertThat(logInPortal("barrick"), containsString(stringVersion));
    }

    @SuppressWarnings("deprecation")
	@Test
    public void logInPortalNoteAPIBarrick() throws Exception
    {
        assertThat(logInPortalNoteAPI("barrick"), containsString(""));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInUtilityBarrick() throws Exception
    {
        assertThat(logInUtility("barrick"), containsString(stringUtility));
    }
}