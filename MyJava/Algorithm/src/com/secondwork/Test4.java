package com.secondwork;

/**
 * ������Ӵ�
 * ѧ�ţ�13121073 ���������� (practice2)
 * @author YR
 * 
 */
public class Test4 {
    public static void main(String[] args) {
	String x = "ALLAAQANKESSSESFISRLLAIVAD";
	String y = "KLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG";
//	String x = "xzyzzyx";
//	String y = "zxyyzxz";
	System.out.println("X: "+x);
	System.out.println("Y: "+y);
	String  str = getCommonStrLength(x, y);
	System.out.println("������Ӵ�Ϊ��"+str);
}

   public static String getCommonStrLength(String str1, String str2) {
	int len1 = str1.length();
	int len2 = str2.length();
	String min = null;
	String max = null;
	String target = null;
	min = len1 <= len2 ? str1 : str2;
	max = len1 > len2 ? str1 : str2;
	// ����㣺min�Ӵ��ĳ��ȣ�����󳤶ȿ�ʼ
	for (int i = min.length(); i >= 1; i--) {
	    // ��������Ϊi��min�Ӵ�����0��ʼ
	    for (int j = 0; j <= min.length() - i; j++) {
		target = min.substring(j, j + i);
		// ��������Ϊi��max�Ӵ����ж��Ƿ���target�Ӵ���ͬ����0��ʼ
		for (int k = 0; k <= max.length() - i; k++) {
		    if (max.substring(k, k + i).equals(target)) {
			return target;
		    }
		}
	    }
	}
	return null;
    }
}
