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
  public Channel addChannel(Channel channel) {
    return this.addChannel(channel);
  }

  public Channel removeChannel(Channel channel) {
    return this.removeChannel(channel);
  }

  public void processNews(String news) {
    for (Channel channel : channelList) {
      channel.update(news);
    }
  }

}
