package ch12.ex02_enums.mytransportation;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

public class MyTransportationTest {
    @Test
    public void checkMyTransportationNameAndOrinalsTest() throws Exception{
        //given
        MyTransportation[] myTransportations = {MyTransportation.BUS,
                                                MyTransportation.BUS,
                                                MyTransportation.TRAIN,
                                                MyTransportation.SHIP,
                                                MyTransportation.AIRPLANE};
        String[] actualTransportationNames = new String[myTransportations.length];
        int[] actualTransportationOrdinals = new int[myTransportations.length];
        String[] expectTransportationNames = {"BUS", "BUS", "TRAIN", "SHIP", "AIRPLANE"};
        int[] expectTransportationOrdinals = {0, 0, 1, 2, 3};

        //when
        for(int i = 0; i < myTransportations.length; i++){
            actualTransportationNames[i] = myTransportations[i].name();
            actualTransportationOrdinals[i] = myTransportations[i].ordinal();
        }

        //then
        assertThat(actualTransportationNames).isEqualTo(expectTransportationNames);
        assertThat(actualTransportationOrdinals).isEqualTo(expectTransportationOrdinals);


    }

    @Test
    public void compareMyTransportationTest(){
        //given
        MyTransportation t1 = MyTransportation.BUS;
        MyTransportation t2 = MyTransportation.BUS;
        MyTransportation t3 = MyTransportation.SHIP;

        //when
        boolean actual1 = (t1 == t2);
        int actual2 = t1.compareTo(t3);

        //then
        assertThat(actual1).isTrue();
        assertThat(actual2).isLessThan(0);
    }
}