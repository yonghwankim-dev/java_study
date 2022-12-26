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
            // 데이터를 수신하기 위한 패킷을 생성한다.
            inPacket = new DatagramPacket(inMsg, inMsg.length);

            // 패킷을 통해 데이터를 수신한다.
            socket.receive(inPacket);

            // 수신한 패킷으로부터 client의 IP주소와 Port를 얻는다.
            InetAddress address = inPacket.getAddress();
            int port = inPacket.getPort();

            // 서버의 현재 시간을 시분초 형태([hh:mm:ss])로 반환한다
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[hh:mm:ss]");
            String time = formatter.format(LocalDateTime.now());
            outMsg = time.getBytes();

            // 패킷을 생성해서 client에게 전송한다.
            outPacket = new DatagramPacket(outMsg, outMsg.length, address, port);
            socket.send(outPacket);
        }
    }
    public static void main(String[] args) throws IOException {
        new UdpServer().start();
    }
}
