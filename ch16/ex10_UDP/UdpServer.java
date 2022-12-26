package ch16.ex10_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UdpServer {
    public void start() throws IOException {
        DatagramSocket socket = new DatagramSocket(7777);
        DatagramPacket inPacket, outPacket;

        byte[] inMsg = new byte[10];
        byte[] outMsg;

        while(true){
            // �����͸� �����ϱ� ���� ��Ŷ�� �����Ѵ�.
            inPacket = new DatagramPacket(inMsg, inMsg.length);

            // ��Ŷ�� ���� �����͸� �����Ѵ�.
            socket.receive(inPacket);

            // ������ ��Ŷ���κ��� client�� IP�ּҿ� Port�� ��´�.
            InetAddress address = inPacket.getAddress();
            int port = inPacket.getPort();

            // ������ ���� �ð��� �ú��� ����([hh:mm:ss])�� ��ȯ�Ѵ�
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[hh:mm:ss]");
            String time = formatter.format(LocalDateTime.now());
            outMsg = time.getBytes();

            // ��Ŷ�� �����ؼ� client���� �����Ѵ�.
            outPacket = new DatagramPacket(outMsg, outMsg.length, address, port);
            socket.send(outPacket);
        }
    }
    public static void main(String[] args) throws IOException {
        new UdpServer().start();
    }
}
