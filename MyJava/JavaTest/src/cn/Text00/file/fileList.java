package cn.Text00.file;

import java.io.File;

/**
 * 遍历目录中的文件
 * @author YR
 *
 */
public class fileList {
    public static void main(String[] args) {
	String src = "E:\\学习文档\\API";
	File file = new File(src);
	fileTest(file);
    
    
    }
    public static void fileTest(File file){
	
	if(file.isFile()){
	    System.out.println("文件是："+file.getName());
	}
	else if(file.isDirectory()){
	    System.out.println("文件夹，目录是："+file.getName());
	    File f[] = file.listFiles();
	    for(int i = 0;i<f.length;i++){
		fileTest(f[i]);
	    }
	}
    
	
    }
}
