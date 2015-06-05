package cn.text03.socket;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * ����ϵͳ�ͻ���
 * @author YR
 *
 */
public class ChatClient {
    JFrame jf = new JFrame("����ϵͳ�ͻ���");
    JTextArea jt = new JTextArea();
    DataOutputStream dos = null;
    JTextField jtf = new JTextField(15); //ָ���������ı���
    
    public static void main(String[] args){
	ChatClient c = new ChatClient();
	c.createForm();
	try {
	    c.clientStart("localhost", 8888);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
    //�����ͻ����û���ͼ�δ���
    public void createForm(){
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jf.getContentPane().add(jt,BorderLayout.CENTER);
	
	JButton jb = new JButton("����");
	SendButtonAction sendAction = new SendButtonAction();
	jb.addActionListener(sendAction);
	JPanel jp = new JPanel();
	jp.add(jtf);
	jp.add(jb);
	
	jf.getContentPane().add(jp,BorderLayout.SOUTH);
	
	jf.setSize(300,200);
	jf.setVisible(true);
	
    }
    //�����ͻ���Socket�����ӷ�����
    public void clientStart(String ip,int port) throws UnknownHostException, IOException{
	Socket s = new Socket(ip,port);
	dos = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));
	new MySocketReadServer(s).start();
    }
    
    //Ϊͼ���û�����İ�ť��Ӵ����¼�
    class SendButtonAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
	  String msg = jtf.getText();
	  jtf.setText("");
	  if("".equals(msg)){
	      JOptionPane.showMessageDialog(jf, "���͵����ݲ���Ϊ��");
	      return;
	  }
	  try{
	      dos.writeUTF(msg);
	      dos.flush();
	  }catch(IOException e){
	      JOptionPane.showMessageDialog(jf, "����ʧ�ܣ������³���");
	      e.printStackTrace();
	  }
	    
	}
    }
    //����һ���߳��࣬��װ������Ϣ����
    class MySocketReadServer extends Thread{
	private Socket s;
	public MySocketReadServer(Socket s ){
	    this.s = s;
	}
	public void run(){
	    try {
		DataInputStream dis = new DataInputStream(new BufferedInputStream(s.getInputStream()));
		while(true){
		    String msg = jt.getText()+"\n\r"+dis.readUTF();
		    jt.setText(msg);
		    
		    if("88".equals(msg)){
			break;
		    }
		}
	    } catch (IOException e) {
		System.out.println(s+"���˳�������");
	    }
	}
    }
    
}
