package ch11.ex06_Arrays;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class ArraysTest {
    @Test
    public void toStringTest() throws Exception{
        //given
        int[] arr = {1,2,3,4,5};
        String[] arr2 = {"1","2","3","4","5"};
        //when
        String actual1 = Arrays.toString(arr);
        String actual2 = Arrays.toString(arr2);
        //then
        assertThat(actual1).isEqualTo("[1, 2, 3, 4, 5]");
        assertThat(actual2).isEqualTo("[1, 2, 3, 4, 5]");
    }

    @Test
    public void copyOf() throws Exception{
        //given
        int[] arr = {0,1,2,3,4,5};
        //when
        int[] copy1 = Arrays.copyOf(arr, arr.length);
        int[] copy2 = Arrays.copyOf(arr, 3);

        //then
        assertThat(copy1).isEqualTo(new int[]{0,1,2,3,4,5});
        assertThat(copy2).isEqualTo(new int[]{0,1,2});
    }

    @Test
    public void copyOfRange() throws Exception{
        //given
        int[] arr = {0,1,2,3,4,5};
        //when
        int[] copy1 = Arrays.copyOfRange(arr, 0, arr.length);
        int[] copy2 = Arrays.copyOfRange(arr,1, 3);

        //then
        assertThat(copy1).isEqualTo(new int[]{0,1,2,3,4,5});
        assertThat(copy2).isEqualTo(new int[]{1,2});
    }

    @Test
    public void fill() throws Exception{
        //given
        int[] arr = new int[5];
        //when
        Arrays.fill(arr,9);
        //then
        assertThat(arr).isEqualTo(new int[]{9,9,9,9,9});
    }

    @Test
    public void setAll() throws Exception{
        //given
        int[] arr = new int[5];
        //when
        Arrays.setAll(arr, (s) -> (int)(Math.random()*5)+1);
        //then
        System.out.println(Arrays.toString(arr));
    }
    
    @Test
    public void sort() throws Exception{
        //given
        int[] arr = {5,4,3,2,1};
        //when
        Arrays.sort(arr);
        //then
        assertThat(arr).isEqualTo(new int[]{1,2,3,4,5});
    }
    
    @Test
    public void binarySearch() throws Exception{
        //given
        int[] arr = {5,4,3,2,1};
        Arrays.sort(arr); // [1,2,3,4,5]
        //when
        int idx = Arrays.binarySearch(arr, 2);
        //then
        assertThat(idx).isEqualTo(1);
    }

    @Test
    public void deepToString() throws Exception{
        //given
        int[][] arr2D = {{1,2},{3,4}};
        //when
        String actual = Arrays.deepToString(arr2D);
        //then
        assertThat(actual).isEqualTo("[[1, 2], [3, 4]]");
    }

    @Test
    public void equals_deepEquals() throws Exception{
        //given
        String[][] str2D = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};
        String[][] str2D2 = new String[][]{{"aaa","bbb"},{"AAA","BBB"}};
        //when
        boolean actual1 = Arrays.equals(str2D, str2D2);
        boolean actual2 = Arrays.deepEquals(str2D, str2D2);
        //then
        assertThat(actual1).isFalse();
        assertThat(actual2).isTrue();
    }

    @Test
    public void asList() throws Exception{
        //given
        List<Integer> list = Arrays.asList(1,2,3,4,5); // readOnly
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3,4,5)); // read, write °¡´É
        //when
//        list.add(1); // Error

        //then
    }

    @Test
    public void paralleXXX() throws Exception{
        //given
        int[] arr = {5,4,3,2,1};
        int[] arr2 = {1,2,3,4,5};
        int[] arr3 = new int[5];
        //when
        Arrays.parallelSort(arr);
        Arrays.parallelPrefix(arr2,(x,y)->x+y);
        Arrays.parallelSetAll(arr3, (x)->9);
        //then
        assertThat(arr).isEqualTo(new int[]{1,2,3,4,5});
        assertThat(arr2).isEqualTo(new int[]{1,3,6,10,15});
        assertThat(arr3).isEqualTo(new int[]{9,9,9,9,9});
    }

    @Test
    public void spliterator() throws Exception{
        //given
        ArrayList<String> list = new ArrayList<>();
        list.add("abc@geeksforgeeks.org");
        list.add("user@geeksforgeeks.org");
        list.add("pqr@geeksforgeeks.org");
        list.add("random@geeksforgeeks.org");
        list.add("randomuser@geeksforgeeks.org");

        //when
        Spliterator<String> emails = list.spliterator();

        //then
        emails.forEachRemaining((n) -> System.out.println(n));
    }

}
