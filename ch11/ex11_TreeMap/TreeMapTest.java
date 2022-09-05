package ch11.ex11_TreeMap;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class TreeMapTest {
    private static TreeMap<Integer, Person> treeMap;
    @Before
    public void setup(){
        treeMap = new TreeMap<>();
        treeMap.put(1, new Person(1, "김용환"));
        treeMap.put(2, new Person(2, "홍길동"));
        treeMap.put(3, new Person(3, "강감찬"));
    }

    @Test
    public void treeMap() {
        //given
        Comparator<Integer> byId = (o1, o2) -> o1.compareTo(o2);
        SortedMap<Integer, Person> sortedMap = new TreeMap<>();

        //when
        TreeMap<Integer, Person> treeMap1 = new TreeMap<>();
        TreeMap<Integer, Person> treeMap2 = new TreeMap<>(byId);
        TreeMap<Integer, Person> treeMap3 = new TreeMap<>(treeMap1);
        TreeMap<Integer, Person> treeMap4 = new TreeMap<>(sortedMap);

        //then
    }

    // Map.Entry ceilingEntry(Object key) : 지정된 key와 일치하거나 큰 것중 제일 작은 것의 키와 값의쌍(Entry)을 반환,
    // 없으면 null 반환
    @Test
    public void ceilingEntry() {
        //given
        TreeMap<Integer, Person> treeMap = new TreeMap<>();
        treeMap.put(1, new Person(1, "김용환"));
        treeMap.put(2, new Person(2, "홍길동"));
        treeMap.put(3, new Person(3, "강감찬"));
        //when
        Map.Entry<Integer, Person> actual1 = treeMap.ceilingEntry(3);
        Map.Entry<Integer, Person> actual2 = treeMap.ceilingEntry(4);
        //then
        assertThat(actual1.getValue()).isEqualTo(new Person(3, "강감찬"));
        assertThat(actual2).isNull();
    }

    // Object ceilingKey(Object key) : 지정된 key와 일치하거나 큰 것중 제일 작은 것의 키를 반환, 없으면 null 반환
    @Test
    public void ceilingKey() {
        //given
        TreeMap<Integer, Person> treeMap = new TreeMap<>();
        treeMap.put(1, new Person(1, "김용환"));
        treeMap.put(2, new Person(2, "홍길동"));
        treeMap.put(3, new Person(3, "강감찬"));
        //when
        Integer actual1 = treeMap.ceilingKey(3);
        //then
        assertThat(actual1).isEqualTo(3);
    }

    // void clear() : TreeMap에 저자오딘 모든 객체를 제거
    @Test
    public void clear() {
        //given
        TreeMap<Integer, Person> treeMap = new TreeMap<>();
        treeMap.put(1, new Person(1, "김용환"));
        treeMap.put(2, new Person(2, "홍길동"));
        treeMap.put(3, new Person(3, "강감찬"));
        //when
        treeMap.clear();
        //then
        assertThat(treeMap.isEmpty()).isTrue();
    }
    
    // Object clone() : 현재 TreeMap을 복제해서 반환
    @Test
    public void cloneTest() {
        //given

        //when
        TreeMap<Integer, Person> copy = (TreeMap<Integer, Person>) treeMap.clone(); // deep copy
        copy.put(4, new Person(4, "홍길동"));
        //then
        assertThat(treeMap).isNotEqualTo(copy);
    }

    // Comparator comparator() : TreeMap의 정렬기준이 되는 Comparator를 반환, 지정되어 있지 않으면 null 반환
    @Test
    public void comparator() {
        //given
        Comparator<Integer> comp = Comparator.naturalOrder();
        TreeMap<Integer, Person> treeMap2 = new TreeMap<>(comp);
        //when
        Comparator<? super Integer> comparator = treeMap.comparator();
        Comparator<? super Integer> comparator2 = treeMap2.comparator();
        //then
        assertThat(comparator).isNull();
    }

    // boolean containsKey(Object key) : TreeMap에 지정된 키(key)가 포함되어 있는지 알려줌
    @Test
    public void containsKey() {
        //given

        //when
        boolean actual1 = treeMap.containsKey(1);
        boolean actual2 = treeMap.containsKey(4);
        //then
        assertThat(actual1).isTrue();
        assertThat(actual2).isFalse();
    }

    // boolean containsValue(Object value) : treeMap에 지정된 값(value)이 포함되어 있는지 알려줌
    @Test
    public void containsValue() {
        //given

        //when
        boolean actual1 = treeMap.containsValue(new Person(1, "김용환"));
        //then
        assertThat(actual1).isTrue();
    }

    // NavigableSet descendingKeySet() : TreeMap에 지정된 키를 역순으로 정렬해서 NavigableSet에 담아서 반환
    @Test
    public void descendingKeySet() {
        //given

        //when
        NavigableSet<Integer> set = treeMap.descendingKeySet();
        //then
        assertThat(set.toString()).isEqualTo("[3, 2, 1]");
    }

    // Set entrySet() : TreeMap에 저장된 키와 값을 엔트리의 형태로 Set에 저장해서 반환
    @Test
    public void entrySet() {
        //given
        
        //when
        Set<Map.Entry<Integer, Person>> entries = treeMap.entrySet();
        //then
    }

    // Entry firstEntry() : TreeMap에 저장된 첫번째(가장 작은) 키를 반환
    @Test
    public void firstEntry() {
        //given

        //when
        Map.Entry<Integer, Person> entry = treeMap.firstEntry();
        //then
        assertThat(entry.getKey()).isEqualTo(1);
        assertThat(entry.getValue()).isEqualTo(new Person(1, "김용환"));
    }

    // Object firstKey() : treeMap에 저장된 첫번째(가장 작은) 키를 반환
    @Test
    public void firstKey() {
        //given

        //when
        Integer actual = treeMap.firstKey();
        //then
        assertThat(actual).isEqualTo(1);
    }

    // Entry floorEntry(Object key) : 지정된 key와 일치하거나 작은 것 중에서 제일 큰 키의 쌍을 반환, 없으면 null 반환
    @Test
    public void floorEntry() {
        //given

        //when
        Map.Entry<Integer, Person> entry = treeMap.floorEntry(4);

        //then
        assertThat(entry.getKey()).isEqualTo(3);
        assertThat(entry.getValue()).isEqualTo(new Person(3, "강감찬"));
    }

    // Object floorKey(Object key) : 지정된 key와 일치하거나 작은 것중에서 제일 큰 키를 반환, 없으면 null 반환
    @Test
    public void floorKey()  {
        //given

        //when
        Integer actual = treeMap.floorKey(4);
        //then
        assertThat(actual).isEqualTo(3);
    }

    // Object get(Object key) : 지정된 키(key)의 값(value)를 반환
    @Test
    public void get() {
        //given

        //when
        Person actual = treeMap.get(1);
        //then
        assertThat(actual).isEqualTo(new Person(1,"김용환"));
    }

    // SortedMap headMap(Object toKey) : TreeMap에 저장된 첫번째 요소부터 지정된 범위에 속한 모든 요소가 담긴 SortedMap 반환
    // (toKey는 미포함)
    // NavigableMap headMap(Object toKey, boolean inclusive)
    @Test
    public void headMap() {
        //given

        //when
        SortedMap<Integer, Person>    actual1 = treeMap.headMap(3);
        NavigableMap<Integer, Person> actual2 = treeMap.headMap(3, true);

        //then
        System.out.println(actual1);
        System.out.println(actual2);
    }

    // Entry higherEntry(Object key) : 지정된 key보다 큰 키중에서 제일 작은 키의 쌍을 반환, 없으면 null 반환
    @Test
    public void higherEntry() {
        //given
        
        //when
        Map.Entry<Integer, Person> entry = treeMap.higherEntry(2);

        //then
        assertThat(entry.getValue()).isEqualTo(new Person(3, "강감찬"));
    }

    // Object higherKey(Object key) : 지정된 key보다 큰 키중에서 제일 작은 키의 쌍을 반환, 없으면 null 반환
    @Test
    public void higherKey() {
        //given
        
        //when
        Integer actual = treeMap.higherKey(1);
        //then
        assertThat(actual).isEqualTo(2);
    }

    // boolean isEmpty() : TreeMap이 비어있는지 알려줌
    @Test
    public void isEmpty() {
        //given

        //when
        boolean actual = treeMap.isEmpty();
        //then
        assertThat(actual).isFalse();
    }

    // Set keySet() : TreeMap에 저장된 모든 키가 저장된 Set을 반환
    @Test
    public void keySet() {
        //given

        //when
        Set<Integer> set = treeMap.keySet();
        //then
        assertThat(set.toString()).isEqualTo("[1, 2, 3]");
    }

    // Entry lastEntry() : TreeMap에 저장된 마지막 키의 쌍을 반환
    @Test
    public void lastEntry() {
        //given

        //when
        Map.Entry<Integer, Person> entry = treeMap.lastEntry();
        //then
        assertThat(entry.getValue()).isEqualTo(new Person(3, "강감찬"));
    }

    // Object lastKey() : TreeMap에 저장된 마지막 키를 반환
    @Test
    public void lastKey() {
        //given

        //when
        Integer actual = treeMap.lastKey();
        //then
        assertThat(actual).isEqualTo(3);
    }

    // Entry lowerEntry(Object key) : 지정된 key보다 작은 키중에서 제일 큰 키의 쌍을 반환, 없으면 null 반환
    @Test
    public void lowerEntry() {
        //given

        //when
        Map.Entry<Integer, Person> entry = treeMap.lowerEntry(3);
        //then
        assertThat(entry.getValue()).isEqualTo(new Person(2,"홍길동"));
    }

    // Object lowerKey(Object key) : 지정된 key보다 작은 키중에서 제일 큰 키를 반환, 없으면 null 반환
    @Test
    public void lowerKey() {
        //given

        //when
        Integer actual = treeMap.lowerKey(3);
        //then
        assertThat(actual).isEqualTo(2);
    }

    // NavigableSet navigableKeySet() : TreeMap의 모든 키가 담긴 NavigableSet을 반환
    @Test
    public void navigableKeySet() {
        //given

        //when
        NavigableSet<Integer> actual = treeMap.navigableKeySet();
        //then
        System.out.println(actual);
    }

    // Entry pollFirstEntry() : TreeMap에서 제일 작은 키를 제거하면서 반환
    @Test
    public void pollFirstEntry() {
        //given

        //when
        Map.Entry<Integer, Person> entry = treeMap.pollFirstEntry();
        //then
        assertThat(entry.getValue()).isEqualTo(new Person(1, "김용환"));
    }

    // Entry pollLastEntry() : TreeMap에서 제일 큰 키를 제거하면서 반환
    @Test
    public void pollLastEntry() {
        //given

        //when
        Map.Entry<Integer, Person> entry = treeMap.pollLastEntry();
        //then
        assertThat(entry.getValue()).isEqualTo(new Person(3, "강감찬"));
    }

    // Object put(Object key, Object value) : 지정된 키와 값을 TreeMap에 저장, 이전에 저장된 값이 있으면 반환
    @Test
    public void put() {
        //given
        
        //when
        Person actual1 = treeMap.put(4, new Person(4, "김용환"));
        Person actual2 = treeMap.put(3, new Person(3, "김용환"));
        //then
        assertThat(actual1).isNull();
        assertThat(actual2).isEqualTo(new Person(3, "강감찬"));
    }

    // void putAll() : Map에 저장된 모든 요소를 TreeMap에 저장
    @Test
    public void putAll() {
        //given
        TreeMap<Integer, Person> map = new TreeMap<>();
        map.put(4, new Person(4, "사용환"));
        map.put(5, new Person(5, "오용환"));
        //when
        treeMap.putAll(map);
        //then
        System.out.println(treeMap);
    }

    // Object remove(Object key) : treeMap에서 지정된 키로 저장된 value 제거하고 반환
    @Test
    public void remove() {
        //given
        
        //when
        Person actual = treeMap.remove(2);
        //then
        assertThat(actual).isEqualTo(new Person(2, "홍길동"));
    }

    // Object replace(Object key, Object value) : 기존의 키의 값을 지정된 값으로 변경
    @Test
    public void replace() {
        //given
        
        //when
        Person actual1 = treeMap.replace(3, new Person(3, "삼용환"));
        Person actual2 = treeMap.replace(4, new Person(4, "사용환")); // treeMap 넣어지지않음
        //then
        System.out.println(treeMap);
        assertThat(actual1).isEqualTo(new Person(3, "삼용환"));
        assertThat(actual2).isNull();
    }
    
    // boolean replace(Object key, Object oldValue, Object newValue)
    // 기존의 key의 value를 새로운 값(newValue)로 변경 단, 기존의 값과 지정된 값(oldValue)가 일치해야함
    @Test
    public void replace2() {
        //given
        
        //when
        boolean actual1 = treeMap.replace(3, new Person(3, "강감찬"), new Person(3, "삼용환"));
        boolean actual2 = treeMap.replace(2, new Person(2, "김용환"), new Person(2, "이용환"));
        //then
        assertThat(actual1).isTrue();
        assertThat(actual2).isFalse();
    }

    // int size() : TreeMap에 저장된 요소의 개수를 반환
    @Test
    public void size() {
        //given

        //when
        int actual = treeMap.size();
        //then
        assertThat(actual).isEqualTo(3);
    }

    // NavigableMap subMap(Object fromKey, boolean fromInclusive, Object toKey, boolean toInclusive)
    // SortedMap    subMap(Object fromKey, Object toKey)
    // 지정된 두개의 키 사이에 있는 모든 쇼오들이 담긴 Map을 반환
    @Test
    public void subMap() {
        //given
        
        //when
        NavigableMap<Integer, Person> map1 = treeMap.subMap(2, true, 3, true);
        SortedMap<Integer, Person> map2 = treeMap.subMap(2, 3); // from inclusive, to exclusive
        //then
        System.out.println(map1);
        System.out.println(map2);
    }

    // NavigableMap tailMap(Object fromKey, boolean inclusive)
    // SortedMap    tailMap(Object fromKey)
    // 지정된 키부터 마지막 요소의 범위에 속한 요소가 담긴 Map을 반환
    @Test
    public void tailMap() {
        //given
        
        //when
        NavigableMap<Integer, Person> map1 = treeMap.tailMap(2, true);
        SortedMap<Integer, Person> map2 = treeMap.tailMap(2);
        //then
        assertThat(map1.size()).isEqualTo(2);
        assertThat(map2.size()).isEqualTo(2);
    }

    // Collection<V> values() : TreeMap에 저장된 모든 값을 컬렉션의 형태로 반환
    @Test
    public void values() {
        //given

        //when
        Collection<Person> actual = treeMap.values();
        //then
        System.out.println(actual);
        assertThat(actual.size()).isEqualTo(3);
    }

}
