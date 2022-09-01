package ch11.ex09_TreeSet;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class TreeSetTest {
    @Test
    public void add() throws Exception{
        //given
        Set<Integer> treeSet = new TreeSet<>();
        //when
        for(int i = 5; i >= 1; i--){
            treeSet.add(i);
        }
        //then
        assertThat(treeSet).isEqualTo(new TreeSet<>(Arrays.asList(1,2,3,4,5)));
    }

    @Test
    public void subSet() throws Exception{
        //given
        TreeSet<String> treeSet = new TreeSet<>(Arrays.asList("abc","alien","bat","car","Car",
                                                          "disc","dance","dZZZZ","dzzzz",
                                                          "elephant","elevator","fan","flower"));
        String from = "b";
        String to   = "d";
        //when
        SortedSet<String> sortedSet1 = treeSet.subSet(from, to);
        SortedSet<String> sortedSet2 = treeSet.subSet(from, to + "zzz");
        //then
        assertThat(sortedSet1).isEqualTo(new TreeSet<>(Arrays.asList("bat","car")));
        assertThat(sortedSet2).isEqualTo(new TreeSet<>(Arrays.asList("bat","car", "dZZZZ", "dance", "disc")));
    }

    @Test
    public void asciiPrint() throws Exception{
        //given
        char ch = ' ';
        //when
        for(int i = 0; i < 95; i++){
            System.out.print(ch++);
        }
        //then
    }

    @Test
    public void headSet() throws Exception{
        //given
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(80,95,50,35,45,65,10,100));
        //when
        SortedSet<Integer> actual = treeSet.headSet(50); // 50 미포함
        //then
        assertThat(actual).isEqualTo(new TreeSet<>(Arrays.asList(10,35,45)));
    }

    @Test
    public void tailSet() throws Exception{
        //given
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(80,95,50,35,45,65,10,100));
        //when
        SortedSet<Integer> actual = treeSet.tailSet(50); // 50 포함
        //then
        assertThat(actual).isEqualTo(new TreeSet<>(Arrays.asList(50,65,80,95,100)));
    }
}
