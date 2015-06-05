package cn.testIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 字节文件输入输出流演示
 * @author YR
 *
 */
public class TestFileInputStream {
    public static void main(String[] args) throws IOException {
	//构造文件输出流对象，并打开文件
	FileOutputStream fos = new FileOutputStream("readme.bin");
	//键盘输入对象
	Scanner scan = new Scanner(System.in);
	int count; 
	System.out.print("请输入数据个数：");
	count = scan.nextInt();
	int countbk = count;
	for(int i = 0;i<4;i++){
	    //4个字节为数据的个数
	    //向文件写入数据
	    fos.write(countbk&0xFF);
	    countbk = countbk >>8;
	}
	System.out.println("请输入每一个正整数的值：");
	int data = 0;
	for(int i = 0;i<count;i++){
	    //按字节输出每个正整数到文件
	    data = scan.nextInt();
	    for(int j = 0;j<4;j++){
		fos.write(data&0xFF);
		data = data>>8;
	    }
	}
	fos.close();
	
	//构造字节文件输入流对象
	FileInputStream fis = new FileInputStream("readme.bin");
	int len = 0;
	byte[] b = new byte[4];
	//从文件读取4个字节的数据个数值
	len = fis.read(b);
	count = 0;
	for(int i=3;i>=0;i--){
	    count = count<<8;
	    count = count+b[i];
	}
	int sum = 0;
	for(int i = 0;i<count;i++){
	    len = fis.read(b);
	    data = 0;
	    for(int j= 3;j>=0;j--){
		data = data<<8;
		data = data+b[j];
	    }
	    sum += data;
	}
	fis.close();
	System.out.println("求和的结果为："+sum);
    }
}
