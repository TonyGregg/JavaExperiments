package concurrency;

/**
 * Created by Antony Genil on 1/3/20 at 18 37 for JavaExperiments
 **/
public class ThreadExtendDemo extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Extended Thread Printing record "+i);
        }
    }
}
