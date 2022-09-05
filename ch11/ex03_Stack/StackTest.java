package ch11.ex03_Stack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.*;

public class StackTest {
    @Test
    public void push() throws Exception{
        //given
        Stack<Integer> stack = new Stack<>();
        //when
        stack.push(1);
        stack.push(2);
        stack.push(3);

        //then
        assertThat(stack).isEqualTo(Arrays.asList(1,2,3));
    }

    @Test
    public void pop() throws Exception{
        //given
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        List<Integer> list = new ArrayList<>();
        //when
        list.add(stack.pop());
        list.add(stack.pop());
        list.add(stack.pop());
        //then
        assertThat(list).isEqualTo(Arrays.asList(3,2,1));
    }

    @Test
    public void peek() throws Exception{
        //given
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        //when
        int actual = stack.peek();
        //then
        assertThat(actual).isEqualTo(3);
    }
}
