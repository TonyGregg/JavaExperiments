package patterns.observable;

/**
 * Created on Mon, 10/24/22 at 5:56 PM by Genil.
 */
public class DramaChannel implements Channel{

  @Override
  public void update(String news) {
    if (news.indexOf("Gossip") != -1) {
      System.out.println("Publish this great news " +news);
    }
  }
}
