package cn.solor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import cn.util.GameUtil;

public class Plant extends Star {
	//����ͼƬ�����꣬��������ĳ����Բ���У����ᡢ���ᡢ�ٶȡ��Ƕȡ�����ĳ��Star�ɡ�
	double longAxis;  //����
	double shortAxis; //����
	double speed;    //�����ٶ�
	double degree;
	Star   center;
	boolean satellite;
	
	public void draw(Graphics g){
		super.draw(g);
		move();
		if(!satellite)
		drawTrace(g);	
	}

	public void drawTrace(Graphics g){
		double ovalX,ovalY,ovalWeigth,ovalHeight;
		ovalWeigth = longAxis*2;
		ovalHeight = shortAxis*2;
		ovalX = center.x+center.width/2-longAxis;
		ovalY = center.y+center.height/2-shortAxis;		
		Color c = g.getColor();
		g.setColor(Color.blue);
		g.drawOval((int)ovalX,(int)ovalY,(int)ovalWeigth,(int)ovalHeight);
		g.setColor(c);
	}
		public void move(){
		//������Բ�켣����
		x = (center.x+center.width/2)+longAxis*Math.cos(degree );
		y = (center.y+center.height/2)+shortAxis*Math.sin(degree);
		degree += speed;
	}
	
	public Plant(Star center,String imgpath, double longAxis,
			double shortAxis, double speed) {
		super(GameUtil.getImage(imgpath));
		this.center = center;
		this.x = center.x +longAxis;
		this.y = center.y;
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;	
	}

	public Plant(Star center,String imgpath, double longAxis,
			double shortAxis, double speed,boolean satellite) {
		this(center, imgpath, longAxis, shortAxis, speed);
		this.satellite = satellite;
	}
	public Plant(Image img, double x, double y) {
		super(img, x, y);
	}

	public Plant(String imgpath, double x, double y) {
		super(imgpath, x, y);
	}

}
