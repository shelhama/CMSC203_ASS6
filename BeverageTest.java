package bevshop;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BeverageTest {

    @Test
    public void testCoffeePrice() {
        Coffee coffee = new Coffee("Espresso", SIZE.SMALL, true, false);
        double expectedPrice = 2.0 + 0.0 + 0.5; // Base price + small size + extra shot
        assertEquals(expectedPrice, coffee.calcPrice(), 0.01);
    }

    @Test
    public void testAlcoholPrice() {
        Alcohol alcohol = new Alcohol("Beer", SIZE.MEDIUM, false);
        double expectedPrice = 2.0 + 1.0; // Base price + medium size
        assertEquals(expectedPrice, alcohol.calcPrice(), 0.01);
    }

    @Test
    public void testSmoothiePrice() {
        Smoothie smoothie = new Smoothie("Tropical", SIZE.LARGE, 3, true);
        double expectedPrice = 2.0 + 2.0 + (3 * 0.5) + 1.5; // Base price + large size + fruits + protein
        assertEquals(expectedPrice, smoothie.calcPrice(), 0.01);
    }
}
