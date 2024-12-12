package bevshop;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderTest {
    private Order order;
    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer("Eve", 27);
        order = new Order(15, DAY.FRIDAY, customer);
    }

    @Test
    public void testAddNewBeverage() {
        order.addNewBeverage("Latte", SIZE.SMALL, true, false);
        assertEquals(1, order.getBeverages().size());
    }

    @Test
    public void testCalcOrderTotal() {
        order.addNewBeverage("Latte", SIZE.SMALL, true, false); // $2.5
        order.addNewBeverage("Beer", SIZE.MEDIUM, false); // $3.0
        double expectedTotal = 2.5 + 3.0;
        assertEquals(expectedTotal, order.calcOrderTotal(), 0.01);
    }

    @Test
    public void testFindNumOfBeveType() {
        order.addNewBeverage("Latte", SIZE.SMALL, true, false); // Coffee
        order.addNewBeverage("Beer", SIZE.MEDIUM, false); // Alcohol
        order.addNewBeverage("Smoothie", SIZE.LARGE, 2, true); // Smoothie
        assertEquals(1, order.findNumOfBeveType(TYPE.COFFEE));
        assertEquals(1, order.findNumOfBeveType(TYPE.ALCOHOL));
        assertEquals(1, order.findNumOfBeveType(TYPE.SMOOTHIE));
    }

    @Test
    public void testCompareTo() {
        Order anotherOrder = new Order(16, DAY.SATURDAY, new Customer("Frank", 30));
        anotherOrder.setOrderNo(order.getOrderNo() + 1);
        assertTrue(order.compareTo(anotherOrder) < 0);
    }
}
