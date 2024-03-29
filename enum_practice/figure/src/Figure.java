package enum_practice.figure.src;

import java.util.List;

public interface Figure {
    List<Point> getPoints();

    int size();

    String getName();

    double area();
}
