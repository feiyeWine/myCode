package cn.net.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 1�������ͻ��� ָ��������+�˿� ��ʱ��������
 * 2����������+��������
 * 
 * @author YR
 *
 */
public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
	//�����ͻ��� ����ָ��������+�˿� ��ʱ��������
	Socket client = new Socket("localhost",8888);
	//2����������
	/*BufferedReader br = new BufferedReader(new 
		InputStreamReader(client.getInputStream()));
	String echo = br.readLine();//����ʽ����
	System.out.println(echo);*/
	DataInputStream dis = new DataInputStream(client.getInputStream());
	String echo = dis.readUTF();
	System.out.println(echo);
    }
}
