package ch14.ex01_lambda;

import org.junit.Test;

import java.util.*;
import java.util.function.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdaTest {
    static int execute(MyFunction f){ // �Ű������� Ÿ���� MyFunction�� �޼���
        return f.run();
    }

    static MyFunction getMyFunction(){ // ��ȯ Ÿ���� MyFunction�� �޼���
        MyFunction f = ()-> {return 3;};
        return f;
    }

    /**
     * �Լ��� �������̽� Ÿ���� �Ű������� ��ȯŸ��
     */
    @Test
    public void test1() throws Exception{
        //given
        MyFunction f1 = ()->{return 1;}; // ���ٽ����� MyFunction�� run()�� ����
        MyFunction f2 = new MyFunction() {
            @Override
            public int run() { // public�� �ݵ�� �ٿ�����
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
     * ���ٽ��� Ÿ�԰� ����ȯ
     * ���ٽ� Ÿ�� : "�ܺ�Ŭ�����̸�$$Lambda$��ȣ"
     */
    @Test
    public void test2() throws Exception{
        //given
        MyFunction2 f = ()->{}; // MyFunction2 f = (MyFunction2) (()->{});
        Object obj = (MyFunction2)(()->{}); // object Ÿ������ ����ȯ�� ������, (Object)(MyFunction2)(() -> {})
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

//        System.out.println(()=>{}); // ����, ���ٽ��� Object Ÿ������ ����ȯ �ȵ�
//        System.out.println((MyFunction2)(()->{}).toString()); // ����
    }

    /**
     * �ܺ� ������ �����ϴ� ���ٽ�
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
     * �÷��� �����ӟp�� �Լ��� �������̽� ���
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
     * �Լ��� �������̽� ���
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
     * �⺻���� ����� �Լ��� �������̽� ���
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

        Function<String, String> f2 = x -> x; // �׵��Լ�

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

        //�̹� ������ ��ü�� �޼��带 ���ٽĿ��� ����ϴ� ���
        Person person = new Person();
        Function<String, Boolean> f5 = (x)->person.equals(x); // ���ٽ�
        Function<String, Boolean> f6 = person::equals;        // �޼��� ����

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
        // ���� ������ �޼��� ����
        Supplier<Person> s1 = () -> new Person();   // ���ٽ�
        Supplier<Person> s2 = Person::new;          // �޼��� ����

        // �Ű����� �ִ� �������� �޼��� ����
        BiFunction<String, Integer, Person> bf1 = (name, age) -> new Person(name, age); // ���ٽ�
        BiFunction<String, Integer, Person> bf2 = Person::new;                          // �޼��� ����

        // �迭 ����
        Function<Integer, int[]> f1 = x -> new int[x]; // ���ٽ�
        Function<Integer, int[]> f2 = int[]::new;      // �޼��� ����

        //when
        Person p1 = s1.get();
        Person p2 = s2.get();
        Person p3 = bf1.apply("���ȯ", 25);
        Person p4 = bf2.apply("���ȯ", 28);
        int[] array1 = f1.apply(5);
        int[] array2 = f1.apply(3);

        //then
        assertThat(p1).isNotNull();
        assertThat(p2).isNotNull();
        assertThat(p3.getName()).isEqualTo("���ȯ");
        assertThat(p4.getAge()).isEqualTo(28);
        assertThat(array1).isEqualTo(new int[]{0,0,0,0,0});
        assertThat(array2).isEqualTo(new int[]{0,0,0});
    }
}
