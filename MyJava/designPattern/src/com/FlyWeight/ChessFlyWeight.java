package com.FlyWeight;

/**
 * ��Ԫ��
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
	System.out.println("���ӵ���ɫ��"+color);
	System.out.println("���ӵ�λ�ã�("+c.getX()+","+c.getY()+")");
    }
    
}

