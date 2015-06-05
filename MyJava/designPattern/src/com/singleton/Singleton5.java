package com.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * ��ֹͨ�����䡢�����л��ƽⵥ��ģʽ
 * @author YR
 *
 */
public class Singleton5 implements Serializable{
    private  Singleton5() throws Exception{
	if(instance!=null){	//��ֹ�����ƽⵥ��
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
