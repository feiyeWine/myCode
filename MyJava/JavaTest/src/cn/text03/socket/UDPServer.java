package cn.text03.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * ����UDP��ʵ����̨�����֮���ͨ��
 * ��Ϣ����ʾ��
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
		//û�����ݣ���ѭ��
		try {
		    ser.receive(pac);
		    i = pac.getLength();
		    //��������
		    if(i>0){
			//ָ�����ܵ������ݵĳ���
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
