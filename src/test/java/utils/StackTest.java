package utils;
import java.util.EmptyStackException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StackTest {
  static Stack stack;
  @BeforeAll
  static void beforeAll() {
    stack = new Stack();
  }

  @Test
  void doSuccessfulPushAndPop() {
    stack.push(2);
    stack.push(3);
    Assertions.assertEquals(3, stack.pop());
    Assertions.assertEquals(2, stack.pop());
  }

  @Test
  @DisplayName("Check if empty stack exception is thrown")
  void experimentEmptyStackException() {
    stack.push(30);
    Assertions.assertEquals(30, stack.pop());
    Assertions.assertThrows(EmptyStackException.class, () -> stack.pop());
  }
}