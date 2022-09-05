package ch11.ex03_Stack;

import java.util.Stack;

// �� �������� �ڷ�, ������ ����� ������ Ŭ����
class WebBrowserBackForward {
    private static Stack back = new Stack();
    private static Stack forward = new Stack();

    public static void printStatus(){
        System.out.println("back:" + back);
        System.out.println("forward:" + forward);
        System.out.println("����ȭ���� '" + back.peek() + "' �Դϴ�.");
        System.out.println();
    }

    public static void goURL(String url){
        back.push(url);
        if(!forward.empty()){
            forward.clear();
        }
    }

    public static void goForward(){
        if(!forward.empty()){
            back.push(forward.pop());
        }
    }

    public static void goBack(){
        if(!back.empty()){
            forward.push(back.pop());
        }
    }

}