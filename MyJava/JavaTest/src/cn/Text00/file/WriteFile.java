package cn.Text00.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 在文件的任意位置 写
 * @author YR
 *
 */
public class WriteFile {
    public static void write() throws IOException{
	File f = new File("E:/MyJava/JavaTest/src/testFile/Write");
	if(!f.exists()){
	    f.createNewFile();
	   
	}
	 RandomAccessFile rf=new RandomAccessFile(f,"rw");
	// rf.seek(rf.length());
	 rf.write('a');
	 rf.close();
	
    }
    public static void main(String[] args) throws IOException {
	write();
    }
}
