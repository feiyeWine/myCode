package cn.net.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws IOException {
	//1�����������+�˿�
	DatagramSocket server = new DatagramSocket(8888);
	//2��׼����������
	byte[] container = new byte[1024];
	//3����װ�ɰ�
	DatagramPacket packet = new DatagramPacket(container,container.length);
	//4����������
	server.receive(packet);
	//5����������
	double data =convert(packet.getData());
	System.out.println(data);
	//6���ͷ�
	server.close();
    }
    public static double convert(byte[] num) throws IOException{
	DataInputStream dos = new DataInputStream(new ByteArrayInputStream(num));
	double data = dos.readDouble();
	dos.close();
	return data;
    }
 }

