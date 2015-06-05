package com.testJs;

import java.io.FileReader;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * �ű�����ִ��js����,Rhino�﷨
 * @author YR
 *
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
	//��ýű�����
	ScriptEngineManager sem = new ScriptEngineManager();
	ScriptEngine engine = sem.getEngineByName("javascript");
	//����������洢�����������ĵ���
	engine.put("msg","I am a good man");
	String str = "var user = {name:'Mr wang',age:18,others:['15','hello']};";
	str += "println(user.name);";
	//ִ�нű�
	engine.eval(str);
	engine.eval("msg = 'he is a bad man';");
	System.out.println(engine.get("msg"));
	//���庯��
	engine.eval("function add(a,b){var sum = a+b;return sum;}");
	//ȡ�ÿ��ýӿ�
	Invocable jsInvoke = (Invocable) engine;
	//ִ�нű��ж���ķ���
	Object result = jsInvoke.invokeFunction("add", new Object[]{13,21});
	System.out.println(result);
	//��������java����ʹ���������е�java��
	String jsCode = "importPackage(java.util);var list=Arrays.asList([\"i\",\"he\"]);";
	engine.eval(jsCode);
	List<String> list2 = (List<String>) engine.get("list");
	for(String temp:list2){
	    System.out.println(temp);
	}
	//ִ��һ��js�ļ�����a.js����src�¼���
	URL url = Demo01.class.getClassLoader().getResource("test.js");
	FileReader fr = new FileReader(url.getPath());
	engine.eval(fr);
	fr.close();
    }
}
