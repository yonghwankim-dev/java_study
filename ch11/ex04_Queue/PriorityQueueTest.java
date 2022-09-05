package ch11.ex04_Queue;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class PriorityQueueTest {
    @Test
    public void offer_poll() throws Exception{
        //given
        Queue<Integer> pq = new PriorityQueue<>();
        List<Integer> actual = new ArrayList<>();
        //when
        pq.offer(1);
        pq.offer(5);
        pq.offer(2);
        pq.offer(4);
        pq.offer(3);

        while(!pq.isEmpty()){
            actual.add(pq.poll());
        }
        //then
        assertThat(actual).isEqualTo(Arrays.asList(1,2,3,4,5));
    }
}
