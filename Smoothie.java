package bevshop;public class Smoothie extends Beverage {
    private int numOfFruits;
    private boolean addProtein;
    private final double FRUIT_COST = 0.5;  // Cost per fruit
    private final double PROTEIN_COST = 1.5;  // Cost for protein

    public Smoothie(String name, SIZE size, int numOfFruits, boolean addProtein) {
        super(name, TYPE.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }
    @Override
    public double calcPrice() {
        double price = getBasePrice() + getSizeCost();
        price += numOfFruits * FRUIT_COST;
        if (addProtein) {
            price += PROTEIN_COST;
        }
        return price;
    }


    public int getNumOfFruits() {
        return numOfFruits;
    }

    public boolean hasProtein() {
        return addProtein;
    }

    @Override
    public String toString() {
        return super.toString() + ", Fruits: " + numOfFruits + ", Protein: " + addProtein;
    }
}
