package cn.net.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * �����������������������ӿͻ���
 * 1������������ ָ���˿� ServerSocket(int port)
 * 2�����տͻ������ӡ�����ʽ
 * 3����������
 * @author YR
 *
 */
public class MutilServer {
    public static void main(String[] args) throws IOException {
	//1������������ ָ���˿� ServerSocket(int port)
	ServerSocket server = new ServerSocket(8888);
	while(true){
	// 2�����տͻ������ӡ�����ʽ
	Socket socket = server.accept();
	System.out.println("һ���ͻ��˽�������");
	//3����������
	String msg = "��ӭʹ��";
	//�����
	DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
	
	dos.writeUTF(msg);
	dos.flush();
	}
    }
}
