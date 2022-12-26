package ch16.ex09_TcpIp_multiChatServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class TcpIpMultiChatServer {
    private HashMap clients;

    public TcpIpMultiChatServer() {
        this.clients = new HashMap();
        Collections.synchronizedMap(clients);
    }

    public void start(){
        ServerSocket serverSocket = null;
        Socket socket = null;

        try{
            serverSocket = new ServerSocket(7777);
            System.out.println("서버가 시작되었습니다.");

            while(true){
                socket = serverSocket.accept();
                System.out.printf("[%s:%d]에서 접속하였습니다.\n", socket.getInetAddress(), socket.getPort());
                ServerReceiver thread = new ServerReceiver(socket);
                thread.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendToAll(String msg){
        Iterator itor = clients.keySet().iterator();

        while(itor.hasNext()){
            try {
                DataOutputStream out = (DataOutputStream) clients.get(itor.next());
                out.writeUTF(msg);
            } catch (IOException e) {
            }
        }
    }

    public static void main(String[] args) {
        new TcpIpMultiChatServer().start();
    }

    class ServerReceiver extends Thread{
        private Socket socket;
        private DataInputStream in;
        private DataOutputStream out;

        public ServerReceiver(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void run() {
            String name = "";
            try {
                name = in.readUTF();
                sendToAll(String.format("#%s님이 들어오셨습니다.", name));

                clients.put(name, out);
                System.out.printf("현재 서버 접속자 수는 %d입니다.\n", clients.size());

                while(in != null){
                    sendToAll(in.readUTF());
                }
            } catch (IOException e) {

            }finally{
                sendToAll(String.format("#%s님이 나가셨습니다.", name));
                clients.remove(name);
                System.out.printf("[%s:%d]에서 접속을 종료하였습니다.\n", socket.getInetAddress(), socket.getPort());
                System.out.printf("현재 서버 접속자 수는 %d입니다.\n", clients.size());
            }
        }
    }
}
