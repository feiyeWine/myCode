package com.acm;

import java.util.Scanner;

public class MainC {
    public static void main(String[] args) {
	int n =0;
	Scanner sc= new Scanner(System.in);
	while(sc.hasNextInt()) {
	    n = sc.nextInt();
	    long a = 0;
	    long b = 1;
	    long sum = 0;
	    for (int i = 0; i <= n - 2; i++) {
		sum = (2 * b + a)%1000000007;
		a = b%1000000007;
		b = sum%1000000007;
	    }
	    System.out.println(sum%1000000007);
	}
	sc.close();
    }
}
