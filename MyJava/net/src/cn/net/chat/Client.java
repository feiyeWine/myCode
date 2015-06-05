package cn.net.chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �����ͻ��ˣ���������+��������
 * 
 * @author YR
 *
 */
public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
	Socket client = new Socket("localhost",9999);
	//����̨��������
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//��������
    	DataOutputStream bis = new DataOutputStream(client.getOutputStream());
    	String msg = br.readLine();
    	bis.writeUTF(msg);
    	bis.flush();
	//��������
	DataInputStream dos = new DataInputStream(client.getInputStream());
	String str = dos.readUTF();
	System.out.println(str);
	
    }

}
