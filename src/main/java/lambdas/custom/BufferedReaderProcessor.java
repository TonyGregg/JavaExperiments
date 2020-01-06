package lambdas.custom;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Antony Genil on 1/6/20 at 08 54 for JavaExperiments
 **/
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader reader) throws IOException;
}
