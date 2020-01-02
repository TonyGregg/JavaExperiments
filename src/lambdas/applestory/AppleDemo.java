package lambdas.applestory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.List.of;

/**
 * Created by Antony Genil Gregory on 1/1/2020 10:03 PM
 * For project : JavaProfessionalCert
 **/
public class AppleDemo {

    public static void main(String[] args) {
        List<Apple> apples = generateApples();
        playWithApplesOldWay(apples);

    }

    private static List<Apple> generateApples() {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(10, AppleColor.GREEN, AppleType.FUJI));
        apples.add(new Apple(20, AppleColor.RED, AppleType.RED_DELICIOUS));
        apples.add(new Apple(25, AppleColor.RED, AppleType.DAISY));
        apples.add(new Apple(32, AppleColor.RED, AppleType.GRANNY_SMITH));
        apples.add(new Apple(14, AppleColor.RED, AppleType.GOLDEN_DELICIOUS));
        apples.add(new Apple(26, AppleColor.RED, AppleType.GALA));
        apples.add(new Apple(22, AppleColor.RED, AppleType.HONEY_CRISP));
        apples.add(new Apple(30, AppleColor.YELLOW, AppleType.COSMIC_CRISP));

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
}

class Apple {
    Integer weight;
    AppleColor appleColor;
    AppleType appleType;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public AppleColor getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(AppleColor appleColor) {
        this.appleColor = appleColor;
    }

    public AppleType getAppleType() {
        return appleType;
    }

    public void setAppleType(AppleType appleType) {
        this.appleType = appleType;
    }

    Apple(int weight, AppleColor appleColor, AppleType appleType) {
        this.weight = weight;
        this.appleColor = appleColor;
        this.appleType = appleType;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", appleColor=" + appleColor +
                ", appleType=" + appleType +
                '}';
    }
}

enum AppleColor {
    GREEN, RED, YELLOW
}

enum AppleType {
    HONEY_CRISP, COSMIC_CRISP, DAISY, FUJI, GOLDEN_DELICIOUS, GALA, GRANNY_SMITH, RED_DELICIOUS
}
