package MyInterface;

import org.w3c.dom.Attr;

public interface Flyable {
	int MAX_SPEED=11000;
	int MIN_HEIGHT=1;
	void fly(); //抽象类
}
class Plane implements Flyable{

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("发动机依靠发动机飞！");
	}
	public void attack(){
		System.out.println("被击落");
	}
	class Man implements Flyable{

		@Override
		public void fly() {
			// TODO Auto-generated method stub
			System.out.println("跳起来，飞");
		}
		
	}
	
}
class Stone implements Flyable{

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("被人扔出去，飞");
	}
	
}