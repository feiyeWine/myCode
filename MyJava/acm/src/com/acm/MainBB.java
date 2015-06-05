package com.acm;

import java.util.Random;
import java.util.Scanner;

public class MainBB {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int t = 0;
	
	if (sc.hasNextInt()) {
	    t = sc.nextInt();
//	    System.out.println(t);
	}
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
	   System.out.println(countSort(arr)%1000000007); 
	}
	int arr[] = new int[99999];
	 Random rand = new Random();
	for(int i = 0;i<arr.length;i++){
	   arr[i] = rand.nextInt(9);
	}
	 System.out.println(countSort(arr)%1000000007); 
    }
    public static long countSort(int[] a){
	long sum = 0;
	int c[] = new int[10];
	for(int i = 0;i<a.length;i++){
	    c[a[i]] += 1; 
	    for(int j = a[i]+1;j<10;j++){
		sum += c[j];
	    }
	}
	return sum;
    }
}
