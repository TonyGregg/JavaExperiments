package patterns.observable;

/**
 * Created on Sat, 4/3/21 at 12:22 PM by Genil.
 */
public class SportsChannel implements Channel{

  @Override
  public void update(String news) {
    if (news.indexOf("tennis") != -1) {
      System.out.println("Worth the money sports news " + news);
    }
  }
}
