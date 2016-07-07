package automation;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class Retry implements TestRule
{
    private int intCount;

    public Retry(int count)
    {
        intCount = count;
    }

    public Statement apply(Statement statement, Description description)
    {
        return statement(statement, description);
    }

    private Statement statement(final Statement statement, final Description description)
    {
        return new Statement()
        {
            @Override
            public void evaluate() throws Throwable
            {
                Throwable throwable = null;

                for (int i = 0; i < intCount; i++)
                {
                    try
                    {
                        statement.evaluate();

                        return;
                    }
                    catch (Throwable t)
                    {
                        if (t instanceof AssertionError)
                        {
                            throw t;
                        }
                        else
                        {
                            throwable = t;
                        }
                    }
                }

                throw throwable;
            }
        };
    }
}