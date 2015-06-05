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
 * 聊天系统服务端
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
	    System.out.println("服务器启动失败");
	    e.printStackTrace();
	}
	
    }
    //启动服务器，并循环监听客户端的连接
    public void startServer(int port) throws IOException{
	ServerSocket ss = new ServerSocket(port);
	System.out.println("服务器端已启动，等待客户端连接");
	
	while(true){
	    Socket s = ss.accept();
	    vect.add(s);
	    System.out.println("客户端连接成功"+s);
	    
	    new MySocketOpt(s).start();
	}
    }
    //定义一个线程，提供接受和转发服务
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
			System.out.println("服务器端接受到："+msg);
			//遍历集合中的Socket连接，向外转发消息
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
