package cn.testIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * �ֽ��ļ������������ʾ
 * @author YR
 *
 */
public class TestFileInputStream {
    public static void main(String[] args) throws IOException {
	//�����ļ���������󣬲����ļ�
	FileOutputStream fos = new FileOutputStream("readme.bin");
	//�����������
	Scanner scan = new Scanner(System.in);
	int count; 
	System.out.print("���������ݸ�����");
	count = scan.nextInt();
	int countbk = count;
	for(int i = 0;i<4;i++){
	    //4���ֽ�Ϊ���ݵĸ���
	    //���ļ�д������
	    fos.write(countbk&0xFF);
	    countbk = countbk >>8;
	}
	System.out.println("������ÿһ����������ֵ��");
	int data = 0;
	for(int i = 0;i<count;i++){
	    //���ֽ����ÿ�����������ļ�
	    data = scan.nextInt();
	    for(int j = 0;j<4;j++){
		fos.write(data&0xFF);
		data = data>>8;
	    }
	}
	fos.close();
	
	//�����ֽ��ļ�����������
	FileInputStream fis = new FileInputStream("readme.bin");
	int len = 0;
	byte[] b = new byte[4];
	//���ļ���ȡ4���ֽڵ����ݸ���ֵ
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
	System.out.println("��͵Ľ��Ϊ��"+sum);
    }
}
