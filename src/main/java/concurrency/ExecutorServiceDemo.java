package concurrency;

import java.io.IOException;
import java.util.concurrent.*;

import static java.lang.Thread.*;

/**
 * Created by Antony Genil Gregory on 1/4/2020 11:14 AM
 * For project : JavaExperiments
 **/
public class ExecutorServiceDemo {
    static int counter = 0;
    public static void main(String[] args) {
        demoSingleThreadExecExec();
        demoSingleThreadExectuorSub();
        useCallable(() -> {
            System.out.println("Something. .. something..");
//            return null;
            throw new IOException();
        });
    }
    private static void useCallable(Callable<Integer> callable) {
        try {
            System.out.println("UseCallable method "+callable.call());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void demoSingleThreadExectuorSub() {
        ExecutorService executorService = null;
        try {
            executorService = Executors.newSingleThreadExecutor();

            Future<?> result = executorService.submit(() -> {
                for (int i = 0; i < 10; i++) {
                    counter ++;
                }

            });
            result.get(10, TimeUnit.SECONDS);
            System.out.println("Reached !");
        }  catch (TimeoutException | InterruptedException | ExecutionException e) {
            System.out.println("Not reached on time !");
        } finally {
            if (executorService != null) executorService.shutdown();
        }
    }

    /**
     *  Demo singleThreadExecutor's execute method
     */
    private static void demoSingleThreadExecExec() {
        ExecutorService executorService = null;
        try {
            System.out.println("Single thread executor demo begin..");
            executorService = Executors.newSingleThreadExecutor();
            executorService.execute(() -> System.out.println("Printing Zoo inventory"));
            executorService.execute(ExecutorServiceDemo::srun);
            executorService.execute(() -> {
                System.out.println("Finished Printing Zoo inventory");
            });
            System.out.println("The End !!");
        } finally {
            /**
             * It is important that the submit method is called at the end. Because thread scheduler
             * will schedule a non-daemon thread on the 1st task that is executed, so failing to call
             * shutdown() will result in your application never terminating.
             *
             * When shutdown() is called, thread scheduler will stop processing new requests, isShutdown() returns true;
             * isTerminated() returns false. If new tasks is submitted during shutdown, a RejectedExecutionException
             * will be thrown.
             * Once active tasks have been completed, isShutdown() and isTerminated() returns true
             */
            System.out.println("isShutdown()? "+executorService.isShutdown()
                    + " Is Terminated ? "+executorService.isTerminated());
            if (executorService != null) executorService.shutdown();
            System.out.println("isShutdown()? "+executorService.isShutdown()
                    + " Is Terminated ? "+executorService.isTerminated());
        }


    }

    private static void srun() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Printing record " + i);
            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
