package plane;

import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {
	Image img; //= GameUtil.getImage("images/plane.png");
	double x,y;
	boolean left,up,right,down;
	int speed;
	int width,height;
	public Rectangle getRect(){
		return new Rectangle((int)x, (int)y,width,height);
	}
	public GameObject(Image img, double x, double y, boolean left, boolean up,
			boolean right, boolean down, int speed, int width, int height) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.left = left;
		this.up = up;
		this.right = right;
		this.down = down;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}
	public GameObject(){
		
	}
}
