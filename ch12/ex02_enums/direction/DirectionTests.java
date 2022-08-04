package ch12.ex02_enums.direction;


import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class DirectionTests {

    @Test
    public void compareDirectionTest(){
        //given
        Direction d1 = Direction.EAST;
        Direction d2 = Direction.valueOf("WEST");
        Direction d3 = Enum.valueOf(Direction.class, "EAST");

        //when
        boolean actual1 = d1 == d2;
        boolean actual2 = d1 == d3;
        boolean actual3 = d1.equals(d3);
        int actual4 = d1.compareTo(d3);
        int actual5 = d1.compareTo(d2);

        //then
        assertThat(d1).isEqualTo(Direction.EAST);
        assertThat(d2).isEqualTo(Direction.WEST);
        assertThat(d3).isEqualTo(Direction.EAST);

        assertThat(actual1).isFalse();
        assertThat(actual2).isTrue();
        assertThat(actual3).isTrue();
        assertThat(actual4).isEqualTo(0);
        assertThat(actual5).isLessThan(0);
    }

    @Test
    public void checkDirectionNameAndOrdinalTest(){
        //given
        Direction[] directions = Direction.values();
        int n = directions.length;
        String[] actualNameArr = new String[n];
        String[] expectedNameArr = {"EAST", "SOUTH", "WEST", "NORTH"};
        int[] actualOrdinalArr = new int[n];
        int[] expectedOrdinalArr = {0, 1, 2, 3};

        //when
        for(int i = 0; i < n; i++){
            actualNameArr[i] = directions[i].name();
            actualOrdinalArr[i] = directions[i].ordinal();
        }

        //then
        for(int i = 0; i < n; i++){
            assertThat(actualNameArr[i]).isEqualTo(expectedNameArr[i]);
            assertThat(actualOrdinalArr[i]).isEqualTo(expectedOrdinalArr[i]);
        }
    }

    @Test
    public void checkDirectionValueUsingGetterMethodTest(){
        // given
        Direction[] directions = Direction.values();
        int n = directions.length;
        String[] actualNameArr = new String[n];
        String[] expectedNameArr = {"EAST", "SOUTH", "WEST", "NORTH"};
        int[] actualValueArr = new int[n];
        int[] expectedValueArr = {1, 2, 3, 4};

        // when
        for(int i = 0; i < n; i++){
            actualNameArr[i] = directions[i].name();
            actualValueArr[i] = directions[i].getValue();
        }

        //then
        for(int i = 0; i < n; i++){
            assertThat(actualNameArr[i]).isEqualTo(expectedNameArr[i]);
            assertThat(actualValueArr[i]).isEqualTo(expectedValueArr[i]);
        }
    }

    @Test
    public void checkDirectionRotateMethodTest(){
        //given
        Direction east = Direction.EAST;

        //when
        Direction actual1 = east.rotate(1);
        Direction actual2 = east.rotate(2);
        Direction actual3 = east.rotate(-1);
        Direction actual4 = east.rotate(-2);

        //then
        assertThat(actual1).isEqualTo(Direction.SOUTH); // 90도 회전
        assertThat(actual2).isEqualTo(Direction.WEST);  // 180도 회전
        assertThat(actual3).isEqualTo(Direction.NORTH); // 반대로 90도 회전
        assertThat(actual4).isEqualTo(Direction.WEST);  // 반대로 180도 회전
    }
}
