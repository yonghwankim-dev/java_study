package toy.toy_07_ellis;

public class Cake {

    private double quantity;

    public Cake(double quantity) {
        this.quantity = quantity;
    }

    public void eaten(double quantity){
        this.quantity = isEatAll(quantity) ? 0 : this.quantity - quantity;
    }

    private boolean isEatAll(double quantity){
        return this.quantity <= quantity;
    }
}
