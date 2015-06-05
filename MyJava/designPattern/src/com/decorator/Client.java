package com.decorator;

public class Client {
    public static void main(String[] args) {
	Car car = new Car();
	car.move();
	System.out.println("�����¹��ܣ����С�������������������");
	FlyCar flycar = new FlyCar(car);
	flycar.move();
	System.out.println("���������¹��ܣ��ɡ��Ρ�������������������");
	WaterCar waterCar = new WaterCar(flycar);
	waterCar.move();
	System.out.println("���������¹��ܣ��ɡ��Ρ����ܡ�������������������");
	AiCar aiCar = new AiCar(new WaterCar(new FlyCar(car)));
	aiCar.move();
    }
}
