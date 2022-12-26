package ch16.ex06_TcpIp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TcpIpServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime() + "서버가 준비되었습니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while(true){
            System.out.println(getTime() + "연결요청을 기다립니다.");
            // 요청 대기시간 5초로 설정, 5초동안 접속요청이 없으면 SocketTimeoutException 발생
            try {
                serverSocket.setSoTimeout(5*1000);
            }catch (SocketException e) {
                System.out.println("지정된 시간동안 접속요청이 없어서 서버를 종료합니다.");
                System.exit(0);
            }
            // 서버소켓은 클라이언트의 연결요청이 올때까지 실행을 멈추고 계속 기다린다.
            // 클라이언트의 연결요청이 오면 클라이언트 소켓과 통신할 새로운 소켓을 생성한다.
            try(Socket socket = serverSocket.accept()){
                System.out.println(getTime() + socket.getInetAddress() + "로부터 요청이 들어왔습니다.");
                System.out.println("getPort() : " + socket.getPort());
                System.out.println("getLocalPort() : " + socket.getLocalPort());

                // 소켓의 출력 스트림을 얻는다.
                OutputStream out = socket.getOutputStream();
                try(DataOutputStream dos = new DataOutputStream(out)) {
                    // 원격 소켓에 데이터를 보낸다.
                    dos.writeUTF("[Notice] Test Message1 from Server");
                    System.out.println(getTime() + "데이터를 전송하였습니다.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getTime(){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("[hh:mm:ss]");
        return LocalDateTime.now().format(df);
    }
}
