package cn.net.chat;

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
	String str = dos.readUTF();
	//��������
	DataOutputStream bis = new DataOutputStream(client.getOutputStream());
	String msg = "����������>"+str;
	bis.writeUTF(msg);
	bis.flush();
    }
}
