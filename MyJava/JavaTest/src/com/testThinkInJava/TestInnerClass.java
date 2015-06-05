package com.testThinkInJava;
/**
 * 测试内部类的继承
 * @author YR
 *
 */
public class TestInnerClass extends Outer.Inner{
    //enclosingClassReference.super();
    TestInnerClass(Outer o){
	o.super();
    }	//构造器 ****
    
    public static void main(String[] args) {
	Outer o = new Outer();
	TestInnerClass test = new TestInnerClass(o);
    }
}
class Outer{
    
    class Inner{
    	
        }
}

class Outer2 extends Outer{
    
}