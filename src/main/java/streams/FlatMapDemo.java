package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Antony Genil Gregory on 1/2/2020 7:28 AM
 * For project : JavaExperiments
 **/
public class FlatMapDemo {
    public static void main(String[] args) {
        /**
         * Problem: How could you return a list of all the unique chars for a list of words? For example, given the list
         * of words ["Hello", "World"], you'd like to return the list [H e l o W r d]
         *
         *
         */
        String[] words = {"Hello", "World"};
        // flatmap- // get amalgamated (united)

        List<String> uniqueChars = Arrays
                .stream(words)
                .map(word->word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        uniqueChars.forEach(System.out::println);

    }
}
