package cn.collectior;

import java.applet.Applet;
import java.awt.Graphics;

public class Object_1 extends Applet{
	MyBox b1 = new MyBox();
	MyBox b2 = new MyBox(170,20,60,60);
	public void paint(Graphics g){
		b1.setPosition(20,20);
		b1.draw(g);
		g.drawString("矩形1的X位置："+b1.getX(),20,100);
		g.drawString("矩形1的Y位置："+b1.getY(),20,120);
		b2.draw(g);
		g.drawString("矩形2的X位置："+b2.getX(),20,100);
		g.drawString("矩形2的Y位置："+b2.getY(),20,120);
	}
}
class MyBox{
	private int x,y,width,height;
	MyBox(){
		x = 0;
		y = 0;
		width = 0;
		height = 0;	
	}
	MyBox(int xPos, int yPos, int w, int h){
	x=xPos;
	y = yPos;
	width = w;
	height = h;
	}
	public void setPosition(int xPos,int yPos){
		x = xPos;
		y = yPos;	
	}
	public void setSize(int w, int h){
		width = w;
		height = h;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void draw(Graphics g){
		
	}
}