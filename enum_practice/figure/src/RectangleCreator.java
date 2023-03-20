package enum_practice.figure.src;

import java.util.List;

public class RectangleCreator implements FigureCreator {

    @Override
    public Figure create(List<Point> points) {
        return new Rectangle(points);
    }
}
