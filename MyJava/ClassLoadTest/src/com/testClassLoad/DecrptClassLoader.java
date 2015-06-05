package com.testClassLoad;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/**
 * 加载文件系统加密后的类加载器
 * @author YR
 *
 */
public class DecrptClassLoader extends ClassLoader{
 private String rootDir;
    
    public DecrptClassLoader(String rootDir){
	this.rootDir = rootDir;
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
	Class<?> c = findLoadedClass(name);
	//如果已加载，返回加载好的类，否则，加载新类
	if(null!=c){
	    return c;
	}else{
	    ClassLoader parent = this.getParent();
	    try {
		c = parent.loadClass(name);//委派给父类加载
	    } catch (Exception e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	    }
	    if(null!=c){
		return c;
	    }else{
		byte[] classData = getClassData(name);
		if(classData==null){
		    throw new ClassNotFoundException();
		}else{
		    c = defineClass(name, classData, 0,classData.length);
		}
	    }
	}
	
	return c;
    }
    private byte[] getClassData(String className){
	String path = rootDir+"/"+className.replace(".", "/")+".class";
	InputStream is = null;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	try {
	      is = new FileInputStream(path);
	      
	      int temp = -1;
	      while((temp=is.read())!=-1){
		  baos.write(temp^0xff);//取反操作
	      }
	      return baos.toByteArray();
	      
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}finally{
	    try {
		if(baos!=null){
		baos.close();
		}
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	    try {
		if(is!=null){
		is.close();
		}
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
    }
}
