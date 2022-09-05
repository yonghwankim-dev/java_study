package ch11.ex04_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// Queue�� �̿��� ���н��� history ��ɾ� ��ƿ Ŭ����
class History {
    private enum Command{Q, EXIT, HELP, HISTORY}
    private static final Queue<String> q = new LinkedList<>();
    private static final int MAX_SIZE = 5;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void start(){
        showIntroduceHelpMessage();

        while(true){
            showInputArrow();

            String input = input();

            if(isBlank(input)){
                continue;
            }

            if(isExit(input)){
                exit();
            }else if(isHelp(input)){
                help();
            }else if(isHistory(input)){
                history(input);
            }else{
                save(input);
            }
        }
    }

    private static void showIntroduceHelpMessage(){
        System.out.println("help �Է��ϸ� ������ �� �� �ֽ��ϴ�.");
    }

    private static void showInputArrow(){
        System.out.print(">>");
    }

    private static String input(){
        String result = "";
        try{
            result = br.readLine();
        }catch (IOException e) {
            showInputErrorMessage();
        }
        return result;
    }

    private static boolean isBlank(String text){
        return "".equals(text) || text == null;
    }

    private static boolean isExit(String text){
        return text.equalsIgnoreCase(Command.Q.name());
    }

    private static boolean isHelp(String text){
        return text.equalsIgnoreCase(Command.HELP.name());
    }

    private static boolean isHistory(String text){
        return text.equalsIgnoreCase(Command.HISTORY.name());
    }

    private static void showInputErrorMessage(){
        System.out.println("�Է¿����Դϴ�.");
    }
    private static void exit(){
        System.exit(0);
    }

    private static void help(){
        System.out.println(" help    - ������ �����ݴϴ�.");
        System.out.println(" q �Ǵ� Q - ���α׷��� �����մϴ�.");
        System.out.println(" history - �ֱٿ� �Է��� ��ɾ " + MAX_SIZE +"���� �����ݴϴ�.");
    }

    private static void history(String input){
        save(input);
        printHistory();
    }

    private static void save(String input){
        offer(input);

        if(isOverQueueSize()){
            q.remove();
        }
    }

    private static void offer(String input){
        if(!"".equals(input)){
            q.offer(input);
        }
    }

    // ť�� �ִ�ũ�⸦ ������ ���� ó�� �Էµ� ���� ������
    private static boolean isOverQueueSize(){
        return q.size() > MAX_SIZE;
    }

    private static void printHistory(){
        int i = 1;
        for(String s : q){
            System.out.println(i + "." + s);
            i++;
        }
    }

    public static void main(String[] args){
        History.start();
    }
}
