package com.acm;

import java.util.Scanner;

public class MainCC {
    public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	while(sc.hasNext()){
	    long n = matrixSum(sc.nextInt());
	    System.out.println(n);
	}
    }

    final static int MOD = 1000000007;
    final static long[][] BASE = { { 2, 1 }, { 1, 0 } };

    public static long matrixSum(int n) {
	if (n == 0)
	    return 0;
	if (n == 1)
	    return 1;
	long[][] data = matriPow(n);
	return data[0][1];
    }

    private static long[][] matriPow(int n) {
	if (n == 1)
	    return BASE;
	else if (n % 2 == 0) {
	    long[][] data = matriPow(n / 2);
	    return multi(data, data, 2);
	} else {
	    long[][] data = matriPow((n - 1) / 2);
	    return multi(multi(data, data, 2), BASE, 2);
	}
    }

    private static long[][] multi(long[][] a, long[][] b, int n) {
	long[][] c = new long[n][n];
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < n; j++) {
		for (int k = 0; k < n; k++) {
		    c[i][j] += ((a[i][k]%MOD)* (b[k][j]%MOD))%MOD;
		}
	    }
	}
	return c;
    }
}
