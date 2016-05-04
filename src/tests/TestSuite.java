package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Runs associated unit tests.
 *
 * @author Shaun Christensen
 */
@RunWith(Suite.class)
@SuiteClasses(
{
    MyMessages.class,
    MyAccount.class
})
public class TestSuite
{
}