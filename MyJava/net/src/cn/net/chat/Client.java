package cn.net.chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 创建客户端：接收数据+发送数据
 * 
 * @author YR
 *
 */
public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
	Socket client = new Socket("localhost",9999);
	//控制台输入数据
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//发送数据
    	DataOutputStream bis = new DataOutputStream(client.getOutputStream());
    	String msg = br.readLine();
    	bis.writeUTF(msg);
    	bis.flush();
	//接收数据
	DataInputStream dos = new DataInputStream(client.getInputStream());
	String str = dos.readUTF();
	System.out.println(str);
	
    }

}
