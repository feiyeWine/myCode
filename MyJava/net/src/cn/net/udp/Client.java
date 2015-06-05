package cn.net.udp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Client {
    public static void main(String[] args) throws IOException {
	//1、创建客户端+端口
	DatagramSocket client = new DatagramSocket(6666);
	//2、准备数据
	double num = 18.13;
	byte[] data = convert(num);
	//3、打包（发送的地点及端口）
	DatagramPacket packet =new DatagramPacket(data, data.length,new InetSocketAddress("localHost",8888));
	//4、发送
	client.send(packet);
	//5、释放
	client.close();
	
    }
    public static byte[] convert(double num) throws IOException{
	byte[] data = null;
  	ByteArrayOutputStream bt = new ByteArrayOutputStream();
  	DataOutputStream dos = new DataOutputStream(bt);
  	dos.writeDouble(num);
  	dos.flush();
  	data = bt.toByteArray();
  	dos.close();
  	return data;
      }
}
