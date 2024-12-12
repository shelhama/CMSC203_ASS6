package bevshop;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SIZETest {

    @Test
    public void testSizeEnumValues() {
        SIZE[] sizes = SIZE.values();
        assertEquals(3, sizes.length);
        assertEquals(SIZE.SMALL, sizes[0]);
        assertEquals(SIZE.LARGE, sizes[2]);
    }
}
