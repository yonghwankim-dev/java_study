package ch14.ex02_stream;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

// �� �׽�Ʈ�� ��Ʈ���� �������꿡 ���� �׽�Ʈ���Դϴ�
public class FinalOperatorTest {

    // �־��� ��Ʈ���� ��ҿ� ���� ������ �����ϴ� �׽�Ʈ
    // void forEach(Consumer<? super T> consumer)
    // - conusmer �Լ��� �������̽��� Ư¡�� �Ű������� �ְ� ��ȯ�� ����
    @Test
    public void forEach() {
        //given
        int[] scores = {10,20,30,40,50};
        //when
        Arrays.stream(scores).forEach(score -> System.out.print(score+" ")); // 10 20 30 40 50
        //then
    }

    // ��Ʈ���� ��ҿ� ���� ������ ���ǿ� ��� ��Ұ� ��ġ�ϴ��� �׽�Ʈ
    // boolean allMatch(Predicate<? super T> predicate)
    @Test
    public void allMatch() {
        //given
        int[] scores = {10,20,30,40,50};
        //when
        boolean actual = Arrays.stream(scores).allMatch((score)->score > 5); // allMatch(Predicate)
        //then
        assertThat(actual).isTrue();
    }

    // ��Ʈ���� ��ҿ� ���� ������ ���ǿ� �Ϻ� ��Ұ� ��ġ�ϴ��� �׽�Ʈ
    // boolean anyMatch(Predicate<? super T> predicate)
    @Test
    public void anyMath() {
        //given
        int[] scores = {10,20,30,40,50};
        //when
        boolean actual = Arrays.stream(scores).anyMatch((score)->score>45);
        //then
        assertThat(actual).isTrue();
    }

    // ��Ʈ���� ��ҿ� ���ؼ� ������ ���ǿ� � ��ҵ� ��ġ���� �ʴ��� �׽�Ʈ
    // boolean noneMatch(Predicate<? super T> predicate)
    @Test
    public void noneMatch() {
        //given
        int[] scores = {10,20,30,40,50};
        //when
        boolean actual = Arrays.stream(scores).noneMatch((score)->score < 5);
        //then
        assertThat(actual).isTrue();
    }

    // ��Ʈ���� ����߿��� ���ǿ� ��ġ�ϴ� ù��° ���� ��ȯ�ϴ��� �׽�Ʈ
    // Stream<T> filter(Predicate<? super T> predicate)
    // Optional<T> findFirst()
    @Test
    public void findFirst() throws Exception{
        //given
        int[] scores = {10,20,30,40,50};
        //when
        int actual = Arrays.stream(scores).filter(score->score>=30).findFirst().getAsInt();
        //then
        assertThat(actual).isEqualTo(30);
    }

    // ��Ʈ���� ����߿��� ���ǿ� ��ġ�ϴ� ���� ��ȯ�ϴ��� �׽�Ʈ
    // Optional<T> findAny()
    @Test
    public void findAny() throws Exception{
        //given
        int[] scores = {10,20,30,40,50};
        //when
        int actual = Arrays.stream(scores).parallel().filter(score->score>=30).findAny().getAsInt();
        //then
        assertThat(actual).isEqualTo(30);
    }

    // �־��� ��Ʈ�� ��ҿ� ���� ����, �հ�, ���, �ְ�, �ּڰ��� ���ϴ� �׽�Ʈ
    // long count()
    // long sum()
    // Optional<T> average()
    // Optional<T> max(Comparator<? super T> comparator)
    // Optional<T> min(Comparator<? super T> comparator)
    @Test
    public void count_sum_average_max_min() throws Exception{
        //given
        int[] scores = {10,20,30,40,50};

        //when
        long actual1   = Arrays.stream(scores).count();
        long actual2   = Arrays.stream(scores).sum();
        double actual3 = Arrays.stream(scores).average().getAsDouble();
        long actual4   = Arrays.stream(scores).max().getAsInt();
        long actual5   = Arrays.stream(scores).min().getAsInt();

        //then
        assertThat(actual1).isEqualTo(5);
        assertThat(actual2).isEqualTo(150);
        assertThat(actual3).isEqualTo(30.0);
        assertThat(actual4).isEqualTo(50);
        assertThat(actual5).isEqualTo(10);
    }

    // �־��� ��Ʈ���� ��Ҹ� �ٿ������鼭 ������ �����ϰ� ��������� ��ȯ�ϴ� �׽�Ʈ
    // Optional<T> reduce(BinaryOperator<T> accumulator)
    // T           reduce(T identity, BinaryOperator<T> accumulator)
    //  - identity : �ʱⰪ
    //  - ��Ʈ���� ��Ұ� �ϳ��� ���� ���, �ʱⰪ�� ��ȯ�ǹǷ� ��ȯŸ���� Optional<T>�� �ƴ� T
    // U           reduce(U identity, BiFunction<U,T,U> accumulator, BinaryOperator<U> combiner)
    // - combiner  : ���� ��Ʈ���� ���� ó���� ����� ��ĥ�� ����ϱ� ���� ���Ǵ°�
    @Test
    public void reduce() throws Exception{
        //given
        int[] scores = {10,20,30,40,50};
        //when
        int count = Arrays.stream(scores).reduce(0, (a, b) -> a + 1);
        int sum   = Arrays.stream(scores).reduce(0, (a, b) -> a + b);

        // �ʱⰪ�� ����� ���, �⺻�� Ÿ���� ��ȯ��
        int max   = Arrays.stream(scores).reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
        int min   = Arrays.stream(scores).reduce(Integer.MAX_VALUE, (a, b) -> a > b ? b : a);

        // �ʱⰪ�� ������� �ʰ� ����ϴ� ���, OptionalInt Ÿ���� ��ȯ�� : ����
        OptionalInt max2 = Arrays.stream(scores).reduce((a,b)-> a > b ? a : b);
        OptionalInt min2 = Arrays.stream(scores).reduce((a,b)-> a > b ? b : a);
        int max2Val = max2.getAsInt();
        int min2Val = min2.getAsInt();

        // Integer.max()�� �̿��� ���
        OptionalInt max3 = Arrays.stream(scores).reduce(Integer::max);
        OptionalInt min3 = Arrays.stream(scores).reduce(Integer::min);
        int max3Val = max3.getAsInt();
        int min3Val = min3.getAsInt();

        //then
        assertThat(count).isEqualTo(5);
        assertThat(sum).isEqualTo(150);
        assertThat(max).isEqualTo(50);
        assertThat(min).isEqualTo(10);
        assertThat(max2Val).isEqualTo(50);
        assertThat(min2Val).isEqualTo(10);
        assertThat(max3Val).isEqualTo(50);
        assertThat(min3Val).isEqualTo(10);
    }
}
