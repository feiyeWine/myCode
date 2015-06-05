package com.decorator;

public interface Icar {
    void move();
}
//��ʵ����
class Car implements Icar{
    @Override
    public void move() {
	System.out.println("½������");
    }
}

class SuperCar implements Icar{
    protected Icar car ;
    public SuperCar(Icar car){
	this.car = car;
    }
    @Override
    public void move() {
	car.move();
    }
    
}
//����װ�ν�ɫ
class FlyCar extends SuperCar{
    public FlyCar(Icar car) {
	super(car);
    }
    public void fly(){
	System.out.println("���Ϸ�");
    }
    @Override
    public void move() {
        super.move();
        fly();
    }
}
class WaterCar extends SuperCar{
    public WaterCar(Icar car) {
	super(car);
    }
    public void swim(){
	System.out.println("ˮ����");
    }
    @Override
    public void move() {
        super.move();
        swim();
    }
}
class AiCar extends SuperCar{
    public AiCar(Icar car) {
	super(car);
    }
    public void autoMove(){
	System.out.println("½�����Զ���");
    }
    @Override
    public void move() {
        super.move();
        autoMove();
    }
}
