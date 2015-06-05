package com.secondwork;
/**
 * ѧ�ţ�13121073 ���������� (practice2)
 * @author YR
 *
 */
public class Test3 {
    public static void main(String[] args) {
	int a[] = {-2,11,-4,13,-5,-2};
	System.out.println("����Ϊ��");
	for(int i:a){
	    System.out.print(i+"\t");
	}
	int sum = maxSubsequenceSum(a);
	System.out.println("\n����Ϊ��"+sum);
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