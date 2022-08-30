package ch14.ex02_stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class CollectTest {
    // �־��� ��Ʈ���� ��� ��Ҹ� ����Ʈ�� ����
    // List<T> collect(Collectors.toList()) : ��Ʈ���� ��� ��Ҹ� ����Ʈ�� �����Ͽ� ��ȯ
    @Test
    public void toList() {
        //given
        String[] array = {"a","b","c","d","e"};
        //when
        List<String> list = Arrays.stream(array).collect(Collectors.toList());
        //then
        assertThat(list).isEqualTo(Arrays.asList("a","b","c","d","e"));
    }

    // �־��� ��Ʈ���� ��Ҹ� �������� �����ϴ� �׽�Ʈ
    // Set<T> collect(Collectors.toSet())
    @Test
    public void toSet() {
        //given
        String[] array = {"a","b","c","d","e"};
        //when
        Set<String> set = Arrays.stream(array).collect(Collectors.toSet());
        //then
        assertThat(set).isEqualTo(Set.of("a","b","c","d","e"));
    }

    /**
     * �־��� ��Ʈ���� ��Ҹ� ������ �����ϴ� �׽�Ʈ
     *  <T, K, U> Collector<T, ?, Map<K, U>> toMap(
     *  @NotNull  java.util.function.Function<? super T, ? extends K> keyMapper,
     *  @NotNull java.util.function.Function<? super T, ? extends U> valueMapper)
     */
    @Test
    public void toMap() {
        //given
        Person person1 = new Person(1, 30);
        Person person2 = new Person(2, 50);
        Person[] personArray = {person1, person2};

        //when
        Map<Integer, Person> map = Arrays.stream(personArray)
                                         .collect(Collectors.toMap(p->p.getId(), p->p));
        //then
        assertThat(map.get(1)).isEqualTo(person1);
        assertThat(map.get(2)).isEqualTo(person2);
    }

    // �־��� ��Ʈ���� ��Ҹ� �÷������� �����ϴ� �׽�Ʈ
    //  <T, C extends java.util.Collection<T>> java.util.stream.Collector<T, ?, C>
    //   Collectors.toCollection(Supplier<C) collectionFactory)
    @Test
    public void toCollection() {
        //given
        String[] array = {"a","b","c","d","e"};
        //when
        ArrayList<String> list = Arrays.stream(array).collect(Collectors.toCollection(ArrayList::new));
        //then
        assertThat(list).isEqualTo(Arrays.asList("a","b","c","d","e"));
    }

    // �־��� ��Ʈ���� ��Ҹ� �迭�� �����ϴ� �׽�Ʈ
    // <A> A[] toArray(Function<A[]> generator)
    // Object[] toArray()
    @Test
    public void toArray() {
        //given
        List<String> list = Arrays.asList("a","b","c","d","e");
        //when
        String[] strArray = list.stream().toArray(String[]::new);
//        String[] strArray2 = list.stream().toArray(); // error
        Object[] strArray3 = list.stream().toArray();
        //then
        assertThat(strArray).isEqualTo(new String[]{"a","b","c","d","e"});
        assertThat(strArray).isEqualTo(new Object[]{"a","b","c","d","e"});
    }

    // �־��� ��Ʈ���� ����� ������ ���� �׽�Ʈ
    // collect(Collectors.counting())
    @Test
    public void counting() {
        //given
        String[] array = {"a","b","c","d","e"};
        //when
        long count1 = Arrays.stream(array).count();
        long count2 = Arrays.stream(array).collect(Collectors.counting());
        //then
        assertThat(count2).isEqualTo(5);
    }

    // �־��� ��Ʈ���� ��ҵ��� �հ踦 ���ϴ� �׽�Ʈ
    // collect(Collectors.summingInt())
    @Test
    public void summingInt() {
        //given
        Person[] persons = {new Person(1,10), new Person(2, 20)};
        //when
        long totalScore1 = Arrays.stream(persons).mapToInt(Person::getScore).sum();
        long totalScore2 = Arrays.stream(persons).collect(Collectors.summingInt(Person::getScore));
        //then
        assertThat(totalScore1).isEqualTo(30);
        assertThat(totalScore2).isEqualTo(30);
    }

    // �־��� ��Ʈ���� ��ҵ��� �ְ��� ���� ��Ҹ� Ž���ϴ� �׽�Ʈ
    // Collector Collectors.maxBy(Comparator)
    @Test
    public void maxBy() {
        //given
        Person[] persons = {new Person(1,10),
                            new Person(2, 20),
                            new Person(3, 30),
                            new Person(4, 40),
                            new Person(5, 50)};
        //when
        OptionalInt      topPerson1 = Arrays.stream(persons).mapToInt(Person::getScore).max();
        Optional<Person> topPerson2 = Arrays.stream(persons).max(Comparator.comparingInt(Person::getScore));
        Optional<Person> topPerson3 = Arrays.stream(persons)
                                            .collect(Collectors.maxBy(Comparator.comparingInt(Person::getScore)));
        //then
        assertThat(topPerson1.getAsInt()).isEqualTo(50);
        assertThat(topPerson2.get().getId()).isEqualTo(5);
        assertThat(topPerson3.get().getId()).isEqualTo(5);
    }

    // �־��� ��Ʈ���� ��ҵ��� �ּڰ��� ���� ��Ҹ� Ž���ϴ� �׽�Ʈ
    // Collector Collectors.minBy(Comparator)
    @Test
    public void minBy() {
        //given
        Person[] persons = {new Person(1,10),
                new Person(2, 20),
                new Person(3, 30),
                new Person(4, 40),
                new Person(5, 50)};
        //when
        OptionalInt      underPerson1 = Arrays.stream(persons).mapToInt(Person::getScore).min();
        Optional<Person> underPerson2 = Arrays.stream(persons).min(Comparator.comparingInt(Person::getScore));
        Optional<Person> underPerson3 = Arrays.stream(persons)
                                              .collect(Collectors.minBy(Comparator.comparingInt(Person::getScore)));
        //then
        assertThat(underPerson1.getAsInt()).isEqualTo(50);
        assertThat(underPerson2.get().getId()).isEqualTo(5);
        assertThat(underPerson3.get().getId()).isEqualTo(5);
    }

    // �־��� ��Ʈ���� ��ҵ鿡 ���� ��� ������ �����ϴ� �׽�Ʈ
    // Collector Collectors.summarizingInt(ToIntFunction)
    @Test
    public void summarizingInt() {
        //given
        Person[] persons = {new Person(1,10),
                            new Person(2, 20),
                            new Person(3, 30),
                            new Person(4, 40),
                            new Person(5, 50)};
        //when
        IntSummaryStatistics stat1 = Arrays.stream(persons).mapToInt(Person::getScore).summaryStatistics();
        IntSummaryStatistics stat2 = Arrays.stream(persons).collect(Collectors.summarizingInt(Person::getScore));
        //then
        assertThat(stat2.getCount()).isEqualTo(5);
        assertThat(stat2.getSum()).isEqualTo(150);
        assertThat(stat2.getMax()).isEqualTo(50);
        assertThat(stat2.getMin()).isEqualTo(10);
        assertThat(stat2.getAverage()).isEqualTo(30.0);
    }

    // �־��� ��Ʈ���� ��Ҹ� reduce ������ �����ϴ� �׽�Ʈ
    // Collector reducing(BinaryOperator<T> op)
    // Collector reducing(T identity, BinaryOperator<T> op)
    // Collector reducing(U identity, Function<T,U> mapper, BinaryOperator<U> op)
    @Test
    public void reducing() {
        //given
        Person[] persons = {new Person(1,10),
                new Person(2, 20),
                new Person(3, 30),
                new Person(4, 40),
                new Person(5, 50)};
        //when
        OptionalInt       max1 = getLotto().reduce(Integer::max);
        Optional<Integer> max2 = getLotto().boxed().collect(Collectors.reducing(Integer::max));
        long              sum1 = getLotto().reduce(0, (a,b)->a+b);
        long              sum2 = getLotto().boxed().collect(Collectors.reducing(0, (a,b) -> a+b));
        int        grandTotal1 = Arrays.stream(persons).map(Person::getScore).reduce(0, Integer::sum);
        int        grandTotal2 = Arrays.stream(persons).collect(Collectors.reducing(0, Person::getScore, Integer::sum));

        //then
        assertThat(grandTotal1).isEqualTo(150);
        assertThat(grandTotal2).isEqualTo(150);

    }
    private static IntStream getLotto(){
        return new Random().ints(1,46).distinct().limit(6);
    }

    // ��Ʈ���� ��Ҹ� ���ڿ��� �����Ű�� �׽�Ʈ
    // Collector joining()
    // Collector joining(String delimiter)
    // Collector joining(String delimiter, String prefix, String postfix)
    @Test
    public void joining() {
        //given
        Student[] students = {
                new Student("ȫ�浿",1,100),
                new Student("������",1,200),
                new Student("������",2,300),
                new Student("������",2,400),
                new Student("������",3,500)
        };

        //when
        String studentNames1 = Arrays.stream(students).map(Student::getName).collect(Collectors.joining());
        String studentNames2 = Arrays.stream(students).map(Student::getName).collect(Collectors.joining(","));
        String studentNames3 = Arrays.stream(students).map(Student::getName).collect(Collectors.joining(",", "[", "]"));

        //then
        assertThat(studentNames1).isEqualTo("ȫ�浿�����ٱ�����������������");
        assertThat(studentNames2).isEqualTo("ȫ�浿,������,������,������,������");
        assertThat(studentNames3).isEqualTo("[ȫ�浿,������,������,������,������]");
    }
    

}
