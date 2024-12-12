package bevshop;
public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;
    public static final double EXTRA_COST = 0.5;

    public Coffee(String name, SIZE size, boolean extraShot, boolean extraSyrup) {
        super(name, TYPE.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    @Override
    public double calcPrice() {
        double price = BASE_PRICE;
        if (getSize() == SIZE.MEDIUM) price += SIZE_PRICE;
        if (getSize() == SIZE.LARGE) price += 2 * SIZE_PRICE;
        if (extraShot) price += EXTRA_COST;
        if (extraSyrup) price += EXTRA_COST;
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Extra Shot: %b, Extra Syrup: %b, Price: %.2f", extraShot, extraSyrup, calcPrice());
    }
}
