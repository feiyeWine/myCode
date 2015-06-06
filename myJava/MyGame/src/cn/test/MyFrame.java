package cn.test;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;


public class MyFrame extends Frame{
	
	public void launchFrame(){
		setSize(Cconstant.GAME_WIDTH,Cconstant.GAME_HEIGHT);
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
	private Image offScreenImage = null; //����˫���弼��������˸
	/*public void update(Graphics g){
		if(offScreenImage == null)
			offScreenImage = this.createImage(Cconstant.GAME_WIDTH,Cconstant.GAME_HEIGHT);
			Graphics gOff= offScreenImage.getGraphics();
			paint(gOff);
			g.drawImage(offScreenImage,0,0,null);
	}*/
				
		/**
		 * ����һ���ػ����ڵ��߳��࣬��һ���ڲ���
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
}