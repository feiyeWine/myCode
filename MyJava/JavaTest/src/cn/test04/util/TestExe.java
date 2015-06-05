package cn.test04.util;

import java.io.IOException;

/**
 * 调用系统EXE文件
 * @author YR
 *
 */
public class TestExe {
    public static void main(String[] args) {
	//获取一个Runtime对象实例
	Runtime m = Runtime.getRuntime();
	try {
	    m.exec("D:/YY语音/yy/YY.exe");
	} catch (IOException e) {
	    System.out.println("执行失败");
	    e.printStackTrace();
	}
    }
}
