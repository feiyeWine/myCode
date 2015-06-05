package cn.net.chat04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建服务器
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
	//接收数据
	MyChannel channel = new MyChannel(client);
	all.add(channel); //统一管理
	new Thread(channel).start();
	}
    }
   private class MyChannel implements Runnable{
       
       private DataInputStream dis;
       private  DataOutputStream dos;
       private String name;
       private boolean isRunning = true;
       
    public MyChannel (Socket client) throws IOException{
	
	try {
	    dis = new DataInputStream(client.getInputStream());
	    dos = new DataOutputStream(client.getOutputStream());
	    this.name=dis.readUTF();
	    System.out.println(this.name);
	    this.send("欢迎您进入聊天室");
	    sendOther(this.name+"进入了聊天室",true);
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
	    all.remove(this);//移除自身
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
     * 发送给其他客户端
     * @throws IOException 
     */
    private void sendOther(String msg,boolean sys) throws IOException{
	//是否为私聊
	if(msg.startsWith("@")&&msg.indexOf(":")>-1){
	    //私聊,获取name
	    String name = msg.substring(1,msg.indexOf(":"));
	    String content = msg.substring(msg.indexOf(":")+1);
	    for(MyChannel other:all){
		if(other.name.equals(name)){
		    other.send(this.name+"对您悄悄地说："+content);
		}
	    }
	}
	
	else{
	
	//遍历容器
	for(MyChannel other:all){
	    if(other==this){
		continue;
	    }
	    if(sys){
		System.out.println("系统信息："+msg);
	    }else{
		other.send(this.name+"对所有人说："+msg);
	    }
	 }
	}
    }
    @Override
    public void run() {
	while(isRunning){
	   try {
	   sendOther(receive(),false);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	}
  }
       
  
       
   }
}
