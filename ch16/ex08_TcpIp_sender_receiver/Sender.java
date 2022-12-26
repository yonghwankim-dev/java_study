package ch16.ex08_TcpIp_sender_receiver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Sender extends Thread{
    private Socket socket;
    private DataOutputStream out;
    private String name;

    public Sender(Socket socket) {
        this.socket = socket;
        try {
            out = new DataOutputStream(socket.getOutputStream());
            name = String.format("[%s:%d]",socket.getInetAddress(), socket.getPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(out != null){
            try {
                out.writeUTF(name + br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
