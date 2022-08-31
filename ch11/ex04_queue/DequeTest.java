package ch11.ex04_queue;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class DequeTest {

    @Test
    public void offerFirst() throws Exception{
        //given
        Deque<Integer> deque = new LinkedList<>();
        //when
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        //then
        assertThat(deque).isEqualTo(Arrays.asList(3,2,1));
    }

    @Test
    public void offerLast() throws Exception{
        //given
        Deque<Integer> deque = new LinkedList<>();
        //when
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        //then
        assertThat(deque).isEqualTo(Arrays.asList(1,2,3));
    }

    @Test
    public void pollFirst() throws Exception{
        //given
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> actual = new ArrayList<>();

        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        //when
        actual.add(deque.pollFirst());
        actual.add(deque.pollFirst());
        actual.add(deque.pollFirst());
        //then
        assertThat(actual).isEqualTo(Arrays.asList(1,2,3));
    }

    @Test
    public void pollLast() throws Exception{
        //given
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> actual = new ArrayList<>();

        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        //when
        actual.add(deque.pollLast());
        actual.add(deque.pollLast());
        actual.add(deque.pollLast());
        //then
        assertThat(actual).isEqualTo(Arrays.asList(3,2,1));
    }

    @Test
    public void peek() throws Exception{
        //given
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        //when
        int actual1 = deque.peekFirst();
        int actual2 = deque.peekLast();
        //then
        assertThat(actual1).isEqualTo(1);
        assertThat(actual2).isEqualTo(3);
    }

}
