package bevshop;

public class BevShopDriver {
    public static void main(String[] args) {
        BevShop shop = new BevShop();

        // Start a new order with a valid age for alcohol
        shop.startNewOrder(10, DAY.MONDAY, "John Doe", 25);

        // Process orders
        shop.processCoffeeOrder("Latte", SIZE.SMALL, true, false);
        shop.processSmoothieOrder("Tropical Smoothie", SIZE.MEDIUM, 3, true);

        // Process Alcohol Order (valid customer age)
        shop.processAlcoholOrder("Whiskey", SIZE.LARGE);

        // Display current order
        System.out.println("Current Order:");
        System.out.println(shop.getOrderAtIndex(0));

        // Start another order with an invalid age for alcohol
        shop.startNewOrder(12, DAY.SATURDAY, "Jane Doe", 18);
        shop.processCoffeeOrder("Espresso", SIZE.LARGE, false, true);

        try {
            // Attempt to process alcohol (should throw an exception)
            shop.processAlcoholOrder("Wine", SIZE.MEDIUM);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Display all orders
        System.out.println("\nAll Orders:");
        System.out.println(shop);

        // Total sales
        System.out.println("Total Monthly Sales: " + shop.totalMonthlySale());
    }
}
