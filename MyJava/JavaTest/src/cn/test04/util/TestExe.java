package cn.test04.util;

import java.io.IOException;

/**
 * ����ϵͳEXE�ļ�
 * @author YR
 *
 */
public class TestExe {
    public static void main(String[] args) {
	//��ȡһ��Runtime����ʵ��
	Runtime m = Runtime.getRuntime();
	try {
	    m.exec("D:/YY����/yy/YY.exe");
	} catch (IOException e) {
	    System.out.println("ִ��ʧ��");
	    e.printStackTrace();
	}
    }
}
