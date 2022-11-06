package newfeatures.jdk17to19;

/**
 * Created on Sun, 11/6/22 at 11:11 AM by Genil.
 */
public class NewSwitch {
  private static void testSwitch(Object obj) {
    switch (obj) {
      case String s && s.length() > 5 -> System.out.println(s.toUpperCase());
      case String s                   -> System.out.println(s.toLowerCase());

      case Integer i                  -> System.out.println(i * i);

      default -> {}
    }
  }

}
