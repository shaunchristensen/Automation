package tests;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.junit.Test;

public class DeploymentMy extends Deployment {
	// constructors

	public DeploymentMy(String browserName) {
		super(browserName);
	}

	// methods

    @SuppressWarnings("deprecation")
	@Test
    public void logInAssetsV2My() throws Exception
    {
        assertThat(logInAssetsV2("my"), containsString(stringAssetsV2));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInConfiguratorMy() throws Exception
    {
        assertThat(logInConfigurator("my"), containsString(stringConfigurator));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInFormsMy() throws Exception
    {
        assertThat(logInForms("my"), containsString(stringForms));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInKioskMy() throws Exception
    {
        assertThat(logInKiosk("my"), containsString(stringKiosk));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInPortalMyWeb1() throws Exception
    {
        assertThat(logInPortal("my", "my-web1"), containsString(stringVersion));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInPortalMyWeb2() throws Exception
    {
        assertThat(logInPortal("my", "my-web2"), containsString(stringVersion));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInPortalNoteAPIMy() throws Exception
    {
        assertThat(logInPortalNoteAPI("my"), containsString(""));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInUtilityMy() throws Exception
    {
        assertThat(logInUtility("my"), containsString(stringUtility));
    }
}