package cn.testIO;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;

/**
 * ��д�˺����ɳ��������������������ϵ��ַ������ظ�
 * ����һ���
 * @author YR
 *
 */
public class TestStringRW {
    public static void main(String[] args) throws IOException {
	StringWriter userId = new StringWriter();
	boolean flag[] = new boolean[100000];//�˺��Ƿ�ע���
	Arrays.fill(flag, false);
	for(int i = 0;i<10000;i++){
	    int j = (int)(100000+Math.random()*100000);
	    if(!check(""+j)||(flag[j-100000])){
		i--;
		continue;
	    }
	    userId.write(""+j+',');
	    flag[j-100000] = true;
	}
	StringBuffer s = userId.getBuffer();
	userId.close();
	String s2[] = s.toString().split(",");
	System.out.println("�������˺�Ϊ��"+Arrays.toString(s2));
    }
    private static boolean check(String cardNo){
	//�����˺ź�����
	for(int i = 0;i<cardNo.length();i++){
	    int count = 1;
	    //���������ַ��Ƿ���ͬ
	    for(int j = i+1;j<i+4;j++){
		if(j>=cardNo.length()){
		    break;
		}
		if(cardNo.charAt(j) == cardNo.charAt(i)){
		    if(count == 2){
			break;
		    }
		    count++;
		}
	    }
	}
	return true;
    }

}
