package com.myJava;

import java.io.ObjectInputStream.GetField;

/**
 * ð������
 * @author YR
 *
 */
public class BubbleSort {
    public static void main(String[] args) {
	int[] array = new int[30];
	for (int i = 0; i < array.length; i++) {
	    array[i] = (int) (Math.random()*30); 
	}
	BubbleSort b = new BubbleSort();
	b.getSort(array);
	for(int temp : array){
	    System.out.print(temp+"	");
	}
    }
     private void getSort(int[] obj){
	 int count = 0;
	int object;
	for(int i=0;i<obj.length;i++){
	    for(int j=0;j<obj.length-i-1;j++){
		if(obj[j]>obj[j+1]){
		    object = obj[j];
		    obj[j] = obj[j+1];
		    obj[j+1] = object;
		    count++;
		}
	    }
	}
	System.out.printf("�ܹ�����%1$d ����",count);
	System.out.println();
    }
}
