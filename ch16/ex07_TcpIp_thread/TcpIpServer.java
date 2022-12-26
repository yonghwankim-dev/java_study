package ch16.ex07_TcpIp_thread;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TcpIpServer implements Runnable{
    ServerSocket serverSocket;
    Thread[] threads;

    public TcpIpServer(int num) {
        try{
            // ���� ������ �����Ͽ� 7777�� ��Ʈ�� ����(bind)��Ų��.
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime() + "������ �غ�Ǿ����ϴ�.");
            threads = new Thread[num];
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new TcpIpServer(5).start();
    }

    public void start(){
        for(int i = 0; i < threads.length; i++){
            threads[i] = new Thread(this);
            threads[i].start();
        }
    }

    @Override
    public void run() {
        while(true){
            System.out.println(getTime() + "�����û�� ��ٸ��ϴ�.");
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
