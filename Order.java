package bevshop;

import java.util.ArrayList;

public class Order implements Comparable<Order> {
    private int orderNo;
    private int orderTime;
    private DAY orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverages;

    public Order(int orderTime, DAY orderDay, Customer customer) {
        this.orderNo = generateOrderNo();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(customer); // Use deep copy
        this.beverages = new ArrayList<>();
    }

    private int generateOrderNo() {
        return (int) (Math.random() * 90000) + 10000; // Generate random 5-digit order number
    }

    public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    public void addNewBeverage(String bevName, SIZE size, boolean isWeekend) {
        beverages.add(new Alcohol(bevName, size, isWeekend));
    }

    public double calcOrderTotal() {
        double total = 0;
        for (Beverage bev : beverages) {
            total += bev.calcPrice();
        }
        return total;
    }

    public int findNumOfBeveType(TYPE type) {
        int count = 0;
        for (Beverage bev : beverages) {
            if (bev.getType() == type) {
                count++;
            }
        }
        return count;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public DAY getOrderDay() {
        return orderDay;
    }

       public Customer getCustomer() {
            return new Customer(customer); // Return a deep copy of the customer
        }
    
    public ArrayList<Beverage> getBeverages() {
        return beverages;
    }

    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.orderNo, other.orderNo);
    }
    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order No: ").append(orderNo).append(", Time: ").append(orderTime).append(", Day: ").append(orderDay).append("\n");
        sb.append("Customer: ").append(customer.toString()).append("\n");
        for (Beverage bev : beverages) {
            sb.append(bev.toString()).append("\n");
        }
        return sb.toString();
    }
}
