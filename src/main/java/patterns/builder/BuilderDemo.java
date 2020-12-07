package patterns.builder;

/**
 * Created by Antony Genil Gregory on 1/19/2020 8:34 PM
 * For project : JavaExperiments
 **/
public class BuilderDemo {
}

class NutritionFacts {
    private NutritionFacts(Builder builder) {
        this.serveSize = builder.serveSize;
        this.servings = builder.servings;
        this.sodium = builder.sodium;
        this.fat = builder.fat;
        this.calcium = builder.calcium;
        this.magnesium = builder.magnesium;
    }

    private final int serveSize;
    private final int servings;
    private int sodium;
    private int fat;
    private short magnesium;
    private Short calcium;

    static class Builder {
        private final int serveSize;
        private final int servings;

        private int sodium;
        private int fat;

        private short magnesium;
        private Short calcium;

        Builder(int serveSize, int servings) {
            this.serveSize = serveSize;
            this.servings = servings;
        }
        public NutritionFacts build() {
            return new NutritionFacts(this);
        }

        public Builder fat(int fat) {
            this.fat = fat;
            return this;
        }

        public Builder sodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        public Builder magnesium(short magnesium) {
            this.magnesium = magnesium;
            return this;
        }

        public Builder calcium(Short calcium) {
            this.calcium = calcium;
            return this;
        }
    }

    public static void main(String[] args) {
        NutritionFacts cocoCola = new Builder(20,10).fat(0).sodium(20).calcium((short) 10).build();

        System.out.println("Magnesium :: "+cocoCola.magnesium);
        System.out.println("Calcium :: "+cocoCola.calcium);
    }
}
