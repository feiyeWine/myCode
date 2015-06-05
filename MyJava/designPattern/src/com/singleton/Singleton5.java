package com.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 防止通过反射、反序列化破解单例模式
 * @author YR
 *
 */
public class Singleton5 implements Serializable{
    private  Singleton5() throws Exception{
	if(instance!=null){	//防止反射破解单例
	    throw new Exception(); 
	}
    }
    private static Singleton5 instance;
    public static Singleton5 getInstance() throws Exception{
	if(null==instance){
	    instance = new Singleton5();
	}
	return instance;
    }
    private Object readResolve()throws ObjectStreamException{
	return instance;
    }
}
