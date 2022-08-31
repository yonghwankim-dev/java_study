package ch11.ex02_LinkedList;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LinkedListTest {
    @Test
    public void add() throws Exception{
        //given
        List<Integer> list = new LinkedList<>();
        //when
        list.add(1);
        list.add(2);
        list.add(3);
        //then
        assertThat(list).isEqualTo(Arrays.asList(1,2,3));
    }

    @Test
    public void add_index() throws Exception{
        //given
        List<Integer> list = new LinkedList<>(Arrays.asList(1,2,3));
        //when
        list.add(1,4);
        //then
        assertThat(list).isEqualTo(Arrays.asList(1,4,2,3));
    }



    @Test
    public void remove_index() throws Exception{
        //given
        List<Integer> list = new LinkedList<>(Arrays.asList(1,2,3));
        //when
        list.remove(1);
        //then
        assertThat(list).isEqualTo(Arrays.asList(1,3));
    }

    @Test
    public void remove_element() throws Exception{
        //given
        List<Integer> list = new LinkedList<>(Arrays.asList(1,2,3));
        //when
        list.remove(Integer.valueOf(3));
        //then
        assertThat(list).isEqualTo(Arrays.asList(1,2));
    }

    @Test
    public void set() throws Exception{
        //given
        List<Integer> list = new LinkedList<>(Arrays.asList(1,2,3));
        //when
        list.set(1,4);
        //then
        assertThat(list).isEqualTo(Arrays.asList(1,4,3));
    }
}
