package ch11.ex04_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// Queue를 이용한 유닉스의 history 명령어 유틸 클래스
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
        System.out.println("help 입력하면 도움말을 볼 수 있습니다.");
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
        System.out.println("입력오류입니다.");
    }
    private static void exit(){
        System.exit(0);
    }

    private static void help(){
        System.out.println(" help    - 도움말을 보여줍니다.");
        System.out.println(" q 또는 Q - 프로그램을 종료합니다.");
        System.out.println(" history - 최근에 입력한 명령어를 " + MAX_SIZE +"개를 보여줍니다.");
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

    // 큐의 최대크기를 넘으면 제일 처음 입력된 것을 삭제함
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
