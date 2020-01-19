package lambdas.custom;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Antony Genil on 1/19/20 at 13 39 for JavaExperiments
 **/

@FunctionalInterface
public interface LittleHelper {
    public String doThings(Errands errands);
}


class Errands {
    public String checkMailPosts() {
        return "At post-office, checking mails..";
    }
    public String getBooksFromLibrary(String libraryName) {
        return "I am @ " + libraryName + ", going to check-out few books";
    }
    public String buyGroceries(String storeName) {
        System.out.println("At store "+storeName);
        return "At store "+storeName;
    }
}
