package com.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;

/**
 * 使用javassist新建一个类
 * @author YR
 *
 */
public class Demo01 {
    public static  void main(String[] args) throws Exception {
	ClassPool pool = ClassPool.getDefault();
	CtClass cc = pool.makeClass("com.javassist.Emp");
	//创建属性
	CtField f1 = CtField.make("private int empno;", cc);
	CtField f2 = CtField.make("private String ename;", cc);
	cc.addField(f1);
	cc.addField(f2);
	//创建方法
	CtMethod m1 = CtMethod.make("public int getEmpno(){return empno;}", cc);
	CtMethod m2 = CtMethod.make("public void setEmpno(int empno){this.empno = empno;}", cc);
	cc.addMethod(m1);
	cc.addMethod(m2);
	//添加构造器
	CtConstructor constructor = new CtConstructor(null, cc);
	CtConstructor constructor2 = new CtConstructor(new CtClass[]{pool.get("java.lang.String"),CtClass.intType},cc );
	constructor2.setBody("{this.empno = empno;this.ename = ename;}");
	cc.addConstructor(constructor2);
	cc.addConstructor(constructor);
	cc.writeFile("E:/");
	
    }
}
