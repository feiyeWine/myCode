package cn.solor;

import java.awt.Graphics;
import java.awt.Image;

import cn.util.Cconstant;
import cn.util.MyFrame;
import cn.util.GameUtil;

/**
 * Ì«ÑôÏµÖ÷´°¿Ú
 * @author Administrator
 *
 */
public class SolorFrame extends MyFrame{
	Image bg = GameUtil.getImage("images/bg.jpg");
	Star sun = new Star("images/sun.jpg",Cconstant.GAME_WIDTH/2,Cconstant.GAME_HEIGHT/2);
	Plant earth = new Plant(sun,"images/Earth.jpg",150,100,0.1);
	Plant moon = new Plant(earth,"images/moon.jpg",30,20,0.3,true);
	Plant marth = new Plant(sun,"images/Mars.jpg",200,130,0.05);
	Plant venus = new Plant(sun,"images/Venus.jpg",100,60,0.15);
	Plant mercury = new Plant(sun,"images/Mercury.jpg",50,30,0.2);
	Plant jupiter = new Plant(sun,"images/Jupiter.jpg",250,160,0.03);
	public void paint(Graphics g){
		g.drawImage(bg, 0, 0, null);
		sun.draw(g);
		earth.draw(g);
		marth.draw(g);
		moon.draw(g);
		venus.draw(g);
		mercury.draw(g);
		jupiter.draw(g);
	}
	public static void main(String[] args) {
		new SolorFrame().launchFrame();
	
	}
}
