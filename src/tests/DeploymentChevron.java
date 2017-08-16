package tests;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.junit.Test;

public class DeploymentChevron extends Deployment {
	// constructors

	public DeploymentChevron(String browserName) {
		super(browserName);
	}

	// methods

    @SuppressWarnings("deprecation")
    @Test
    public void logInAssetsV2Chevron() throws Exception
    {
        assertThat(logInAssetsV2("chevron"), containsString(stringAssetsV2));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInConfiguratorChevron() throws Exception
    {
        assertThat(logInConfigurator("chevron"), containsString(stringConfigurator));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInFormsChevron() throws Exception
    {
        assertThat(logInForms("chevron"), containsString(stringForms));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInKioskChevron() throws Exception
    {
        assertThat(logInKiosk("chevron"), containsString(stringKiosk));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInPortalChevron() throws Exception
    {
        assertThat(logInPortal("chevron"), containsString(stringVersion));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInPortalNoteAPIChevron() throws Exception
    {
        assertThat(logInPortalNoteAPI("chevron"), containsString(""));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInUtilityChevron() throws Exception
    {
        assertThat(logInUtility("chevron"), containsString(stringUtility));
    }
}