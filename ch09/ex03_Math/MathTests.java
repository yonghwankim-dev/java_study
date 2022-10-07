package ch09.ex03_Math;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class MathTests {
    @Test
    public void round(){
        //given
        double val1 = 90.7552;

        //when
        double actual1 = Math.round(val1); // 91
        val1 *= 100;    // 9075.52
        double actual2 = Math.round(val1); // 9076.0
        double actual3 = Math.round(val1) / 100; // 90
        double actual4 = Math.round(val1) / 100.0; // 90.76
        double actual5 = Math.ceil(1.1); // 2.0
        double actual6 = Math.floor(1.5); // 1.0
        double actual7 = Math.round(1.1); // 1.0
        double actual8 = Math.round(1.5); // 2.0
        double actual9 = Math.rint(1.5); // 2.0
        double actual10 = Math.round(-1.5); // -1.0
        double actual11 = Math.rint(-1.5); // -2.0
        double actual12 = Math.ceil(-1.5); // -1.0
        double actual13 = Math.floor(-1.5); // -2.0
        //then
        assertThat(actual1).isEqualTo(91.0);
        assertThat(actual2).isEqualTo(9076.0);
        assertThat(actual3).isEqualTo(90);
        assertThat(actual4).isEqualTo(90.76);
        assertThat(actual5).isEqualTo(2.0);
        assertThat(actual6).isEqualTo(1.0);
        assertThat(actual7).isEqualTo(1.0);
        assertThat(actual8).isEqualTo(2.0);
        assertThat(actual9).isEqualTo(2.0);
        assertThat(actual10).isEqualTo(-1.0);
        assertThat(actual11).isEqualTo(-2.0);
        assertThat(actual12).isEqualTo(-1.0);
        assertThat(actual13).isEqualTo(-2.0);
    }

    @Test
    public void negateExact(){
        //given
        int i = Integer.MIN_VALUE;

        //when
        int actual1 = i;
        int actual2 = -i;
        int actual3 = Math.negateExact(10);
        int actual4 = Math.negateExact(-10);

        //then
        assertThat(actual1).isEqualTo(-2147483648);
        assertThat(actual2).isEqualTo(-2147483648);
        assertThat(actual3).isEqualTo(-10);
        assertThat(actual4).isEqualTo(10);
    }

    @Test(expected = ArithmeticException.class)
    public void negateExactException(){
        //given
        int i = Integer.MIN_VALUE;
        //when
        int actual1 = Math.negateExact(i);
        //then
        fail("이 테스트는 실패해야 합니다.");
    }

    @Test
    public void sin_cos_tan(){
        //given
        int x1 = 1, y1 = 1; // (1,1)
        int x2 = 2, y2 = 2; // (2,2)
        //when
        double c = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
        double a = c * Math.sin(Math.PI / 4); // PI / 4 rad = 45 degree
        double b = c * Math.cos(Math.PI / 4);

        //then
        assertThat(Math.round(a)).isEqualTo(1L);
        assertThat(Math.round(b)).isEqualTo(1L);
        assertThat(Math.round(c)).isEqualTo(1L);
        assertThat(Math.atan2(a,b)).isEqualTo(0.7853981633974482);
        assertThat(Math.round(Math.atan2(a,b) * 180 / Math.PI)).isEqualTo(45L);
        assertThat(Math.round(24 * Math.log10(2))).isEqualTo(7L);
        assertThat(Math.round(53 * Math.log10(2))).isEqualTo(16L);


    }
}
