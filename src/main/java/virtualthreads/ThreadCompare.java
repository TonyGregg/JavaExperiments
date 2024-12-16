package virtualthreads;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ThreadCompare {
    public static void main(String[] args) {
        var begin = Instant.now();
        try (var exec = Executors.newCachedThreadPool()) {
            IntStream.range(0, 1000).forEach(i -> exec.submit(() -> {
                Thread.sleep(Duration.ofSeconds(1));
                return i;
            }));
        }
        var end = Instant.now();
        System.out.println(Duration.between(begin, end));
    }
}
