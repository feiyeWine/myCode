package cn.wrapperClass;
/**
 * �����Զ�װ�������
 * @author Administrator
 *
 */
public class Test2WrapperClass {
	public static void main(String[] args) {
	//Integer a=new Integer(1000);
	Integer a=1000;  //jdk5.0֮���Զ�װ�䣬�����������ǸĽ����룺Integer a=new Integer(1000);
	Integer b=2000;
	int c=b;//�Զ����䣬�������Ľ���b.intValue
	System.out.println(c);
	Integer d=1234;
	Integer d2=1234;
	System.out.println(d==d2);
	System.out.println(d.equals(d2));
	Integer d3=123;   //[-128,127]֮���������Ȼ����������������������
	Integer d4=123;
	System.out.println(d3==d4);
	System.out.println(d3.equals(d4));
	}
	
}
