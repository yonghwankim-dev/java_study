package ch16.ex09_TcpIp_multiChatServer;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpIpMultiChatClient {
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("USAGE: java TcpIpMultChatClient 대화명");
            System.exit(0);
        }

        try{
            String serverIp = "127.0.0.1";
            // 소켓 생성하여 연결을 요청
            Socket socket = new Socket(serverIp, 7777);
            System.out.println("서버에 연결되었습니다.");
            Thread sender = new Thread(new ClientSender(socket, args[0]));
            Thread receiver = new Thread(new ClientReceiver(socket));

            sender.start();
            receiver.start();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static class ClientSender extends Thread{
        private Socket socket;
        private DataOutputStream out;
        private String name;

        ClientSender(Socket socket, String name){
            this.socket = socket;
            try {
                out = new DataOutputStream(socket.getOutputStream());
                this.name = name;
            } catch (IOException e) {
            }
        }

        @Override
        public void run() {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try{
                if(out != null){
                    out.writeUTF(name);
                }
                while(out != null){
                    out.writeUTF(String.format("[%s] : %s",name, br.readLine()));
                }
            } catch (IOException e) {}
        }
    }

    static class ClientReceiver extends Thread{
        private Socket socket;
        private DataInputStream in;

        ClientReceiver(Socket socket){
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
            } catch (IOException e) {}
        }

        @Override
        public void run() {
            while(in != null){
                try {
                    System.out.println(in.readUTF());
                } catch (IOException e) {}
            }
        }
    }
}
