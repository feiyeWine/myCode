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
public class Sever3 {
   private ServerSocket sever;
    public static void main(String[] args) {
	Sever3 sever = new Sever3();
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
	Request request= new Request(client.getInputStream()); 
	System.out.println(request.toString());
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
