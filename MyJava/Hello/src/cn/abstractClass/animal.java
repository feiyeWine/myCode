package cn.abstractClass;

abstract class animal {
	public  void run() {
	}
	public void breath(){
		System.out.println("����");
	}
}
class Cat extends animal{
	public void run(){
	System.out.println("è��С��");
	}	
}
class Dog extends animal{
	public void run (){
		System.out.println("����");
	}
}