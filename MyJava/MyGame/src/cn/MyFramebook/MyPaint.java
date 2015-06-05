package cn.MyFramebook;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;
import java.net.URL;

import javax.imageio.ImageIO;

import cn.test.GameUtil;

public class MyPaint extends Frame
{
	Image img;
	public static void main(String[] args) 
	{
		MyPaint draw =new MyPaint();
		
	}
	MyPaint()
	{
		super("Frame with Panel");
		img= GameUtil.getImage("images/flower.jpg");
		setVisible(true);
		setSize(500,400);
		addWindowListener(new WindowAdapter()
		{

			@Override
			public void windowClosing(WindowEvent e) 
			{
				System.exit(0);
			}	
		});
	}
	public void paint(Graphics g)
	{
		int wt= img.getWidth(this);
		int ht= img.getHeight(this);
		g.drawImage(img, 30, 35, wt/2, ht/2, this);
	}

}
