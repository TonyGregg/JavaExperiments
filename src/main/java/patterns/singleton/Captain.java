package patterns.singleton;

/**
 * Created by Antony Genil Gregory on 1/19/2020 8:16 PM
 * For project : JavaExperiments
 **/
public class Captain {
    private Captain() {
    }

    private static volatile Captain captain;
    public static  Captain getCaptain() {
        // Check for an instance and if there isn't one, enter a synchronized block
        if (captain == null) {
            synchronized (Captain.class) {
                // once in the block, check again and if still null, create an instance
                if (captain == null) {
                    captain = new Captain();                }

            }
        }
        return captain;

    }
}
