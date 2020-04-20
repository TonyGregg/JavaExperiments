package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Antony Genil on 1/16/20 at 18 19 for JavaExperiments
 **/
public class ConcurrentExcepDemo {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("s");

        Iterator<String> stringIterator = strings.iterator();

        while (stringIterator.hasNext()) {
//            System.out.println(stringIterator.next ());
//            strings.remove("s"); // concurrent modification exception
            if (stringIterator.next().equals("s")) {
                System.out.println("found s.. ");
                stringIterator.remove(); //works fine


            }
        }

        System.out.println(strings);

    }
}
