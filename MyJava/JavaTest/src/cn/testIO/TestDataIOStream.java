package cn.testIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


public class TestDataIOStream {
    public static void main(String[] args) throws IOException {
	BufferedInputStream bis = new BufferedInputStream(new DataInputStream(System.in));
	
	DataOutputStream dos = new DataOutputStream(System.out);
	BufferedOutputStream bos = new BufferedOutputStream(dos);
	byte[] b = new byte[1024];
	if(bis.read(b)!=-1){
	    bos.write(b);
	    bos.flush();
	}
	bos.close();
	bis.close();
    }
}
