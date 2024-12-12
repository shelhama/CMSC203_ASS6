package bevshop;

import static org.junit.Assert.*;
import org.junit.Test;

public class TYPETest {
    @Test
    public void testEnumValues() {
        assertEquals("COFFEE", TYPE.COFFEE.toString());
        assertEquals("SMOOTHIE", TYPE.SMOOTHIE.toString());
        assertEquals("ALCOHOL", TYPE.ALCOHOL.toString());
    }
}

