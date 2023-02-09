package ch14.ex02_stream;


import org.junit.Test;

import javax.swing.text.html.Option;
import java.io.File;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StreamTest {

    @Test
    public void Stream_createStream()  {
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
    public void Stream_Collection_create()  {
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
    public void Stream_arrayStream()  {
        Stream<String> strStream1 = Stream.of("a", "b", "c");          // 가변인자
        Stream<String> strStream2 = Stream.of(new String[]{"a", "b", "c"});     // 제너릭타입 배열
        Stream<String> strStream3 = Arrays.stream(new String[]{"a", "b", "c"}); // 제너릭타입 배열
        Stream<String> strStream4 = Arrays.stream(new String[]{"a", "b", "c"}, 0, 3);

        // int, long, double과 같은 기본형 배열을 소스로 하는 스트림을 생성
        IntStream intStream1 = IntStream.of(1, 2, 3);
        IntStream intStream2 = IntStream.of(new int[]{1, 2, 3});
        IntStream intStream3 = Arrays.stream(new int[]{1, 2, 3});
        IntStream intStream4 = Arrays.stream(new int[]{1, 2, 3}, 0, 3);
    }

    @Test
    public void IntStream_range_rangeClosed()  {
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
    public void Random_ints()  {
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
    public void Stream_iterate_generate()  {
        Stream<Integer> evenStream = Stream.iterate(0, n -> n + 2);
        Stream<Double> randomStream = Stream.generate(Math::random);
        Stream<Integer> oneStream = Stream.generate(() -> 1);

        // convert Stream<Integer> -> IntStream
        IntStream evenStream2 = Stream.iterate(0, n -> n + 2).mapToInt(Integer::intValue);

        // convert IntStream -> Stream<Integer>
        Stream<Integer> stream = evenStream2.boxed();
    }

    @Test
    public void emptyStream_empty_test()  {
        //given
        Stream emptyStream = Stream.empty();

        //when
        long count = emptyStream.count();
        //then
        assertThat(count).isEqualTo(0);
    }

    @Test
    public void streamConcat_concat_test()  {
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
    public void streamSlice_skip_limit_test()  {
        //given
        IntStream intStream = IntStream.rangeClosed(1, 10); // 1~10
        //when
        int[] actual = intStream.skip(3).limit(5).toArray();
        //then
        assertThat(actual).isEqualTo(new int[]{4, 5, 6, 7, 8});
    }

    @Test
    public void streamElementFilter_distinct_test() {
        //given
        IntStream intStream = IntStream.of(1,2,2,3,3,3,4,5,5,6);
        //when
        int[] actual = intStream.distinct().toArray();
        //then
        assertThat(actual).isEqualTo(new int[]{1,2,3,4,5,6});
    }

    @Test
    public void streamElementFilter_test() {
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
    public void sorted_test() {
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
    public void sorted_Comparator_test() {
        //given
        Stream<String>[] strStreams = new Stream[11];
        String[] actualArray = new String[11];
        IntStream.rangeClosed(0,10).forEach(i-> strStreams[i] = Stream.of("dd", "aaa", "CC", "cc", "b"));

        //when
        // 대문자->소문자 오름차순
        actualArray[0] = strStreams[0].sorted().collect(Collectors.joining(" "));
        actualArray[1] = strStreams[1].sorted(Comparator.naturalOrder()).collect(Collectors.joining(" "));
        actualArray[2] = strStreams[2].sorted((s1,s2)->s1.compareTo(s2)).collect(Collectors.joining(" "));
        actualArray[3] = strStreams[3].sorted(String::compareTo).collect(Collectors.joining(" "));

        // 소문자->대문자 내림차순
        actualArray[4] = strStreams[4].sorted(Comparator.reverseOrder()).collect(Collectors.joining(" "));
        actualArray[5] = strStreams[5].sorted(Comparator.<String>naturalOrder().reversed()).collect(Collectors.joining(" "));

        // 대소문자 구분없이 오름차순
        actualArray[6] = strStreams[6].sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.joining(" "));

        // 대소문자 구분없이 내림차순
        actualArray[7] = strStreams[7].sorted(String.CASE_INSENSITIVE_ORDER.reversed()).collect(Collectors.joining(" "));

        // 길이순으로 오름차순
        actualArray[8] = strStreams[8].sorted(Comparator.comparing(String::length)).collect(Collectors.joining(" "));    // 길이순정렬
        actualArray[9] = strStreams[9].sorted(Comparator.comparingInt(String::length)).collect(Collectors.joining(" ")); // no 오토박싱

        // 길이순으로 내림차순
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
    public void sort_thenComparing_test() {
        //given
        Stream<Student> studentStream = Stream.of(new Student("김용환", 1, 100),
                new Student("이경수",1, 150),
                new Student("홍길동",2,125));
        StringBuilder sb = new StringBuilder();
        String actual;
        //when
        // 학생 스트림을 반별, 성적순, 이름순으로 정렬
        studentStream.sorted(Comparator.comparing(Student::getBan)
                        .thenComparing(Student::getTotalScore)
                        .thenComparing(Student::getName))
                .forEach((s)->sb.append(s.getName()+" "));

        actual = sb.toString().trim();
        //then
        assertThat(actual).isEqualTo("김용환 이경수 홍길동");
    }

    @Test
    public void sorted_objectSort_thenComparing_test() {
        //given
        Student[] students = {
                new Student("이자바",3,300),
                new Student("김자바",1,200),
                new Student("안자바",2,100),
                new Student("박자바",2,150),
                new Student("소자바",1,200),
                new Student("나자바",3,290),
                new Student("감자바",3,180)
        };
        Stream<Student> studentStream = Stream.of(students);
        List<String> actualList = Arrays.asList("김자바","소자바","박자바","안자바","이자바","나자바","감자바");
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
    public void map_test() {
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
    public void map_extension_test() {
        //given
        File[] files = {new File("Ex1.java"),
                new File("Ex1"),
                new File("Ex1.bak"),
                new File("Ex2.java"),
                new File("Ex1.txt")};
        Stream<File> fileStream = Stream.of(files);
        //when
        String[] actual = fileStream.map(File::getName)                               // 파일이름 추출
                .filter(s -> s.indexOf(".") != -1)                // 확장자가 없는 것은 제외
                .map(s->s.substring(s.indexOf(".")+1))  // Stream<String>->Stream<String>
                .map(String::toUpperCase)                        // 모두 대문자로 변환
                .distinct()                                      //중복제거
                .collect(Collectors.joining(" "))        // 공백을 구분자로 문자열로 모음
                .split(" ");                               // 공백을 기준으로 문자열 배열 생성
        //then
        assertThat(actual).isEqualTo(new String[]{"JAVA", "BAK", "TXT"});
    }

    @Test
    public void search_peek_test() {
        //given
        File[] files = {new File("Ex1.java"),
                new File("Ex1"),
                new File("Ex1.bak"),
                new File("Ex2.java"),
                new File("Ex1.txt")};
        Stream<File> fileStream = Stream.of(files);
        Consumer<String> printFileName = (s)->System.out.printf("filename=%s\n",s);

        //when
        String[] actual = fileStream.map(File::getName)                               // 파일이름 추출
                .filter(s -> s.indexOf(".") != -1)                // 확장자가 없는 것은 제외
                .peek(printFileName)
                .map(s->s.substring(s.indexOf(".")+1))  // Stream<String>->Stream<String>
                .peek(printFileName)
                .map(String::toUpperCase)                        // 모두 대문자로 변환
                .distinct()                                      //중복제거
                .collect(Collectors.joining(" "))        // 공백을 구분자로 문자열로 모음
                .split(" ");                               // 공백을 기준으로 문자열 배열 생성
        //then
        assertThat(actual).isEqualTo(new String[]{"JAVA", "BAK", "TXT"});
    }

    @Test
    public void map_mapToInt_test() {
        //given
        Student[] students = getStudents();
        Stream<Student> studentStream = Stream.of(students);

        //when
        Stream<Integer> studentScoreStream1 = studentStream.map(Student::getTotalScore);
        studentStream = Stream.of(students);
        IntStream studentScoreStream2 = studentStream.mapToInt(Student::getTotalScore);
        int actual1 = studentScoreStream1.reduce(0, Integer::sum);
        int actual2 = studentScoreStream2.sum();
        //then
        assertThat(actual1).isEqualTo(1420);
        assertThat(actual2).isEqualTo(1420);
    }

    private Student[] getStudents() {
        Student[] students = {
                new Student("이자바",3,300),
                new Student("김자바",1,200),
                new Student("안자바",2,100),
                new Student("박자바",2,150),
                new Student("소자바",1,200),
                new Student("나자바",3,290),
                new Student("감자바",3,180)
        };
        return students;
    }

    @Test
    public void IntStream_sum() {
        //given
        Student[] students = getStudents();
        Stream<Student> studentStream = Stream.of(students);
        //when
        IntStream scoreStream = studentStream.mapToInt(Student::getTotalScore);
        int actual = scoreStream.sum();
        //then
        assertThat(actual).isEqualTo(1420);
    }

    @Test
    public void Stream_mapToInt_average() {
        //given
        Student[] students = getStudents();
        Stream<Student> studentStream = Stream.of(students);
        //when
        IntStream scoreStream = studentStream.mapToInt(Student::getTotalScore);
        OptionalDouble optionalDouble = scoreStream.average();
        long actual = Math.round(optionalDouble.orElse(0));
        //then
        assertThat(actual).isEqualTo(203L);
    }

    @Test
    public void IntStream_summaryStatistics() {
        //given
        Student[] students = getStudents();
        Stream<Student> studentStream = Stream.of(students);
        //when
        IntStream scoreStream = studentStream.mapToInt(Student::getTotalScore);
        IntSummaryStatistics stat = scoreStream.summaryStatistics();
        long   totalCount = stat.getCount();
        long   totalScore = stat.getSum();
        double avgScore   = Math.round(stat.getAverage());
        int    minScore   = stat.getMin();
        int    maxScore   = stat.getMax();
        //then
        assertThat(totalCount).isEqualTo(7);
        assertThat(totalScore).isEqualTo(1420);
        assertThat(avgScore).isEqualTo(203.0);
        assertThat(minScore).isEqualTo(100);
        assertThat(maxScore).isEqualTo(300);
    }

    @Test
    public void IntStream_mapToObj() {
        //given
        IntStream intStream = new Random().ints(1, 16); // 1~45사이의 정수 (46은 포함안됨)

        //when
        Stream<String> lottoStream = intStream.distinct()
                .limit(6)
                .sorted()
                .mapToObj(i->i+","); // 정수를 문자열로 변환
        //then
        lottoStream.forEach(System.out::print);
    }

    @Test
    public void flatMap1() {
        //given
        Stream<String[]> strArrStrm = Stream.of(
                new String[]{"abc","def","ghi"},
                new String[]{"ABC","GHI","JKLMN"}
        );
        //when
//        Stream<Stream<String>> strStrStream = strArrStrm.map(Arrays::stream); // (x)
        Stream<String> strStream = strArrStrm.flatMap(Arrays::stream);
        String[] actual = strStream.collect(Collectors.joining(" ")).split(" ");
        //then
        assertThat(actual).isEqualTo(new String[]{"abc","def","ghi","ABC","GHI","JKLMN"});
    }

    @Test
    public void flatMap2() {
        //given
        String[] lineArr = {
                "Belive or not It is true",
                "Do or do not There is no try"
        };
        Stream<String> lineStream = Arrays.stream(lineArr);
        //when
        Stream<Stream<String>> strArrayStream = lineStream.map(line -> Stream.of(line.split(" "))); // 적절하지 않은 매핑

        lineStream = Arrays.stream(lineArr);
        Stream<String> strStream = lineStream.flatMap(line->Stream.of(line.split(" ")));
        String[] actual = strStream.collect(Collectors.joining(" ")).split(" ");
        //then
        assertThat(actual).isEqualTo(new String[]{"Belive", "or", "not", "It", "is", "true", "Do", "or", "do", "not", "There", "is", "no", "try"});
    }

    @Test
    public void flatMap3() {
        // strStream의 단어들을 모두 소문자로 변환하고, 중복된 단어들을 제거한 다음에 정렬해서 배열에 저장

        //given
        String[] lineArr = {
                "Belive or not It is true",
                "Do or do not There is no try"
        };
        Stream<String> lineStream = Arrays.stream(lineArr);
        Stream<String> strStream = lineStream.flatMap(line->Stream.of(line.split(" ")));
        //when
        String[] actual = strStream.map(String::toLowerCase)
                .distinct()
                .sorted()
                .collect(Collectors.joining(" "))
                .split(" ");

        //then
        assertThat(actual).isEqualTo(new String[]{"belive", "do", "is", "it", "no", "not", "or", "there", "true", "try"});
    }

    @Test
    public void flatMap4() {
        // 스트림의 스트림을 하나의 스트림으로 합칠때 flatMap을 사용함

        //given
        Stream<String> strStrea1 = Stream.of("abc","def","jklmn");
        Stream<String> strStrea2 = Stream.of("ABC","GHI","JKLMN");
        Stream<Stream<String>> strmStrm = Stream.of(strStrea1, strStrea2);

        //when
        String[] actual = strmStrm.map(s->s.toArray(String[]::new)) // Stream<Stream<String>> -> Stream<String[]>
                .flatMap(Arrays::stream)// Stream<String[]> -> Stream<String>
                .collect(Collectors.joining(" "))
                .split(" ");

        //then
        assertThat(actual).isEqualTo(new String[]{"abc","def","jklmn","ABC","GHI","JKLMN"});
    }



}
