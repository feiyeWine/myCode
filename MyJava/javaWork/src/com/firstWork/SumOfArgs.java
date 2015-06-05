package com.firstWork;
/**
 * 求参数的和
 * @author 尹榕
 * 学号：13121073
 *
 */
public class SumOfArgs {
    public static void main(String[] args) {
	int num = 0;
	int sum = 0;
	    for(int i = 0;i<args.length;i++){
	        try {
		    num = Integer.parseInt(args[i]);
		} catch (NumberFormatException e) {
		    //捕获NumberFormat异常
		   continue;
		}
	        sum = sum + num;
	    }
	System.out.println(sum);
    }
}
