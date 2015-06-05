package cn.testFile;

import java.io.File;

public class TestFile {
	public static void main(String[] args) {
		
	File f = new File("E:/MyJava/testDate/src/cn/testFile/TestFile.java");
	File f2=new File("E:/FavoriteVideo/readme.txt");
	if(f2.isFile()){
		System.out.println("是一个文件");
	}
	
	}
}
