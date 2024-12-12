package bevshop;

public abstract class Beverage {
    private String name;
    private TYPE type;
    private SIZE size;
    public static final double BASE_PRICE = 2.0;
    public static final double SIZE_PRICE = 1.0;

    public Beverage(String name, TYPE type, SIZE size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public abstract double calcPrice();

    @Override
    public String toString() {
        return String.format("Name: %s, Type: %s, Size: %s", name, type, size);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Beverage beverage = (Beverage) obj;
        return name.equals(beverage.name) && type == beverage.type && size == beverage.size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public SIZE getSize() {
        return size;
    }
    public double getBasePrice() {
        return 2.0; // Default base price
    }

    public double getSizeCost() {
        switch (size) {
            case MEDIUM: return 1.0;
            case LARGE: return 2.0;
            default: return 0.0; // Small size has no additional cost
        }
    }

    public void setSize(SIZE size) {
        this.size = size;
    }
}
