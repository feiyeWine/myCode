package com.secondwork;
/**
 * 学号：13121073 姓名：尹榕 (practice2)
 * @author YR
 *
 */
public class Test3 {
    public static void main(String[] args) {
	int a[] = {-2,11,-4,13,-5,-2};
	System.out.println("序列为：");
	for(int i:a){
	    System.out.print(i+"\t");
	}
	int sum = maxSubsequenceSum(a);
	System.out.println("\n最大和为："+sum);
    }
    public static int maxSubsequenceSum(int a[]) {
	int maxSum = 0;
	int thisSum = 0;
	for (int j = 0; j < a.length; j++) {
	    thisSum += a[j];
	    if (thisSum > maxSum) {
		maxSum = thisSum;
	    } else if (thisSum < 0) {
		thisSum = 0;
	    }
	}
	return maxSum;
    }
}