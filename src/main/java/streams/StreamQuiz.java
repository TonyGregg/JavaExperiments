package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamQuiz {
  public static void main(String[] args) {
    // Given a list of numbers, how would you return a list of the square of each number?
    // For example, given [1, 2, 3, 4, 5] you should return [1, 4, 9, 16, 25]
    List<Integer> ints = Arrays.asList(2, 3, 43, 5);
    List<Integer> integers = ints.stream().map(x -> x * x).collect(Collectors.toList());
    integers.stream().forEach(System.out::println);
    // Sum all the numbers.
    int sum = ints.stream().reduce(0, (a, b) -> a + b);
    System.out.println("Sum total " + sum);
    System.out.println("Multiply total : " + ints.stream().reduce(1, (a, b) -> a * b));
    // find out the minimum
    ints.stream().reduce(Integer::min).ifPresent(m-> System.out.println("Minimum : " + m ));
    ints.stream().reduce(Integer::max).ifPresent(m-> System.out.println("Maximum : " + m ));
  }
}
