package bevshop;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SmoothieTest {

    @Test
    public void testSmoothieCreation() {
        Smoothie smoothie = new Smoothie("Berry Blast", SIZE.SMALL, 3, true);
        assertEquals("Berry Blast", smoothie.getName());
        assertEquals(SIZE.SMALL, smoothie.getSize());
        assertEquals(3, smoothie.getNumOfFruits());
        assertTrue(smoothie.hasProtein());
    }

    @Test
    public void testCalcPrice() {
        Smoothie smoothie = new Smoothie("Tropical", SIZE.LARGE, 4, true);
        double expectedPrice = 2.0 + 2.0 + (4 * 0.5) + 1.5; // Base price + large size increment + fruits + protein
        assertEquals(expectedPrice, smoothie.calcPrice(), 0.01);
    }
}
