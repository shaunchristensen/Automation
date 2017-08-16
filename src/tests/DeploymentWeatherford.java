package tests;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.junit.Test;

public class DeploymentWeatherford extends Deployment {
	// constructors

	public DeploymentWeatherford(String browserName) {
		super(browserName);
	}

	// methods

    @SuppressWarnings("deprecation")
    @Test
    public void logInAssetsV2Weatherford() throws Exception
    {
        assertThat(logInAssetsV2("weatherford"), containsString(stringAssetsV2));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInConfiguratorWeatherford() throws Exception
    {
        assertThat(logInConfigurator("weatherford"), containsString(stringConfigurator));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInFormsWeatherford() throws Exception
    {
        assertThat(logInForms("weatherford"), containsString(stringForms));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInKioskWeatherford() throws Exception
    {
        assertThat(logInKiosk("weatherford"), containsString(stringKiosk));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInPortalWeatherford() throws Exception
    {
        assertThat(logInPortal("weatherford"), containsString(stringVersion));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInPortalNoteAPIWeatherford() throws Exception
    {
        assertThat(logInPortalNoteAPI("weatherford"), containsString(""));
    }

    @SuppressWarnings("deprecation")
    @Test
    public void logInUtilityWeatherford() throws Exception
    {
        assertThat(logInUtility("weatherford"), containsString(stringUtility));
    }
}