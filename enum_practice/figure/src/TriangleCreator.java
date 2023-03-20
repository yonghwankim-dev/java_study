package enum_practice.figure.src;

import java.util.List;

public class TriangleCreator implements FigureCreator {

    @Override
    public Figure create(List<Point> points) {
        return new Triangle(points);
    }
}
