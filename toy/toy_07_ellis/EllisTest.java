package toy.toy_07_ellis;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

public class EllisTest {

    Ellis ellis;
    Food beverage;
    Food cake;
    Fan fan;

    @Before
    public void setup(){
        ellis = new Ellis("aisle", 130);
        beverage = new Beverage(1.0);
        cake = new Cake(1.0);
        fan = new Fan();
    }

    @Test
    public void drinkBeverage() throws NoSuchFieldException, IllegalAccessException {
        ellis.setBeverage(beverage);

        ellis.drinkBeverage();

        Field field = ellis.getClass().getDeclaredField("height");
        field.setAccessible(true);
        int height = (int) field.get(ellis);

        field = beverage.getClass().getSuperclass().getDeclaredField("quantity");
        field.setAccessible(true);
        double quantity = (double) field.get(beverage);

        assertThat(height).isEqualTo(24);
        assertThat(quantity).isEqualTo(0.5);
    }

    @Test
    public void eatCake() throws NoSuchFieldException, IllegalAccessException {
        ellis.setCake(cake);

        ellis.eatCake();

        Field field = ellis.getClass().getDeclaredField("height");
        field.setAccessible(true);
        int height = (int) field.get(ellis);

        field = cake.getClass().getSuperclass().getDeclaredField("quantity");
        field.setAccessible(true);
        double quantity = (double) field.get(cake);

        assertThat(height).isEqualTo(280);
        assertThat(quantity).isEqualTo(0.5);
    }

    @Test
    public void useFan() throws NoSuchFieldException, IllegalAccessException {
        ellis.setFan(fan);

        ellis.useFan();

        Field field = ellis.getClass().getDeclaredField("height");
        field.setAccessible(true);
        int height = (int) field.get(ellis);

        assertThat(height).isEqualTo(110);
    }

    @Test
    public void passDoor() throws IllegalAccessException, NoSuchFieldException {
        Door door = new Door(40);
        ellis.setBeverage(beverage);
        ellis.drinkBeverage();
        ellis.setKey(new Key());
        ellis.passDoor(door);

        Field field = ellis.getClass().getDeclaredField("position");
        field.setAccessible(true);
        String position = (String) field.get(ellis);

        assertThat(position).isEqualTo("garden");
    }

}