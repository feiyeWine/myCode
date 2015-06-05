package cn.net.url;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 * 获取资源
 * @author YR
 *
 */
public class URLDemo02 {
    public static void main(String[] args) throws IOException {
	URL url = new URL("http://172.16.222.253/portal/logon.htm?userip=115.155.9.124&userurl=687474703a2f2f68616f2e3336302e636e3f6131303034");
	//获取资源 网络流
	/*InputStream is = url.openStream();
	byte[] flush = new byte[1024];
	int len = 0;
	while(-1!=(len = is.read(flush))){
	    System.out.println(new String(flush,0,len));
	}
	is.close();*/
	BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
	
	BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(
		new FileOutputStream("xidian.html"),"UTF-8"));
	String msg = null;
	while(null!=(msg=br.readLine())){
	   System.out.println(msg);
	    wr.append(msg);
	    wr.newLine();
	}
	wr.flush();
	wr.close();
	br.close();
    }
}
