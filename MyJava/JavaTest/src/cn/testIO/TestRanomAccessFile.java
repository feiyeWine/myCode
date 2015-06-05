package cn.testIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 测试随机文件访问
 * @author YR
 *
 */
public class TestRanomAccessFile {
    public static void main(String[] args) throws IOException {
	test();
    }
    public static void test() throws IOException{
	RandomAccessFile raf = new RandomAccessFile("write", "rw");
	StringBuilder str = new StringBuilder();
	char c;
	while((c = (char) System.in.read())!='\n'){
	    str.append(c);
	}
	raf.seek(raf.length());
	raf.writeBytes(str.toString());
	raf.close();
    
    }
}
