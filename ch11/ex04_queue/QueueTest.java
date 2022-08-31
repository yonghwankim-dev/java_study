package ch11.ex04_queue;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.*;

public class QueueTest {
    @Test
    public void offer() throws Exception{
        //given
        Queue<Integer> queue = new LinkedList<>();
        //when
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        //then
        assertThat(queue).isEqualTo(Arrays.asList(1,2,3));
    }

    @Test
    public void poll() throws Exception{
        //given
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(1,2,3));
        //when
        int actual = queue.poll();
        //then
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void peek() throws Exception{
        //given
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(1,2,3));
        //when
        int actual = queue.peek();
        //then
        assertThat(actual).isEqualTo(1);
    }

}
