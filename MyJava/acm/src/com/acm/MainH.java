package com.acm;

import java.util.Scanner;

public class MainH {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = 0;
	if(sc.hasNext()){
	    n = sc.nextInt();
	}
	int arr[] = new int[n];
	int i = 0;
	while(n>0){
	    if(sc.hasNext())
	    arr[i] = sc.nextInt();
	    n--;
	}
    }
}
