package tests;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.junit.Test;

public class DeploymentLDS extends Deployment {
	// constructors

	public DeploymentLDS(String browserName) {
		super(browserName);
	}

	// methods

	@SuppressWarnings("deprecation")
	@Test
    public void logInAssetsV2LDS() throws Exception
    {
        assertThat(logInAssetsV2("lds"), containsString(stringAssetsV2));
    }

    @SuppressWarnings("deprecation")
	@Test
    public void logInConfiguratorLDS() throws Exception
    {
        assertThat(logInConfigurator("lds"), containsString(stringConfigurator));
    }

    @SuppressWarnings("deprecation")
	@Test
    public void logInFormsLDS() throws Exception
    {
        assertThat(logInForms("lds"), containsString(stringForms));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInKioskLDS() throws Exception
    {
        assertThat(logInKiosk("lds"), containsString(stringKiosk));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInPortalLDS() throws Exception
    {
        assertThat(logInPortal("lds"), containsString(stringVersion));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInPortalNoteAPILDS() throws Exception
    {
        assertThat(logInPortalNoteAPI("lds"), containsString(""));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInUtilityLDS() throws Exception
    {
        assertThat(logInUtility("lds"), containsString(stringUtility));
    }
}