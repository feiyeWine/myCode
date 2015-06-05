package com.firstwork;

import java.util.Arrays;

/**
 * 基数排序：原地排序，稳定的
 * @author YR
 *
 * 学号：13121073	姓名：尹榕 (practice 1)
 */
public class RadixSort {  
    
    public static void main(String[] args) {
	int [] arr = {1,2,8,5,9,6,21,45,5};
	System.out.println("待排数组为:");
        for(int i :arr){
            System.out.print(i+"\t");
        }
	radixSort(arr, 3, 32);
	System.out.println("\n基数排序为：");
	for(int i : arr){
	    System.out.print(i+"\t");
	}
    }
    
  
   //基于计数排序的基数排序算法  
   private static void radixSort(int[] array,int radix, int distance) {  
        //array为待排序数组  
        //radix，代表基数  
       //distance代表排序元素的位数  
         
       int length = array.length;  
       int[] temp = new int[length];//用于暂存元素  
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

