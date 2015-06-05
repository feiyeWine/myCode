package cn.text03.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/**
 * ����ϵͳ�����
 * @author YR
 *
 */
public class ChatServer {
    private Vector<Socket> vect = new Vector<Socket>();
    
    public static void main(String[] args) {
	ChatServer server = new ChatServer();
	try {
	    server.startServer(8888);
	} catch (IOException e) {
	    System.out.println("����������ʧ��");
	    e.printStackTrace();
	}
	
    }
    //��������������ѭ�������ͻ��˵�����
    public void startServer(int port) throws IOException{
	ServerSocket ss = new ServerSocket(port);
	System.out.println("�����������������ȴ��ͻ�������");
	
	while(true){
	    Socket s = ss.accept();
	    vect.add(s);
	    System.out.println("�ͻ������ӳɹ�"+s);
	    
	    new MySocketOpt(s).start();
	}
    }
    //����һ���̣߳��ṩ���ܺ�ת������
    class MySocketOpt extends Thread{
	private Socket s;
	public MySocketOpt(Socket s){
	    this.s = s;
	}
	public void run(){
	    try {
		DataInputStream dis = new DataInputStream(new BufferedInputStream(s.getInputStream()));
		while(true){
			String msg = dis.readUTF();
			System.out.println("�������˽��ܵ���"+msg);
			//���������е�Socket���ӣ�����ת����Ϣ
			for(Socket tmp_s:vect){
			    if(tmp_s!=s){
				DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(tmp_s.getOutputStream()));
				dos.writeUTF(msg);
				dos.flush();
			    }
			}
			if("88".equals(msg)){
			    break;
			}
		    }
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
    }
    
}
