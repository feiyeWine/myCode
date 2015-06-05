package cn.net.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器
 * @author YR
 *
 */
public class Server {
    public static void main(String[] args) throws IOException {
	ServerSocket server = new ServerSocket(9999);
	Socket client = server.accept();
	//接收数据
	DataInputStream dos = new DataInputStream(client.getInputStream());
	String str = dos.readUTF();
	//发送数据
	DataOutputStream bis = new DataOutputStream(client.getOutputStream());
	String msg = "服务器——>"+str;
	bis.writeUTF(msg);
	bis.flush();
    }
}
