package cn.MyFramebook;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyCanvas extends Frame{
	MyCanvas()
	{
		super("Frame with Canvas");
		setVisible(true);
		Panel pnl = new Panel();
		pnl.setBackground(Color.blue);
		canvas2a cvs = new canvas2a();
		add(pnl);
		pnl.add(cvs);
		pack();
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
	}
	public static void main(String[] args) {
		MyCanvas frm=new MyCanvas();
		}
}
class canvas2a extends Canvas
{
	canvas2a()
	{
		setSize(150,120);
		setBackground(Color.yellow);
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.red);
		g.drawString("黄色区域是画布", 50, 22);
		g.drawString("可用鼠标拖动边框", 30, 39);
		g.fillRoundRect(25, 50, 100, 50, 20, 20);
	}
}







