package com.acm;

import java.util.Scanner;

public class MainD {
    static int  mod = 0;
    static int sum = 0;
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int a = 0,b = 0;
	while(sc.hasNextLine()){
	    a = sc.nextInt();
	    b = sc.nextInt();
	    mod = sc.nextInt();
	    System.out.println(mod(a,b));
	}
    }
    
    private static int mod(int a,int b){
	if(a == 0){
	    return 0;
	}
	if(b ==0){
	    return 1;
	}
	if(a==1){
	    return a;
	}
	if(b%2==0){
	    sum = mod(a,b/2)*mod(a,b/2)%mod;
//	    System.out.println(sum);
	   return sum; 
	}else{
	    sum = a*mod(a,(b-1)/2)*mod(a,(b-1)/2)%mod;
//	    System.out.println(sum);
	    return sum;
	}
    }
}
