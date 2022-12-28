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

    // 음료를 먹으면 엘리스의 키가 24cm로 작아짐
    public void drinkBeverage(){
        beverage.drunken(0.5);
        this.height = 24;
    }

    // 케이크를 먹으면 엘리스의 키가 현재 키에서 150cm미터가 커진다
    public void eatCake(){
        cake.eaten(0.5);
        this.height += 150;
    }

    // 부채질하면 엘리스의 키가 현재 키에서 20cm미터 줄어든다.
    public void useFan(){
        fan.used();
        this.height -= 20;
    }

    // 열쇠를 이용해 문을 통과한다
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
