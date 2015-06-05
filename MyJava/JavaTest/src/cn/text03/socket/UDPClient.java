package cn.text03.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 消息发送示例
 * @author YR
 *
 */
public class UDPClient {
    public static void main(String[] args) {
	try {
	    DatagramSocket client = new DatagramSocket(10002);
	    byte[] sb = new byte[1024];
	    String str = "UDP方式发送数据";
	    sb = str.getBytes();
	    try {
		DatagramPacket pac = new DatagramPacket(sb, sb.length,InetAddress.getByName("localhost"),10005);
		try {
		    client.send(pac);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    } catch (UnknownHostException e) {
		e.printStackTrace();
	    }
	    
	} catch (SocketException e) {
	    e.printStackTrace();
	}
    }
}
