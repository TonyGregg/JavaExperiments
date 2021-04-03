package newfeatures;

import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on Sat, 1/9/21 at 6:35 PM by Genil.
 */
public class OptionalDemo {
  private static String getInsuranceName(Optional<Person> person) {
    return person.flatMap(Person::getCar)
        .flatMap(Car::getInsurance)
        .map(Insurance::getName)
        .orElse("Unknown");
  }
  public static void main(String[] args){
    Insurance insurance = new Insurance("Lemonade",200.25);
    Optional<Insurance> optionalInsurance = Optional.of(insurance);
//    Optional<Car> car = Optional.of(new Car(optionalInsurance));
    Optional<Car> car = Optional.empty();
    Optional<Person> person = Optional.of(new Person(car));
//    Optional<Person> person = Optional.empty();
    System.out.println(getInsuranceName(person));
  }

}
@AllArgsConstructor
@NoArgsConstructor
@Data
class Person {
  Optional<Car> car;
}

@AllArgsConstructor
@Data
class Car {
  Optional<Insurance> insurance;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Insurance {
  private String name;
  private double policyAmount;
}
