package ch11.ex03_stack;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ExpValidCheckTest {

    @Test
    public void test1() throws Exception{
        //given
        String text = "((2+3)*1)+3";
        //when
        boolean actual = ExpValidCheck.test(text);
        //then
        Assertions.assertThat(actual).isTrue();
    }

    @Test
    public void test2() throws Exception{
        //given
        String text = "((2+3*1+3";
        //when
        boolean actual = ExpValidCheck.test(text);
        //then
        Assertions.assertThat(actual).isFalse();
    }
}