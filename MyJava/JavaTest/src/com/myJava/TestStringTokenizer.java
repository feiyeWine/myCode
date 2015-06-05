package com.myJava;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * StringTokenizer进行四则运算
 * @author YR
 *
 */
public class TestStringTokenizer {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String str = sc.nextLine();
	
	StringTokenizer st = new StringTokenizer(str,"*/+-");
	double data[] = new double[st.countTokens()];
	//取得数字数组
	int i = 0;
	while(st.hasMoreTokens()){
	    data[i++] = Double.parseDouble(st.nextToken());
	}
	
	st = new StringTokenizer(str,"0123456789");
	char operator[] = new char[st.countTokens()];
	i = 0;
	while(st.hasMoreTokens()){
	    operator[i++] = st.nextToken().charAt(0);
	}
	int k = 0;
	double result = 0;
	double left = data[k];
	double right = 0;
	for(char o : operator){
	    right = data[++k];
	    switch(o){
	    case '*':
		result = left*right;
		break;
            case '/':
        	result = left/right;	
            	break;
            case '+':
        	result = left+right;
            	break;
            case '-':
        	result = left-right;
            	break;
	    }
	    left = result;
	}
	System.out.println("="+result);
	
    }
}
