# Java Enum

## 리팩토링 미션

다음 코드를 리팩토링하시오.

```java
public interface Figure {

    List<Point> getPoints();

    int size();

    String getName();

    double area();
}
```

```java
import java.util.List;

public class FigureFactory {

    Figure getInstance(List<Point> points) {
        if (points.size() == 2) {
            return new Line(points);
        }

        if (points.size() == 3) {
            return new Triangle(points);
        }

        if (points.size() == 4) {
            return new Rectangle(points);
        }

        throw new IllegalArgumentException("유효하지 않은 도형입니다.");
    }
}
```

## 리팩토링 요구사항

숫자 2, 3, 4를 하드코딩하지 말고 enum을 활용해 상수로 만든다.

FigureFactory의 if문을 제거한다.

익명 클래스를 활용해 코드를 개선한다.

## 요구사항1 : 숫자 2, 3, 4를 하드코딩하지 말고 enum을 활용해 상수로 만든다.

FigureType이라는 enum 타입을 생성하고 enum 타입 요소로 LINE, TRIANGLE, RECTANGLE를 정의할 수 있습니다.

```java
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
}
```

위 enum 타입을 이용하여 다음과 같이 FigureFactory 클래스의 getInstance 메서드를 다음과 같이 변경할 수 있습니다.

```java
public class FigureFactory {

    // ...
    public static Figure getInstance(List<Point> points) {
        if (FigureType.LINE.matchCountOfPoint(points.size())) {
            return new Line(points);
        }
        if (FigureType.TRIANGLE.matchCountOfPoint(points.size())) {
            return new Triangle(points);
        }
        if (FigureType.RECTANGLE.matchCountOfPoint(points.size())) {
            return new Rectangle(points);
        }
        throw new IllegalArgumentException("유효하지 않은 도형입니다.");
    }
}
```

## 요구사항2 : FigureFactory의 if문을 제거한다.

첫번째로 if문을 제거하기 위해서는 FigureType enum 타입의 메서드에 points.size()의 정수를 전달하여

points 리스트의 개수만큼 LINE 또는 TRIANGLE, RECTANGLE enum 타입이 나와야 합니다.

```java
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
```

위 코드에서 getFigureType 메서드를 선언하면 points.size() 값에 해당하는 enum 타입 구성요소가 반환됩니다.

그리고 FigureFactory 클래스에서는 Map 자료구조를 이용하여 다음과 같이 key(points.size())에 따른

FigureCreator 구현 클래스를 이용하여 Line, Triangle, Rectangle 객체를 생성할 수 있습니다.

```java
import other.enum_practice.figure.src.FigureCreator;
import other.enum_practice.figure.src.Line;

public class FigureFactory {

    private static final Map<Integer, FigureCreator> figureTypeMap = new HashMap<>();

    static {
        figureTypeMap.put(FigureType.LINE.getCountOfPoint(), new FigureCreator() {
            public Figure create(List<Point> points) {
                return new Line(points);
            }
        });
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
```

위와 같이 FigureCreator 인터페이스를 익명 클래스로 직접 구현하는 팩토리 객체를 생성할 수 있고

람다로 Triangle::new 와 같이 표현할 수도 있습니다.

