package com.secondwork;

import java.util.Scanner;

/**
 * 矩阵链乘法
 * @author YR
 *
 */
public class Test1 {
    private static int [][] m;
    private static int [][]s;
    public static void main(String[] args) {
	int[] p = {10, 3, 15, 12, 7, 2};
	System.out.println("序列为：");
	for(int i:p){
	    System.out.print(i+"\t");
	}
	System.out.println("\n链乘矩阵为：");
	m = new int[p.length-1][p.length-1];
	s = new int[p.length-1][p.length-1];
	int min = matrixChain(p);
	System.out.println("最小代价为："+min);
	print(s,0,p.length-2);
    }
    //计算最优代价
    public static int matrixChain(int []p){
	int n = p.length-1;
	int min = 0;
	for(int i = 1;i<n;i++){
	    m[i][i] = 0;
	}
	for(int len = 2;len<=n;len++){
	    for(int i =0;i<n-len+1;i++){
		int j = i+len-1;
		m[i][j] = Integer.MAX_VALUE;
		for(int k = i;k<j;k++){
		    int q = m[i][k]+m[k+1][j]+p[i]*p[k+1]*p[j+1];
		    if(q<m[i][j]){
			min = q;
			m[i][j] = q;
			s[i][j] = k;
		    }
		}
		System.out.print(min+"\t");
	    }
	    System.out.println();
	}
	return min;
    }
    //构造一个最优解
    public static void print(int[][] s,int i, int j){
	if(i==j){
	    System.out.print("A"+(i+1));
	}else{
	  System.out.print("(");  
	  print(s,i,s[i][j]);
	  print(s,s[i][j]+1,j);
	  System.out.print(")");
	}
    }
}
