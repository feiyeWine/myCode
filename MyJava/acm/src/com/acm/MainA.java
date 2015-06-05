package com.acm;

import java.util.Scanner;

public class MainA {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int test = 0;
	int n = 0, m = 0;
	if (sc.hasNext()) {
	    test = sc.nextInt();
	}
	for (int t = 0; t < test; t++) {
	    if (sc.hasNextLine()) {
		n = sc.nextInt();
	    }
	    int arr[][] = new int[n][3];

	    if (sc.hasNextLine()) {
		for (int i = 0; i < n; i++)
		    for (int j = 0; j < 3; j++) {
			arr[i][j] = sc.nextInt();
		    }
	    }
	    if (sc.hasNextLine()) {
		m = sc.nextInt();
	    }
	    int[] v = new int[m];
	    if (sc.hasNextLine()) {
		for (int i = 0; i < m; i++) {
		    v[i] = sc.nextInt();
		}
	    }
	    for (int i = 0; i < v.length; i++) {
		boolean flag = false;
		for (int j = 0; j < n; j++)
		    if (arr[j][0] <= v[i] && v[i] <= arr[j][1]) {
			System.out.println(arr[j][2]);
			flag = true;
		    }
		if (!flag) {
		    System.out.println(-1);
		}
	    }
	}
    }
}
