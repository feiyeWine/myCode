package cn.ObjectClass;

public class Animal {
	
	String eye;
	public void run(){
		System.out.println("��");
	}
	public void eat(){
		System.out.println("�Գ�");
	}
}
class Mammal extends Animal{
	public void taisheng(){
		 System.out.println("����̥��");
	}
}
class Bird extends Animal{
	public void eggSheng(){
		System.out.println("����");
	}
}

	
