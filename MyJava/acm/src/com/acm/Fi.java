package com.acm;

public class Fi {
	
	final static int [][] BASEMATRIX = {{1,1},{1,0} };
	
	//普通的递归算法 T(n) = T(n-1) + T(n-2)
	//指数级的时间复杂度
	public static long fiWithRecursion(int n){
		if ( n == 0) 
			return 0;
		else if ( n == 1)
			return 1;
		else 
			return fiWithRecursion(n - 1) + fiWithRecursion(n - 2);
	}
	
	//采用迭代算法
	//线性时间复杂度O(n)
	public static long fiWithIterator(int n){
		if ( n == 0)
			return 0;
		if ( n == 1)
			return 1;
		long f0 = 0;
		long f1 = 1;
		for(int i = 2; i<= n ; i++){
			long temp = f0;
			f0 = f1;
			f1 = temp + f1;
		}
		return f1;
	}
	
	//采用分治法的矩阵运算
	//对数的时间复杂度O(lgN)
	public static long fiWithMatrix(int n){
		if ( n == 0)
			return 0;
		if ( n == 1)
			return 1;
		int [][] data = recruit(n);
		return data[0][1];
	}
	
	private static int [][] recruit(int n){
		if (n == 1) 
			return BASEMATRIX;
		else if (n % 2 == 0){
			int [][] data = recruit(n/2);
			return matrixTimes(data,data,2);
		}else {
			int [][] data = recruit((n-1)/2);
			return matrixTimes(matrixTimes(data,data,2),BASEMATRIX,2);
		}
	}
	
	//分治法计算x^n
	public static int mm(int n,int x){
		if ( n == 0) 
			return 1;
		if ( n == 1)
			return x;
		else if ( n % 2 == 0){
			return mm(n/2,x) * mm(n/2,x);
		}
		else {
			return mm((n-1)/2,x) * mm((n-1)/2,x) * x ;
		}
	}
	
      //计算矩阵乘法
	private static int [][] matrixTimes(int [][] a, int [][] b,int n){
		int [][] c = new int[n][n];
		for(int i =0; i< n ; i++){
			for(int j =0; j< n ; j++){
				for(int k = 0; k< n ; k++){
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return c;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//0,1,1,2,3,5,8,13,21,34,55
		Long begin2 = System.nanoTime();
		fiWithRecursion(15);
		Long end2 = System.nanoTime();
		System.out.println("user recure argrithom:   【" + (end2 - begin2) + "ns】");
		
		Long begin1 = System.nanoTime();
		fiWithIterator(1500000);
		Long end1 = System.nanoTime();
		System.out.println("user iterator argrithom: 【" + (end1 - begin1) + "ns】");
		
		Long begin3 = System.nanoTime();
		fiWithMatrix(1500000);
		System.out.println(fiWithMatrix(1500000));
		Long end3 = System.nanoTime();
		System.out.println("user matrix argrithom:   【" + (end3 - begin3) + "ns】");
		
	}

}