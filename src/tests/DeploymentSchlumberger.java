package tests;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.junit.Test;

public class DeploymentSchlumberger extends Deployment {
	// constructors

	public DeploymentSchlumberger(String browserName) {
		super(browserName);
	}

	// methods

    @SuppressWarnings("deprecation")
    @Test
    public void logInAssetsV2Schlumberger() throws Exception
    {
        assertThat(logInAssetsV2("schlumberger"), containsString(stringAssetsV2));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInConfiguratorSchlumberger() throws Exception
    {
        assertThat(logInConfigurator("schlumberger"), containsString(stringConfigurator));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInFormsSchlumberger() throws Exception
    {
        assertThat(logInForms("schlumberger"), containsString(stringForms));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInKioskSchlumberger() throws Exception
    {
        assertThat(logInKiosk("schlumberger"), containsString(stringKiosk));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInPortalSchlumbergerWeb1() throws Exception
    {
        assertThat(logInPortal("schlumberger", "schlumberger-web1"), containsString(stringVersion));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInPortalSchlumbergerWeb2() throws Exception
    {
        assertThat(logInPortal("schlumberger", "schlumberger-web2"), containsString(stringVersion));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInPortalNoteAPISchlumberger() throws Exception
    {
        assertThat(logInPortalNoteAPI("schlumberger"), containsString(""));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInUtilitySchlumberger() throws Exception
    {
        assertThat(logInUtility("schlumberger"), containsString(stringUtility));
    }
}