package ch14.ex02_stream;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

// 이 테스트는 스트림의 최종연산에 관한 테스트들입니다
public class FinalOperatorTest {

    // 주어진 스트림의 요소에 대해 로직을 수행하는 테스트
    // void forEach(Consumer<? super T> consumer)
    // - conusmer 함수형 인터페이스의 특징은 매개변수가 있고 반환이 없음
    @Test
    public void forEach() {
        //given
        int[] scores = {10,20,30,40,50};
        //when
        Arrays.stream(scores).forEach(score -> System.out.print(score+" ")); // 10 20 30 40 50
        //then
    }

    // 스트림의 요소에 대해 지정된 조건에 모든 요소가 일치하는지 테스트
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

    // 스트림의 요소에 대해 지정된 조건에 일부 요소가 일치하는지 테스트
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

    // 스트림의 요소에 대해서 지정된 조건에 어떤 요소도 일치하지 않는지 테스트
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

    // 스트림의 요소중에서 조건에 일치하는 첫번째 것을 반환하는지 테스트
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

    // 스트림의 요소중에서 조건에 일치하는 것을 반환하는지 테스트
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

    // 주어진 스트림 요소에 대해 개수, 합계, 평균, 최고값, 최솟값을 구하는 테스트
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

    // 주어진 스트림의 요소를 줄여나가면서 연산을 수행하고 최종결과를 반환하는 테스트
    // Optional<T> reduce(BinaryOperator<T> accumulator)
    // T           reduce(T identity, BinaryOperator<T> accumulator)
    //  - identity : 초기값
    //  - 스트림의 요소가 하나도 없는 경우, 초기값이 반환되므로 반환타입이 Optional<T>가 아닌 T
    // U           reduce(U identity, BiFunction<U,T,U> accumulator, BinaryOperator<U> combiner)
    // - combiner  : 병렬 스트림에 의해 처리된 결과를 합칠때 사용하기 위해 사용되는것
    @Test
    public void reduce() throws Exception{
        //given
        int[] scores = {10,20,30,40,50};
        //when
        int count = Arrays.stream(scores).reduce(0, (a, b) -> a + 1);
        int sum   = Arrays.stream(scores).reduce(0, (a, b) -> a + b);

        // 초기값을 사용한 방법, 기본형 타입이 반환됨
        int max   = Arrays.stream(scores).reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
        int min   = Arrays.stream(scores).reduce(Integer.MAX_VALUE, (a, b) -> a > b ? b : a);

        // 초기값을 사용하지 않고 사용하는 방법, OptionalInt 타입이 반환됨 : 권장
        OptionalInt max2 = Arrays.stream(scores).reduce((a,b)-> a > b ? a : b);
        OptionalInt min2 = Arrays.stream(scores).reduce((a,b)-> a > b ? b : a);
        int max2Val = max2.getAsInt();
        int min2Val = min2.getAsInt();

        // Integer.max()를 이용한 방법
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
