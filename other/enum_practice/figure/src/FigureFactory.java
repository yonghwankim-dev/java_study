package other.enum_practice.figure.src;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FigureFactory {

    private static final Map<Integer, FigureCreator> figureTypeMap = new HashMap<>();

    static {
        figureTypeMap.put(FigureType.LINE.getCountOfPoint(), Line::new);
        figureTypeMap.put(FigureType.TRIANGLE.getCountOfPoint(), Triangle::new);
        figureTypeMap.put(FigureType.RECTANGLE.getCountOfPoint(), Rectangle::new);
    }

    public static Figure getInstance(List<Point> points) {
        try {
            return figureTypeMap.get(points.size()).create(points);
        } catch (Exception e) {
            throw new IllegalArgumentException("유효하지 않은 도형입니다.");
        }
    }
}
