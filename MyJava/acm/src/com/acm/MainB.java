package com.acm;

import java.util.Scanner;

public class MainB {
    private  static int count = 0;
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int t = 0;
	
	if (sc.hasNextInt()) {
	    t = sc.nextInt();
//	    System.out.println(t);
	}
	int c[] = new int[t];
	for (int i = 0; i < t; i++) {
	    int n = 0;
	    if (sc.hasNextLine()) {
		n = sc.nextInt();
//		System.out.println(n);
	    }
	    int arr[] = new int[n];
	    int j = 0;
	    for(int m = 0;m<n;m++){
		arr[j++] = sc.nextInt();
//		System.out.println(arr[j-1]);
	    }
	    count = 0;
//	    System.out.println(merageSort(arr));
	    System.out.println(test(arr)%1000000007);
	}
	/*for(int i : c){
	    System.out.println(i);
	}*/
    }
    public static int test(int [] arr){
	int count = 0;
	for(int i = 0;i<arr.length-1;i++){
	    for(int k = i+1;k<arr.length;k++){
		if(arr[i]>arr[k]){
		    count ++;
		}
	    }
	}
	return count;
    } 
    
    public static int merageSort(int [] arr){
	if(arr.length==0||arr==null){
	    return 0;
	}
	int middle = arr.length/2;
	int[] left = new int[middle];
	int[] right = new int[arr.length-middle];
	
	for(int i = 0 ;i<arr.length;i++){
	    if(i<middle){
		left[i] = arr[i];
	    }else{
		right[i-middle] = arr[i];
	    }
	}
	if(arr.length>1){
	    merageSort(left);
	    merageSort(right);
	    count +=merage(arr,left,right);
	}
	return count;
    }
    private static int merage(int[] arr, int[] left, int[] right) {
	int i = 0,j = 0,k = 0;
	int count = 0;
	while(i<left.length&&j<right.length){
	    if(left[i]<=right[j]){
		arr[k] = left[i];
		i++;
	    }else{
		arr[k] = right[j];
		j++;
		count+=left.length-i;
	    }
	    k++;
	}
	while(i<left.length){
	    arr[k] = left[i];
	    i++;
	    k++;
	}
	while(j<right.length){
	    arr[k] = right[j];
	    j++;
	    k++;
	}
	return count;
    }
}
