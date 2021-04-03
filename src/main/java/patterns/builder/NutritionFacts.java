package patterns.builder;

class NutritionFacts {
  private final int serveSize;
  private final int servings;
  private final int sodium;
  private final int fat;
  private final short magnesium;
  private final Short calcium;
  private NutritionFacts(Builder builder) {
    this.serveSize = builder.serveSize;
    this.servings = builder.servings;
    this.sodium = builder.sodium;
    this.fat = builder.fat;
    this.calcium = builder.calcium;
    this.magnesium = builder.magnesium;
  }

  public static void main(String[] args) {
    NutritionFacts cocoCola = new Builder(20, 10).fat(0).sodium(20).calcium((short) 10).build();

    System.out.println("Magnesium :: " + cocoCola.magnesium);
    System.out.println("Calcium :: " + cocoCola.calcium);
  }

  static class Builder {
    private final int serveSize;
    private final int servings;

    private int sodium = 0;
    private int fat = 0;

    private short magnesium = 0;
    private Short calcium = 0;

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
}