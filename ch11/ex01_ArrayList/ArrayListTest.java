package ch11.ex01_ArrayList;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ArrayListTest {

    @Test
    public void add() throws Exception{
        //given
        ArrayList<Integer> list = new ArrayList<>();
        //when
        list.add(5);
        list.add(4);
        list.add(2);
        list.add(0);
        list.add(1);
        list.add(3);
        //then
        assertThat(list).isEqualTo(Arrays.asList(5,4,2,0,1,3));
    }

    @Test
    public void subList() throws Exception{
        //given
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        //when
        List<Integer> actual = list.subList(1,3);
        //then
        assertThat(actual).isEqualTo(Arrays.asList(2,3));
    }

    @Test
    public void sort() throws Exception{
        //given
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5,4,3,2,1));
        //when
        Collections.sort(list);
        //then
        assertThat(list).isEqualTo(Arrays.asList(1,2,3,4,5));
    }

    @Test
    public void containsAll() throws Exception{
        //given
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(5,4,3,2,1));
        //when
        boolean actual = list1.containsAll(list2);
        //then
        assertThat(actual).isTrue();
    }

    @Test
    public void set() throws Exception{
        //given
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        //when
        list.set(1,6);
        //then
        assertThat(list).isEqualTo(Arrays.asList(1,6,3,4,5));
    }

    // retainAll : 겹치는 부분만 제외하고 전부 삭제
    @Test
    public void retainAll() throws Exception{
        //given
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1,2));
        //when
        boolean actual = list1.retainAll(list2);
        //then
        assertThat(actual).isTrue();
        assertThat(list1).isEqualTo(Arrays.asList(1,2));
    }
    
    @Test
    public void contains() throws Exception{
        //given
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        //when
        boolean actual = list.contains(3);
        //then
        assertThat(actual).isTrue();
    }
    
    @Test
    public void remove() throws Exception{
        //given
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        //when
        int actual = list.remove(3);
        //then
        assertThat(actual).isEqualTo(4);
        assertThat(list).isEqualTo(Arrays.asList(1,2,3,5));
    }

    @Test
    public void get() throws Exception{
        //given
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        //when
        int actual = list.get(3);
        //then
        assertThat(actual).isEqualTo(4);
    }

    @Test
    public void toStringTest() throws Exception{
        //given
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        //when
        String actual = list.toString();
        //then
        assertThat(actual).isEqualTo("[1, 2, 3, 4, 5]");
    }

    // 긴 문자열의 데이터를 특정 길이 단위로 잘라서 ArrayList에 담는 테스트
    @Test
    public void givenStringWhenSubStringAndAddToArrayList() throws Exception{
        //given
        final int LIMIT = 10;
        String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
        int len = source.length();
        List<String> list = new ArrayList<>(len / LIMIT + 10);

        //when
        for(int i = 0; i < len; i+=LIMIT){
            if(i + LIMIT < len){
                list.add(source.substring(i, i + LIMIT));
                continue;
            }
            list.add(source.substring(i));
        }
        //then
        assertThat(list).isEqualTo(Arrays.asList("0123456789","abcdefghij","ABCDEFGHIJ","!@#$%^&*()", "ZZZ"));
    }

}
