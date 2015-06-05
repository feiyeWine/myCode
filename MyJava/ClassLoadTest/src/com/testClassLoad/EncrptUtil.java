package com.testClassLoad;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ���ܹ�����
 * @author YR
 *
 */
public class EncrptUtil {
    
    public static void main(String[] args) throws IOException {
	encrpt("E:/MyJava/ClassLoadTest/src/com/testClassLoad/com/testClassLoad/Hello.class",
		"E:/MyJava/ClassLoadTest/src/com/testClassLoad/com/testClassLoad/out.class");
    }
    public static void encrpt(String src,String dest) throws IOException{
	FileInputStream fis = null;
	FileOutputStream fos = null;
	try {
	    fis = new FileInputStream(src);
	    fos = new FileOutputStream(dest);
	    int temp = -1;
	    while((temp=fis.read())!=-1){
		fos.write(temp^0xff);//ȡ������
	    }
	    
	    
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}finally{
	    if(fis!=null){
		fis.close();
	    }
	    if(fos!=null){
		fos.close();
	    }

	}
    }
}
