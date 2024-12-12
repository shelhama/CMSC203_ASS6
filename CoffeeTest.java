package bevshop;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoffeeTest {
    Coffee coffee;

    @Before
    public void setUp() throws Exception {
        coffee = new Coffee("Latte", SIZE.MEDIUM, true, false);// Initialize Coffee object before each test method
    }

    @After
    public void tearDown() throws Exception {
        coffee = null;//Reset Coffee object to null after each test 
    }

    @Test
    public void testCalcPrice() {
        assertEquals(3.5, coffee.calcPrice(), .01);
    }

    @Test
    public void testEquals() {
        Coffee sameCoffee = new Coffee("Latte", SIZE.MEDIUM, true, false);
        Coffee differentCoffee = new Coffee("Espresso", SIZE.SMALL, true, false);

        assertTrue(coffee.equals(sameCoffee));
        assertFalse(coffee.equals(differentCoffee));
    }
}

