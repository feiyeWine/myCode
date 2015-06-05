package cn.net.chat03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * ����������
 * @author YR
 *
 */
public class Server {
    private List<MyChannel> all = new ArrayList<MyChannel>();
    public static void main(String[] args) throws IOException {
	new Server().start();
    }
    public void start() throws IOException{
	ServerSocket server = new ServerSocket(9999);
	while(true){
	Socket client = server.accept();
	//��������
	MyChannel channel = new MyChannel(client);
	all.add(channel); //ͳһ����
	new Thread(channel).start();
	}
    }
   private class MyChannel implements Runnable{
       
       private DataInputStream dis;
       private  DataOutputStream dos;
       private boolean isRunning = true;
       
    public MyChannel (Socket client) throws IOException{
	
	try {
	    dis = new DataInputStream(client.getInputStream());
	    dos = new DataOutputStream(client.getOutputStream());
	} catch (IOException e) {
	   // e.printStackTrace();
	    isRunning =false;
	    dis.close();
	    dos.close();
	}
    }
    private String receive() throws IOException{
	String msg = "";
	try {
	    msg=dis.readUTF();
	} catch (IOException e) {
	 // e.printStackTrace();
	    isRunning =false;
	    all.remove(this);//�Ƴ�����
	}
	return msg;
    }
    private void send (String msg) throws IOException{
	if(null==msg||msg.equals("")){
	    return ;
	}
	try {
	    dos.writeUTF(msg);
	    dos.flush();
	} catch (IOException e) {
	    //e.printStackTrace();
	    isRunning =false;
	    dis.close();
	    dos.close();
	}
    }
    /**
     * ���͸������ͻ���
     * @throws IOException 
     */
    private void sendOther() throws IOException{
	String msg =this.receive();
	//��������
	for(MyChannel other:all){
	    if(other==this){
		continue;
	    }
	    other.send(msg);
	}
    }
    @Override
    public void run() {
	while(isRunning){
	   try {
	   sendOther();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	}
    }
       
  
       
   }
}
