package tests;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.junit.Test;

public class DeploymentCintas extends Deployment {
	// constructors

	public DeploymentCintas(String browserName) {
		super(browserName);
	}

	// methods

    @SuppressWarnings("deprecation")
    @Test
    public void logInAssetsV2Cintas() throws Exception
    {
        assertThat(logInAssetsV2("cintas"), containsString(stringAssetsV2));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInConfiguratorCintas() throws Exception
    {
        assertThat(logInConfigurator("cintas"), containsString(stringConfigurator));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInFormsCintas() throws Exception
    {
        assertThat(logInForms("cintas"), containsString(stringForms));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInKioskCintas() throws Exception
    {
        assertThat(logInKiosk("cintas"), containsString(stringKiosk));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInPortalCintas() throws Exception
    {
        assertThat(logInPortal("cintas"), containsString(stringVersion));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInPortalNoteAPICintas() throws Exception
    {
        assertThat(logInPortalNoteAPI("cintas"), containsString(""));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInUtilityCintas() throws Exception
    {
        assertThat(logInUtility("cintas"), containsString(stringUtility));
    }
}