package bevshop;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BevShopTestStudent {
    private BevShop bevShop;

    @BeforeEach
    public void setUp() {
        bevShop = new BevShop();
    }

    // Test valid and invalid order times
    @Test
    public void testValidTime() {
        assertTrue(bevShop.validTime(10)); // Within range
        assertTrue(bevShop.validTime(23)); // Upper boundary
        assertFalse(bevShop.validTime(7)); // Below range
        assertFalse(bevShop.validTime(24)); // Above range
    }

    // Test valid and invalid customer ages for alcohol
    @Test
    public void testValidAge() {
        assertTrue(bevShop.validAge(21)); // Minimum valid age
        assertTrue(bevShop.validAge(25)); // Above minimum
        assertFalse(bevShop.validAge(20)); // Below minimum
    }

    // Test starting a new order
    @Test
    public void testStartNewOrder() {
        bevShop.startNewOrder(10, DAY.MONDAY, "John", 23);
        assertNotNull(bevShop.getCurrentOrder());
        assertEquals("John", bevShop.getCurrentOrder().getCustomer().getName());
        assertEquals(23, bevShop.getCurrentOrder().getCustomer().getAge());
        assertEquals(10, bevShop.getCurrentOrder().getOrderTime());
    }

    // Test adding coffee to the current order
    @Test
    public void testProcessCoffeeOrder() {
        bevShop.startNewOrder(10, DAY.MONDAY, "John", 23);
        bevShop.processCoffeeOrder("Latte", SIZE.MEDIUM, true, false);
        assertEquals(1, bevShop.getCurrentOrder().getBeverages().size());
        assertEquals(3.5, bevShop.getCurrentOrder().calcOrderTotal(), 0.01); // Total price
    }

    // Test adding alcohol to the current order and enforcing limits
    @Test
    public void testProcessAlcoholOrder() {
        bevShop.startNewOrder(10, DAY.MONDAY, "John", 23);
        bevShop.processAlcoholOrder("Wine", SIZE.SMALL);
        assertEquals(1, bevShop.getNumOfAlcoholDrink());
        assertEquals(2.0, bevShop.getCurrentOrder().calcOrderTotal(), 0.01);

        // Add more alcohol
        bevShop.processAlcoholOrder("Beer", SIZE.MEDIUM);
        bevShop.processAlcoholOrder("Whiskey", SIZE.LARGE);
        assertEquals(3, bevShop.getNumOfAlcoholDrink());

        // Exceed alcohol limit
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            bevShop.processAlcoholOrder("Vodka", SIZE.SMALL);
        });
        assertEquals("Cannot add more than 3 alcohol beverages to an order.", exception.getMessage());
    }

    // Test adding smoothies to the current order and enforcing fruit limits
    @Test
    public void testProcessSmoothieOrder() {
        bevShop.startNewOrder(10, DAY.TUESDAY, "Alice", 20);
        bevShop.processSmoothieOrder("Berry Blast", SIZE.SMALL, 3, true);

        // Update the expected value to 5.0
        assertEquals(5.0, bevShop.getCurrentOrder().calcOrderTotal(), 0.01);

        // Test exceeding fruit limit
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bevShop.processSmoothieOrder("Tropical Blend", SIZE.LARGE, 6, false);
        });
        assertEquals("Number of fruits cannot exceed 5", exception.getMessage());
    }




    // Test calculating total monthly sales
    @Test
    public void testTotalMonthlySale() {
        // First order
        bevShop.startNewOrder(10, DAY.MONDAY, "John", 23);
        bevShop.processCoffeeOrder("Latte", SIZE.SMALL, true, false); // $2.5
        bevShop.processAlcoholOrder("Wine", SIZE.SMALL); // $2.0
        assertEquals(4.5, bevShop.getCurrentOrder().calcOrderTotal(), 0.01);

        // Second order
        bevShop.startNewOrder(12, DAY.SUNDAY, "Alice", 20);
        bevShop.processSmoothieOrder("Berry Blast", SIZE.MEDIUM, 3, true); // $6.0
        assertEquals(6.0, bevShop.getCurrentOrder().calcOrderTotal(), 0.01);

        // Check total monthly sales
        assertEquals(10.5, bevShop.totalMonthlySale(), 0.01);
    }




    // Test sorting orders by order number
    @Test
    public void testSortOrders() {
        bevShop.startNewOrder(10, DAY.MONDAY, "John", 23);
        bevShop.startNewOrder(12, DAY.TUESDAY, "Alice", 21);
        bevShop.startNewOrder(14, DAY.WEDNESDAY, "Bob", 25);

        bevShop.sortOrders();

        // Check order numbers are sorted
        assertTrue(bevShop.getOrderAtIndex(0).getOrderNo() < bevShop.getOrderAtIndex(1).getOrderNo());
        assertTrue(bevShop.getOrderAtIndex(1).getOrderNo() < bevShop.getOrderAtIndex(2).getOrderNo());
    }
}
