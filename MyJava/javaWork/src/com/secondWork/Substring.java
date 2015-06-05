package com.secondWork;

import java.util.Arrays;

/**
 * Substring:��ȡ�ַ���
 * @author ���ţ�13121073��
 * 
 *
 */
public class Substring {
    public static void main(String[] args) {
	Substring s = new Substring();
	String str =  args[0].toString(); //�ַ���
	Integer index=0;
	Integer lenth=0;
	
	try {
	    index = Integer.parseInt(args[1]); 
	    lenth = Integer.parseInt(args[2]);
	} catch (NumberFormatException e) {
	    e.printStackTrace();//ת��ʧ��
	}
	//��ȡ�ַ����Ŀ�ʼλ,����
	String subString =s.subing(str,index,lenth);
	System.out.println(subString);
    }
    public   String subing(String string,int index,int length){
	char c[] = string.toCharArray();
	if(index<0){
	    throw new StringIndexOutOfBoundsException(index);
	}
	if((index+length)>string.length()){
	    throw new StringIndexOutOfBoundsException(index+length);
	}
	if((index+length)<index){
	    throw new StringIndexOutOfBoundsException(length);
	}
	 char[] s= Arrays.copyOfRange(c, index, index+length);
	return String.valueOf(s);
    }
} 
