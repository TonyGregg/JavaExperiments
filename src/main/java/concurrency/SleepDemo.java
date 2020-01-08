package concurrency;

/**
 * Created by Antony Genil on 1/3/20 at 18 51 for JavaExperiments
 **/
public class SleepDemo implements Runnable {
    private static int counter = 0;


    public static void main(String[] args) throws InterruptedException {
        new Thread(new SleepDemo()).start();

        while (SleepDemo.counter < 100) {
            System.out.println("Not reached yet");
            Thread.sleep(1000);
        }

        System.out.println("Reached !"+SleepDemo.counter);

    }

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            SleepDemo.counter++;
        }
    }
}
