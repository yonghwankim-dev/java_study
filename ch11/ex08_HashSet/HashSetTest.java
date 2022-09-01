package ch11.ex08_HashSet;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class HashSetTest {
    @Test
    public void add() throws Exception{
        //given
        List<Integer> list = new ArrayList<>(Arrays.asList(1,1,2,2,3,3));
        Set<Integer> set = new HashSet<>();
        //when
        for(int num : list){
            set.add(num);
        }
        //then
        assertThat(set).isEqualTo(new HashSet<>(Arrays.asList(1,2,3)));
    }

    @Test
    public void lotto() throws Exception{
        //given
        Set<Integer> set = new HashSet<>();
        //when
        IntStream intStream = new Random().ints( 1, 46)
                                          .distinct()
                                          .limit(6);
        intStream.forEach(set::add);
        //then
        System.out.println(set);
    }

    @Test
    public void bingo() throws Exception{
        //given
        Set<Integer> set = new HashSet<>();
        int[][] board = new int[5][5];
        //when
        List<Integer> bingo = new Random().ints(1,50)
                                          .distinct()
                                          .limit(25)
                                          .boxed()
                                          .collect(Collectors.toList());

        int idx = 0;
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = bingo.get(idx++);
            }
        }
        //then
        System.out.println(Arrays.deepToString(board));
    }
    
    @Test
    public void equalsTest() throws Exception{
        //given
        Set<Person> set = new HashSet<>();
        //when
        set.add(new Person("김용환",20));
        set.add(new Person("김용환",20));
        //then
        assertThat(set.size()).isEqualTo(1);
    }

    @Test
    public void intersectionByUsingReatinAll() throws Exception{
        //given
        HashSet<Integer> A = new HashSet<>(Arrays.asList(1,2,3,4,5));
        HashSet<Integer> B = new HashSet<>(Arrays.asList(4,5,6,7,8));
        //when
        HashSet<Integer> intersection = new HashSet<>(A);
        intersection.retainAll(B); // B 요소에 있는 것을 제외한 것을 A에서 지움 (교집합)
        //then
        assertThat(intersection).isEqualTo(new HashSet<>(Arrays.asList(4,5)));
    }

    @Test
    public void union() throws Exception{
        //given
        HashSet<Integer> A = new HashSet<>(Arrays.asList(1,2,3,4,5));
        HashSet<Integer> B = new HashSet<>(Arrays.asList(4,5,6,7,8));
        //when
        // 교집합
        HashSet<Integer> union = new HashSet<>(A);
        union.addAll(B);
        //then
        assertThat(union).isEqualTo(new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8)));
    }

    @Test
    public void minus() throws Exception{
        //given
        HashSet<Integer> A = new HashSet<>(Arrays.asList(1,2,3,4,5));
        HashSet<Integer> B = new HashSet<>(Arrays.asList(4,5,6,7,8));
        //when
        // 교집합
        HashSet<Integer> minus = new HashSet<>(A);
        minus.removeAll(B);
        //then
        assertThat(minus).isEqualTo(new HashSet<>(Arrays.asList(1,2,3)));
    }


}
