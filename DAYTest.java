package bevshop;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DAYTest {

    @Test
    public void testDayEnumValues() {
        DAY[] days = DAY.values();
        assertEquals(7, days.length);
        assertEquals(DAY.MONDAY, days[0]);
        assertEquals(DAY.SUNDAY, days[6]);
    }
}
