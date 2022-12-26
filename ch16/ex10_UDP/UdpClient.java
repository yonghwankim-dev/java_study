package ch16.ex10_UDP;

import java.io.IOException;
import java.net.*;

public class UdpClient {
    public void start() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("127.0.0.1");

        // �����Ͱ� ����� �������� byte�迭�� �����Ѵ�.
        byte[] msg = new byte[10];

        DatagramPacket outPacket = new DatagramPacket(msg, 1, serverAddress, 7777);
        DatagramPacket inPacket = new DatagramPacket(msg, msg.length);

        datagramSocket.send(outPacket);
        datagramSocket.receive(inPacket);

        System.out.println("current server time " + new String(inPacket.getData()));
        datagramSocket.close();
    }

    public static void main(String[] args) throws IOException {
        new UdpClient().start();
    }
}
