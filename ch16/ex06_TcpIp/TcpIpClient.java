package ch16.ex06_TcpIp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpIpClient {
    public static void main(String[] args) {
        String serverIp = "127.0.0.1";
        System.out.println("������ �������Դϴ�. ����IP : " + serverIp);

        // ������ �����Ͽ� ������ ��û�Ѵ�.
        // ������ �Է½�Ʈ���� ��´�.
        try(Socket socket = new Socket(serverIp, 7777);
            DataInputStream dis = new DataInputStream(socket.getInputStream())){
            // �������κ��� ���� �����͸� ����Ѵ�.
            System.out.println("�����κ��� ���� �޽��� : " + dis.readUTF());
            System.out.println("������ �����մϴ�.");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
