package com.firstWork;
/**
 * ������ĺ�
 * @author ����
 * ѧ�ţ�13121073
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
		    //����NumberFormat�쳣
		   continue;
		}
	        sum = sum + num;
	    }
	System.out.println(sum);
    }
}
