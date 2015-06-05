package cn.net.chat04;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 发送数据 线程
 * @author YR
 *
 */
public class Send implements Runnable{

    private BufferedReader console;
    private DataOutputStream dos;
    private String name;
    private boolean isRunning = true;
    public Send(){
	console = new BufferedReader(new InputStreamReader(System.in));
    }
    public Send(Socket client,String name) throws IOException{
	this();
	try {
	    this.name=name;
	    dos = new DataOutputStream(client.getOutputStream());
	    send(this.name);
	} catch (IOException e) {
	    //e.printStackTrace();
	    isRunning = false;
	    dos.close();
	    console.close();
	}
    } 
    //1、从控制台接收数据
    private String getFromConsole() {
	try {
	    return console.readLine();
	} catch (IOException e) {
	    //e.printStackTrace();
	    return "";
	}
    }
    /**
     *
     * 2、发送数据
     * @throws IOException 
     */
    public void send(String msg) throws IOException{
	if(null!=msg&&!msg.equals("")){
	    try {
		dos.writeUTF(msg);
		dos.flush();
	    } catch (IOException e) {
		//e.printStackTrace();
		isRunning = false;
		dos.close();
		console.close();
	    }
	    
	}
    }
    @Override
    public void run() {
	while(isRunning){
	    try {
		send(getFromConsole());
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
    }

}
