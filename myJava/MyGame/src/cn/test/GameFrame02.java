package cn.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 测试窗口物体沿着水平、垂直移动
 * @author Administrator
 *
 */
public class GameFrame02 extends Frame{   //GUI编程，AWT，swing等。
	
	Image img= GameUtil.getImage("images/sun.jpg");
	
	
	/**
	 * 加载窗口
	 */
	public void launchFrame(){
		setSize(500, 500);
		setLocation(100,100);
		setVisible(true);
		
		new PaintThread().start();
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
			
	}
	private double x=100,y=100;
	private double degree=3.14/3;
	private double speed= 10;
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(img, (int)x,(int)y, null);
	    if(speed>0){
	    	speed -=0.05;
	    }
	    else{
	    	speed=0;
	    }
		x+=speed*Math.cos(degree);
	    y+=speed*Math.sin(degree);
	    if(y>500-30||y<30){
	    	degree=-degree;
	    }

	    if(x<0||x>500-30){
	    	degree=Math.PI-degree;
	    }
	   
	}
	
	
	/**
	 * 定义一个重画窗口的线程类，是一个内部类
	 * @author Administrator
	 *
	 */
	class PaintThread extends Thread{
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
	}

	public static void main(String[] args) {
		GameFrame02 gf=new GameFrame02();
		gf.launchFrame();
	}

}


