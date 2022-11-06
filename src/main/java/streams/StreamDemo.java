package streams;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/** Created by Antony Genil Gregory on 1/2/2020 1:35 AM For project : JavaExperiments */
public class StreamDemo {
  public static void main(String[] args) {
    ArrayList<Dish> dishes = getMenus();
    // 1. Get low calorie dishes name, sort by low to high calorie
    List<String> lowCalorieDishes =
        dishes.parallelStream()
            .filter(dish -> dish.getCalories() < 500)
            .sorted(comparing(Dish::getCalories))
            .map(Dish::getName)
            .collect(Collectors.toList());

    lowCalorieDishes.forEach(System.out::println);


    // reverse order
    List<String> lowCalorieDishesReverseOrder =
        dishes.parallelStream()
            .filter(dish -> dish.getCalories() < 500)
            .sorted(comparing(Dish::getCalories).reversed())
            .map(Dish::getName)
            .collect(Collectors.toList());
    // use of takewhile (java 9 feature)
    // If the menu is already ordered, stop once you found a dish that is greater than or equal to
    // 300 calories

    List<Dish> lowCalorieMenus =
        dishes.stream()
            .takeWhile(dish -> dish.getCalories() <= 300)
            .collect(Collectors.toList());
    //
    System.out.println("Takewhile demo. No filter. ");
    //
    //        lowCalorieMenus.forEach(System.out::println);println

    // opposite is dropWhile
    List<Dish> highCalorieDishes =
        dishes.stream().dropWhile(dish -> dish.getCalories() < 300).collect(Collectors.toList());
    System.out.println("use of dropWhile. ");
    highCalorieDishes.forEach(System.out::println);
    Comparator<Dish> calorieComparator = Comparator.comparingInt(Dish::getCalories);

    // The most caloric dish
    Optional<Dish> mostCaloricDish = dishes.stream().collect(Collectors.maxBy(calorieComparator));

    System.out.println("Most Caloric Dish in the world : " + mostCaloricDish.get());
    // max caloric dish using reducing
    final Optional<Dish> optionalDish = dishes.stream()
        .collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));

    if (optionalDish.isPresent()) {
      System.out.println("The most caloric dish " + optionalDish.get());
    }
    // Group by Dish
    final Map<Type, List<Dish>> typeListMap = dishes.stream()
        .collect(Collectors.groupingBy(Dish::getType));
    System.out.println("By Type " + typeListMap);
  }

  private static ArrayList<Dish> getMenus() {
    ArrayList<Dish> dishes = new ArrayList<>();

    Dish dish = new Dish("Parotta", 150, 3.0f, Type.VEGETARIAN);
    dishes.add(dish);
    dish = new Dish("Dhal Makhini", 250, 12.0f, Type.VEGETARIAN);
    dishes.add(dish);
    dish = new Dish("Kothu Parotta", 1300, 6.0f, Type.NON_VEG);
    dishes.add(dish);

    dish = new Dish("Mutton Curry", 450, 15.0f, Type.NON_VEG);
    dishes.add(dish);

    dish = new Dish("Goat Biryani", 500, 17.0f, Type.NON_VEG);
    dishes.add(dish);

    dish = new Dish("Mutton Chuka", 550, 12.0f, Type.NON_VEG);
    dishes.add(dish);

    dish = new Dish("Fish curry", 250, 14.0f, Type.SEA_FOOD);
    dishes.add(dish);

    dish = new Dish("Fish fry", 450, 18.0f, Type.SEA_FOOD);
    dishes.add(dish);

    return dishes;
  }
}
