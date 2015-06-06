package plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import cn.util.Cconstant;


public class Bullet extends GameObject{
	double degree;
	public Bullet(){
		degree = Math.random()*Math.PI*2;
		x = Cconstant.GAME_WIDTH/2;
		y = Cconstant.GAME_WIDTH/2;
		 width = 6;
		 height = 6;
		 speed = 3;
	}
	
	public void draw(Graphics g){
		Color c=g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x,(int) y, width, height);
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		 if(y>Cconstant.GAME_HEIGHT-height||y<height){
		    	degree=-degree;
		    }

		    if(x<0||x>Cconstant.GAME_WIDTH-width){
		    	degree=Math.PI-degree;
		    }
		g.setColor(c);
	}
	
}
