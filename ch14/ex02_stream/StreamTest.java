package ch14.ex02_stream;


import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.BaseStream;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StreamTest {

    @Test
    public void ��Ʈ��_stream_�׽�Ʈ() throws Exception {
        //given
        String[] strArr = {"aaa", "bbb", "ccc"};
        List<String> strList = Arrays.asList(strArr);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        String actual1, actual2;
        //when
        Stream<String> strStream1 = Arrays.stream(strArr);
        Stream<String> strStream2 = strList.stream();

        strStream1.sorted().forEach((s) -> sb1.append(s + " "));
        strStream2.sorted().forEach((s) -> sb2.append(s + " "));

        actual1 = sb1.toString().trim();
        actual2 = sb2.toString().trim();
        //then
        assertThat(actual1).isEqualTo("aaa bbb ccc");
        assertThat(actual2).isEqualTo("aaa bbb ccc");

    }

    @Test
    public void ��Ʈ�������÷���_stream_�׽�Ʈ() throws Exception {
        //given
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        StringBuilder sb = new StringBuilder();
        String actual;
        //when
        Stream<Integer> intStream = list.stream();
        intStream.forEach(sb::append);
        actual = sb.toString();
        //then
        assertThat(actual).isEqualTo("12345");
    }

    @Test
    public void ��Ʈ������_�迭_�׽�Ʈ() throws Exception {
        Stream<String> strStream1 = Stream.of("a", "b", "c");          // ��������
        Stream<String> strStream2 = Stream.of(new String[]{"a", "b", "c"});     // ���ʸ�Ÿ�� �迭
        Stream<String> strStream3 = Arrays.stream(new String[]{"a", "b", "c"}); // ���ʸ�Ÿ�� �迭
        Stream<String> strStream4 = Arrays.stream(new String[]{"a", "b", "c"}, 0, 3);

        // int, long, double�� ���� �⺻�� �迭�� �ҽ��� �ϴ� ��Ʈ���� ����
        IntStream intStream1 = IntStream.of(1, 2, 3);
        IntStream intStream2 = IntStream.of(new int[]{1, 2, 3});
        IntStream intStream3 = Arrays.stream(new int[]{1, 2, 3});
        IntStream intStream4 = Arrays.stream(new int[]{1, 2, 3}, 0, 3);
    }

    @Test
    public void Ư������������_range_rangeClosed_�׽�Ʈ() throws Exception {
        //given
        IntStream intStream1 = IntStream.range(1, 5);
        IntStream intStream2 = IntStream.rangeClosed(1, 5);
        int[] actual1, actual2;

        //when
        actual1 = intStream1.toArray();
        actual2 = intStream2.toArray();

        //then
        assertThat(actual1).isEqualTo(new int[]{1, 2, 3, 4});
        assertThat(actual2).isEqualTo(new int[]{1, 2, 3, 4, 5});
    }

    @Test
    public void �����Ǽ�_ints_�׽�Ʈ() throws Exception {
        //given
        Random r = new Random();
        IntStream intStream1 = r.ints().limit(5);
        IntStream intStream2 = r.ints(5, 1, 5);
        int[] actual1, actual2;

        //when
        actual1 = intStream1.toArray();
        actual2 = intStream2.toArray();

        //then
        System.out.println(Arrays.toString(actual1));
        System.out.println(Arrays.toString(actual2));
    }

    @Test
    public void iterate_generate_�׽�Ʈ() throws Exception {
        Stream<Integer> evenStream = Stream.iterate(0, n -> n + 2);
        Stream<Double> randomStream = Stream.generate(Math::random);
        Stream<Integer> oneStream = Stream.generate(() -> 1);

        // convert Stream<Integer> -> IntStream
        IntStream evenStream2 = Stream.iterate(0, n -> n + 2).mapToInt(Integer::intValue);

        // convert IntStream -> Stream<Integer>
        Stream<Integer> stream = evenStream2.boxed();
    }

    @Test
    public void ��Ʈ��_empty_�׽�Ʈ() throws Exception {
        //given
        Stream emptyStream = Stream.empty();

        //when
        long count = emptyStream.count();
        //then
        assertThat(count).isEqualTo(0);
    }

    @Test
    public void ��Ʈ���ǿ���_concat_�׽�Ʈ() throws Exception {
        //given
        String[] str1 = {"123", "456", "789"};
        String[] str2 = {"ABC", "DEF", "GHI"};
        StringBuilder sb = new StringBuilder();
        String actual;
        //when
        Stream<String> strStream1 = Stream.of(str1);
        Stream<String> strStream2 = Stream.of(str2);
        Stream<String> strStream3 = Stream.concat(strStream1, strStream2);

        strStream3.forEach((s) -> sb.append(s + " "));
        actual = sb.toString().trim();
        //then
        assertThat(actual).isEqualTo("123 456 789 ABC DEF GHI");
    }

    @Test
    public void ��Ʈ���ڸ���_skip_limit_�׽�Ʈ() throws Exception {
        //given
        IntStream intStream = IntStream.rangeClosed(1, 10); // 1~10
        //when
        int[] actual = intStream.skip(3).limit(5).toArray();
        //then
        assertThat(actual).isEqualTo(new int[]{4, 5, 6, 7, 8});
    }

    @Test
    public void ��Ʈ����Ұɷ�����_distinct_�׽�Ʈ() throws Exception{
        //given
        IntStream intStream = IntStream.of(1,2,2,3,3,3,4,5,5,6);
        //when
        int[] actual = intStream.distinct().toArray();
        //then
        assertThat(actual).isEqualTo(new int[]{1,2,3,4,5,6});
    }

    @Test
    public void ��Ʈ����Ұɷ�����_filter_�׽�Ʈ() throws Exception{
        //given
        IntStream intStream = IntStream.rangeClosed(1,10);
        IntStream intStream2 = IntStream.rangeClosed(1,10);
        IntStream intStream3 = IntStream.rangeClosed(1,10);
        //when
        int[] actual = intStream.filter(i -> i % 2 == 0).toArray();
        int[] actual2 = intStream2.filter(i -> i % 2 != 0).filter(i -> i % 3 != 0).toArray();
        int[] actual3 = intStream3.filter(i -> i % 2 != 0 && i % 3 != 0).toArray();
        //then
        assertThat(actual).isEqualTo(new int[]{2,4,6,8,10});
        assertThat(actual2).isEqualTo(new int[]{1,5,7});
        assertThat(actual3).isEqualTo(new int[]{1,5,7});
    }

    @Test
    public void ����_sorted_�׽�Ʈ() throws Exception{
        //given
        Stream<String> strStream = Stream.of("dd", "aaa", "CC", "cc", "b");
        StringBuilder sb = new StringBuilder();
        String actual;
        //when
        strStream.sorted().forEach((s)->sb.append(s +" "));
        actual = sb.toString().trim();
        //then
        assertThat(actual).isEqualTo("CC aaa b cc dd");
    }

    @Test
    public void ����_sorted_Comparator_�׽�Ʈ() throws Exception{
        //given
        Stream<String>[] strStreams = new Stream[11];
        String[] actualArray = new String[11];
        IntStream.rangeClosed(0,10).forEach(i-> strStreams[i] = Stream.of("dd", "aaa", "CC", "cc", "b"));

        //when
        // �빮��->�ҹ��� ��������
        actualArray[0] = strStreams[0].sorted().collect(Collectors.joining(" "));
        actualArray[1] = strStreams[1].sorted(Comparator.naturalOrder()).collect(Collectors.joining(" "));
        actualArray[2] = strStreams[2].sorted((s1,s2)->s1.compareTo(s2)).collect(Collectors.joining(" "));
        actualArray[3] = strStreams[3].sorted(String::compareTo).collect(Collectors.joining(" "));

        // �ҹ���->�빮�� ��������
        actualArray[4] = strStreams[4].sorted(Comparator.reverseOrder()).collect(Collectors.joining(" "));
        actualArray[5] = strStreams[5].sorted(Comparator.<String>naturalOrder().reversed()).collect(Collectors.joining(" "));

        // ��ҹ��� ���о��� ��������
        actualArray[6] = strStreams[6].sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.joining(" "));

        // ��ҹ��� ���о��� ��������
        actualArray[7] = strStreams[7].sorted(String.CASE_INSENSITIVE_ORDER.reversed()).collect(Collectors.joining(" "));

        // ���̼����� ��������
        actualArray[8] = strStreams[8].sorted(Comparator.comparing(String::length)).collect(Collectors.joining(" "));    // ���̼�����
        actualArray[9] = strStreams[9].sorted(Comparator.comparingInt(String::length)).collect(Collectors.joining(" ")); // no ����ڽ�

        // ���̼����� ��������
        actualArray[10] = strStreams[10].sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.joining(" "));

        //then
        assertThat(actualArray[0]).isEqualTo("CC aaa b cc dd");
        assertThat(actualArray[1]).isEqualTo("CC aaa b cc dd");
        assertThat(actualArray[2]).isEqualTo("CC aaa b cc dd");
        assertThat(actualArray[3]).isEqualTo("CC aaa b cc dd");

        assertThat(actualArray[4]).isEqualTo("dd cc b aaa CC");
        assertThat(actualArray[5]).isEqualTo("dd cc b aaa CC");

        assertThat(actualArray[6]).isEqualTo("aaa b CC cc dd");

        assertThat(actualArray[7]).isEqualTo("dd CC cc b aaa");

        assertThat(actualArray[8]).isEqualTo("b dd CC cc aaa");
        assertThat(actualArray[9]).isEqualTo("b dd CC cc aaa");

        assertThat(actualArray[10]).isEqualTo("aaa dd CC cc b");
    }

    @Test
    public void ����_thenComparing_�׽�Ʈ() throws Exception{
        //given
        Stream<Student> studentStream = Stream.of(new Student("���ȯ", 1, 100),
                                                  new Student("�̰��",1, 150),
                                                  new Student("ȫ�浿",2,125));
        StringBuilder sb = new StringBuilder();
        String actual;
        //when
        // �л� ��Ʈ���� �ݺ�, ������, �̸������� ����
        studentStream.sorted(Comparator.comparing(Student::getBan)
                                       .thenComparing(Student::getTotalScore)
                                       .thenComparing(Student::getName))
                     .forEach((s)->sb.append(s.getName()+" "));

        actual = sb.toString().trim();
        //then
        assertThat(actual).isEqualTo("���ȯ �̰�� ȫ�浿");
    }

    @Test
    public void sorted_��ü����_thenComparing_�׽�Ʈ() throws Exception{
        //given
        Student[] students = {
                new Student("���ڹ�",3,300),
                new Student("���ڹ�",1,200),
                new Student("���ڹ�",2,100),
                new Student("���ڹ�",2,150),
                new Student("���ڹ�",1,200),
                new Student("���ڹ�",3,290),
                new Student("���ڹ�",3,180)
        };
        Stream<Student> studentStream = Stream.of(students);
        List<String> actualList = Arrays.asList("���ڹ�","���ڹ�","���ڹ�","���ڹ�","���ڹ�","���ڹ�","���ڹ�");
        //when
        List<Student> studentList = studentStream.sorted(Comparator.comparing(Student::getBan)
                                                                    .thenComparing(Comparator.naturalOrder()))
                                                 .collect(Collectors.toList());
        //then
        IntStream.rangeClosed(0, actualList.size()-1).forEach((i)->{
            assertThat(studentList.get(i).getName()).isEqualTo(actualList.get(i));
        });
    }

    @Test
    public void ��ȯ_map_�׽�Ʈ() throws Exception{
        //given
        File[] files = {new File("Ex1.java"),
                        new File("Ex1"),
                        new File("Ex1.bak"),
                        new File("Ex2.java"),
                        new File("Ex1.txt")};
        Stream<File> fileStream = Stream.of(files);
        //when
        Stream<String> fileNameStream = fileStream.map(File::getName);
        String[] actual = fileNameStream.collect(Collectors.joining(" ")).split(" ");
        //then
        assertThat(actual).isEqualTo(new String[]{"Ex1.java","Ex1","Ex1.bak","Ex2.java","Ex1.txt"});
    }

    @Test
    public void ��ȯ_map_Ȯ���ڸ�����_�׽�Ʈ() throws Exception{
        //given
        File[] files = {new File("Ex1.java"),
                new File("Ex1"),
                new File("Ex1.bak"),
                new File("Ex2.java"),
                new File("Ex1.txt")};
        Stream<File> fileStream = Stream.of(files);
        //when
        String[] actual = fileStream.map(File::getName)                               // �����̸� ����
                                    .filter(s -> s.indexOf(".") != -1)                // Ȯ���ڰ� ���� ���� ����
                                    .map(s->s.substring(s.indexOf(".")+1))  // Stream<String>->Stream<String>
                                    .map(String::toUpperCase)                        // ��� �빮�ڷ� ��ȯ
                                    .distinct()                                      //�ߺ�����
                                    .collect(Collectors.joining(" "))        // ������ �����ڷ� ���ڿ��� ����
                                    .split(" ");                               // ������ �������� ���ڿ� �迭 ����
        //then
        assertThat(actual).isEqualTo(new String[]{"JAVA", "BAK", "TXT"});
    }

    @Test
    public void ��ȸ_peek_�׽�Ʈ() throws Exception{
        //given
        File[] files = {new File("Ex1.java"),
                new File("Ex1"),
                new File("Ex1.bak"),
                new File("Ex2.java"),
                new File("Ex1.txt")};
        Stream<File> fileStream = Stream.of(files);
        Consumer<String> printFileName = (s)->System.out.printf("filename=%s\n",s);

        //when
        String[] actual = fileStream.map(File::getName)                               // �����̸� ����
                .filter(s -> s.indexOf(".") != -1)                // Ȯ���ڰ� ���� ���� ����
                .peek(printFileName)
                .map(s->s.substring(s.indexOf(".")+1))  // Stream<String>->Stream<String>
                .peek(printFileName)
                .map(String::toUpperCase)                        // ��� �빮�ڷ� ��ȯ
                .distinct()                                      //�ߺ�����
                .collect(Collectors.joining(" "))        // ������ �����ڷ� ���ڿ��� ����
                .split(" ");                               // ������ �������� ���ڿ� �迭 ����
        //then
        assertThat(actual).isEqualTo(new String[]{"JAVA", "BAK", "TXT"});
    }

    @Test
    public void ��ȯ_mapToInt_�׽�Ʈ() throws Exception{
        //given
        Student[] students = {
                new Student("���ڹ�",3,300),
                new Student("���ڹ�",1,200),
                new Student("���ڹ�",2,100),
                new Student("���ڹ�",2,150),
                new Student("���ڹ�",1,200),
                new Student("���ڹ�",3,290),
                new Student("���ڹ�",3,180)
        };
        Stream<Student> studentStream = Stream.of(students);

        //when
//        Stream<Integer> studentScoreStream = studentStream.map(Student::getTotalScore);
        IntStream studentScoreStream = studentStream.mapToInt(Student::getTotalScore);
        int actual = studentScoreStream.sum();
        //then
        assertThat(actual).isEqualTo(1420);
    }

}
