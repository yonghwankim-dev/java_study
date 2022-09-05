package ch11.ex13_Collections;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class CollectionsTest {
    // 컬렉션의 동기화
    // static Collection synchronizedCollection(Collection c)
    @Test
    public void synchronizedTest() throws Exception{
        //given
        List<Integer> list = new ArrayList<>();
        //when
        Collection c                         = Collections.synchronizedCollection(list);
        List li                              = Collections.synchronizedList(list);
        Set<Integer> set                     = Collections.synchronizedSet(new HashSet<>());
        Map<Integer, String> map             = Collections.synchronizedMap(new HashMap<>());
        SortedSet<Integer> sortedSet         = Collections.synchronizedSortedSet(new TreeSet<>());
        SortedMap<Integer, String> sortedMap = Collections.synchronizedSortedMap(new TreeMap<>());

        //then
    }

    // 변경불가 컬렉션 만들기
    // static Collection unmodifiableCollection(Collection c)
    @Test(expected = UnsupportedOperationException.class)
    public void unmodifiable() throws Exception{
        //given

        //when
        List<Integer> list = Collections.unmodifiableList(new ArrayList<>());
        //then
        list.add(1);
    }

    // 싱글톤 컬렉션 만들기
    @Test
    public void singleton() throws Exception{
        //given

        //when
        List<Integer> list = Collections.singletonList(1);
        //then
        assertThat(list.size()).isEqualTo(1);
    }

    // 한 종류의 객체만 저장하는 컬렉션
    @Test(expected = ClassCastException.class)
    public void checked() throws Exception{
        //given

        //when
        List list = Collections.checkedList(new ArrayList<>(), Integer.class);
        //then
        list.add(1);
        list.add("2");
    }


}
