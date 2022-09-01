package ch11.ex05_iterator;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class IteratorTest {
    @Test
    public void iterator() throws Exception{
        //given
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        StringBuilder sb = new StringBuilder();
        //when
        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()){
            sb.append(itr.next());
        }
        //then
        assertThat(sb.toString()).isEqualTo("12345");
    }

    @Test
    public void listIterator() throws Exception{
        //given
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        StringBuilder sb = new StringBuilder();
        //when
        ListIterator<Integer> itr = list.listIterator();
        while(itr.hasNext()){
            sb.append(itr.next());
        }
        while(itr.hasPrevious()){
            sb.append(itr.previous());
        }
        //then
        assertThat(sb.toString()).isEqualTo("1234554321");
    }

    @Test
    public void remove() throws Exception{
        //given
        List<Integer> origin = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        List<Integer> copy1  = new ArrayList<>();
        List<Integer> copy2  = new ArrayList<>();
        //when
        Iterator itr = origin.iterator();
        while(itr.hasNext()){
            copy1.add((Integer) itr.next());
        }

        Iterator itr2 = origin.iterator();
        while(itr2.hasNext()){
            copy2.add((Integer) itr2.next());
            itr2.remove();
        }

        //then
        assertThat(origin).isEqualTo(Arrays.asList());
        assertThat(copy1).isEqualTo(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        assertThat(copy2).isEqualTo(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
    }

    @Test
    public void remove_lastRet() throws Exception{
        //given
        List<Integer> list = new ArrayList<>(Arrays.asList(0,1,2,3,4));
        //when
        Iterator itr = list.iterator();
        itr.next();
        itr.remove();
        itr.next();
        itr.remove();
        //then
        assertThat(list).isEqualTo(Arrays.asList(2,3,4));
    }
}
