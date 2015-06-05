package com.decorator;

public class Client {
    public static void main(String[] args) {
	Car car = new Car();
	car.move();
	System.out.println("增加新功能：飞行——————————");
	FlyCar flycar = new FlyCar(car);
	flycar.move();
	System.out.println("增加两个新功能：飞、游——————————");
	WaterCar waterCar = new WaterCar(flycar);
	waterCar.move();
	System.out.println("增加三个新功能：飞、游、智能——————————");
	AiCar aiCar = new AiCar(new WaterCar(new FlyCar(car)));
	aiCar.move();
    }
}
