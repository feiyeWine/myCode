package cn.Array;

import java.util.Arrays;

public class array2 {
	public static void main(String[] args) {
		int [][] a={
				{1,3},
				{2,4},
					};
		int[][] b={
				{3,4},
				{5,6},
					};
		int c[][]=new int [2][3];
		for(int i=0;i<c.length;i++){
			for(int j=0;j<c.length;j++){
				c[i][j]=a[i][j]+b[i][j];
			}
		}
	for(int k=0;k<c.length;k++){
		for(int m=0;m<c.length;m++)
		System.out.print(c[k][m]+"\t");
		System.out.println();
		}
	int d[]={1,2,5,4,7,3,8};
	Arrays.sort(d);
	System.out.println(Arrays.toString(d));
	System.out.println(Arrays.binarySearch(d,4));
	//System.out.println(Arrays.fill(d,1,2,20));
	for (int i:d) {      //±éÀúÊı×é
		System.out.print(i+"\t");
	}
	}
	
}
