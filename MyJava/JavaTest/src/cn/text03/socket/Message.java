package cn.text03.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 封装信息类，并进行序列化
 * @author YR
 *
 */
public class Message implements Serializable{
    //消息发送者
    private String name;
    //发送者IP
    private String ip;
    //发送内容
    private String msg;
    //发送时间
    private Date date;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
  //消息对象传递的客户端
    public static void clientStart(String ip,int port) throws Exception, IOException{
        Socket s = new Socket(ip,port);
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        Message msg = new Message();
        msg.setName(InetAddress.getLocalHost().getHostName());
        msg.setIp(InetAddress.getLocalHost().getHostAddress());
        msg.setMsg("你好，好久不见");
        msg.setDate(new Date());
        oos.writeObject(msg);
        oos.flush();
        s.close();
        
    }
    public static void startServer(int port) throws IOException, Exception{
	ServerSocket ss = new ServerSocket(port);
	System.out.println("服务器端已启动，等待客户端连接");
	Socket s = ss.accept();
	System.out.println("客户端连接成功");
	
	ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
	Message msg = (Message)ois.readObject();
	System.out.println(msg.getName()+" "+msg.getIp()+"说：");
	System.out.println(msg.getMsg());
	System.out.println("消息发送时间为："+msg.getDate());
	ois.close();
	ss.close();
    }
}


