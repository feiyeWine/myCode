package cn.serverDemo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����������
 * @author YR
 *
 */
public class Sever2 {
   private ServerSocket sever;
    public static void main(String[] args) {
	Sever2 sever = new Sever2();
	sever.start();
    }
    //����������
    public void start(){
	try {
	    sever = new ServerSocket(8888);
	    this.receive();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
    //���շ�������Ϣ
  private void receive(){
      try {
	Socket client = sever.accept();
	String msg = null;
	StringBuilder sb = new StringBuilder();
	BufferedReader br = new BufferedReader(
		new InputStreamReader(client.getInputStream())
		);
	while((msg=br.readLine()).length()>0){
	   sb.append(msg);
	   sb.append("\r\n");
	   if(msg==null){
	       break;
	   }
	}
	String request = sb.toString().trim();
	System.out.println(request);
	Response rep = new Response(client.getOutputStream());
	rep.println("hi hi ");
	rep.pushToClient(200);
	
      } catch (IOException e) {
	e.printStackTrace();
    }
  }
  //ֹͣ������
  public void stop(){
      
  }
}
