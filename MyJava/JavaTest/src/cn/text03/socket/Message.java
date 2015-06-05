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
 * ��װ��Ϣ�࣬���������л�
 * @author YR
 *
 */
public class Message implements Serializable{
    //��Ϣ������
    private String name;
    //������IP
    private String ip;
    //��������
    private String msg;
    //����ʱ��
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
  //��Ϣ���󴫵ݵĿͻ���
    public static void clientStart(String ip,int port) throws Exception, IOException{
        Socket s = new Socket(ip,port);
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        Message msg = new Message();
        msg.setName(InetAddress.getLocalHost().getHostName());
        msg.setIp(InetAddress.getLocalHost().getHostAddress());
        msg.setMsg("��ã��þò���");
        msg.setDate(new Date());
        oos.writeObject(msg);
        oos.flush();
        s.close();
        
    }
    public static void startServer(int port) throws IOException, Exception{
	ServerSocket ss = new ServerSocket(port);
	System.out.println("�����������������ȴ��ͻ�������");
	Socket s = ss.accept();
	System.out.println("�ͻ������ӳɹ�");
	
	ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
	Message msg = (Message)ois.readObject();
	System.out.println(msg.getName()+" "+msg.getIp()+"˵��");
	System.out.println(msg.getMsg());
	System.out.println("��Ϣ����ʱ��Ϊ��"+msg.getDate());
	ois.close();
	ss.close();
    }
}


