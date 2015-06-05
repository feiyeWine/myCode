package cn.text03.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * ����UDPʵ��IP��㴫��
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
	//������ͬһ��IP�Ͷ˿�
	MultiCastReceiver cast = new MultiCastReceiver();
	try {
	    cast.reveiver("224.1.1.1", "12345");	//224.0.0.0-239.255.255.255
	} catch (IOException e) {			//ÿһ��IP��������Ϊһ����㴫����
	    e.printStackTrace();
	}
    }
    //��ʼ������Ϣ
    public void reveiver(String ip,String port) throws IOException{
	DatagramPacket mulcastPacket; //���ڽ���udp���ݰ�
	byte[] mulcastBuffer;
	InetAddress fromIp;	//���ͷ�IP
	int fromPort;		//���ͷ��Ķ˿�
	String mulcastMsg;
	//���ý�����Ϣ��socket
	mulcastIp = InetAddress.getByName(ip);
	mulcastPort = Integer.parseInt(port);
	mulcastSocket = new MulticastSocket(mulcastPort);
	//��IP����socketת����
	mulcastSocket.joinGroup(mulcastIp);
	while(keepReceiving){
	    //����һ�����ݰ�
	    mulcastBuffer = new byte[DATAGRAM_BYTES];
	    mulcastPacket = new DatagramPacket(mulcastBuffer, mulcastBuffer.length);
	    //�������ݰ�
	    mulcastSocket.receive(mulcastPacket);
	    fromIp = mulcastPacket.getAddress();
	    fromPort = mulcastPacket.getPort();
	    mulcastMsg = new String(mulcastPacket.getData());
	    //��ӡ������յ�����Ϣ
	    System.out.println("Received from "+fromIp+"on port "+fromPort+":"+mulcastMsg);
	}
	//�˳�socketת����
	mulcastSocket.leaveGroup(mulcastIp);
	mulcastSocket.close();
    }
    	//ֹͣ������Ϣ
    public void stop(){
	if(keepReceiving){
	    keepReceiving = false;
	}
    }
}
