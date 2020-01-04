package concurrency;

/**
 * Created by Antony Genil on 1/3/20 at 18 26 for JavaExperiments
 **/
public class RunnableDemo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Runnable Printing record "+i);
        }
    }

    public static void main(String[] args) {
        new Thread(new RunnableDemo()).start();
        System.out.println("Completed");
    }
}
