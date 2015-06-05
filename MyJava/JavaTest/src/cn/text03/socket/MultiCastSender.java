package cn.text03.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * udp��㷢��
 * @author YR
 *
 */
public class MultiCastSender {
    private static final byte TTL=1;	//ͨ����������ͬ�����緢��
    private static final int DATAGRAM_BYTES = 1024;
    private int mulcastPort;
    private InetAddress mulcastIp;
    private BufferedReader input;
    private MulticastSocket mulcastSocket;
    
    public static void main(String[] args){
	//���պͷ��͵�ַ����һ��
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
	String nextLine;	//��ȡ����������ַ���
	byte[] mulcastBuffer;
	byte[] lineData;	//��ż������������
	int sendLength;
	//��ȡ������Ϣ
	input = new BufferedReader(new InputStreamReader(System.in));
	//����multicastSocket���㲥����
	mulcastIp = InetAddress.getByName(ip);
	mulcastPort = Integer.parseInt(port);
	mulcastSocket = new MulticastSocket();
	//ѭ����ȡ�������ݣ�����㲥
	while(null!=(nextLine=input.readLine())){
	    mulcastBuffer = new byte[DATAGRAM_BYTES];
	    //�����ȡ������Ϣ���ȴ��ڻ������������ʹ�С����Ϊ���ݰ����ֽڴ�С
	    if(nextLine.length()>mulcastBuffer.length){
		sendLength = mulcastBuffer.length;
		//�������ü�����Ϣ�Ĵ�С
	    }else{
		sendLength = nextLine.length();
	    }
	    lineData = nextLine.getBytes();
	    //���ֽ����鸴�Ƶ����ݰ���
	    for(int i = 0;i<sendLength;i++){
		mulcastBuffer[i] = lineData[i];
	    }
	    //�������ݰ�
	    mulcastPacket = new DatagramPacket(mulcastBuffer, mulcastBuffer.length,mulcastIp,mulcastPort);
	    //�������ݰ�
	    mulcastSocket.send(mulcastPacket,TTL);
	}
	mulcastSocket.close();
	
    }
}
