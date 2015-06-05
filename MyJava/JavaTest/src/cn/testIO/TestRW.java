package cn.testIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.CharArrayReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

/**
 * �����ַ����������
 * @author YR
 *
 */
public class TestRW {
    public static void main(String[] args) throws IOException {
	//test1();
	//test2();
	test3();
    }
    
    public static void test1() throws IOException{
	//����CharArrayReader
	String str = "it is a good sun";
	char c[] = new char[str.length()];
	CharArrayReader car = new CharArrayReader(str.toCharArray());
	if(car.read(c)!=-1){
	    System.out.println(c);
	}
	car.close();
    }
    public static void test2() throws IOException{
	//����StringReader
	String str = "i have a good dream";
	StringReader sr = new StringReader(str);
	int c =0;
	if((c=sr.read())!=-1){
	   System.out.println((char)c); 
	   sr.close();
	}
    }
    public static void test3() throws IOException{
	//����BufferedRW
	File file = new File("readme.bin");
	BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	BufferedReader br = new BufferedReader(new FileReader(file));
	
	String str = "����һֻСС����ɷɲ���";
	char[] c = new char[100];
	bw.write(str.toCharArray());
	bw.flush();
	if((br.read(c))!=-1){
	    System.out.println(c);
	}
	if(bw!=null){
	    bw.close();
	}
	if(br!=null){
	    br.close();
	}
	
    }
}
