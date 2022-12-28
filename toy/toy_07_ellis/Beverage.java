package toy.toy_07_ellis;

public class Beverage {
    private double quantity;

    public Beverage(double quantity) {
        this.quantity = quantity;
    }

    public void drunken(double quantity){
        this.quantity = isEatAll(quantity) ? 0 : this.quantity - quantity;
    }

    private boolean isEatAll(double quantity){
        return this.quantity <= quantity;
    }
}
