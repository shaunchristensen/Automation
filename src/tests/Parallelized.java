package tests;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.runners.Parameterized;
import org.junit.runners.model.RunnerScheduler;

public class Parallelized extends Parameterized
{
    private static class ThreadPoolScheduler implements RunnerScheduler
    {
        // fields

        private ExecutorService executorService;

        // constructors

        public ThreadPoolScheduler()
        {
            String stringThreads = System.getProperty("junit.parallel.threads", "16");
            int intThreads = Integer.parseInt(stringThreads);
            executorService = Executors.newFixedThreadPool(intThreads);
        }

        // methods

        @Override
        public void finished()
        {
            executorService.shutdown();

            try
            {
                executorService.awaitTermination(5, TimeUnit.MINUTES);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void schedule(Runnable r)
        {
            executorService.submit(r);
        }
    }

    // constructors

    public Parallelized(Class<?> c) throws Throwable
    {
        super(c);
        setScheduler(new ThreadPoolScheduler());
    }
}