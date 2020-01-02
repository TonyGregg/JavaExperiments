package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * Created by Antony Genil Gregory on 1/2/2020 1:35 AM
 * For project : JavaExperiments
 **/
public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<Menu> menus = getMenus();
        // 1. Get low calorie dishes name, sort by low to high calorie
        List<String> lowCalorieDishes = menus
                .parallelStream()
                .filter(menu -> menu.getCalories() < 500)
                .sorted(comparing(Menu::getCalories))
                .map(Menu::getName)
                .collect(Collectors.toList());

        lowCalorieDishes.forEach(System.out::println);
    }

    private static ArrayList<Menu> getMenus() {
        ArrayList<Menu> menus = new ArrayList<>();

        Menu menu = new Menu("Parotta",150,3.0f);
        menus.add(menu);
        menu = new Menu("Dhal Makhini",250,12.0f);
        menus.add(menu);
        menu = new Menu("Kothu Parotta",300,6.0f);
        menus.add(menu);

        menu = new Menu("Mutton Curry",450,15.0f);
        menus.add(menu);

        menu = new Menu("Goat Biryani",500,17.0f);
        menus.add(menu);

        menu = new Menu("Mutton Chuka",550,12.0f);
        menus.add(menu);




        return menus;
    }
}
