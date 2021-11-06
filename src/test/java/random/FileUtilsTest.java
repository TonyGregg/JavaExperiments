package random;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class FileUtilsTest {

  @Test
  public void testFileRead() {
    String input = getQuery("/Users/genil/src/java/JavaExperiments/src/test/resources/ssrreport/pnr-sample/test.txt");
    System.out.println(input);
  }

  /*
   *
   */
  public static String getQuery(String fFileName) {
    System.out.println("Inside getQuery " + fFileName);
    StringBuilder contents = new StringBuilder();
    try {
      File file = new File(fFileName);
      if (file != null) {
        System.out.println("File is not null. Is it a file? " + file.isFile());

      } else {
        System.out.println("File do not exist");
      }
//      String[] files = file.list();
//      System.out.println("Files size " + files.length);
//      Arrays.stream(files).forEach(System.out::println);

      BufferedReader input = new BufferedReader(new
          InputStreamReader(new FileInputStream(fFileName)));
      try {
        String line = null;
        while ((line = input.readLine()) != null) {
          contents.append(line);
          contents.append(System.getProperty("line.separator"));
        }
      } finally {
        input.close();
      }
    } catch (Exception ex) {
      //			logger.error(ex.getMessage());
      ex.printStackTrace();
    }
    return contents.toString();
  }

}