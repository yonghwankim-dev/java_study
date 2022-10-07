package ch09.ex04_Wrapper;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class WrapperTests {

    @Test
    public void integer(){
        //given
        Integer i1 = new Integer(100);
        Integer i2 = new Integer(100);
        //when
        boolean actual1 = i1==i2;
        boolean actual2 = i1.equals(i2);
        int     actual3 = i1.compareTo(i2);
        String  actual4 = i1.toString();
        int     actual5 = Integer.MAX_VALUE;
        int     actual6 = Integer.MIN_VALUE;
        int     actual7 = Integer.SIZE;
        int     actual8 = Integer.BYTES;
        Class<Integer> actual9 = Integer.TYPE;
        //then
        assertThat(actual1).isFalse();
        assertThat(actual2).isTrue();
        assertThat(actual3).isEqualTo(0);
        assertThat(actual4).isEqualTo("100");
        assertThat(actual5).isEqualTo(2147483647);
        assertThat(actual6).isEqualTo(-2147483648);
        assertThat(actual7).isEqualTo(32);
        assertThat(actual8).isEqualTo(4);
        assertThat(actual9).isEqualTo(int.class);
    }

    @Test
    public void parse(){
        //given
        int i1 = 100;
        int i2 = Integer.parseInt("100");
        int i3 = Integer.valueOf("100");
        //when
        int i4 = Integer.parseInt("100",2);
        int i5 = Integer.parseInt("100", 8);
        int i6 = Integer.parseInt("100", 16);
        int i7 = Integer.parseInt("FF",16);

        Integer i8 = Integer.valueOf("100", 2);
        Integer i9 = Integer.valueOf("100", 8);
        Integer i10 = Integer.valueOf("100", 16);
        Integer i11 = Integer.valueOf("FF", 16);

        //then
        assertThat(i1).isEqualTo(100);
        assertThat(i2).isEqualTo(100);
        assertThat(i3).isEqualTo(100);
        assertThat(i4).isEqualTo(4);
        assertThat(i5).isEqualTo(64);
        assertThat(i6).isEqualTo(256);
        assertThat(i7).isEqualTo(255);
        assertThat(i8).isEqualTo(4);
        assertThat(i9).isEqualTo(64);
        assertThat(i10).isEqualTo(256);
        assertThat(i11).isEqualTo(255);
    }

    @Test
    public void autoboxing_unboxing(){
        //given
        int i = 10;
        //when
        Integer intg = (Integer) i;
        Object obj = (Object)i;
        Long lng = 100L;
        int i2 = intg + 10;
        long l = intg + lng;
        Integer intg2 = Integer.valueOf(20);
        int i3 = (int)intg2;
        Integer intg3 = intg2 + i3;
        //then
        assertThat(i).isEqualTo(10);
        assertThat(intg).isEqualTo(10);
        assertThat(obj).isEqualTo(10);
        assertThat(lng).isEqualTo(100L);
        assertThat(l).isEqualTo(110);
        assertThat(intg2).isEqualTo(20);
        assertThat(i3).isEqualTo(20);
        assertThat(intg3).isEqualTo(40);



    }
}
