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
        treeMap.put(1, new Person(1, "���ȯ"));
        treeMap.put(2, new Person(2, "ȫ�浿"));
        treeMap.put(3, new Person(3, "������"));
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

    // Map.Entry ceilingEntry(Object key) : ������ key�� ��ġ�ϰų� ū ���� ���� ���� ���� Ű�� ���ǽ�(Entry)�� ��ȯ,
    // ������ null ��ȯ
    @Test
    public void ceilingEntry() {
        //given
        TreeMap<Integer, Person> treeMap = new TreeMap<>();
        treeMap.put(1, new Person(1, "���ȯ"));
        treeMap.put(2, new Person(2, "ȫ�浿"));
        treeMap.put(3, new Person(3, "������"));
        //when
        Map.Entry<Integer, Person> actual1 = treeMap.ceilingEntry(3);
        Map.Entry<Integer, Person> actual2 = treeMap.ceilingEntry(4);
        //then
        assertThat(actual1.getValue()).isEqualTo(new Person(3, "������"));
        assertThat(actual2).isNull();
    }

    // Object ceilingKey(Object key) : ������ key�� ��ġ�ϰų� ū ���� ���� ���� ���� Ű�� ��ȯ, ������ null ��ȯ
    @Test
    public void ceilingKey() {
        //given
        TreeMap<Integer, Person> treeMap = new TreeMap<>();
        treeMap.put(1, new Person(1, "���ȯ"));
        treeMap.put(2, new Person(2, "ȫ�浿"));
        treeMap.put(3, new Person(3, "������"));
        //when
        Integer actual1 = treeMap.ceilingKey(3);
        //then
        assertThat(actual1).isEqualTo(3);
    }

    // void clear() : TreeMap�� ���ڿ��� ��� ��ü�� ����
    @Test
    public void clear() {
        //given
        TreeMap<Integer, Person> treeMap = new TreeMap<>();
        treeMap.put(1, new Person(1, "���ȯ"));
        treeMap.put(2, new Person(2, "ȫ�浿"));
        treeMap.put(3, new Person(3, "������"));
        //when
        treeMap.clear();
        //then
        assertThat(treeMap.isEmpty()).isTrue();
    }
    
    // Object clone() : ���� TreeMap�� �����ؼ� ��ȯ
    @Test
    public void cloneTest() {
        //given

        //when
        TreeMap<Integer, Person> copy = (TreeMap<Integer, Person>) treeMap.clone(); // deep copy
        copy.put(4, new Person(4, "ȫ�浿"));
        //then
        assertThat(treeMap).isNotEqualTo(copy);
    }

    // Comparator comparator() : TreeMap�� ���ı����� �Ǵ� Comparator�� ��ȯ, �����Ǿ� ���� ������ null ��ȯ
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

    // boolean containsKey(Object key) : TreeMap�� ������ Ű(key)�� ���ԵǾ� �ִ��� �˷���
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

    // boolean containsValue(Object value) : treeMap�� ������ ��(value)�� ���ԵǾ� �ִ��� �˷���
    @Test
    public void containsValue() {
        //given

        //when
        boolean actual1 = treeMap.containsValue(new Person(1, "���ȯ"));
        //then
        assertThat(actual1).isTrue();
    }

    // NavigableSet descendingKeySet() : TreeMap�� ������ Ű�� �������� �����ؼ� NavigableSet�� ��Ƽ� ��ȯ
    @Test
    public void descendingKeySet() {
        //given

        //when
        NavigableSet<Integer> set = treeMap.descendingKeySet();
        //then
        assertThat(set.toString()).isEqualTo("[3, 2, 1]");
    }

    // Set entrySet() : TreeMap�� ����� Ű�� ���� ��Ʈ���� ���·� Set�� �����ؼ� ��ȯ
    @Test
    public void entrySet() {
        //given
        
        //when
        Set<Map.Entry<Integer, Person>> entries = treeMap.entrySet();
        //then
    }

    // Entry firstEntry() : TreeMap�� ����� ù��°(���� ����) Ű�� ��ȯ
    @Test
    public void firstEntry() {
        //given

        //when
        Map.Entry<Integer, Person> entry = treeMap.firstEntry();
        //then
        assertThat(entry.getKey()).isEqualTo(1);
        assertThat(entry.getValue()).isEqualTo(new Person(1, "���ȯ"));
    }

    // Object firstKey() : treeMap�� ����� ù��°(���� ����) Ű�� ��ȯ
    @Test
    public void firstKey() {
        //given

        //when
        Integer actual = treeMap.firstKey();
        //then
        assertThat(actual).isEqualTo(1);
    }

    // Entry floorEntry(Object key) : ������ key�� ��ġ�ϰų� ���� �� �߿��� ���� ū Ű�� ���� ��ȯ, ������ null ��ȯ
    @Test
    public void floorEntry() {
        //given

        //when
        Map.Entry<Integer, Person> entry = treeMap.floorEntry(4);

        //then
        assertThat(entry.getKey()).isEqualTo(3);
        assertThat(entry.getValue()).isEqualTo(new Person(3, "������"));
    }

    // Object floorKey(Object key) : ������ key�� ��ġ�ϰų� ���� ���߿��� ���� ū Ű�� ��ȯ, ������ null ��ȯ
    @Test
    public void floorKey()  {
        //given

        //when
        Integer actual = treeMap.floorKey(4);
        //then
        assertThat(actual).isEqualTo(3);
    }

    // Object get(Object key) : ������ Ű(key)�� ��(value)�� ��ȯ
    @Test
    public void get() {
        //given

        //when
        Person actual = treeMap.get(1);
        //then
        assertThat(actual).isEqualTo(new Person(1,"���ȯ"));
    }

    // SortedMap headMap(Object toKey) : TreeMap�� ����� ù��° ��Һ��� ������ ������ ���� ��� ��Ұ� ��� SortedMap ��ȯ
    // (toKey�� ������)
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

    // Entry higherEntry(Object key) : ������ key���� ū Ű�߿��� ���� ���� Ű�� ���� ��ȯ, ������ null ��ȯ
    @Test
    public void higherEntry() {
        //given
        
        //when
        Map.Entry<Integer, Person> entry = treeMap.higherEntry(2);

        //then
        assertThat(entry.getValue()).isEqualTo(new Person(3, "������"));
    }

    // Object higherKey(Object key) : ������ key���� ū Ű�߿��� ���� ���� Ű�� ���� ��ȯ, ������ null ��ȯ
    @Test
    public void higherKey() {
        //given
        
        //when
        Integer actual = treeMap.higherKey(1);
        //then
        assertThat(actual).isEqualTo(2);
    }

    // boolean isEmpty() : TreeMap�� ����ִ��� �˷���
    @Test
    public void isEmpty() {
        //given

        //when
        boolean actual = treeMap.isEmpty();
        //then
        assertThat(actual).isFalse();
    }

    // Set keySet() : TreeMap�� ����� ��� Ű�� ����� Set�� ��ȯ
    @Test
    public void keySet() {
        //given

        //when
        Set<Integer> set = treeMap.keySet();
        //then
        assertThat(set.toString()).isEqualTo("[1, 2, 3]");
    }

    // Entry lastEntry() : TreeMap�� ����� ������ Ű�� ���� ��ȯ
    @Test
    public void lastEntry() {
        //given

        //when
        Map.Entry<Integer, Person> entry = treeMap.lastEntry();
        //then
        assertThat(entry.getValue()).isEqualTo(new Person(3, "������"));
    }

    // Object lastKey() : TreeMap�� ����� ������ Ű�� ��ȯ
    @Test
    public void lastKey() {
        //given

        //when
        Integer actual = treeMap.lastKey();
        //then
        assertThat(actual).isEqualTo(3);
    }

    // Entry lowerEntry(Object key) : ������ key���� ���� Ű�߿��� ���� ū Ű�� ���� ��ȯ, ������ null ��ȯ
    @Test
    public void lowerEntry() {
        //given

        //when
        Map.Entry<Integer, Person> entry = treeMap.lowerEntry(3);
        //then
        assertThat(entry.getValue()).isEqualTo(new Person(2,"ȫ�浿"));
    }

    // Object lowerKey(Object key) : ������ key���� ���� Ű�߿��� ���� ū Ű�� ��ȯ, ������ null ��ȯ
    @Test
    public void lowerKey() {
        //given

        //when
        Integer actual = treeMap.lowerKey(3);
        //then
        assertThat(actual).isEqualTo(2);
    }

    // NavigableSet navigableKeySet() : TreeMap�� ��� Ű�� ��� NavigableSet�� ��ȯ
    @Test
    public void navigableKeySet() {
        //given

        //when
        NavigableSet<Integer> actual = treeMap.navigableKeySet();
        //then
        System.out.println(actual);
    }

    // Entry pollFirstEntry() : TreeMap���� ���� ���� Ű�� �����ϸ鼭 ��ȯ
    @Test
    public void pollFirstEntry() {
        //given

        //when
        Map.Entry<Integer, Person> entry = treeMap.pollFirstEntry();
        //then
        assertThat(entry.getValue()).isEqualTo(new Person(1, "���ȯ"));
    }

    // Entry pollLastEntry() : TreeMap���� ���� ū Ű�� �����ϸ鼭 ��ȯ
    @Test
    public void pollLastEntry() {
        //given

        //when
        Map.Entry<Integer, Person> entry = treeMap.pollLastEntry();
        //then
        assertThat(entry.getValue()).isEqualTo(new Person(3, "������"));
    }

    // Object put(Object key, Object value) : ������ Ű�� ���� TreeMap�� ����, ������ ����� ���� ������ ��ȯ
    @Test
    public void put() {
        //given
        
        //when
        Person actual1 = treeMap.put(4, new Person(4, "���ȯ"));
        Person actual2 = treeMap.put(3, new Person(3, "���ȯ"));
        //then
        assertThat(actual1).isNull();
        assertThat(actual2).isEqualTo(new Person(3, "������"));
    }

    // void putAll() : Map�� ����� ��� ��Ҹ� TreeMap�� ����
    @Test
    public void putAll() {
        //given
        TreeMap<Integer, Person> map = new TreeMap<>();
        map.put(4, new Person(4, "���ȯ"));
        map.put(5, new Person(5, "����ȯ"));
        //when
        treeMap.putAll(map);
        //then
        System.out.println(treeMap);
    }

    // Object remove(Object key) : treeMap���� ������ Ű�� ����� value �����ϰ� ��ȯ
    @Test
    public void remove() {
        //given
        
        //when
        Person actual = treeMap.remove(2);
        //then
        assertThat(actual).isEqualTo(new Person(2, "ȫ�浿"));
    }

    // Object replace(Object key, Object value) : ������ Ű�� ���� ������ ������ ����
    @Test
    public void replace() {
        //given
        
        //when
        Person actual1 = treeMap.replace(3, new Person(3, "���ȯ"));
        Person actual2 = treeMap.replace(4, new Person(4, "���ȯ")); // treeMap �־���������
        //then
        System.out.println(treeMap);
        assertThat(actual1).isEqualTo(new Person(3, "���ȯ"));
        assertThat(actual2).isNull();
    }
    
    // boolean replace(Object key, Object oldValue, Object newValue)
    // ������ key�� value�� ���ο� ��(newValue)�� ���� ��, ������ ���� ������ ��(oldValue)�� ��ġ�ؾ���
    @Test
    public void replace2() {
        //given
        
        //when
        boolean actual1 = treeMap.replace(3, new Person(3, "������"), new Person(3, "���ȯ"));
        boolean actual2 = treeMap.replace(2, new Person(2, "���ȯ"), new Person(2, "�̿�ȯ"));
        //then
        assertThat(actual1).isTrue();
        assertThat(actual2).isFalse();
    }

    // int size() : TreeMap�� ����� ����� ������ ��ȯ
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
    // ������ �ΰ��� Ű ���̿� �ִ� ��� ������� ��� Map�� ��ȯ
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
    // ������ Ű���� ������ ����� ������ ���� ��Ұ� ��� Map�� ��ȯ
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

    // Collection<V> values() : TreeMap�� ����� ��� ���� �÷����� ���·� ��ȯ
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
