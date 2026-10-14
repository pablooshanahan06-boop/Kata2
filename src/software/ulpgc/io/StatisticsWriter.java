package software.ulpgc.io;

import java.util.Map;

public interface StatisticsWriter {
    void write(Map<String, Long> statistics);
}