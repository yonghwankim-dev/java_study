package ch14.ex02_stream;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class ConcatCollectorTest {
    @Test
    public void test() throws Exception{
        //given
        String[] strArr = {"aaa", "bbb", "ccc"};
        Stream<String> strStream = Stream.of(strArr);

        //when
        String result = strStream.collect(new ConcatCollector());
        //then
        assertThat(Arrays.toString(strArr)).isEqualTo("[aaa, bbb, ccc]");
        assertThat(result).isEqualTo("aaabbbccc");
    }
}