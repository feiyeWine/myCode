package MyInterface;

import org.w3c.dom.Attr;

public interface Flyable {
	int MAX_SPEED=11000;
	int MIN_HEIGHT=1;
	void fly(); //������
}
class Plane implements Flyable{

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("�����������������ɣ�");
	}
	public void attack(){
		System.out.println("������");
	}
	class Man implements Flyable{

		@Override
		public void fly() {
			// TODO Auto-generated method stub
			System.out.println("����������");
		}
		
	}
	
}
class Stone implements Flyable{

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("�����ӳ�ȥ����");
	}
	
}