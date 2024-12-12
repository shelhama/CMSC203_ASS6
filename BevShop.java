package bevshop;

import java.util.ArrayList;

public class BevShop implements BevShopInterface {
    private ArrayList<Order> orders;
    private Order currentOrder;
    private int numOfAlcoholInCurrentOrder;

    public BevShop() {
        orders = new ArrayList<>();
        numOfAlcoholInCurrentOrder = 0;
    }

    @Override
    public boolean validTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    @Override
    public boolean eligibleForMore() {
        return numOfAlcoholInCurrentOrder < MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public boolean validAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
        if (!validTime(time)) {
            throw new IllegalArgumentException("Invalid time. Time must be between " + MIN_TIME + " and " + MAX_TIME + ".");
        }
        currentOrder = new Order(time, day, new Customer(customerName, customerAge));
        orders.add(currentOrder);
        numOfAlcoholInCurrentOrder = 0;
    }

    @Override
    public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
        if (currentOrder == null) {
            throw new IllegalStateException("No active order. Start a new order first.");
        }
        currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    @Override
    public void processAlcoholOrder(String bevName, SIZE size) {
        if (currentOrder == null) {
            throw new IllegalStateException("No active order. Start a new order first.");
        }
        if (!validAge(currentOrder.getCustomer().getAge())) { // Validate customer's age from order
            throw new IllegalArgumentException("Customer is not of legal age for alcohol.");
        }
        if (!eligibleForMore()) { // Check alcohol limit
            throw new IllegalStateException("Cannot add more than " + MAX_ORDER_FOR_ALCOHOL + " alcohol beverages to an order.");
        }
        boolean isWeekend = currentOrder.getOrderDay() == DAY.SATURDAY || currentOrder.getOrderDay() == DAY.SUNDAY;
        currentOrder.addNewBeverage(bevName, size, isWeekend);
        numOfAlcoholInCurrentOrder++;
    }


    @Override
    public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
        if (currentOrder == null) {
            throw new IllegalStateException("No active order. Start a new order first.");
        }
        if (numOfFruits > MAX_FRUIT) {
            throw new IllegalArgumentException("Number of fruits cannot exceed " + MAX_FRUIT);
        }
        currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index != -1) {
            return orders.get(index).calcOrderTotal();
        }
        return 0.0;
    }

    @Override
    public double totalMonthlySale() {
        double total = 0;
        for (Order order : orders) {
            total += order.calcOrderTotal();
        }
        return total;
    }

    @Override
    public void sortOrders() {
        for (int i = 0; i < orders.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < orders.size(); j++) {
                if (orders.get(j).getOrderNo() < orders.get(minIndex).getOrderNo()) {
                    minIndex = j;
                }
            }
            Order temp = orders.get(i);
            orders.set(i, orders.get(minIndex));
            orders.set(minIndex, temp);
        }
    }

    @Override
    public Order getOrderAtIndex(int index) {
        if (index >= 0 && index < orders.size()) {
            return orders.get(index);
        }
        return null;
    }

    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    public int getNumOfAlcoholDrink() {
        return numOfAlcoholInCurrentOrder;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }
}
