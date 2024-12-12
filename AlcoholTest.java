package bevshop;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AlcoholTest {

    @Test
    public void testAlcoholCreation() {
        Alcohol alcohol = new Alcohol("Wine", SIZE.MEDIUM, true);
        assertEquals("Wine", alcohol.getName());
        assertEquals(SIZE.MEDIUM, alcohol.getSize());
       
    }

    @Test
    public void testCalcPrice() {
        Alcohol alcohol = new Alcohol("Beer", SIZE.LARGE, true);
        double expectedPrice = 2.0 + 2.0 + 0.6; // Base price + large size increment + weekend cost
        assertEquals(expectedPrice, alcohol.calcPrice(), 0.01);
    }
}
