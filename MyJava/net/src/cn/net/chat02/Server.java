package cn.net.chat02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����������
 * @author YR
 *
 */
public class Server {
    public static void main(String[] args) throws IOException {
	ServerSocket server = new ServerSocket(9999);
	Socket client = server.accept();
	//��������
	DataInputStream dos = new DataInputStream(client.getInputStream());
	DataOutputStream bis = new DataOutputStream(client.getOutputStream());
	while(true){
	String str = dos.readUTF();
	//��������
	String msg = "����������>"+str;
	bis.writeUTF(msg);
	bis.flush();
	}
    }
}
