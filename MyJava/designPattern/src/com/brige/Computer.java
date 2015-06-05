package com.brige;

public class Computer {
    protected Brand brand;
    public Computer(Brand brand){
	this.brand = brand;
    }
    public void sale(){
	brand.scale();
    }
}
class Desktop extends Computer{

    public Desktop(Brand brand) {
	super(brand);
    }
    @Override
    public void sale() {
        super.sale();
        System.out.println("台式机");
    }
}
class Laptop extends Computer{

    public Laptop(Brand brand) {
	super(brand);
    }
    @Override
    public void sale() {
        super.sale();
        System.out.println("笔记本");
    }
}