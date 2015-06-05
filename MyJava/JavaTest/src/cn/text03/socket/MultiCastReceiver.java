package cn.text03.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * 利用UDP实现IP多点传送
 * @author YR
 *
 */
public class MultiCastReceiver {
    private static final int DATAGRAM_BYTES = 1024;
    private int mulcastPort;
    private InetAddress mulcastIp;
    private MulticastSocket mulcastSocket;
    private boolean keepReceiving = true;
    
    public static void main(String[] args) {
	//发送者同一个IP和端口
	MultiCastReceiver cast = new MultiCastReceiver();
	try {
	    cast.reveiver("224.1.1.1", "12345");	//224.0.0.0-239.255.255.255
	} catch (IOException e) {			//每一个IP都可以作为一个多点传送组
	    e.printStackTrace();
	}
    }
    //开始接受消息
    public void reveiver(String ip,String port) throws IOException{
	DatagramPacket mulcastPacket; //用于接收udp数据包
	byte[] mulcastBuffer;
	InetAddress fromIp;	//发送方IP
	int fromPort;		//发送方的端口
	String mulcastMsg;
	//设置接受消息的socket
	mulcastIp = InetAddress.getByName(ip);
	mulcastPort = Integer.parseInt(port);
	mulcastSocket = new MulticastSocket(mulcastPort);
	//将IP加入socket转发组
	mulcastSocket.joinGroup(mulcastIp);
	while(keepReceiving){
	    //创建一个数据包
	    mulcastBuffer = new byte[DATAGRAM_BYTES];
	    mulcastPacket = new DatagramPacket(mulcastBuffer, mulcastBuffer.length);
	    //接收数据包
	    mulcastSocket.receive(mulcastPacket);
	    fromIp = mulcastPacket.getAddress();
	    fromPort = mulcastPacket.getPort();
	    mulcastMsg = new String(mulcastPacket.getData());
	    //打印输出接收到的消息
	    System.out.println("Received from "+fromIp+"on port "+fromPort+":"+mulcastMsg);
	}
	//退出socket转发组
	mulcastSocket.leaveGroup(mulcastIp);
	mulcastSocket.close();
    }
    	//停止接收消息
    public void stop(){
	if(keepReceiving){
	    keepReceiving = false;
	}
    }
}
