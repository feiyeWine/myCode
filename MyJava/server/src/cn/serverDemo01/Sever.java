package cn.serverDemo01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 创建服务器
 * @author YR
 *
 */
public class Sever {
   private ServerSocket sever;
    public static void main(String[] args) {
	Sever sever = new Sever();
	sever.start();
    }
    //启动服务器
    public void start(){
	try {
	    sever = new ServerSocket(8888);
	    this.receive();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
    //接收服务器信息
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
	
	//响应
	final String BLANK = " ";
	final String CRLF = "\r\n";
	StringBuilder responseContext = new StringBuilder();
	responseContext.append("my response");
	
	StringBuilder response = new StringBuilder();
	//1、HTTP协议版本、状态代码、描述
	response.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("ok").append(CRLF);
	//2、响应头
	response.append("Server:myServer/0.0.1").append(CRLF);
	response.append("Date:").append(new Date()).append(CRLF);
	response.append("Content-type:text/plain;charset=GBK").append(CRLF);
	//正文长度，字节长度
	response.append("Content-Length:").append(responseContext.toString().getBytes().length).append(CRLF);
	//3、正文之前
	response.append(CRLF);
	//4、正文
	response.append(responseContext);
	//输出流
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
	bw.write(response.toString());
	bw.flush();
	bw.close();
      
      } catch (IOException e) {
	e.printStackTrace();
    }
  }
  //停止服务器
  public void stop(){
      
  }
}
