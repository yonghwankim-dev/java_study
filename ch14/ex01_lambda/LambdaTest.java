package ch14.ex01_lambda;

import org.junit.Test;

import java.util.*;
import java.util.function.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdaTest {
    static int execute(MyFunction f){ // 매개변수의 타입인 MyFunction인 메서드
        return f.run();
    }

    static MyFunction getMyFunction(){ // 반환 타입이 MyFunction인 메서드
        MyFunction f = ()-> {return 3;};
        return f;
    }

    /**
     * 함수형 인터페이스 타입의 매개변수와 반환타입
     */
    @Test
    public void test1() throws Exception{
        //given
        MyFunction f1 = ()->{return 1;}; // 람다식으로 MyFunction의 run()을 구현
        MyFunction f2 = new MyFunction() {
            @Override
            public int run() { // public을 반드시 붙여야함
                return 2;
            }
        };
        MyFunction f3 = getMyFunction();
        int expected1 = 1;
        int expected2 = 2;
        int expected3 = 3;

        //when
        int actual1 = f1.run();
        int actual2 = f2.run();
        int actual3 = f3.run();
        int actual4 = execute(f1);
        int actual5 = execute(()->{return 2;});

        //then
        assertThat(actual1).isEqualTo(expected1);
        assertThat(actual2).isEqualTo(expected2);
        assertThat(actual3).isEqualTo(expected3);
        assertThat(actual4).isEqualTo(expected1);
        assertThat(actual5).isEqualTo(expected2);
    }

    /**
     * 람다식의 타입과 형변환
     * 람다식 타입 : "외부클래스이름$$Lambda$번호"
     */
    @Test
    public void test2() throws Exception{
        //given
        MyFunction2 f = ()->{}; // MyFunction2 f = (MyFunction2) (()->{});
        Object obj = (MyFunction2)(()->{}); // object 타입으로 형변환이 생략됨, (Object)(MyFunction2)(() -> {})
        String str = ((Object)(MyFunction2)(() -> {})).toString();

        //when
        String actual1 = f.toString();
        String actual2 = obj.toString();
        String actual3 = str;
        String actual4 = ((MyFunction2)(()->{})).toString();
        String actual5 = ((Object) (MyFunction2)(()->{})).toString();

        //then
        assertThat(actual1.startsWith("ch14.ex01_lambda.LambdaTest$$Lambda$48/")).isTrue();
        assertThat(actual2.startsWith("ch14.ex01_lambda.LambdaTest$$Lambda$49/")).isTrue();
        assertThat(actual3.startsWith("ch14.ex01_lambda.LambdaTest$$Lambda$50/")).isTrue();
        assertThat(actual4.startsWith("ch14.ex01_lambda.LambdaTest$$Lambda$51/")).isTrue();
        assertThat(actual5.startsWith("ch14.ex01_lambda.LambdaTest$$Lambda$52/")).isTrue();

//        System.out.println(()=>{}); // 에러, 람다식은 Object 타입으로 형변환 안됨
//        System.out.println((MyFunction2)(()->{}).toString()); // 에러
    }

    /**
     * 외부 변수를 참조하는 람다식
     */
    @Test
    public void test3() throws Exception{
        //given
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();

        //when
        int actual1 = inner.method1(100);
        int actual2 = inner.method2();
        int actual3 = inner.method3();
        int actual4 = inner.method4();

        //then
        assertThat(actual1).isEqualTo(100);
        assertThat(actual2).isEqualTo(30);
        assertThat(actual3).isEqualTo(21);
        assertThat(actual4).isEqualTo(11);
    }

    /**
     * 컬렉션 프레임웤과 함수형 인터페이스 사용
     */
    @Test
    public void test4() throws Exception{
        //given
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        Map<String, String> map = new HashMap<>();
        StringBuilder actual1 = new StringBuilder();
        StringBuilder actual2 = new StringBuilder();
        StringBuilder actual3 = new StringBuilder();
        StringBuilder actual4 = new StringBuilder();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");

        //when
        list.forEach(i->actual1.append(i + ", "));

        list.removeIf(x-> x % 2 == 0 || x % 3 == 0);
        list.forEach(i->actual2.append(i + ", "));

        list.replaceAll(i->i*10);
        list.forEach(i->actual3.append(i + ", "));

        map.forEach((k, v)->actual4.append("{" + k + "," + v + "},"));

        //then
        assertThat(actual1.toString()).isEqualTo("0, 1, 2, 3, 4, 5, 6, 7, 8, 9, ");
        assertThat(actual2.toString()).isEqualTo("1, 5, 7, ");
        assertThat(actual3.toString()).isEqualTo("10, 50, 70, ");
        assertThat(actual4.toString()).isEqualTo("{1,1},{2,2},{3,3},{4,4},");
    }

    /**
     * 함수형 인터페이스 사용
     */
    @Test
    public void test5() throws Exception{
        //given
        Supplier<Integer> supplier = ()->(int)((Math.random()*100)+1);
        Consumer<Integer> consumer = i->System.out.print(i + " ");
        Predicate<Integer> predicate = i->i%2==0;
        Function<Integer, Integer> function = i->i/10*10;
        List<Integer> list = new ArrayList<>();

        //when
        LambdaEx5.makeRandomList(supplier, list);
        System.out.println(list);

        LambdaEx5.printEvenNum(predicate, consumer, list);
        List<Integer> newList = LambdaEx5.doSomething(function, list);
        System.out.println(newList);

        //then
    }

    /**
     * 기본형을 사용한 함수형 인터페이스 사용
     */
    @Test
    public void test6() throws Exception{
        //given
        IntSupplier supplier = ()->(int)((Math.random()*100)+1);
        IntConsumer consumer = i->System.out.print(i + " ");
        IntPredicate predicate = i->i%2==0;
        IntUnaryOperator operator = i->i/10*10;
        int[] arr = new int[10];

        //when
        LambdaEx6.makeRandomList(supplier, arr);
        System.out.println(Arrays.toString(arr));

        LambdaEx6.printEvenNum(predicate, consumer, arr);
        int[] newArr = LambdaEx6.doSomething(operator, arr);
        System.out.println(Arrays.toString(newArr));

        //then
    }

    @Test
    public void predicate_conbine_test() throws Exception{
        //given
        Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);
        Function<Integer, String> g = (i) -> Integer.toBinaryString(i);
        Function<String, String> h = f.andThen(g);
        Function<Integer, Integer> h2 = f.compose(g);

        Function<String, String> f2 = x -> x; // 항등함수

        Predicate<Integer> p = i -> i < 100;
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> r = i -> i % 2 == 0;
        Predicate<Integer> notP = p.negate(); // i >= 100
        Predicate<Integer> all = notP.and(q.or(r));

        String str1 = "abc";
        String str2 = "abc";
        Predicate<String> p2 = Predicate.isEqual(str1);

        //when
        String  actual1 = h.apply("FF");   // "FF" -> 255 -> "11111111"
        Integer actual2 = h2.apply(2);     // 2 -> "10" -> 16
        String  actual3 = f2.apply("AAA"); // "AAA" -> "AAA"
        boolean actual4 = all.test(150);   // true
        boolean actual5 = p2.test(str2);     // true

        //then
        assertThat(actual1).isEqualTo("11111111");
        assertThat(actual2).isEqualTo(16);
        assertThat(actual3).isEqualTo("AAA");
        assertThat(actual4).isEqualTo(true);
        assertThat(actual5).isEqualTo(true);

    }

    @Test
    public void methodReference_test() throws Exception{
        //given
        Function<String, Integer> f1 = (String s) -> Integer.parseInt(s);
        Function<String, Integer> f2 = Integer::parseInt;

        BiFunction<String, String, Boolean> f3 = (s1, s2) -> s1.equals(s2);
        BiFunction<String, String, Boolean> f4 = String::equals;

        //이미 생성된 객체의 메서드를 람다식에서 사용하는 경우
        Person person = new Person();
        Function<String, Boolean> f5 = (x)->person.equals(x); // 람다식
        Function<String, Boolean> f6 = person::equals;        // 메서드 참조

        //when
        int actual1 = f2.apply("10");
        boolean actual2 = f4.apply("a", "a");
        boolean actual3 = f6.apply("a");

        //then
        assertThat(actual1).isEqualTo(10);
        assertThat(actual2).isTrue();
        assertThat(actual3).isFalse();
    }

    @Test
    public void constructorMethodReference() throws Exception{
        //given
        // 공백 생성자 메서드 참조
        Supplier<Person> s1 = () -> new Person();   // 람다식
        Supplier<Person> s2 = Person::new;          // 메서드 참조

        // 매개변수 있는 생성자의 메서드 참조
        BiFunction<String, Integer, Person> bf1 = (name, age) -> new Person(name, age); // 람다식
        BiFunction<String, Integer, Person> bf2 = Person::new;                          // 메서드 참조

        // 배열 생성
        Function<Integer, int[]> f1 = x -> new int[x]; // 람다식
        Function<Integer, int[]> f2 = int[]::new;      // 메서드 참조

        //when
        Person p1 = s1.get();
        Person p2 = s2.get();
        Person p3 = bf1.apply("김용환", 25);
        Person p4 = bf2.apply("김용환", 28);
        int[] array1 = f1.apply(5);
        int[] array2 = f1.apply(3);

        //then
        assertThat(p1).isNotNull();
        assertThat(p2).isNotNull();
        assertThat(p3.getName()).isEqualTo("김용환");
        assertThat(p4.getAge()).isEqualTo(28);
        assertThat(array1).isEqualTo(new int[]{0,0,0,0,0});
        assertThat(array2).isEqualTo(new int[]{0,0,0});
    }
}
