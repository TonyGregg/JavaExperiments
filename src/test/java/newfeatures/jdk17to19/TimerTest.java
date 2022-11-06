package newfeatures.jdk17to19;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.Duration;
import java.time.Instant;
import java.time.InstantSource;
import org.junit.jupiter.api.Test;

class TimerTest {

  @Test
  void measure() {
    InstantSource instantSource = mock(InstantSource.class);
    when(instantSource.instant())
        .thenReturn(Instant.ofEpochMilli(1_640_033_566_000L))
        .thenReturn(Instant.ofEpochMilli(1_640_033_567_750L));

    Timer timer = new Timer(instantSource);
    Duration duration = timer.measure(() -> {});

    assertEquals(duration, Duration.ofMillis(1_750));
  }
}