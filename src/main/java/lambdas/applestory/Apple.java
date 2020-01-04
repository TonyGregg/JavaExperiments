package lambdas.applestory;

/**
 * Created by Antony Genil Gregory on 1/1/2020 11:14 PM
 * For project : JavaExperiments
 **/
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
