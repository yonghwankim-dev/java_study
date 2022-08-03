package ch12._02_enums.transportation;


import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

public class TransportationTest {
    @Test
    public void checkTransportationFareMethodTest(){
        //given
        Transportation bus = Transportation.BUS;
        Transportation train = Transportation.TRAIN;
        Transportation ship = Transportation.SHIP;
        Transportation airplane = Transportation.AIRPLANE;

        //when
        int actualPrice1 = bus.fare(100);
        int actualPrice2 = train.fare(100);
        int actualPrice3 = ship.fare(100);
        int actualPrice4 = airplane.fare(100);

        //then
        assertThat(actualPrice1).isEqualTo(10000);
        assertThat(actualPrice2).isEqualTo(15000);
        assertThat(actualPrice3).isEqualTo(10000);
        assertThat(actualPrice4).isEqualTo(30000);
    }
}