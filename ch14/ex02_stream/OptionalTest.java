package ch14.ex02_stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class OptionalTest {
    @Test
    public void Optional_of_ofNullable() {
        //given
        String str = "abc";
        //when
        Optional<String> optVal1 = Optional.of(str);
//        Optional<String> optVal2 = Optional.of(null); // of 메서드는 NullPointerException 발생할 수 있음
        Optional<String> optVal3 = Optional.ofNullable(null); // ofNullable 메서드는 NullPointerException 발생 방지 (권장)
    }


    @Test
    public void Optional_get_orElse_orElseGet() {
        //given
        Optional<String> optVal1 = Optional.of("abc");
        Optional<String> optVal2 = Optional.ofNullable(null);
        Optional<String> optVal3 = Optional.ofNullable(null);

        //when
        String str1 = optVal1.get();            // optVal1에 저장된 값을 반환, null이면 예외 발생
        String str2 = optVal2.orElse(getDefaultName()); // orElse : 저장된 값이 null이든 아니든 getDefaultName 호출
        String str3 = optVal3.orElseGet(()->getDefaultName()); // orElseGet : 저장된 값이 null일때만 supplier 호출
        //then
        assertThat(str1).isEqualTo("abc");
        assertThat(str2).isEqualTo("no name");
        assertThat(str3).isEqualTo("no name");
    }

    /**
     * orElse와 orElseGet의 차이
     * 1. orElse는 값(String)을 인수로 받음. orElseGet은 Supplier를 인수로 받음
     * 2. orElse는 값을 설정하기 위해서 getDefaultName을 optVal값이 null이든 아니든 무조건 호출해아함
     * orElseGet은 optVal의 값이 null인 경우에만 Supplier를 통해서 getDefaultName을 호출함
     *
     * 수행결과
     * optVal1의 값이 "abc"인데도 불구하고 getDefaultName 메서드를 호출하게됨
     * 반면 optVal2의 값도 "abc"인데도 불구하고 Supplier로 설정되어 있기 때문에 getDefaultName이 호출하지 않게됨
     */
    @Test
    public void Optional_orElse_orElseGet_DIFF() {
        //given
        Optional<String> optVal1 = Optional.ofNullable("abc");
        Optional<String> optVal2 = Optional.ofNullable("abc");

        //when
        String str1 = optVal1.orElse(getDefaultName());
        String str2 = optVal2.orElseGet(()->getDefaultName());

        //then
        assertThat(str1).isEqualTo("abc");
        assertThat(str2).isEqualTo("abc");
    }

    private static String getDefaultName(){
        System.out.println("call getDefaultName");
        return "no name";
    }

    @Test(expected = NullPointerException.class)
    public void Optional_orElseThrow() {
        //given
        Optional<String> optVal1 = Optional.ofNullable(null);

        //when
        String str1 = optVal1.orElseThrow(NullPointerException::new);

        //then
        fail("NullPointerException이 발생해야 합니다.");
    }

    @Test
    public void Optional_filter_map() {
        //given
        String s1 = "123";
        String s2 = "";
        //when
        int actual1 = getInteger(s1);
        int actual2 = getInteger(s2);
        //then
        assertThat(actual1).isEqualTo(123);
        assertThat(actual2).isEqualTo(-1);
    }

    // 문자열의 길이가 0보다 크면 정수로 변환하여 반환, 0보다 같거나 작으면 -1 반환
    private static int getInteger(String s){
        return Optional.of(s)
                .filter(x -> x.length() > 0)
                .map(Integer::parseInt)
                .orElse(-1);
    }

    @Test
    public void Optional_flatMap() {
        //given
        Optional<String> opt1 = Optional.of("STRING");
        Optional<Optional<String>> opt2 = Optional.of(Optional.of("STRING"));

        //when
        Optional<String> actual1 = Optional.of("STRING").flatMap(s -> Optional.of("STRING"));
        Optional<Optional<String>> actual2 = Optional.of("STRING").map(s->Optional.of("STRING"));

        //then
        assertThat(actual1).isEqualTo(opt1);
        assertThat(actual2).isEqualTo(opt2);
    }

    @Test
    public void Optional_try_catch() {
        //given
        String s1 = "";
        String s2 = "2";
        Optional<String> opt1 = Optional.of(s1);
        Optional<String> opt2 = Optional.of(s2);
        //when
        int actual1 = optStrToInt(opt1, 1);
        int actual2 = optStrToInt(opt2, 1);
        //then
        assertThat(actual1).isEqualTo(1);
        assertThat(actual2).isEqualTo(2);
    }

    private static int optStrToInt(Optional<String> optStr, int defaultValue){
        try {
            return optStr.map(Integer::parseInt).get();
        }catch(NumberFormatException e){
            return defaultValue;
        }
    }

    @Test
    public void Optional_isPresent() {
        //given
        String s = "abc";
        Optional<String> opt1 = Optional.ofNullable(s);
        String actual1 = null;
        //when
        if(opt1.isPresent()){
            actual1 = opt1.get();
        }
        //then
        assertThat(actual1).isEqualTo("abc");
    }

    @Test
    public void Optional_ifPresent() {
        //given
        String s = "abc";
        Optional<String> opt1 = Optional.ofNullable(s);
        //when
        opt1.ifPresent(System.out::println);
        //then
    }

    @Test
    public void Optional_ifPresent_findAny_findFirst_max_min_reduce() throws Exception{
        //given
        String[] names = {"tom", "bob", "bread", "bread"};
        int[] scores = {20, 60, 70, 80};
        //when
        Arrays.stream(names)
                .filter(name->name.equals("bread"))
                .findAny()
                .ifPresent(System.out::println);

        Arrays.stream(names)
                .filter(name->name.equals("bread"))
                .findFirst()
                .ifPresent(System.out::println);

        Arrays.stream(scores)
                .filter(score -> score > 40)
                .max()
                .ifPresent(System.out::println);

        Arrays.stream(scores)
                .filter(score -> score > 40)
                .min()
                .ifPresent(System.out::println);

        Arrays.stream(scores)
                .filter(score -> score > 40)
                .reduce((a,b)->a+b)
                .ifPresent(System.out::println);
        //then
    }

    @Test
    public void OptionalInt() throws Exception{
        //given

        //when
        OptionalInt opt1 = OptionalInt.of(0);
        OptionalInt opt2 = OptionalInt.empty();

        //then
        assertThat(opt1.isPresent()).isTrue();
        assertThat(opt2.isPresent()).isFalse();

        assertThat(opt1.getAsInt()).isEqualTo(0);
//        opt2.getAsInt(); // NoSuchElementException 예외 발생
        assertThat(opt1.equals(opt2)).isFalse();
    }
}
