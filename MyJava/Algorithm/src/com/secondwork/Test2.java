package com.secondwork;

/**
 * 学号：13121073 姓名：尹榕 (practice2)
 * @author YR
 *	
 *最长公共子序列
 */
public class Test2 {
    public static void main(String[] args) {

        String x = "ALLAAQANKESSSESFISRLLAIVAD";
        String y = "KLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG";
	/*String x = "xzyzzyx";
	String y = "zxyyzxz";*/

        // 构造二维数组记录子问题x[i]和y[i]的LCS的长度
        int[][] opt = new int[x.length() + 1][y.length() + 1];

        // 动态规划计算所有子问题
        for (int i = x.length() - 1; i >= 0; i--) {
            for (int j = y.length() - 1; j >= 0; j--) {
                if (x.charAt(i) == y.charAt(j))
                    opt[i][j] = opt[i + 1][j + 1] + 1;
                else
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
            }
        }

        System.out.println("x: "+x);
        System.out.println("y: "+y);
        System.out.print("LCS: ");

        int i = 0, j = 0;
        while (i < x.length() && j < y.length()) {
            if (x.charAt(i) == y.charAt(j)) {
                System.out.print(x.charAt(i));
                i++;
                j++;
            } else if (opt[i + 1][j] >= opt[i][j + 1])
                i++;
            else
                j++;
        }
    }
}
