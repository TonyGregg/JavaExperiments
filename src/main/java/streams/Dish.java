package streams;

/**
 * Created by anton on 6/9/2018 10:19 AM
 **/
public class Dish {
    private final String name;
    private final int calories;
    private final float price;
    private final Type type;

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public float getPrice() {
        return price;
    }

    public Type getType() {
        return type;
    }

    public Dish(String name, int calories, float price, Type type) {
        this.name = name;
        this.calories = calories;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", price=" + price +
                '}';
    }

}
enum Type {
    VEGETARIAN, NON_VEG, SEA_FOOD;
}
