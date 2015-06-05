package com.decorator;

public interface Icar {
    void move();
}
//真实对象
class Car implements Icar{
    @Override
    public void move() {
	System.out.println("陆地上跑");
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
//具体装饰角色
class FlyCar extends SuperCar{
    public FlyCar(Icar car) {
	super(car);
    }
    public void fly(){
	System.out.println("天上飞");
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
	System.out.println("水上游");
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
	System.out.println("陆地上自动跑");
    }
    @Override
    public void move() {
        super.move();
        autoMove();
    }
}
