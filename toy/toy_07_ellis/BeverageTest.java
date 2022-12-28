package toy.toy_07_ellis;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class BeverageTest {

    Beverage beverage;

    @Before
    public void setup(){
        beverage = new Beverage(0.5);
    }

    // �̹� �����ϴ� �纸�� �� ���� ���� �������� �Ҷ� ���� ���� Ȯ���ϴ� �׽�Ʈ
    @Test
    public void drunken() throws NoSuchFieldException, IllegalAccessException {
        beverage.drunken(0.7);

        Field field = beverage.getClass().getDeclaredField("quantity");
        field.setAccessible(true);
        double quantity = (double) field.get(beverage);

        Assertions.assertThat(quantity).isEqualTo(0);
    }

}