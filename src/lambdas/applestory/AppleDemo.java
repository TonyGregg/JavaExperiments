package lambdas.applestory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.List.of;

/**
 * Created by Antony Genil Gregory on 1/1/2020 10:03 PM
 * For project : JavaProfessionalCert
 **/
public class AppleDemo {

    public static void main(String[] args) {
        List<Apple> apples = generateApples();
        playWithApplesOldWay(apples);
        sortApples(apples);

    }

    private static List<Apple> generateApples() {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(10, AppleColor.GREEN, AppleType.FUJI));
        apples.add(new Apple(20, AppleColor.RED, AppleType.RED_DELICIOUS));
        apples.add(new Apple(25, AppleColor.RED, AppleType.DAISY));
        apples.add(new Apple(25, AppleColor.RED, AppleType.GRANNY_SMITH));
        apples.add(new Apple(14, AppleColor.RED, AppleType.GOLDEN_DELICIOUS));
        apples.add(new Apple(26, AppleColor.RED, AppleType.GALA));
        apples.add(new Apple(22, AppleColor.RED, AppleType.HONEY_CRISP));
        apples.add(new Apple(26, AppleColor.YELLOW, AppleType.COSMIC_CRISP));

        return apples;
    }

    private static void playWithApplesOldWay(List<Apple> apples) {
        // Sort apples by weight
        Comparator<Apple> appleComparator = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        };

        Collections.sort(apples, appleComparator);
        apples.forEach(System.out::println);

    }
    private static void sortApples(List<Apple> apples) {
        // Java 8 way
//        Comparator<Apple> byWeight = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        Comparator<Apple> byWeight1 = ( a1,  a2) -> a1.getWeight().compareTo(a2.getWeight());
        Comparator<Apple> byWeight = comparing(Apple::getWeight);
//        Collections.sort(apples, byWeight);
//        System.out.println("Sorted using lambda function ");
//        apples.forEach(System.out::println);
        //Sort by weight and apple type

        apples.sort(comparing(Apple::getWeight)
//                .reversed()
            .thenComparing(Apple::getAppleType));

        System.out.println("Sorted by weight and apple type");
        apples.forEach(System.out::println);
    }
}

