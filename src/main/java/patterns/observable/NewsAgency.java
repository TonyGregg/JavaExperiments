package patterns.observable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on Sat, 4/3/21 at 12:16 PM by Genil.
 *
 * Observer pattern involves observable - an object that updates all it's subscribers (observers)
 * when an event occurs.
 */
public class NewsAgency {
  List<Channel> channelList = new ArrayList<>();
  public boolean addChannel(Channel channel) {
    return channelList.add(channel);
  }

  public boolean removeChannel(Channel channel) {
    return channelList.remove(channel);
  }

  public void processNews(String news) {
    for (Channel channel : channelList) {
      channel.update(news);
    }
  }

  public static void main(String[] args) {
    NewsAgency newsAgency = new NewsAgency();
    newsAgency.addChannel(new SportsChannel());
    newsAgency.addChannel(new DramaChannel());
    newsAgency.processNews("Tennis news: Roger federer retired");
    newsAgency.processNews("Tennis news: Djokovic can't play at US open");
    newsAgency.processNews("Gossip news: Boris Becker back to power again in UK?");
  }

}
