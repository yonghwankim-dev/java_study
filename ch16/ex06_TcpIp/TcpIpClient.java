package ch16.ex06_TcpIp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpIpClient {
    public static void main(String[] args) {
        String serverIp = "127.0.0.1";
        System.out.println("서버에 연결중입니다. 서버IP : " + serverIp);

        // 소켓을 연결하여 연결을 요청한다.
        // 소켓의 입력스트림을 얻는다.
        try(Socket socket = new Socket(serverIp, 7777);
            DataInputStream dis = new DataInputStream(socket.getInputStream())){
            // 소켓으로부터 받은 데이터를 출력한다.
            System.out.println("서버로부터 받은 메시지 : " + dis.readUTF());
            System.out.println("연결을 종료합니다.");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
