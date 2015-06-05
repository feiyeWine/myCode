package com.testJs;

import java.io.FileReader;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * 脚本引擎执行js代码,Rhino语法
 * @author YR
 *
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
	//获得脚本对象
	ScriptEngineManager sem = new ScriptEngineManager();
	ScriptEngine engine = sem.getEngineByName("javascript");
	//定义变量，存储到引擎上下文当中
	engine.put("msg","I am a good man");
	String str = "var user = {name:'Mr wang',age:18,others:['15','hello']};";
	str += "println(user.name);";
	//执行脚本
	engine.eval(str);
	engine.eval("msg = 'he is a bad man';");
	System.out.println(engine.get("msg"));
	//定义函数
	engine.eval("function add(a,b){var sum = a+b;return sum;}");
	//取得可用接口
	Invocable jsInvoke = (Invocable) engine;
	//执行脚本中定义的方法
	Object result = jsInvoke.invokeFunction("add", new Object[]{13,21});
	System.out.println(result);
	//导入其他java包，使用其他包中的java类
	String jsCode = "importPackage(java.util);var list=Arrays.asList([\"i\",\"he\"]);";
	engine.eval(jsCode);
	List<String> list2 = (List<String>) engine.get("list");
	for(String temp:list2){
	    System.out.println(temp);
	}
	//执行一个js文件，将a.js置于src下即可
	URL url = Demo01.class.getClassLoader().getResource("test.js");
	FileReader fr = new FileReader(url.getPath());
	engine.eval(fr);
	fr.close();
    }
}
