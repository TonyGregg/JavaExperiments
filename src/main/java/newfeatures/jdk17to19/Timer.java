package newfeatures.jdk17to19;

import java.time.Duration;
import java.time.Instant;
import java.time.InstantSource;

/**
 * Created on Sun, 11/6/22 at 10:33 AM by Genil.
 */
public class Timer {

  private final InstantSource instantSource;


  public Timer(InstantSource instantSource) {
    this.instantSource = instantSource;
  }
  public Duration measure(Runnable runnable) {
    Instant start = instantSource.instant();
    runnable.run();
    Instant end = instantSource.instant();
    return Duration.between(start, end);
  }
}
