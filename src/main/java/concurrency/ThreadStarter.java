package concurrency;

/**
 * Created by Antony Genil on 1/3/20 at 18 38 for JavaExperiments
 **/
public class ThreadStarter {
    public static void main(String[] args) {
        new Thread(new RunnableDemo()).start();
        new ThreadExtendDemo().start();
        new Thread(new RunnableDemo()).start();
        new ThreadExtendDemo().start();
        System.out.println("- ---- ---- Over --");



    }
}
