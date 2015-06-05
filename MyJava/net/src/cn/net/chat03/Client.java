package cn.net.chat03;

import java.io.IOException;
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
	new Thread(new Send(client)).start();
	new Thread(new Receive(client)).start();
    }

}
