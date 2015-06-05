package com.FlyWeight;

/**
 * 享元类
 * 
 */
public interface ChessFlyWeight {
    String getColor();
    void display(Coordinate c);
}

class ConcreteChess implements ChessFlyWeight{
    private String color;
    
    public ConcreteChess(String color) {
	super();
	this.color = color;
    }

    @Override
    public String getColor() {
	return color;
    }

    @Override
    public void display(Coordinate c) {
	System.out.println("棋子的颜色："+color);
	System.out.println("棋子的位置：("+c.getX()+","+c.getY()+")");
    }
    
}

