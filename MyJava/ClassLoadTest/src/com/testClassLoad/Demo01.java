package com.testClassLoad;
/**
 * 测试类加载顺序
 * @author YR
 *
 */
public class Demo01 {
    public static void main(String[] args) {
	//A a = new A();
	//B b = new B();
	System.out.println(B.a);
	System.out.println("加载Demo01");
    }
}
class A{
    static int a = 2;
    static{
	int width = 100;
	width = 200;
	System.out.println(width);
    }
   public A(){
       System.out.println("A的构造器");
   }
}
class B extends A{
    static final int c = 10;
    static {
	int length = 10;
	System.out.println(c);
    }
    public B(){
	System.out.println("B的构造器");
    }
}


