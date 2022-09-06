package ch09.ex01_Object;

public class Circle implements Cloneable{
    Point p1;
    double r;

    public Circle(Point p1, double r) {
        this.p1 = p1;
        this.r = r;
    }

    public Circle clone(){
        Object obj = null;

        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return (Circle) obj;
    }

    public Circle deepCopy(){
        Object obj = null;

        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        Circle c = (Circle) obj;
        c.p1 = new Point(this.p1.x, this.p1.y);
        return c;
    }
}
