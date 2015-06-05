package cn.net.chat04;

import java.io.BufferedReader;
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
	System.out.println("请输入名称：");
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	String name=br.readLine();
	if(name.equals("")){
	    return;
	}
	
	Socket client = new Socket("localhost",9999);
	//控制台输入数据
	new Thread(new Send(client,name)).start();
	new Thread(new Receive(client)).start();
    }

}
