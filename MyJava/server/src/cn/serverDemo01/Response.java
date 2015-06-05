package cn.serverDemo01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

public class Response {
      
      //连个常量
      public static final String BLANK = " ";
      public static final String CRLF = "\r\n";
      //正文
      private StringBuilder content;
      //存储头信息
      private StringBuilder headInfo;
      private int len = 0;
      //流
      private BufferedWriter bw;
      public Response(){
	headInfo = new StringBuilder();
	content = new StringBuilder();
	len = 0;
    }
    public Response(OutputStream os){
	this();
	bw = new BufferedWriter(new OutputStreamWriter(os));
    }
    public Response(Socket client){
   	this();
   	try {
	    bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
	} catch (IOException e) {
	    headInfo = null;
	    e.printStackTrace();
	}
       }
    //构建正文
    public Response print(String info){
	content.append(info);
	return this;
    }
    public Response println(String info){
	content.append(info).append(CRLF);
	len += (info+CRLF).getBytes().length;
	return this;
    }
    private void createHeadInfo(int code){
	StringBuilder headInfo = new StringBuilder();
	//1、HTTP协议版本、状态代码、描述
	headInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
	switch(code){
	case 200:
	    headInfo.append("OK");
	    break;
	case 404:
	    headInfo.append("Not Found");
	    break;
	case 500:
	    headInfo.append("Server Error");
	    break;
	}
	headInfo.append(CRLF);
	//2、响应头
	headInfo.append("Server:myServer/0.0.1").append(CRLF);
	headInfo.append("Date:").append(new Date()).append(CRLF);
	headInfo.append("Content-type:text/plain;charset=GBK").append(CRLF);
	//正文长度，字节长度
	headInfo.append("Content-Length:").append(len).append(CRLF);
	//3、正文之前
	headInfo.append(CRLF);
    }
    //推送到客户端
    void pushToClient(int code ) throws IOException{
	if(null == headInfo){
	   code = 500; 
	}
	createHeadInfo(code);
	//头信息+分隔符
	bw.append(headInfo.toString());
	bw.append(content.toString());
	bw.flush();
    }
    public void close(){
	CloseUtil.closeAll(bw);
    }
}
