package com.testCompiler;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * ��̬����
 * @author YR
 *
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
	String path = "E:/Test.java";
	JavaCompiler complier = ToolProvider.getSystemJavaCompiler();
	int result = complier.run(null, null, null, path);
	System.out.println(result==0?"����ɹ�":"����ʧ��");
	//����
	/*Runtime runtime = Runtime.getRuntime();
	Process process = runtime.exec("java -cp E:/ Test");
	InputStream in = process.getInputStream();
	BufferedReader br = new BufferedReader(new InputStreamReader(in) );
	String str = "";
	while(null!=(str=br.readLine())){
	    System.out.println(str);
	}*/
	//ͨ����������
	try {
	    URL[] urls = new URL[] {new URL("file:/"+"E:/")};
	    URLClassLoader loader = new URLClassLoader(urls);
	    Class c = loader.loadClass("Test");
	    //���ü������mian����
	    Method m = c.getMethod("main", String[].class);
	    m.invoke(null, (Object)new String[]{"a","b"});
	    //���ڿɱ������JDK5.0֮����У������������ɣ�m.invoke(null,"a","b");
	    //�ͻᷢ��������ƥ�������
	    //��ˣ�����Ҫ���ϣ�Object��ת�ͣ������������
	} catch (Exception e) {
	    e.printStackTrace();
	} 
    }
}
