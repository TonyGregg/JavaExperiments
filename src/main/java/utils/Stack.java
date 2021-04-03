package utils;

import java.util.Arrays;
import java.util.EmptyStackException;

/** Created on Sat, 1/16/21 at 9:02 PM by Genil. Operations : push(), pop() */
public class Stack {
  private static final int DEFAULT_INITIAL_CAPACITY = 16;
  private int[] elements;
  private int size = 0; // holds current size

  // Initialize with the default capacity.
  public Stack() {
    elements = new int[DEFAULT_INITIAL_CAPACITY];
  }

  public static void main(String[] args) {
    Stack stack = new Stack();
    for (int i = 0; i < 25; i++) {
      stack.push(i);
    }
    for (int i = 26; i >0 ; i--) {
      System.out.print(stack.pop() + " ");
    }
  }

  // push operation.
  public void push(int i) {
    // Make sure enough room before push.
    ensureCapacity();
    elements[size++] = i;
  }

  public int pop() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    return elements[--size];
  }

  private void ensureCapacity() {
    if (elements.length == size) {
      elements = Arrays.copyOf(elements, size * 2 + 1);
    }
  }
}
