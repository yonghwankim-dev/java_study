package other.enum_practice.figure.src;

import java.util.Arrays;

public enum FigureType {
    LINE(2), TRIANGLE(3), RECTANGLE(4);

    private final int countOfPoint;

    FigureType(int countOfPoint) {
        this.countOfPoint = countOfPoint;
    }

    public int getCountOfPoint() {
        return countOfPoint;
    }

    public boolean matchCountOfPoint(int countOfPoint) {
        return this.countOfPoint == countOfPoint;
    }

    public static FigureType getFigureType(int countOfPoint) {
        return Arrays.stream(FigureType.values())
            .filter(type -> type.matchCountOfPoint(countOfPoint))
            .findFirst()
            .orElse(null);
    }
}
