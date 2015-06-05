package com.secondwork;

/**
 * ѧ�ţ�13121073 ���������� (practice2)
 * @author YR
 *	
 *�����������
 */
public class Test2 {
    public static void main(String[] args) {

        String x = "ALLAAQANKESSSESFISRLLAIVAD";
        String y = "KLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG";
	/*String x = "xzyzzyx";
	String y = "zxyyzxz";*/

        // �����ά�����¼������x[i]��y[i]��LCS�ĳ���
        int[][] opt = new int[x.length() + 1][y.length() + 1];

        // ��̬�滮��������������
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
