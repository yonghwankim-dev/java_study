package ch11.ex03_stack;

import java.util.EmptyStackException;
import java.util.Stack;

// 입력한 수식의 괄호가 올바른지를 체크하는 유틸클래스
class ExpValidCheck {
    private static final char OPEN = '(';
    private static final char CLOSE = ')';
    private static final Stack<String> stack = new Stack<>();

    public static boolean test(String expression){
        try{
            for(char ch : expression.toCharArray()){
                if(isOpen(ch)){
                    stack.push(ch+"");
                }else if(isClosed(ch)){
                    stack.pop();
                }
            }
        }catch (EmptyStackException e){
            System.out.println("괄호가 일치하지 않습니다.");
            return false;
        }

        return stack.isEmpty();
    }

    private static boolean isOpen(char ch){
        return ch == OPEN;
    }

    private static boolean isClosed(char ch){
        return ch == CLOSE;
    }
}
