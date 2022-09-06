package ch09.ex01_Object;

public class Point implements Cloneable{
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("x = %d, y = %d", x, y);
    }

    public Point clone(){
        Object obj = null;
        try{
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return (Point) obj;
    }
}
