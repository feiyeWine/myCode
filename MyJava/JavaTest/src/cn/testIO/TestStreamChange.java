package cn.testIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 测试字节流与字符流之间的转换
 * @author YR
 *
 */
public class TestStreamChange {
    public static void main(String[] args) throws IOException {
	test();
    }
    public static void test() throws IOException{
	File file = new File("readme.bin");
	//字节流转换为字符流
	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
	//字符流转换为字节流
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("write")));
	String str = null;
	char[] c = new char[1024];
	int length  = 0;
	if((length = br.read(c))!=-1){
	    str = new String(c,0,length);
	}
	System.out.println(str);
	bw.write(str+" hi");
	bw.flush();
	bw.close();
	br.close();
    }
}
