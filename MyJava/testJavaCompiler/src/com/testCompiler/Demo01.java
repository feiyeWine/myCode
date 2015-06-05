package com.testCompiler;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * 动态编译
 * @author YR
 *
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
	String path = "E:/Test.java";
	JavaCompiler complier = ToolProvider.getSystemJavaCompiler();
	int result = complier.run(null, null, null, path);
	System.out.println(result==0?"编译成功":"编译失败");
	//运行
	/*Runtime runtime = Runtime.getRuntime();
	Process process = runtime.exec("java -cp E:/ Test");
	InputStream in = process.getInputStream();
	BufferedReader br = new BufferedReader(new InputStreamReader(in) );
	String str = "";
	while(null!=(str=br.readLine())){
	    System.out.println(str);
	}*/
	//通过反射运行
	try {
	    URL[] urls = new URL[] {new URL("file:/"+"E:/")};
	    URLClassLoader loader = new URLClassLoader(urls);
	    Class c = loader.loadClass("Test");
	    //调用加载类的mian方法
	    Method m = c.getMethod("main", String[].class);
	    m.invoke(null, (Object)new String[]{"a","b"});
	    //由于可变参数是JDK5.0之后才有，上面代码会编译成：m.invoke(null,"a","b");
	    //就会发生参数不匹配的问题
	    //因此，必须要加上（Object）转型，避免这个问题
	} catch (Exception e) {
	    e.printStackTrace();
	} 
    }
}
