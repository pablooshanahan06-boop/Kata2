package software.ulpgc.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class TsvStatisticsWriter implements StatisticsWriter {
    private final OutputStream outputStream;

    private TsvStatisticsWriter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public static TsvStatisticsWriter with(OutputStream outputStream) {
        return new TsvStatisticsWriter(outputStream);
    }

    @Override
    public void write(Map<String, Long> statistics) {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
        try {
            writer.write("Gender\tCount\n");
            for (Map.Entry<String, Long> entry : statistics.entrySet()) {
                writer.write(entry.getKey() + "\t" + entry.getValue() + "\n");
            }
            writer.flush();
        } catch (IOException e) {
            System.err.println("Error escribiendo la estadística: " + e.getMessage());
        }
    }
}