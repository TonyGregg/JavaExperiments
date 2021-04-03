package patterns.builder;

/** Created by Antony Genil Gregory on 1/19/2020 8:34 PM For project : JavaExperiments */
public class BuilderDemo {
  public static void main(String[] args) {
    NutritionFacts nutritionFacts = new NutritionFacts.Builder(20, 12)
        .fat(1)
        .sodium(2)
        .build();
  }
}
