package com.testThinkInJava;
/**
 * �����ڲ���ļ̳�
 * @author YR
 *
 */
public class TestInnerClass extends Outer.Inner{
    //enclosingClassReference.super();
    TestInnerClass(Outer o){
	o.super();
    }	//������ ****
    
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