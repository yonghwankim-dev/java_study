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
            System.out.println(getTime() + "������ �غ�Ǿ����ϴ�.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while(true){
            System.out.println(getTime() + "�����û�� ��ٸ��ϴ�.");
            // ��û ���ð� 5�ʷ� ����, 5�ʵ��� ���ӿ�û�� ������ SocketTimeoutException �߻�
            try {
                serverSocket.setSoTimeout(5*1000);
            }catch (SocketException e) {
                System.out.println("������ �ð����� ���ӿ�û�� ��� ������ �����մϴ�.");
                System.exit(0);
            }
            // ���������� Ŭ���̾�Ʈ�� �����û�� �ö����� ������ ���߰� ��� ��ٸ���.
            // Ŭ���̾�Ʈ�� �����û�� ���� Ŭ���̾�Ʈ ���ϰ� ����� ���ο� ������ �����Ѵ�.
            try(Socket socket = serverSocket.accept()){
                System.out.println(getTime() + socket.getInetAddress() + "�κ��� ��û�� ���Խ��ϴ�.");
                System.out.println("getPort() : " + socket.getPort());
                System.out.println("getLocalPort() : " + socket.getLocalPort());

                // ������ ��� ��Ʈ���� ��´�.
                OutputStream out = socket.getOutputStream();
                try(DataOutputStream dos = new DataOutputStream(out)) {
                    // ���� ���Ͽ� �����͸� ������.
                    dos.writeUTF("[Notice] Test Message1 from Server");
                    System.out.println(getTime() + "�����͸� �����Ͽ����ϴ�.");
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
