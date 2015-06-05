package cn.text03.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * udp多点发送
 * @author YR
 *
 */
public class MultiCastSender {
    private static final byte TTL=1;	//通过多少条不同的网络发送
    private static final int DATAGRAM_BYTES = 1024;
    private int mulcastPort;
    private InetAddress mulcastIp;
    private BufferedReader input;
    private MulticastSocket mulcastSocket;
    
    public static void main(String[] args){
	//接收和发送地址必须一致
	MultiCastSender cast = new MultiCastSender();
	try {
	    cast.Sender("224.1.1.1", "12345");
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    @SuppressWarnings("deprecation")
    public void Sender(String ip, String port) throws Exception{
	DatagramPacket mulcastPacket;
	String nextLine;	//读取键盘输入的字符串
	byte[] mulcastBuffer;
	byte[] lineData;	//存放键盘输入的内容
	int sendLength;
	//读取键盘信息
	input = new BufferedReader(new InputStreamReader(System.in));
	//创建multicastSocket多点广播对象
	mulcastIp = InetAddress.getByName(ip);
	mulcastPort = Integer.parseInt(port);
	mulcastSocket = new MulticastSocket();
	//循环读取键盘内容，想多点广播
	while(null!=(nextLine=input.readLine())){
	    mulcastBuffer = new byte[DATAGRAM_BYTES];
	    //如果读取键盘信息长度大于缓冲区，将发送大小设置为数据包的字节大小
	    if(nextLine.length()>mulcastBuffer.length){
		sendLength = mulcastBuffer.length;
		//否则，设置键盘信息的大小
	    }else{
		sendLength = nextLine.length();
	    }
	    lineData = nextLine.getBytes();
	    //将字节数组复制到数据包中
	    for(int i = 0;i<sendLength;i++){
		mulcastBuffer[i] = lineData[i];
	    }
	    //创建数据包
	    mulcastPacket = new DatagramPacket(mulcastBuffer, mulcastBuffer.length,mulcastIp,mulcastPort);
	    //发送数据包
	    mulcastSocket.send(mulcastPacket,TTL);
	}
	mulcastSocket.close();
	
    }
}
