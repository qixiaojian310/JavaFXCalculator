import org.example.util.HistoryRecorder;
import org.junit.Test;

public class HistoryRecorderTest {
    @Test
    public void testHistoryRecorder() {
        HistoryRecorder.writeDownHistory("8*8-3*8","40", "11c134b8-d379-4cfb-9d9e-91bc6d54ff11");
    }
}
