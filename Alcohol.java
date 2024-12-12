package bevshop;

public class Alcohol extends Beverage {
    private boolean offeredInWeekend;
    public static final double WEEKEND_COST = 0.6;

    public Alcohol(String name, SIZE size, boolean offeredInWeekend) {
        super(name, TYPE.ALCOHOL, size);
        this.offeredInWeekend = offeredInWeekend;
    }

    @Override
    public double calcPrice() {
        double price = BASE_PRICE;
        if (getSize() == SIZE.MEDIUM) price += SIZE_PRICE;
        if (getSize() == SIZE.LARGE) price += 2 * SIZE_PRICE;
        if (offeredInWeekend) price += WEEKEND_COST;
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Weekend: %b, Price: %.2f", offeredInWeekend, calcPrice());
    }
}

