package cn.text03.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 基于UDP的实现两台计算机之间的通信
 * 消息接受示例
 * @author YR
 *
 */
public class UDPServer {
    public static void main(String[] args) {
	try {
	    DatagramSocket ser = new DatagramSocket(10005);
	    byte[] rb = new byte[1024];
	    DatagramPacket pac = new DatagramPacket(rb,rb.length);
	    String rev = "";
	    int i = 0;
	    while(0==i){
		//没有数据，则循环
		try {
		    ser.receive(pac);
		    i = pac.getLength();
		    //接受数据
		    if(i>0){
			//指定接受到的数据的长度
			rev = new String(rb,0,pac.getLength());
			System.out.println(rev);
			i=0;
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	    }
	    
	} catch (SocketException e) {
	    e.printStackTrace();
	}
    }
}
