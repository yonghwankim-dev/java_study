package toy.toy_07_ellis;

public abstract class Food {
    double quantity;

    public Food(double quantity) {
        this.quantity = quantity;
    }

    public void eaten(double quantity){
        this.quantity = isEatenAll(quantity) ? 0 : this.quantity - quantity;
    }

    public boolean isEatenAll(double quantity){
        return this.quantity <= quantity;
    }
}
