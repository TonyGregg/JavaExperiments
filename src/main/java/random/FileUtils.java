package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created on Wed, 5/26/21 at 12:09 PM by Genil.
 */
public class FileUtils {
  public static void main(String[] args) {

  }
  /*
   *
   */
  public static String getQuery(String fFileName) {
    StringBuilder contents = new StringBuilder();
    try {
      BufferedReader input = new BufferedReader(new InputStreamReader(Object.class.getResourceAsStream(fFileName)));
      try {
        String line = null;
        while ((line = input.readLine()) != null) {
          contents.append(line);
          contents.append(System.getProperty("line.separator"));
        }
      } finally {
        input.close();
      }
    } catch (IOException ex) {
//			logger.error(ex.getMessage());
    }
    return contents.toString();
  }
}
