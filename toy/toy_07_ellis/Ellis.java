package toy.toy_07_ellis;

public class Ellis {
    private String position;
    private int height;
    private Beverage beverage;
    private Cake cake;
    private Fan fan;
    private Key key;

    public Ellis(String position, int height) {
        this.position = position;
        this.height = height;
    }

    // ���Ḧ ������ �������� Ű�� 24cm�� �۾���
    public void drinkBeverage(){
        beverage.drunken(0.5);
        this.height = 24;
    }

    // ����ũ�� ������ �������� Ű�� ���� Ű���� 150cm���Ͱ� Ŀ����
    public void eatCake(){
        cake.eaten(0.5);
        this.height += 150;
    }

    // ��ä���ϸ� �������� Ű�� ���� Ű���� 20cm���� �پ���.
    public void useFan(){
        fan.used();
        this.height -= 20;
    }

    // ���踦 �̿��� ���� ����Ѵ�
    public void passDoor(Door door){
        this.position = isPassThroughDoor(door) ? "garden" : this.position;
    }

    private boolean isPassThroughDoor(Door door){
        return isEnoughHeightToPassThroughDoor(door) && hasKey();
    }

    private boolean isEnoughHeightToPassThroughDoor(Door door){
        return this.height <= door.getHeight();
    }

    private boolean hasKey(){
        return this.key != null;
    }

    public void setBeverage(Beverage beverage) {
        this.beverage = beverage;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public void setFan(Fan fan) {
        this.fan = fan;
    }

    public void setKey(Key key) {
        this.key = key;
    }
}
