package cn.abstractClass;

abstract class animal {
	public  void run() {
	}
	public void breath(){
		System.out.println("ºôÎü");
	}
}
class Cat extends animal{
	public void run(){
	System.out.println("Ã¨²½Ğ¡ÅÜ");
	}	
}
class Dog extends animal{
	public void run (){
		System.out.println("¹·ÅÜ");
	}
}