package plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import cn.util.Cconstant;
import cn.util.GameUtil;
import cn.util.MyFrame;

public class PlaneGameFrame extends MyFrame{
	Image bg = GameUtil.getImage("images/bg.jpg");
	Plane p = new Plane("images/plane.png",50,50);
	ArrayList bulletList = new ArrayList();  //未学泛型
	Date startTime;
	Date endTime;
	Explode bao;
	public void paint(Graphics g){
		
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
		for(int i= 0;i<bulletList.size();i++){
			Bullet b = (Bullet)bulletList.get(i);
			b.draw(g);
			//检测跟飞机的碰撞
		boolean peng = b.getRect().intersects(p.getRect());
		if(peng){
			p.setLive(false);  //飞机死掉
			
			if(bao ==null){
			endTime = new Date();
			bao = new Explode(p.x,p.y);
			}
			bao.draw(g);
			break;
		}
		}
		if(!p.isLive()){
			printInfo(g,"GAME OVER",30,180,150,Color.red);
			int period = (int)(endTime.getTime()-startTime.getTime())/1000;
			printInfo(g,"时间："+period+"秒",20,180,260,Color.blue);
			switch (period/10) {
			case 0:
			case 1:
				printInfo(g,"菜鸟",50,180,200,Color.white);
				break;
			case 2:
			case 3:
				printInfo(g,"小鸟",50,180,200,Color.white);
				break;
			case 4:
			case 5:
			case 6:
				printInfo(g,"大鸟",50,180,200,Color.white);
				break;
			case 7:
			case 8:
			case 9:
				printInfo(g,"鸟王",50,180,200,Color.white);
				
			default:
				printInfo(g,"战机好手",50,180,200,Color.white);
				break;
			} 		
		}
		
		
		// printInfo(g,"分数", 10, 60, 60, Color.blue);

	}
	//在窗口打印信息
	public void printInfo(Graphics g,String str,int size,int x,int y,Color color){
		Color c = g.getColor();
		g.setColor(color);
		Font f = new Font("宋体",Font.BOLD,30);
		g.setFont(f);
		g.drawString(str, x, y);
		g.setColor(c);
	}
	public static void main(String[] args) {
		new PlaneGameFrame().launchFrame();
}		
	public void launchFrame(){
		super.launchFrame();
		//增加键盘的监听
		addKeyListener(new KeyMonitor());
		
		//生成一推子弹
		for(int i= 0;i<20;i++){
			Bullet b = new Bullet();
			bulletList.add(b);
		}
		startTime = new Date();
	}
	
	//定义为内部类，可以方便的使用外部类的普通属性
		class KeyMonitor extends KeyAdapter{

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("按下："+e.getKeyCode());
				p.addDirection(e);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				System.out.println("释放："+e.getKeyCode());
				p.minsuDirection(e);
			}
			
			
		}
	}

