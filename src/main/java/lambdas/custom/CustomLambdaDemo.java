package lambdas.custom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Antony Genil on 1/6/20 at 08 56 for JavaExperiments
 **/
public class CustomLambdaDemo {
    public static void main(String[] args) {
        try {
            String oneLine = processFile((BufferedReader::readLine));
            String twoLines = processFile((BufferedReader reader) ->
                 reader.readLine() + reader.readLine());

            System.out.println("Line 1 "+oneLine + " Two lines after that "+twoLines);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String processFile(BufferedReaderProcessor bufferedReaderProcessor) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"))) {
            return bufferedReaderProcessor.process(bufferedReader);

        }
    }
}
