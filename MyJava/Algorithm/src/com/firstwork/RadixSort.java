package com.firstwork;

import java.util.Arrays;

/**
 * ��������ԭ�������ȶ���
 * @author YR
 *
 * ѧ�ţ�13121073	���������� (practice 1)
 */
public class RadixSort {  
    
    public static void main(String[] args) {
	int [] arr = {1,2,8,5,9,6,21,45,5};
	System.out.println("��������Ϊ:");
        for(int i :arr){
            System.out.print(i+"\t");
        }
	radixSort(arr, 3, 32);
	System.out.println("\n��������Ϊ��");
	for(int i : arr){
	    System.out.print(i+"\t");
	}
    }
    
  
   //���ڼ�������Ļ��������㷨  
   private static void radixSort(int[] array,int radix, int distance) {  
        //arrayΪ����������  
        //radix���������  
       //distance��������Ԫ�ص�λ��  
         
       int length = array.length;  
       int[] temp = new int[length];//�����ݴ�Ԫ��  
       int[] count = new int[radix];  
       int divide = 1;  
          
       for (int i = 0; i < distance; i++) {  
             
            System.arraycopy(array, 0,temp, 0, length);  
            Arrays.fill(count, 0);  
             
            for (int j = 0; j < length; j++) {  
                int tempKey = (temp[j]/divide)%radix;  
               count[tempKey]++;  
            }  
              
            for (int j = 1; j < radix; j++) {  
                count [j] = count[j] + count[j-1];  
            }  
              
            for (int j = length - 1; j >= 0; j--) {  
                int tempKey = (temp[j]/divide)%radix;  
                count[tempKey]--;  
                array[count[tempKey]] = temp[j];  
            }  
              
            divide = divide * radix;                  
              
       }                    
   }
}

