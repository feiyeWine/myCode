package cn.net.udp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Client {
    public static void main(String[] args) throws IOException {
	//1�������ͻ���+�˿�
	DatagramSocket client = new DatagramSocket(6666);
	//2��׼������
	double num = 18.13;
	byte[] data = convert(num);
	//3����������͵ĵص㼰�˿ڣ�
	DatagramPacket packet =new DatagramPacket(data, data.length,new InetSocketAddress("localHost",8888));
	//4������
	client.send(packet);
	//5���ͷ�
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
