package ch11.ex03_stack;

import java.util.EmptyStackException;
import java.util.Stack;

// �Է��� ������ ��ȣ�� �ùٸ����� üũ�ϴ� ��ƿŬ����
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
            System.out.println("��ȣ�� ��ġ���� �ʽ��ϴ�.");
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
